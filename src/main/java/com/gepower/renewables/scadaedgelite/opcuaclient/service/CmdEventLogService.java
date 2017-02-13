/**
 * 
 */
package com.gepower.renewables.scadaedgelite.opcuaclient.service;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface CmdEventLogService {

	public  void getCommandEventLogs() throws MalformedURLException, IOException, ParserConfigurationException, SAXException;
	
}
