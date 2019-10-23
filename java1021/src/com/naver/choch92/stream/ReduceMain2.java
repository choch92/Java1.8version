package com.naver.choch92.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceMain2 {

	public static void main(String[] args) {
		// Store 객체 4개를 저장할 수 있는 배열이 생성
		Store [] ar = new Store[4];
		ar[0] = new Store(1, "만보성", 53, "양천구 목동");
		ar[1] = new Store(1, "희래성", 23, "양천구 신정동");
		ar[2] = new Store(1, "홍보석", 75, "서울시 노원구 중계동 상아아파트");
		ar[3] = new Store(1, "대리석", 17, "노원구 중계동 롯데아파트");
		// 배열을 가지고 스트림 생성
		Stream <Store> stream = Arrays.stream(ar);
		stream.filter((store)->{
			//return store.getReplyCnt() < 30;
			// 구로 분할할 때
			// return store.getAddress().substring(0,3).equals("노원구");
			// 동으로 분할할 때
			// 공백을 기준으로 분할
			String [] ad = store.getAddress().split(" ");
			if(ad[1].equals("중계동")) {
				return true;
			}
			/**
			for(String imsi : ad) {
				// "중계동"이 있으면 true로 출력되고 아니면 false로 출력이 안됨
				if(imsi.equals("중계동")) {
						return true;
				}
			}
			**/
			return false;
		}).forEach(store -> System.out.println(store));
	}
}
