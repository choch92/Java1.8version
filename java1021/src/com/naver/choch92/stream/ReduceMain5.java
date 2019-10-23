package com.naver.choch92.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ReduceMain5 {

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
		// Comparator 객체 직접 생성
		Comparator<Student> comp = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getScore() > o2.getScore()) {
					return 1;
				}else if(o1.getScore() == o2.getScore()) {
					return o2.getName().compareTo(o1.getName());
				}else {
					return -1;
				}
			}			
		};
		st.sorted(comp).forEach(student -> System.out.println(student));
	}
}
