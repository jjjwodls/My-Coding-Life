package codility;


public class BinaryGap {

	public static void main(String[] args) {
		int N = 32;
		String binaryStr = Integer.toBinaryString(N);
		char[] binaryAry = binaryStr.toCharArray();
		char tmep = '1';
		int max = 0;
		int cnt = 0;
		for(char binary : binaryAry) {
			if(tmep == binary) {
				if(cnt > max)
					max = cnt;
				cnt = 0;
			}else {
				cnt ++;
			}
		}
		System.out.println(max);
	}

}
