package com.naver.choch92.stream;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamMain5 {
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
		// 남자인 데이터를 골라내서 이름을 key로 하고, 전체 데이터를 value로 하는 Map 만들기
		Map<String, Student> map = stream.filter(student->{
			return student.getGender().equals("남자");
		}).collect(Collectors.toMap(Student::getName, student-> student));
		// Map의 데이터를 각 키마다 출력
		// Map은 Key를 알지 못해도 출력이 가능
		// DTO 클래스는 속성의 이름을 알아야 출력이 가능
		// DTO를 사용하면 구조 변경이 어렵다 - RDBMS
		// Map을 이용하면 구조 변경이 쉽다 - NoSQL
		Set<String> keyset = map.keySet();
		for(String key : keyset) {
			System.out.printf("%s\n", map.get(key));
		}
		// 최근에 등장한 언어들의 자신들이 만든 API의 결과를 Map(Dictionary)으로 리턴하는 경우가 많습니다.
	}
}
