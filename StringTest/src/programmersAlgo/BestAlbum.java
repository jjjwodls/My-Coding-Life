package programmersAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 문제 설명 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로
 * 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다. 
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다. 
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. 
 * 
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항 genres[i]는 고유번호가 i인 노래의 장르입니다. 
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다. 
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다. 
 * 장르 종류는 100개 미만입니다. 
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다. 
 * 모든 장르는 재생된 횟수가 다릅니다. 
 * 
 * 입출력 예 
 * 			genres 								plays 					return 
 * [classic, pop, classic, classic, pop] [500, 600, 150, 800, 2500] [4, 1, 3, 0] 
 * 
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 * 
 * 고유 번호 3: 800회 재생 
 * 고유 번호 0: 500회 재생 
 * 고유 번호 2: 150회 재생 
 * 
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 * 
 * 고유 번호 4: 2,500회 재생 
 * 고유 번호 1: 600회 재생 
 * 
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 * 
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 * 
 * @author JJI
 * 
 */
public class BestAlbum {
	
	public static void main(String[] args) {
		String [] genres = {"classic", "pop", "classic", "classic", "pop","classic","classic"};
		int[] plays = {200, 600, 150, 800, 2500, 200,200};
		
		solution(genres, plays);
	}
	
	/*public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		int genresLength = genres.length;
		//int playsLength = plays.length;
		
		List<Album> albumList = new ArrayList<Album>();
		Album album = null;
		for(int i = 0 ; i < genresLength ; i ++){
			album = new Album();
			album.setIdx(i);
			album.setGenre(genres[i]);
			album.setPlaysCnt(plays[i]);
			albumList.add(album);
		}
		
		Collections.sort(albumList, new Comparator<Album>() {

			@Override
			public int compare(Album o1, Album o2) {
				if(o1.playsCnt < o2.playsCnt){
					return 1;
				}else if(o1.playsCnt > o2.playsCnt){
					return -1;
				}else{
					return 0;
				}
			}
		});
		String albumGenre = null;
		String albumGenre2 = null;
		List<Integer> idxList = new ArrayList<Integer>();
		boolean flag = true;
		
		for(int i = 0; i < albumList.size() ; i++){
			albumGenre = albumList.get(i).getGenre();
			for(int j = i+1 ; j < albumList.size(); j++){
				albumGenre2 = albumList.get(j).getGenre();
				if(albumGenre.equals(albumGenre2)){
					if( (albumList.get(i).getPlaysCnt() == albumList.get(j).getPlaysCnt()) &&  albumList.get(i).getIdx() > albumList.get(j).getIdx() ){
						idxList.add(albumList.get(j).getIdx());
						idxList.add(albumList.get(i).getIdx());
					}else{
						idxList.add(albumList.get(i).getIdx());
						idxList.add(albumList.get(j).getIdx());
					}
					flag = false;
					break;
				}
			}
			if(flag){
				idxList.add(albumList.get(i).getIdx());
			}
			flag = true;
		}
		
		return answer;
	}*/
	
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		int genresLength = genres.length;
		//int playsLength = plays.length;
		
		List<Album> albumList = new ArrayList<Album>();
		Album album = null;
		Map<String,Integer> albumMap = new HashMap<String,Integer>();
		
		Integer playCntTmp = null;
		
		for(int i = 0 ; i < genresLength ; i ++){
			album = new Album();
			album.setIdx(i);
			album.setGenre(genres[i]);
			album.setPlaysCnt(plays[i]);
			
			playCntTmp = albumMap.get(genres[i]);
			if(playCntTmp == null){
				albumMap.put(genres[i], plays[i]);
			}else{
				albumMap.put(genres[i], playCntTmp+plays[i]);
			}
			
			playCntTmp = albumMap.get(genres[i]);
			album.setTotalPlay(playCntTmp);
			albumList.add(album);
		}
		
		List<Album> hashMapList = new ArrayList<Album>();
		Album hashMapAlbum = null;
		for(String genreKey : albumMap.keySet()){
			hashMapAlbum = new Album();
			hashMapAlbum.setGenre(genreKey);
			hashMapAlbum.setTotalPlay(albumMap.get(genreKey));
			hashMapList.add(hashMapAlbum);
		}
		
		Collections.sort(hashMapList, new Comparator<Album>() {

			@Override
			public int compare(Album o1, Album o2) {
				if(o1.totalPlay < o2.totalPlay){
					return 1;
				}else if(o1.totalPlay > o2.totalPlay){
					return -1;
				}else{
					return 0;
				}
			}
		});
		
		Collections.sort(albumList, new Comparator<Album>() {

			@Override
			public int compare(Album o1, Album o2) {
				if(o1.playsCnt < o2.playsCnt){
					return 1;
				}else if(o1.playsCnt > o2.playsCnt){
					return -1;
				}else{
					return 0;
				}
			}
		});
		
		String firstGenre = null;
		String secondGenre = null;
		List<Integer> albumIdx = new ArrayList<Integer>();
		if(hashMapList.size() == 1){
			firstGenre = hashMapList.get(0).getGenre();
			for(int i = 0 ; i < albumList.size(); i++){
				
			}
		}else{
			firstGenre = hashMapList.get(0).getGenre();
			secondGenre = hashMapList.get(1).getGenre();
			
			
		}
		
		for(Album albumObj : albumList){
			System.out.println(albumObj);
		}
		Album temp = null;
		Album temp2 = null;
		String tempGenre = null;
		List<Integer> albumIdxList = new ArrayList<Integer>();
		boolean flag = false;
		for(int i = 0 ; i < albumList.size() ; i++){
			temp = albumList.get(i);
			tempGenre = temp.getGenre();
			for(int j = i+1; j < albumList.size() ; j++){
				temp2 = albumList.get(j);
				if(tempGenre.equals(temp2.getGenre())){
					albumIdxList.add(temp.getIdx());
					albumIdxList.add(temp2.getIdx());
					break;
				}
			}
		}
		
		/*
		String albumGenre = null;
		String albumGenre2 = null;
		List<Integer> idxList = new ArrayList<Integer>();
		boolean flag = true;
		
		for(int i = 0; i < albumList.size() ; i++){
			albumGenre = albumList.get(i).getGenre();
			for(int j = i+1 ; j < albumList.size(); j++){
				albumGenre2 = albumList.get(j).getGenre();
				if(albumGenre.equals(albumGenre2)){
					if( (albumList.get(i).getPlaysCnt() == albumList.get(j).getPlaysCnt()) &&  albumList.get(i).getIdx() > albumList.get(j).getIdx() ){
						idxList.add(albumList.get(j).getIdx());
						idxList.add(albumList.get(i).getIdx());
					}else{
						idxList.add(albumList.get(i).getIdx());
						idxList.add(albumList.get(j).getIdx());
					}
					flag = false;
					break;
				}
			}
			if(flag){
				idxList.add(albumList.get(i).getIdx());
			}
			flag = true;
		}
		*/
		return answer;
	}
	
	public static class Album {
		
		private int idx;
		private int playsCnt;
		private String genre;
		private int totalPlay;
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public int getPlaysCnt() {
			return playsCnt;
		}
		public void setPlaysCnt(int playsCnt) {
			this.playsCnt = playsCnt;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		
		
		public int getTotalPlay() {
			return totalPlay;
		}
		public void setTotalPlay(int totalPlay) {
			this.totalPlay = totalPlay;
		}
		@Override
		public String toString() {
			return "idx = " + this.idx + " genre = " + this.genre + " playsCnt = " + this.playsCnt + " total = " + this.totalPlay;
		}
		
	}
}
