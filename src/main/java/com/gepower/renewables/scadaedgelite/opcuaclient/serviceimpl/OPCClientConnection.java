package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.security.interfaces.RSAPrivateKey;
import java.util.Locale;

import org.opcfoundation.ua.builtintypes.LocalizedText;
import org.opcfoundation.ua.core.ApplicationDescription;
import org.opcfoundation.ua.core.ApplicationType;
import org.opcfoundation.ua.transport.security.Cert;
import org.opcfoundation.ua.transport.security.PrivKey;
import org.opcfoundation.ua.transport.security.SecurityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.OPCServerJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.SiteSettingsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.OPCServer;
import com.gepower.renewables.scadaedgelite.utils.CertificateKey;
import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.UaAddress;
import com.prosysopc.ua.client.UaClient;

@Repository
public class OPCClientConnection{

	@Autowired
	private static OPCServerJdbcImpl opcServerJdbcImpl;
	
	@Autowired
	public OPCClientConnection(OPCServerJdbcImpl opcServerJdbcImpl)
	{
		this.opcServerJdbcImpl = opcServerJdbcImpl;
	}
	
	public static UaClient getOPCUAClientConnection()
	{
		UaClient uaClient = new UaClient();
		
		try{
			for(OPCServer opcServer : opcServerJdbcImpl.getSiteOPCServerData())
			{
			String opcHostIP = opcServer.getOpcHostIP();
			String opcPort = opcServer.getOpcPort();
			String opcServerName = opcServer.getOpcServerName();

			String opcUaClientURL = "opc.tcp://"+opcHostIP+":"+opcPort+"/"+opcServerName;

			uaClient.setAddress(new UaAddress(opcUaClientURL));
			ApplicationDescription applicationDescription = new ApplicationDescription();
			applicationDescription.setApplicationName( new LocalizedText("Workstation Java Client", Locale.ENGLISH) );		
			applicationDescription.setProductUri( "urn:WorkstationJava" );
			applicationDescription.setApplicationType(ApplicationType.Client);
			
			CertificateKey certificateKey = new CertificateKey();
			certificateKey.load();
			
			ApplicationIdentity applicationIdentity = new ApplicationIdentity(
					new Cert(certificateKey.getClientCertificate()), 
					new PrivKey((RSAPrivateKey)certificateKey.getPrivateKey()));
		
			applicationIdentity.setApplicationDescription(applicationDescription);
			uaClient.setApplicationIdentity(applicationIdentity);
			uaClient.setSecurityMode(SecurityMode.BASIC128RSA15_SIGN);
			
			uaClient.connect();
			
		System.out.println("Connected to the OPC Server : "+uaClient.getUri());
			}
		}
		catch (Exception exception) {
			 exception.printStackTrace();
			 System.out.println("Lost OPC Server Connection   ");
	         System.err.println(exception.getClass().getName()+": "+exception.getMessage());	         
	         //System.exit(0);
	      }
		return uaClient;
		
	}
	
}