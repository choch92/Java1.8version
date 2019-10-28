package com.naver.choch92.swing;

import javax.swing.JFrame;

public class ImageFrame extends JFrame {
	public ImageFrame() {
		ImagePanel panel = new ImagePanel();
		add("Center", panel);

		setTitle("2D 객체를 이용한 출력");
		setBounds(100, 100, 350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		System.out.printf("생성자\n");
	}
}
