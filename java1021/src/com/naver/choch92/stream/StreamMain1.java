package com.naver.choch92.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain1 {

	public static void main(String[] args) {
		/**
		List<String> list = new ArrayList<>();
		list.add("후라이드치킨");
		list.add("양념치킨");
		list.add("간장치킨");
		**/
		String [] list = {"후라이드치킨", "양념치킨", "간장치킨", "파닭치킨"};
		
		// 일반 반복문을 이용해서 접근
		int i = 0;
		int len = list.length;
		while(i<len) {
			// 데이터 가져오기
			String item = list[i];
			// 가져온 데이터 출력 - 출력
			System.out.printf("%s\n", item);
			// 인덱스 변수 증감
			i=i+1;
		}
		System.out.printf("========\n");
		
		// iterator(cursor - 반복자)
		// 데이터를 가져온 위치에 대기하고 있다가 다음 데이터를 찾아가는 방법
		// 배열은 사용 못함(위에 주석 처리된 Arraylist에서만 가능
		/**
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			System.out.printf("%s\n", next);
		}
		System.out.printf("========\n");
		**/

		// 최근에는 위의 방식을 개선해서 Fast Enumeration 제공
		// 언어에 따라 Map도 이 방식이 가능
		for(String imsi : list) {
			System.out.printf("%s\n", imsi);
		}
		System.out.printf("========\n");
		
		// 위의 문장을 조금 더 간결하게 작성
		// Stream<String> stream = list.stream(); <- 맨위에 list 주석처리용
		Stream<String> stream = Arrays.stream(list);
		stream.forEach(name -> System.out.println(name));
	}
}
