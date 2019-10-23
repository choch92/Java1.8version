package com.naver.choch92.stream;

import java.util.LinkedList;
import java.util.stream.Stream;

public class StreamMain1 {

	public static void main(String[] args) {
		// 여러 개의 Student 객체를 저장
		// 동일한 모양 여러 개 - 배열, List
		// 다른 모양 여러 개 - DTO 생성, Map
		
		// LinkedList : 다음 데이터를 가리키는 포인터를 소유한 리스트
		// 삽입 및 삭제가 빈번한 경우에 사용
		// 읽기만 하는 경우에는 속도가 느려서 못씀
		LinkedList <Student> list = new LinkedList<>();
		list.add(new Student(1, "마빈해글러", "남자", 98));
		list.add(new Student(2, "나브라틸로바", "여자", 78));
		list.add(new Student(3, "조몬타나", "남자", 86));
		list.add(new Student(4, "카타리나비트", "여자", 85));
		list.add(new Student(5, "웨인그레츠키", "남자", 89));
		list.add(new Student(6, "그리피스조이너", "여자", 85));
		
		// List를 스트림으로 생성
		Stream <Student> stream = list.stream();
		/**
		// Stream.중간연산.최종연산
		// 중간 연산은 생략가능하고 중복가능, 최종연산은 한번만 가능
		long cnt = stream.filter(student -> {
			return student.getGender().equals("여자");
		}).count();
		System.out.printf("여자 : %d명\n", cnt);
		**/
		// Student 객체를 getScore의 결과로 변환하여 합계를 구합니다.
		int sum = stream.filter(student -> {
			return student.getGender().equals("여자");
		}).mapToInt(Student::getScore).sum();
		System.out.printf("여자 점수 합계 : %d\n", sum);
	}
}
