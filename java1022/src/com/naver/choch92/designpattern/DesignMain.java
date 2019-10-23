package com.naver.choch92.designpattern;

import com.naver.choch92.adapter.NewSystem;
import com.naver.choch92.adapter.OldSystem;
import com.naver.choch92.delegate.Button;
import com.naver.choch92.delegate.OnClickListener;
import com.naver.choch92.service.CustomerService;
import com.naver.choch92.service.CustomerServiceImpl;

public class DesignMain {

	public static void main(String[] args) {
		SingleTon s1 = SingleTon.sharedInstance();
		SingleTon s2 = SingleTon.sharedInstance();
		System.out.printf("s1:%d\n", s1.hashCode());
		System.out.printf("s2:%d\n", s2.hashCode());
		// java.lang.Runtime 클래스
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();
		System.out.printf("s1:%d\n", r1.hashCode());
		System.out.printf("s2:%d\n", r2.hashCode());
		
		// 팩토리 메소드 패턴이 적용된 클래스의 객체 생성
		Dao dao1 = DaoFactory.create();
		Dao dao2 = DaoFactory.create();
		System.out.printf("dao1:%d\n", dao1.hashCode());
		System.out.printf("dao2:%d\n", dao2.hashCode());
		
		// 템플릿 메소드 패턴이 적용된 경우의 객체 생성
		// 변수는 인터페이스 타입으로 만듭니다.
		CustomerService service = new CustomerServiceImpl();
		service.delete();
		
		new OldSystem().oldMethod();
		new NewSystem().newMethod();
		
		Button btn = new Button();
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.printf("버튼 클릭\n");				
			}			
		});
		btn.onClick();
	}
}
