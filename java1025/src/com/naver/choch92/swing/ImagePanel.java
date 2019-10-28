package com.naver.choch92.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// Image객체 만들기
		Image image = Toolkit.getDefaultToolkit().getImage("./1.jpeg");
		// 그림 출력 - 좌표만 입력해서 출력 : 원본 크기 그대로
		//g.drawImage(image, 10, 10, this);
		// 100, 100 에 200, 200 크기로 원본을 출력
		//g.drawImage(image, 80, 80, 200, 200, this);
		// 0,0 에서 100, 100 만큼을 분할해서 80, 80 부터 200, 200까지의 출력
		// 출력 영역을 수정
		g.setClip(0, 0, 150, 300);
		g.drawImage(image, 80, 80, 200, 200, 0, 0, 700, 700, this);
		g.drawImage(image, 80, 320, 200, 200, 0, 0, 700, 700, this);
		
	}
}
