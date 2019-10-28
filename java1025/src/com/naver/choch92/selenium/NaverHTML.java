package com.naver.choch92.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverHTML {

	public static void main(String[] args) {
		try {
			// 드라이버 위치 등록
			System.setProperty("webdriver.chorme.driver", "./chromedriver");
			// 크롬 실행
			WebDriver driver = new ChromeDriver();
			// 사이트 접속
			driver.get("http://www.daum.net");
			// html을 가져와서 출력
			System.out.printf("%s\n", driver.getPageSource());
		}catch(Exception e) {
			System.out.printf("크롬 실행 오류 : %s\n", e.getMessage());
			e.printStackTrace();
		}		
	}
}
