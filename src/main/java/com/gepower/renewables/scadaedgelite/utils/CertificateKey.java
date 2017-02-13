package com.gepower.renewables.scadaedgelite.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;



public class CertificateKey {

	private static final String CLIENT_ALIAS = "workstationjava";	
	private static final char[] PASSWORD = "2016Roc2.@".toCharArray();
     private  X509Certificate clientCertificate;
     private KeyPair clientKeyPair;
     private  PrivateKey privKey;
     
     public CertificateKey load() throws Exception {
    	 File javaKey =  new File("Predix_OPCUAAdaptor.jks");
         KeyStore keyStore = KeyStore.getInstance("jks");
         InputStream readStream = new FileInputStream(javaKey);
         keyStore.load(readStream, PASSWORD);
         clientCertificate= (X509Certificate)keyStore.getCertificate(CLIENT_ALIAS);
         //System.out.println(clientCertificate.toString());
         privKey= (PrivateKey)keyStore.getKey(CLIENT_ALIAS, PASSWORD);
         //clientKeyPair = new KeyPair((PublicKey)keyStore.getCertificate(CLIENT_ALIAS),privKey);
         
         //System.out.println(privKey);
         return this; 
    
}
     public X509Certificate getClientCertificate() {
         return clientCertificate;
     }

     public KeyPair getClientKeyPair() {
         return clientKeyPair;
     }
     public PrivateKey getPrivateKey() {
         return privKey;
     }
     
	
	
}
