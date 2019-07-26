package StringTest;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		Vector rt = new Vector();
		
		Vector tmpVector = new Vector();
		
		String tempPermType = "1234";
		
		NFPermType permType = new NFPermType();
		
		permType.permType = tempPermType;
		
		tmpVector.add( permType );
		
		NFPermBasic perm = new NFPermBasic();
		perm.deptID = "dept";
		perm.permUserID = "n01";
		
		perm.LPerm.addAll(tmpVector);
		rt.add(perm);
		
		System.out.println(rt.get(0).getClass());
		NFPermBasic nfPermBasic =  (NFPermBasic) rt.get(0);
		System.out.println(nfPermBasic.LPerm.get(0).getClass());
		
		
		NFPermType nfPermType = (NFPermType) nfPermBasic.LPerm.get(0);
		System.out.println(nfPermType.permType);
		
		String temp = "1NNNNNNNN";
		
		System.out.println(temp.substring(0,1));
		
		
	}

}
