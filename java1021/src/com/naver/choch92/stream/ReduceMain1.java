package com.naver.choch92.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceMain1 {

	public static void main(String[] args) {
		// 문자열 배열을 생성
		String [] ar = {"삼겹살", "목살", "갈매기살", "등심", "삼겹살", "항정살", "목살"};
		int PageCount = 2;
		// 배열을 이용해서 Stream을 생성
		Stream <String> stream = Arrays.stream(ar);
		// 중복 제거
		// stream.distinct().forEach(name -> System.out.println(name));
		
		// skip, limit 활용
		int len = ar.length;
		for(int i=0; i<len; i=i+1) {
			Stream <String> imsi = Arrays.stream(ar);
			imsi.skip(i*PageCount).limit(PageCount).forEach(name -> System.out.println(name));
			try {
				Thread.sleep(4000);
			}catch(Exception e) {}
		}
	}
}
