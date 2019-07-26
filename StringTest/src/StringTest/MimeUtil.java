/*
 * Created on 2003. 8. 20.
 *
 * To change this generated comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

package StringTest;

import java.io.Serializable;

import com.oreilly.servlet.Base64Decoder;
import com.oreilly.servlet.Base64Encoder;

public class MimeUtil implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static String encodeByBase64( String src ) throws Exception {
        String output = Base64Encoder.encode(src.getBytes("EUC-KR"));        
        return output;
    }
    
    public static String encodeByBase64( byte [] src ) throws Exception {

        String output = Base64Encoder.encode(src);
        return output;
    }


    public static String decodeByBase64( String src ) throws Exception {

        String output = Base64Decoder.decode(src);
        return output;

    }
}
