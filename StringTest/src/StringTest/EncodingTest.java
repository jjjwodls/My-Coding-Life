package StringTest;

import java.io.UnsupportedEncodingException;

public class EncodingTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String temp = "〒(511-442) 中國 广州市 番禺区 南村镇 锦绣香江内 广州韩国学校-";
		
		System.out.println(temp);
		
		System.out.println(temp.getBytes("ksc5601"));
		
		String euckr = new String(temp.getBytes("utf-8"), "ksc5601");
		
		System.out.println(euckr);
		
		//byte[] utf8StrBuffer = temp.getBytes("UTF-8");
	
		//String decodeEuckr = utf8StrBuffer.
		
	}
}
