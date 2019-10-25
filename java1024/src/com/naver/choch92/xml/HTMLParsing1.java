package com.naver.choch92.xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParsing1 {

	public static void main(String[] args) {
		// www.hani.co.kr의 html 받아오기
		String html = "";
		try {
			String addr = "http://www.hani.co.kr";
			URL url = new URL(addr);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(30000);
			con.addRequestProperty("Authorization", "KakaoAK abfe30c50bf8646b3518958413f646c1");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			html = sb.toString();
			//System.out.printf("%s\n", html);			
		}catch(Exception e) {
			System.out.printf("다운로드 예외 : %s\n", e.getMessage());
			e.printStackTrace();
		}
		// HTML 파싱을 수행하는 부분
		try {
			// HTML 문자열을 파싱할 수 있도록 DOM으로 생성
			Document document = Jsoup.parse(html);
			/**
			// 태그로 찾아오기
			Elements elements = document.getElementsByTag("a");
			for(int i=0;i<elements.size();i=i+1) {
				Element element = elements.get(i);
				System.out.printf("%s\n", element.text());
			}
			**/
			// F12를 누르고 Select an element in the page to inspect it(화면 왼쪽상단의 마우스)를
			// 클릭 후 원하는 곳을 클릭하고 음영생기는곳을 복사하여 select() 괄호안에 복사하기
			Elements elements = document.select("#main-top > div.main-top > div.main-top-article > h4 > a");
			for(int i=0;i<elements.size();i=i+1) {
				Element element = elements.get(i);
				// 태그 안의 문자열을 찾아오기
				System.out.printf("%s\n", element.text());
				// 태그 내의 속성 값을 찾아오기
				System.out.printf("%s\n", element.attr("href"));
			}
		}catch(Exception e) {
			System.out.printf("HTML 파싱 예외 : %s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}
