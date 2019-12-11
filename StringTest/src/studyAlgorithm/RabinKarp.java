package studyAlgorithm;

//문자열 탐색에서 많이 사용됨.
//동일한 문자열이 숨어있는지 확인 할 때 사용되며 시간복잡도는 O(N)
public class RabinKarp {

	public static void main(String[] args) {
		String parent = "ababacabacaabacaaba";
		String pattern = "abacaaba";
		RabinKarp karp = new RabinKarp();
		karp.findString(parent, pattern);
	}
	
	public void findString(String parent, String pattern) {
		int parentLen = parent.length();
		int patternLen = pattern.length();
		int parentHash = 0;
		int patternHash = 0;
		int power =1;
		
		for(int i = 0 ; i <= parentLen - patternLen ; i++) {
			if(i == 0) {
				for(int j = 0 ; j < patternLen ; j++) {
					parentHash += parent.charAt(patternLen-1-j)*power;
					patternHash += pattern.charAt(patternLen-1-j)*power;
					if(j < patternLen-1)
						power *= 2;
				}
			}else { // 부모의 해쉬가 계속 바뀌어야한다.
				parentHash = 2 * (parentHash - parent.charAt(i-1)*power) + parent.charAt(patternLen-1+i);
			}
			System.out.println(patternHash + " // " + parentHash);
			if(parentHash == patternHash) {
				boolean finded = true;
				for(int j = 0 ; j < patternLen ; j++) {
					if(parent.charAt(i+j) != pattern.charAt(j)) {
						finded = false;
						break;
					}
				}
				if(finded) {
					System.out.println((i+1) + " 번째에서 패턴 확인!");
				}
			}
			
		}
		
	}

}
