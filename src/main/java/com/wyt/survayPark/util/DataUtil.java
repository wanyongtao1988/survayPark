package com.wyt.survayPark.util;

import java.security.MessageDigest;

public class DataUtil {
	
	public static String md5(String arg){
		try {
			StringBuffer sb = new StringBuffer();
			char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] data = md.digest(arg.getBytes());
			for(byte b : data){
				sb.append(chars[(b>>4) & 0x0f]);
				sb.append(chars[b & 0x0f]);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
