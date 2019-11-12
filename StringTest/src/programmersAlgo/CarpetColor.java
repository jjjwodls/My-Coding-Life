package programmersAlgo;

public class CarpetColor {

	public static void main(String[] args) {
		int [] rst = solution(24, 24);
		for (int i = 0; i < rst.length; i++) {
			System.out.println(rst[i]);
		}
	}	
	
	public static int[] solution(int brown, int red) {
	       /* int[] answer = {}; 풀이 1

	        answer = new int[2];
	        if(brown % 2 != 0)
	            return answer;
	        int square = brown + red; // red와 brown 의 타일의 갯수를 다 더하면 총 넓이가 나오므로 이걸 활용한다.
	        int height = 0;
	        
	        for(int width = 1 ; width < brown ; width ++) { //width를 늘려가며 완전탐색을 진행함.
	        	height = square/width;
	        	if( (width-2) * (height-2) == red ) { // red타일의 넓이를 구하려면 width -2 와 height-2 를 곱하면 됨. 왜냐하면 모서리를 제거하고 연산해야 맞기 때문에.
	        		if(width > height) { // 더 넓은것이 가로여야 하므로 체크 진행.
	        			answer[0] = width;
		        		answer[1] = height;
	        		}else {
	        			answer[0] = height;
		        		answer[1] = width;
	        		}
	        		
	        		return answer;
	        	}
	        }*/
		int[] answer = {}; // 풀이2

        answer = new int[2];
        int redW = 1; 
        int redH = 1;
        int result = 0;

        //정답에 가깝긴 했으나 1부터 차근차근 숫자를 늘리며 탐색해야 맞음. redW ++ 이런식으로..
        for(int i = 1; i < red ; i++) {
        	if(red % i == 0) {
         		result = 2*(redW + redH + 2);  
            	if(brown == result){
            		break;
            	}
            	redW = red/i;
            	redH = i;
        	}
        }
        	
        
        if(redW > redH){
        	answer[0] = redW + 2;
        	answer[1] = redH + 2;    
        }else{
        	answer[0] = redH + 2;
        	answer[1] = redW + 2;
        }


        return answer;
	 }

}
