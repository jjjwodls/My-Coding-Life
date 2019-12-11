package studyAlgorithm;

//문자열 매칭 알고리즘으로 많이 사용된다.
//아직 완성 안됨.
public class KnuthMorrisPratt_KMP {
	
	public static void main(String[] args) {
		String pattern = "abacaaba";
		int[] check = new int[pattern.length()];
		makeTable(pattern,check);
		for(int rst : check) {
			System.out.print(rst + " ");
		}
	}
	
	public static void makeTable(String pattern,int[] check) {
		
		int i = 0;
		for(int j = 1 ; j < pattern.length() ; j++) {
			
			while(i > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				i = check[i-1];
			}
			// i의 인덱스 +1 값을 대입해준다.
			if(pattern.charAt(i) == pattern.charAt(j)) {
				check[j] = ++i;
			}
		}
		
	}

}
