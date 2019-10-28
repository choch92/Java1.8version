package com.naver.choch92.swing;

import javax.swing.JFrame;

public class MouseFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MouseFrame() {
		MousePanel p = new MousePanel();
		add(p);
		setTitle("선그리기");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
