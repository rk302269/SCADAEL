package com.gepower.renewables.scadaedgelite.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class ScadaUtil {

	public static String secondsToString(long logTime) {
		long millis = logTime*1000;
	        Date date = new Date(millis);
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	        String formattedDate = sdf.format(date);
	        return formattedDate;
		}
	
	public static long getEndTimeInSecs()
	{
		long currentTimestamp = System.currentTimeMillis()/1000;
		
		return currentTimestamp-(2*60*60);
		
	}
	
	public static long getStartTimeInSecs()
	{
		long currenttimestamp = getEndTimeInSecs() - (4*60*60);
		return currenttimestamp;
	}
	
	public static String getAssetName(String uniqueTagId)
	{
		String[] output = uniqueTagId.split("-");
		return output[0];
		
	}
	
	public static String gettagId(String uniqueTagId)
	{
		String[] output = uniqueTagId.split("-");
		return output[1];		
	}
	
	
}
