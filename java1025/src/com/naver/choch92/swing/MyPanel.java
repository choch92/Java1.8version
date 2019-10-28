package com.naver.choch92.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Color color = new Color(0,0,128);
	public String str = "색상변경";
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.drawString(str, 150, 90);
	}
}
