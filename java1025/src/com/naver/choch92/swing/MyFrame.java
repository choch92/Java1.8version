package com.naver.choch92.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyFrame(){
		setTitle("그래픽 출력");
		setBounds(0, 0, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		System.out.printf("생성자\n");
	}
	// 화면에 출력될 때 호출되는 메소드
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawString("오늘 점심은 홍콩반점", 96, 90);
		g.setColor(new Color(100,200,100));
		g.drawRect(100, 100, 100, 50);
		System.out.printf("화면 출력\n");
	}
}
