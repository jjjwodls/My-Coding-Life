package StringTest;

import java.security.MessageDigest;

public class MD5Encrypt {

	public static void main(String[] args) {
		
		String str = "1";
		
		StringBuffer sb = new StringBuffer();
		int i;
		
		try{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte[] md5Bytes = md5.digest(); 
			
			for( i = 0 ; i < md5Bytes.length ; i++){
				sb.append(md5Bytes[i]);
			}
			
		} catch (Exception e) {
		}
      
		System.out.println(sb.toString());
//		return	sb.toString();
		
	}
}
