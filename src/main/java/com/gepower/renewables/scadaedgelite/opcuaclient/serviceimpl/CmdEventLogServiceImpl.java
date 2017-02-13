package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.AssetsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.CommandEventLogJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.OPCServerJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Asset;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.OPCServer;
import com.gepower.renewables.scadaedgelite.opcuaclient.service.CmdEventLogService;
import com.gepower.renewables.scadaedgelite.utils.ScadaUtil;

@Repository
public class CmdEventLogServiceImpl implements CmdEventLogService  {

	/*  The IP of the OPC  */
	private static String opchostIp;

	/*  The IP of the Asset  */
	private static String assetIp;

	/*  The logs starting Time  */
	private static long startTime;

	/*  The logs ending Time  */
	private static long endTime;

	/*  The command url  */
	private static String cmdUri;

	/*  The event url  */
	private static String eventUri;

	/*  The temporary Directory Path */
	private static String tempDir;

	private static String eventXmlPath;

	private static String cmdXmlPath;

	public static final String URLPREFIX = "http://";

	public static final String URLAPPEND = "/ControllerHMI/";

	public static final String CMDURLSUFFIX = "/cgi-bin/mk6e-readdynamicxml?file=celcommand.xml&type=1&";

	public static final String EVENTURLSUFFIX = "/cgi-bin/mk6e-readdynamicxml?file=celevent.xml&type=1&";

	private final static String USERNAME = "g55csc";

	private final static String PASSWORD = "2016Roc2.@";

	@Autowired
	private static AssetsJdbcImpl assetsJdbc;
	private static CommandEventLogJdbcImpl commandEventLogJdbcImpl;
	private static OPCServerJdbcImpl opcServerJdbcImpl;

	@Autowired
	public CmdEventLogServiceImpl(AssetsJdbcImpl assetsJdbc, CommandEventLogJdbcImpl commandEventLogJdbcImpl, OPCServerJdbcImpl opcServerJdbcImpl)
	{
		this.assetsJdbc = assetsJdbc;
		this.commandEventLogJdbcImpl = commandEventLogJdbcImpl;
		this.opcServerJdbcImpl = opcServerJdbcImpl;
	}
	
	

	public CmdEventLogServiceImpl() 
	{
		super();		
	}



	@Override
	public void getCommandEventLogs() throws ParserConfigurationException, SAXException, IOException {

		for(OPCServer opcServer : opcServerJdbcImpl.getSiteOPCServerData())
		{
			opchostIp = opcServer.getOpcHostIP();
		for(Asset asset : assetsJdbc.getAssetsData(opchostIp))
		{
			List<CmdEventLog> commandEventLogs = new ArrayList<CmdEventLog>();
			assetIp = asset.getAssetIp();
			startTime = ScadaUtil.getStartTimeInSecs();
			endTime = ScadaUtil.getEndTimeInSecs();	    

			/*siteIp = "10.119.166.35";
			assetIp = "172.16.16.2";
			startTime = 1476268372;
			endTime = 1476297772;*/

			/*
			URL eventUrl1 = new 
				URL("http://10.119.164.163/ControllerHMI/172.16.16.11/cgi-bin/mk6e-readdynamicxml?file=celevent.xml&type=1&p1=1476274172&p2=1476297772"); 
			URL cmdUrl1 = new 
				URL("http://10.119.164.163/ControllerHMI/172.16.16.11/cgi-bin/mk6e-readdynamicxml?file=celcommand.xml&type=1&p1=1475602972&p2=1476034972");
			 */
			cmdUri = URLPREFIX+opchostIp+URLAPPEND+assetIp+CMDURLSUFFIX+"p1="+startTime+"&p2="+endTime;

			eventUri = URLPREFIX+opchostIp+URLAPPEND+assetIp+EVENTURLSUFFIX+"p1="+startTime+"&p2="+endTime;

			URL eventUrl,cmdUrl;
			eventUrl = new URL(eventUri.toString());     		    		
			cmdUrl = new URL(cmdUri.toString());

			System.out.println("url Dynamic: "+eventUrl);
			System.out.println("url Dynamic: "+cmdUrl);		

			String tDir = System.getProperty("java.io.tmpdir");
			System.out.println("Temp Dir : "+tDir);

			Authenticator.setDefault(new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USERNAME,PASSWORD.toCharArray());
				}
			});

			tempDir = System.getProperty("java.io.tmpdir");
			eventXmlPath = tempDir+"event"+".xml";
			cmdXmlPath = tempDir+"cmd"+".xml";

			File eventXmlFile,cmdXmlFile;
			eventXmlFile = new File(eventXmlPath);
			cmdXmlFile = new File(cmdXmlPath);

			try{
			FileUtils.copyURLToFile(eventUrl, eventXmlFile);
			FileUtils.copyURLToFile(cmdUrl, cmdXmlFile);

			//File file = new File("D:/502658206/SCADALiteDocs/pom.xml"); 
			eventXmlFile.deleteOnExit();
			cmdXmlFile.deleteOnExit();	

			commandEventLogJdbcImpl.deleteCommandEventlogs(asset.getAssetName());
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document eventDocument = documentBuilder.parse(eventXmlFile);
			Document cmdDocument = documentBuilder.parse(cmdXmlFile);

			NodeList eventNodeList = eventDocument.getElementsByTagName("Event");
			NodeList cmdNodeList = cmdDocument.getElementsByTagName("SdiCmd");
			NodeList cmdNodeList1 = cmdDocument.getElementsByTagName("ModVar");		

			String assetName=asset.getAssetName();;

			CmdEventLog commandEventLogBean;

			for(int i=0; i<eventNodeList.getLength(); i++)
			{
				long logTime= Long.parseLong(eventNodeList.item(i).getAttributes().getNamedItem("Secs").getNodeValue());

				commandEventLogBean = new CmdEventLog();			
				commandEventLogBean.setLogTime(ScadaUtil.secondsToString(logTime));
				commandEventLogBean.setLogDescription(eventNodeList.item(i).getAttributes().getNamedItem("Desc").getNodeValue());
				commandEventLogBean.setAssetName(assetName);

				//commandEventLogBean.setState(eventNodeList.item(i).getAttributes().getNamedItem("State").getNodeValue());

				switch(eventNodeList.item(i).getAttributes().getNamedItem("Type").getNodeValue())
				{
				case  "71" : 				

					commandEventLogBean.setLogType("Event");
					commandEventLogBean.setLogName(eventNodeList.item(i).getAttributes().getNamedItem("Name").getNodeValue());

					break;

				case  "63" : 
					commandEventLogBean.setLogType("Alarm");
					commandEventLogBean.setLogName(eventNodeList.item(i).getAttributes().getNamedItem("Name").getNodeValue());

					break;

				case  "62" : 
					commandEventLogBean.setLogType("Event");
					commandEventLogBean.setLogName(eventNodeList.item(i).getAttributes().getNamedItem("Device").getNodeValue());

					break;

				case  "60" : 
					commandEventLogBean.setLogType("Alarm");
					commandEventLogBean.setLogName(eventNodeList.item(i).getAttributes().getNamedItem("Device").getNodeValue());

					break;
				default :	
					commandEventLogBean.setLogType(eventNodeList.item(i).getAttributes().getNamedItem("Type").getNodeValue());			
					commandEventLogBean.setLogDescription(eventNodeList.item(i).getAttributes().getNamedItem("Desc").getNodeValue());
					//commandEventLogBean.setState(eventNodeList.item(i).getAttributes().getNamedItem("State").getNodeValue());			
				}

				commandEventLogs.add(commandEventLogBean);

			}


			for(int i=0; i<cmdNodeList.getLength();i++)
			{	
				long logTime= Long.parseLong(eventNodeList.item(i).getAttributes().getNamedItem("Secs").getNodeValue());

				commandEventLogBean = new CmdEventLog();			
				commandEventLogBean.setLogTime(ScadaUtil.secondsToString(logTime));
				commandEventLogBean.setLogDescription(cmdNodeList.item(i).getAttributes().getNamedItem("Desc").getNodeValue());

				commandEventLogBean.setLogName("Command Log");
				commandEventLogBean.setAssetName(assetName);

				switch(cmdNodeList.item(i).getAttributes().getNamedItem("Type").getNodeValue())
				{
				case  "28" : 
					commandEventLogBean.setLogType("Execute System Command");				
					break;

				default :
					commandEventLogBean.setLogType(eventNodeList.item(i).getAttributes().getNamedItem("Type").getNodeValue());
				}

				commandEventLogs.add(commandEventLogBean);
			}

			for(int i=0; i<cmdNodeList1.getLength()-1;i++)
			{

				long logTime= Long.parseLong(cmdNodeList1.item(i).getAttributes().getNamedItem("Secs").getNodeValue());

				commandEventLogBean = new CmdEventLog();			
				commandEventLogBean.setLogTime(ScadaUtil.secondsToString(logTime));
				commandEventLogBean.setLogName(cmdNodeList1.item(i).getAttributes().getNamedItem("VarName").getNodeValue());
				commandEventLogBean.setLogDescription(cmdNodeList1.item(i).getAttributes().getNamedItem("VarName").getNodeValue().substring(7));

				commandEventLogBean.setLogType("Set Variable");
				commandEventLogBean.setAssetName(assetName);

				commandEventLogs.add(commandEventLogBean);
			}

			}
		catch (Exception e) {
			System.out.println("Class:CommandEventLogServiceImpl -- Unable to access URL : "+e);
		}

			commandEventLogJdbcImpl.insertBatchCommandEventLogs(commandEventLogs);
		}
		}

	}
}

