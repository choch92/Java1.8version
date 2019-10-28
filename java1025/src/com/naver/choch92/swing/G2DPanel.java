package com.naver.choch92.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class G2DPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 화면에 보여질 때 나 repaint 메소드를 호출하면 화면에 출력되는 메소드
	// 상위 클래스에 있는 메소드를 재정의 한다는 어노테이션
	// 상위 클래스에 메소드가 존재하지 않으면 컴파일 에러 발생
	@Override
	public void paint(Graphics g) {
	
		// 그래픽스 객체 변환
		Graphics2D g2 = (Graphics2D)g;
		// 그라데이션 설정
		g2.setPaint(new GradientPaint(5, 30, Color.RED, 10, 50, Color.YELLOW, true));
		g2.fill(new Rectangle2D.Double(300, 50, 70, 85));
		// 선두께 수정
		g2.setStroke(new BasicStroke(10));
		g2.draw(new Ellipse2D.Double(50, 50, 100, 100));
		// 색상 변경
		g2.setPaint(Color.ORANGE);
		float [] dashes = {5};
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
				10, dashes, 0));
		g2.draw(new Ellipse2D.Double(150, 50, 100, 100));
	}
}
