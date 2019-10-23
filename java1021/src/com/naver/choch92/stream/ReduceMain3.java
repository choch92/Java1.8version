package com.naver.choch92.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceMain3 {

	public static void main(String[] args) {
		String [] ar = {"C&C++", "Java", "C#", "JSP", "Python", "R", "Swift", "Kotlin",
				"SQL", "Haskell", "Closure", "Scala", "Ruby", "Php"};
		// 배열을 가지고 스트림을 생성
		Stream <String> stream = Arrays.stream(ar);
		/** 오름차순 정렬
		// String 클래스는 Comparable 인터페이스를 implements해서 정렬이 가능
		stream.sorted().forEach(lang->System.out.println(lang));
		**/
		
		/**
		// 내림차순 정렬
		stream.sorted(Comparator.reverseOrder()).forEach(lang->System.out.println(lang));
		**/
		
		// Student의 배열을 생성
		Student [] students = {
				new Student(1, "아이린", "여자", 90),
				new Student(2, "차범근", "남자", 88),
				new Student(3, "박정숙", "여자", 93),
				new Student(4, "이종범", "남자", 91),
				new Student(5, "선동렬", "남자", 76),
				new Student(6, "보아", "여자", 92)
		};
		// 배열을 스트림으로 생성
		Stream <Student> st = Arrays.stream(students);
		// 이 형태를 예외 없이 사용하고자 하면 Student 클래스에 Comparable 인터페이스를 구현 해야 함
		st.sorted().forEach(student -> System.out.println(student));
	}
}
