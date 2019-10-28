package com.naver.choch92.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaumLogin {

	public static void main(String[] args) {
		try {
			// 드라이버 위치 등록
			System.setProperty("webdriver.chorme.driver", "./chromedriver");
			// 크롬 실행
			WebDriver driver = new ChromeDriver();
			// 다음 로그인 페이지 접속
			driver.get("https://logins.daum.net/accounts/signinform.do?url=https%3A%2F%2Fwww.daum.net%2F");
			Thread.sleep(1000);
			// id란에 입력하기
			driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("choch92");
			// pw란에 입력하기
			driver.findElement(By.xpath("//*[@id=\"inputPwd\"]")).sendKeys("ch199293");
			// 로그인 버튼 클릭
			driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
			// 카페에 접속
			Thread.sleep(1000);
			driver.get("http://cafe.daum.net/moonlight-rpg");
		} catch (Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}
