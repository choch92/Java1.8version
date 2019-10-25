package com.naver.choch92.xml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsing2 {

	public static void main(String[] args) {
		// 기상청 날씨 데이터 가져오기
		String xml = "";
		try {
			// 주소 만들기
			String addr = "http://www.weather.go.kr/weather/forecast/mid-term-xml.jsp?stnld=109";
			URL url = new URL(addr);
			// 연결하기
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(30000);
			con.addRequestProperty("Authorization", "KakaoAK abfe30c50bf8646b3518958413f646c1");
			// 문자열 데이터 읽고 저장하기
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			// 데이터 옮기기
			xml = sb.toString();
			br.close();
			con.disconnect();
			// System.out.printf("%s\n", xml);
		} catch (Exception e) {
			System.out.printf("다운로드 예외 : %s\n", e.getMessage());
			e.printStackTrace();
		}
		// 파싱
		try {
			// 파싱을 수행할 객체 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			// 파싱을 수행할 데이터 만들기
			InputStream is = new ByteArrayInputStream(xml.getBytes());
			// 메모리에 전부 펼치기
			Document document = documentBuilder.parse(is);
			// 루트 찾기
			Element element = document.getDocumentElement();
			
			// city 태그의 내용을 찾아서 List에 저장
			List <String> cities = new ArrayList<>();			
			// city 태그 전부 가져오기
			NodeList cityList = element.getElementsByTagName("city");			
			for(int i=0; i<cityList.getLength(); i=i+1) {
				Node item = cityList.item(i);
				Node city = item.getFirstChild();
				cities.add(city.getNodeValue());
			}
			
			// 날짜를 가져와서 전부 저장하기
			List <String> dateList = new ArrayList<>();
			// tmEf 태그의 값 가져오기
			NodeList tmef = element.getElementsByTagName("tmEf");
			for(int i=0; i<tmef.getLength(); i=i+1) {
				Node item = tmef.item(i);
				Node t = item.getFirstChild();
				dateList.add(t.getNodeValue());
			}
			System.out.printf("%s\n", dateList);
		
			// 날씨를 가져와서 전부 저장하기
			List <String> weatherList = new ArrayList<>();
			// wf 태그의 값 가져오기
			NodeList WF = element.getElementsByTagName("wf");
			for(int i=0; i<WF.getLength(); i=i+1) {
				// 첫번째 데이터를 사용하지 않기 위해서 첫번째 데이터인 경우는 다음으로 넘기기
				if(i==0)continue;
				Node item = WF.item(i);
				Node w = item.getFirstChild();
				weatherList.add(w.getNodeValue());
			}
			System.out.printf("%s\n", weatherList);
			
			int i = 0;
			for(String city : cities) {
				System.out.printf("%s", city);
				for(int j = 0; j<6; j=j+1) {
					System.out.printf("\t%s:%s\t\n", dateList.get(i*6+j), weatherList.get(i*6+j));
				}
				i = i + 1;
				System.out.printf("\n");
			}			
		}catch(Exception e) {
			System.out.printf("XML 파싱 예외 : %s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}
