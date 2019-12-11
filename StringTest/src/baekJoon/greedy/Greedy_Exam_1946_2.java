package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.StringTokenizer;

public class Greedy_Exam_1946_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer str;
		for(int i=0; i<T; i++) {
			int count=Integer.parseInt(br.readLine());
			int[] paper=new int[count];
			int[] interview=new int[count];
			
			ArrayList<Applicant> list=new ArrayList<>();

			for(int j=0; j<count; j++) {
				str=new StringTokenizer(br.readLine());
				paper[j]=Integer.parseInt(str.nextToken());//서류등수
				interview[j]=Integer.parseInt(str.nextToken());//면접등수
				
				list.add(new Applicant(paper[j], interview[j]));
				
			}
			
			Collections.sort(list, new Comparator<Applicant>() {
				//서류 등수가 높은 순으로 정렬한다
				@Override
				public int compare(Applicant o1, Applicant o2) {
					return o1.paper < o2.paper ? -1 : 1;
				}
			});
			
			int ans=count; //합격자는 전체 지원자로 초기화
			int in=list.get(0).interview;//서류 1등의 면접 등수로 초기화
			for(int j=1; j<list.size(); j++) {
				//서류 등수가 높은 순 -> j 이전 데이터 중 가장 높은 면접 등수와만 비교하면 됨
				int cur=list.get(j).interview; //현재 검사하는 지원자의 면접 등수
				if(in < cur){//저장된 면접 등수보다 낮으면
					ans--;//감소
				}
				if(cur < in)//높으면
					in=cur;//max값 업데이트 
			}
			
			System.out.println(ans);
		}
	}

}

class Applicant{
	int paper;
	int interview;
	
	Applicant(int paper, int interview){
		this.paper=paper;
		this.interview=interview;
	}

	@Override
	public String toString() {
		return "Applicant [paper=" + paper + ", interview=" + interview + "]";
	}
	
	
}
