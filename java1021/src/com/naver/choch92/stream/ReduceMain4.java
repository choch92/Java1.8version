package com.naver.choch92.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ReduceMain4 {

	public static void main(String[] args) {
		// Student의 배열을 생성
		Student [] students = {
			new Student(1, "아이린", "여자", 90),
			new Student(2, "차범근", "남자", 88),
			new Student(3, "박정숙", "여자", 90),
			new Student(4, "이종범", "남자", 91),
			new Student(5, "선동렬", "남자", 76),
			new Student(6, "보아", "여자", 92)
		};
		// 배열을 스트림으로 생성
		Stream <Student> st = Arrays.stream(students);
		// Comparator 인터페이스를 이용한 정렬
		// .reversed를 생략하면 오름차순
		// score가 같으면 이름의 오름차순
		st.sorted(Comparator.comparing(Student::getScore).reversed()
				.thenComparing(Comparator.comparing(Student::getName).reversed()))
				.forEach(student -> System.out.println(student));
	}

}
