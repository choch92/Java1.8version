package com.naver.choch92.externallibrary;
/**
 * 
 * @author 조<br/>창훈
 * Maven으로 MySQL 드라이버를 다운로드 받는 연습
 * 
 */

public class MySQLLoad {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.printf("드라이버 클래스 로드 성공\n");
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}
