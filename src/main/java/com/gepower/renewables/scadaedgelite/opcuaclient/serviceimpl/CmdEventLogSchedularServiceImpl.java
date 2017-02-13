package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.RowCountJdbcImpl;


@Repository
public class CmdEventLogSchedularServiceImpl
{
	@Autowired
	private static RowCountJdbcImpl rowCountJdbc;

	private static final String TABLE_NAME = "scadael.asset_master";  

	CmdEventLogServiceImpl commandEventLogServiceImpl;
	Timer timer;
	TimerTask timerTask;
	int rowCount;

	@Autowired
	public CmdEventLogSchedularServiceImpl(RowCountJdbcImpl rowCountJdbc)
	{
		this.rowCountJdbc =  rowCountJdbc;
	}

	public CmdEventLogSchedularServiceImpl() {
		super();	
	}

	public void runSchedular()
	{
		timerTask = new TimerTask() {	
			@Override
			public void run() 
			{
				try 
				{
					commandEventLogServiceImpl.getCommandEventLogs();
				} 
				catch (ParserConfigurationException | SAXException | IOException e) 
				{
					e.printStackTrace();
				}

			}
		};	
		timer = new Timer();
		System.out.println("Hello Assets");
		rowCount = rowCountJdbc.getRowCount(TABLE_NAME);
		timer.schedule(timerTask, 0, 15000*rowCount);
	}





}
