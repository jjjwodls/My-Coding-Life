package programmersAlgo;

import java.util.*;

/**
 * 디스크 컨트롤러 문제 설명 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가
 * 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
 * 
 * 예를들어
 * 
 * - 0ms 시점에 3ms가 소요되는 A작업 요청 
 * - 1ms 시점에 9ms가 소요되는 B작업 요청 
 * - 2ms 시점에 6ms가 소요되는 C작업
 * 
 * 한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다. 
 * 
 * - A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms) 
 * - B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms) 
 * - C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업  완료(요청에서 종료까지 : 16ms) 
 * 이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.
 * 
 * 하지만 A → C → B 순서대로 처리하면
 * 
 * - A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms) 
 * - C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms) 
 * - B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms) 
 * 
 * 이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 
 * 9ms (= (3 + 7 + 17) / 3)가 됩니다.
 * 
 * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지
 * 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요.
 *  (단, 소수점 이하의 수는 버립니다)
 * 
 * 제한 사항 jobs의 길이는 1 이상 500 이하입니다. 
 * jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간]  입니다. 
 * 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다. 
 * 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다. 
 * 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다. 
 * 입출력 예 jobs return [[0, 3], [1, 9], [2, 6]] 9 입출력 예 설명 문제에 주어진 예와 같습니다.
 * 
 * 0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다. 
 * 1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다. 
 * 2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다
 * 
 * @author jjjwodls
 * 
 * heap 이용
 * disk 우선순위 문제로
 * 우선순위 큐를 사용했다. 
 * 
 * 문제를 풀지는 못했지만 문제를 푸는 과정에서 자료구조가 2개가 필요하다는것을 알았다.
 * 그리고 정렬과정에서 요청시간기준 그리고 처리시간 기준 두개로 정렬할 필요가 있는것을 배웠다.
 */

public class DiskPriorityExecution {

	public static void main(String[] args) {
		//int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		//int[][] jobs = {{0, 3}, {3, 4}, {5, 2} , {6,1}};
		//int[][] jobs = {{0, 3}, {5, 20}, {7, 5} , {8,2}};
		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
		//[[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 2], [15, 34], [35, 43], [26, 1]]
				//[[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]]				
		
		DiskPriorityExecution diskPriorityExecution = new DiskPriorityExecution();
		diskPriorityExecution.solution2(jobs);
	}

	public int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<DiskRequest> pq = new PriorityQueue<DiskRequest>();
		
		PriorityQueue<Integer> resultPq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		}); // 가장 오래걸린 즉, 최종적으로 수행된 disk가 나와야 한다. (우선순위와 상관없는 들어온 순서대로의 disk 수행 결과)
		
		int processingDisk = 0;
		int jobsLength = jobs.length;
		DiskRequest diskRequest = null;
		resultPq.offer(jobs[0][1]);
		int sum = resultPq.peek();
		
		for(int curTime = 1 ; curTime < jobsLength ; curTime++) {
			
			if(sum ==  jobs[curTime][0]) {
				processingDisk = jobs[curTime][1];
				sum += processingDisk;
				resultPq.add(processingDisk);
			}else {
				diskRequest = new DiskRequest(jobs[curTime][0],jobs[curTime][1]);
				pq.offer(diskRequest); // 수행 순서가 빠른 순으로 넣는다.
			}
		}
		
		while(!pq.isEmpty()) {
			diskRequest = pq.poll();
			resultPq.offer(sum-diskRequest.getReqTime()+diskRequest.getProcessTime());
			sum += diskRequest.getProcessTime();
		}
		int diskProcessingSum = 0;
		while(!resultPq.isEmpty()) {
			diskProcessingSum += resultPq.poll();
		}
		
		answer = diskProcessingSum/jobsLength;
		
		return answer;
	}
	
	public int solution2(int[][] jobs) {
		int answer = 0;
		PriorityQueue<DiskRequest> readyPq = new PriorityQueue<DiskRequest>();
		List<DiskRequest> diskList = new ArrayList<DiskRequest>();
		int jobsLength = jobs.length;
		DiskRequest diskRequest = null;
		
		for(int i = 0 ; i < jobsLength ; i++) {
			diskRequest = new DiskRequest(jobs[i][0],jobs[i][1]);
			diskList.add(diskRequest);
		}
		
		
		Collections.sort(diskList, new Comparator<DiskRequest>() {
			@Override
			public int compare(DiskRequest o1, DiskRequest o2) {
				return o1.reqTime - o2.reqTime;
			}
		});
		int settingTime = diskList.get(0).getReqTime();
		int totalTime = 0;
		for (DiskRequest diskRequestObj : diskList) {
			totalTime += (diskRequestObj.getProcessTime() + diskRequestObj.getReqTime() - settingTime);
		}
		
		int idx = 0;
		int job = 0;
		int sum = 0;
		int time = 0;
		
		for(int i = 0 ; i < totalTime ; i++) {
			
			while(idx < jobsLength && i == diskList.get(idx).getReqTime())
				readyPq.offer(diskList.get(idx++));
			
			if(!readyPq.isEmpty() && job == 0) {
				diskRequest = readyPq.poll();
				job = diskRequest.getProcessTime();
				sum += diskRequest.getProcessTime() - diskRequest.getReqTime() + time; 
			}
			if(job > 0) job--;
			
			time ++;
		}
		
		answer = sum/jobsLength;
		
		return answer;
	}
	
	public class DiskRequest implements Comparable<DiskRequest> {
		
		private int reqTime;
		private int processTime;
		
		public DiskRequest(int reqTime, int processTime) {
			super();
			this.reqTime = reqTime;
			this.processTime = processTime;
		}
		
		public int getReqTime() {
			return reqTime;
		}
		public void setReqTime(int reqTime) {
			this.reqTime = reqTime;
		}
		public int getProcessTime() {
			return processTime;
		}
		public void setProcessTime(int processTime) {
			this.processTime = processTime;
		}
		
		@Override
		public String toString() {
			return "DiskRequest [reqTime=" + reqTime + ", processTime=" + processTime + "]";
		}

		@Override
		public int compareTo(DiskRequest o) {
			return this.processTime - o.processTime;
		}
		
		
	}

}
