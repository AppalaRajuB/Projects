package com.techm.util;


import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	
	public static Date getDateFormat(String strDate) 
	{
		Date date = null;
		try
		{
			if(strDate != null)
			{
				date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);  
			}
		}catch(Exception ex)
		{
			ex.getStackTrace();
		}
		
		return date;
	}
	
	
	public static java.sql.Date convertUtilToSql(Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
