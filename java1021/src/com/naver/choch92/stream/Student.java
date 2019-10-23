package com.naver.choch92.stream;

public class Student implements Comparable{
	private int num;
	private String name;
	private String gender;
	private int score;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", gender=" + gender + ", score=" + score + "]";
	}
	public Student(int num, String name, String gender, int score) {
		super();
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	public Student() {
		super();
	}
	@Override
	public int compareTo(Object o) {
		// 매개변수는 자신의 자료형으로 형 변환해서 사용
		Student other = (Student)o;
		// 숫자 오름차순 정렬
		// return this.score - other.score;
		
		// 이름 오름차순 정렬
		return this.name.compareTo(other.name);
	}
}
