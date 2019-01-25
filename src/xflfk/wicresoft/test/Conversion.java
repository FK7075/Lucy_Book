package xflfk.wicresoft.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Conversion {
	public static String toGBK(String str) {
		 String strGBK;
		try {
			strGBK = URLEncoder.encode(str, "GBK");
			return strGBK;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}  
	}
	public static String gbkTo(String str) {
		 String strUTF8;
		try {
			strUTF8 = URLDecoder.decode(str, "GBK");
			return strUTF8;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} 
	}
	public static String toF(String s) {
		if(Conversion.toGBK(s).equals("%D0%BB%B8%BB%C0%F6"))
			return Conversion.gbkTo("%A6%D1%3D%A6%C1%281-Sin%A6%C8%29");
		if(Conversion.toGBK(s).equals("%A6%D1%3D%A6%C1%281-Sin%A6%C8%29"))
			return Conversion.gbkTo("%D0%BB%B8%BB%C0%F6");
		return s;
	}

}
