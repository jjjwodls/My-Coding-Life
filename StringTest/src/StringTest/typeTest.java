package StringTest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class typeTest {
	
	public static void main(String[] args){
		
		
		String nullStr = "인적";
		String[] ary = nullStr.split("/");
		String temp111 = "";
		for(int i = 0 ; i < ary.length ; i++){
			System.out.println(ary[i]);
			temp111 += ary[i] + "사고/";
		}
		System.out.println(temp111);
		System.out.println(temp111.substring(0, temp111.length()-1));
		
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		Float floa = (float) 0;
		System.out.println(nf.format(floa));
		
		float temp = (float) 123333.456;
		Float temp2 = (float) 123333.456;
		int intTemp = 1000000;
		
		String test = String.format("%.2f", temp);
		System.out.println(test);
		
		String test1 = String.format("%,2d", Math.round(temp));
		System.out.println(test1);
		
		
		System.out.println("nf.format(temp) = " + nf.format(temp));
		System.out.println(nf.format(temp2));
		System.out.println("intTemp = " + nf.format(intTemp));
		
		String stringTemp = "abcdefg";
		String stringTmpe1 = "1000000";
		
		if(stringTmpe1 != null){
			
		}
		Integer.parseInt(stringTmpe1);
		
		System.out.println(String.format("%,d", Integer.parseInt(stringTmpe1)));
		//stringTemp.format("%,d", Integer.parseInt(stringTmpe1))
		
		String dateTemp = "20190314175355"; //20190314175355 , 20190314 
		dateTemp.substring(0, 4);
		dateTemp.substring(4, 6);
		dateTemp.substring(7, 8);
		System.out.println(dateTemp.substring(0, 4) + "-" +dateTemp.substring(4, 6)+ "-" + dateTemp.substring(6, 8));
		
		System.out.println(dateTemp.substring(0, 4) + "-" +dateTemp.substring(4, 6)+ "-" + dateTemp.substring(6, 8));
		
		int a = 0;
		Integer integerA = 0;
		
		System.out.println();
		String.format("%,d", a);
	}
}
