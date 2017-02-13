package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.AssetKPIDataJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.AssetsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.OpctagsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.RowCountJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.SiteKPIDataJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Asset;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;

@Repository
public class SiteKPIdataServiceImpl {

	@Autowired
	private static AssetsJdbcImpl assetsJdbc;
	private static AssetKPIDataJdbcImpl liveDataJdbc;
	private static RowCountJdbcImpl rowCountJdbc;

	private static final String SITE_POWER = "Power"; 
	private static final String SITE_WINDSPEED = "Wind Speed"; 
	private static final String TABLE_NAME = "scadael.general_control_data"; 
	private static final String SITE_KPIDATA = "scadael.site_kpi_data"; 
	
	@Autowired
	public SiteKPIdataServiceImpl(AssetsJdbcImpl assetsJdbc,OpctagsJdbcImpl opctagsJdbc,AssetKPIDataJdbcImpl liveDataJdbc, RowCountJdbcImpl rowCountJdbc, SiteKPIDataJdbcImpl siteKPIJdbc)
	{
		this.assetsJdbc = assetsJdbc;
		this.liveDataJdbc = liveDataJdbc;
		this.rowCountJdbc = rowCountJdbc;
	}

	public SiteKPIdataServiceImpl() 	{
		super();		
	}

	public static double getMonthKPIData(int assetId, int tagId1, int tagId2)
	{
		double tagValue1 = 0,tagValue2 = 0,tagValue = 0;
		int i=0;

		for(KPIData xx : liveDataJdbc.getAssetKPIParamValue(assetId,tagId1, tagId2))
		{
			if(i==0)
			{
				tagValue1 = Double.parseDouble(xx.getOpctagValue().split(" ")[0]);
			}
			else
			{
				tagValue2 = Double.parseDouble(xx.getOpctagValue().split(" ")[0]);
			}
			if(i==1)
			{
				if(tagValue2>=tagValue1)
				{
					tagValue = tagValue2-tagValue1;					
				}
				else
				{
					tagValue = tagValue1-tagValue2;					
				}
			}
			i++;
		}


		return tagValue;

	}

	public  static double getSitePower()
	{
		double siteParamVal = 0,sitePower = 0;

		for(KPIData aa : liveDataJdbc.getAssetKPIParamValue(SITE_POWER))
		{
			String kpi = aa.getOpctagValue().split(" ")[0];
			siteParamVal = siteParamVal + Double.parseDouble(kpi);			
		}
		sitePower=(double) Math.round((siteParamVal/1000)* 10) / 10;
		return sitePower;
	}

	public  static double getSiteWindSpeed()
	{
		double siteParamVal = 0,siteWindSpeed = 0;

		for(KPIData aa : liveDataJdbc.getAssetKPIParamValue(SITE_WINDSPEED))
		{
			String kpi = aa.getOpctagValue().split(" ")[0];
			siteParamVal = siteParamVal + Double.parseDouble(kpi);							
		}
		double siteWS = siteParamVal/33;
		siteWindSpeed = (double) Math.round((siteWS)* 10) / 10;
		
		return siteWindSpeed;
	}

	public static double getSiteCapacity()
	{
		Calendar cal = Calendar.getInstance();
		int dayOfMonth,i=0;
		dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		double siteCapacity = 0,siteCap = 0;
		for(Asset assets : assetsJdbc.getAssetsData())
		{
			String totalProd = liveDataJdbc.getLiveData(assets.getAssetId(), 11721,TABLE_NAME).getOpctagValue().split(" ")[0];
			String totalProdLastMon = liveDataJdbc.getLiveData(assets.getAssetId(), 11722,TABLE_NAME).getOpctagValue().split(" ")[0];
			double monthProd = (Double.parseDouble(totalProd)-Double.parseDouble(totalProdLastMon));
			if(monthProd!=0.0)
			{
				i++;
			}
			double namePlateProd = 1656*(dayOfMonth-1)*24;
			double assetCapacity = (monthProd/namePlateProd)*100;
			siteCap = (siteCap + assetCapacity);	
		}
		System.out.println(siteCap+" : "+i);
		siteCapacity = (double) Math.round((siteCap/i)* 100) / 100;
		return siteCapacity;
	}

	public static double getSiteAvailability()	
	{

		double totalAvail = 0;
		for(Asset assets : assetsJdbc.getAssetsData())
		{
			double systemOK = getMonthKPIData(assets.getAssetId(), 11729, 11730);
			double downTime = getMonthKPIData(assets.getAssetId(), 11691, 11692);
			double maintenanceTime = getMonthKPIData(assets.getAssetId(), 11714, 11713);
			double repairTime = getMonthKPIData(assets.getAssetId(), 11728, 11727);
			double lineOutageTime = getMonthKPIData(assets.getAssetId(), 11712, 11711);
			double weatherOutageTime = getMonthKPIData(assets.getAssetId(), 11741, 11740);
			double externalStopTime = getMonthKPIData(assets.getAssetId(), 11696, 11695);
			double energyCurtailmentTime = getMonthKPIData(assets.getAssetId(), 11694, 11693);
			double customerStopTime = getMonthKPIData(assets.getAssetId(), 11668, 11667);

			double surveyTime = (systemOK + downTime + lineOutageTime + weatherOutageTime + externalStopTime + 
					energyCurtailmentTime + maintenanceTime + repairTime + customerStopTime);

			double availability = (1-((downTime+repairTime+maintenanceTime)/surveyTime))*100;
			totalAvail = totalAvail + availability;

		}
		double availability = (double) Math.round((totalAvail/33)* 100) / 100;
		return availability;

	}
	

	public void getSiteKPIData()
	{
		//double siteAvailability = getSiteAvailability();
		String sitePower =  getSitePower()+" MW";
		String siteWindspeed = getSiteWindSpeed()+" m/s";
		//double siteCapacity = getSiteCapacity();
		
		for(int i=90001;i<=90002;i++)
		{
		int rowCount = rowCountJdbc.getRowCount(SITE_KPIDATA,99999,i);
		if(rowCount==1)
		{
			if(i==90001){
				
				liveDataJdbc.updateSiteKPIData(sitePower, "01/04/17 20:30:02", 99999, i);		
			}
			else
			{
				
				liveDataJdbc.updateSiteKPIData(siteWindspeed, "01/04/17 20:30:02", 99999, i);	
			}
		}
		
	}

	}


}
