package com.wyt.survayPark.util;

import java.util.Collection;

public class ValidateUtil {
	
	public static boolean isValid(String arg){
		if(null == arg || "".equals(arg.trim())){
			return false;
		}
		return true;
	}
	public static boolean isValid(Collection arg){
		if(null == arg || arg.isEmpty()){
			return false;
		}
		return true;
	}

}
