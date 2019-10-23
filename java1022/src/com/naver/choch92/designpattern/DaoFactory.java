package com.naver.choch92.designpattern;

public class DaoFactory {
	// Dao 클래스의 객체를 생성해서 리턴
	public static Dao create() {
		return new Dao();
	}
}
