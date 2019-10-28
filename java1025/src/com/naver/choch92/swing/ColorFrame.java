package com.naver.choch92.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ColorFrame() {
		JButton btn1 = new JButton("빨강");
		JButton btn2 = new JButton("파랑");
		JButton btn3 = new JButton("녹색");
		JButton btn4 = new JButton("주황");
		
		JPanel northPanel = new JPanel();
		northPanel.add(btn1);
		northPanel.add(btn2);
		northPanel.add(btn3);
		northPanel.add(btn4);
		add("North", northPanel);
		
		final MyPanel myPanel = new MyPanel();
		add("Center", myPanel);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				myPanel.str = "빨강";
				myPanel.color = Color.RED;
				// 이 메소드가 화면을 다시 그려주는 메소드
				myPanel.repaint();
			}
		});		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.str = "파랑";
				myPanel.color = Color.BLUE;
				// 이 메소드가 화면을 다시 그려주는 메소드
				myPanel.repaint();
			}
		});		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.str = "녹색";
				myPanel.color = Color.GREEN;
				// 이 메소드가 화면을 다시 그려주는 메소드
				myPanel.repaint();
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.str = "주황";
				myPanel.color = Color.ORANGE;
				// 이 메소드가 화면을 다시 그려주는 메소드
				myPanel.repaint();
			}
		});
		
		setTitle("색상 변경");
		setBounds(0, 0, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
