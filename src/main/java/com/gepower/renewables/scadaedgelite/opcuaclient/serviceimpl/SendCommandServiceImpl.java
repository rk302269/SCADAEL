package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import org.opcfoundation.ua.builtintypes.NodeId;
import org.opcfoundation.ua.builtintypes.Variant;
import org.opcfoundation.ua.core.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.CommandJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.OpctagsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Command;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.client.UaClient;

@Repository
public class SendCommandServiceImpl {

	@Autowired
	private static CommandJdbcImpl commandJdbc;
	private static OpctagsJdbcImpl opctagsJdbc;

	@Autowired
	public SendCommandServiceImpl(CommandJdbcImpl commandJdbc, OpctagsJdbcImpl opctagsJdbc)
	{
		this.commandJdbc = commandJdbc;
		this.opctagsJdbc = opctagsJdbc;
	}
	
	public void sendCommand() throws IllegalArgumentException, ServiceException, StatusException
	{
		UaClient cmduaClient = 
				OPCClientConnection.getOPCUAClientConnection();
			
		for(Command cb : commandJdbc.getCommands())
		{
			Boolean status = false;
			String cmdDatatype = opctagsJdbc.getOPCtagDetails(cb.getCommandTag()).getOpctagDatatype();
			String assetName = cb.getAssetName();
			String cmdValue = cb.getCommandValue();
			String cmdTagName = opctagsJdbc.getOPCtagDetails(cb.getCommandTag()).getOpctagName();
			
			System.out.println("Cmd Tag Id : "+cb.getCommandTag());
			
			switch(cmdDatatype)
			{
				case "Boolean" : 
					status = cmduaClient.writeAttribute(NodeId.parseNodeId("ns=2;s="+assetName+"."+cmdTagName), 
						 						  Attributes.Value, new Variant(new Boolean (cmdValue)));
					commandJdbc.updateCommandData(cb.getCommandTag());
				 
					System.out.println("Command of type Boolean sent Successfully..!"+status);
					break;
		
				case "Float" :
					status = cmduaClient.writeAttribute(NodeId.parseNodeId("ns=2;s="+assetName+"."+cmdTagName), 
												 Attributes.Value, new Variant(new Float (cmdValue)));
					commandJdbc.updateCommandData(cb.getCommandTag());
			     
					System.out.println("Command of type Float sent Successfully..!"+status);
					break;
			
				case "Integer" :
					status = cmduaClient.writeAttribute(NodeId.parseNodeId("ns=2;s="+assetName+"."+cmdTagName), 
												 Attributes.Value, new Variant(new Integer (cmdValue)));
					commandJdbc.updateCommandData(cb.getCommandTag());
			     
					System.out.println("Command of type Integer sent Successfully..!"+status);
					break;
				default :
				
					System.out.println("No Command Sent..!");
			}
	    }
		
		cmduaClient.disconnect();
	 
   }
	
}	


