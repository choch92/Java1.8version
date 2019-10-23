package com.naver.choch92.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain4 {

	public static void main(String[] args) {
		LinkedList <Student> list = new LinkedList<>();
		list.add(new Student(1, "마빈해글러", "남자", 98));
		list.add(new Student(2, "나브라틸로바", "여자", 78));
		list.add(new Student(3, "조몬타나", "남자", 86));
		list.add(new Student(4, "카타리나비트", "여자", 85));
		list.add(new Student(5, "웨인그레츠키", "남자", 89));
		list.add(new Student(6, "그리피스조이너", "여자", 85));
		
		// List를 스트림으로 생성
		Stream <Student> stream = list.stream();
		// gender 가 남자인 데이터만 모아서 List 만들기
		List<Student> li = stream.filter(student -> {
			return student.getGender().equals("남자");
		}).collect(Collectors.toList());
		System.out.printf("li:%s\n", li);
	}
}
