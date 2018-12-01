package com.eddyfajar.billyon.generator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 29, 2018 6:28:20 PM
 * @eddypastika
 */
public class ValueGenerator {
	
	public Long GenerateId() {
		
		String fullId = "";
		
		Date date = new Date();
		String sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
//		fullId = sdf + "" + System.currentTimeMillis();
		
		
		return Long.parseLong(sdf);
	}

}
