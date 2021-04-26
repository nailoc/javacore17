package com.hk.app;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class MouseEvent1 extends JFrame {
	
	public MouseEvent1() {
	      
      setTitle("윈도우제목");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300,200);
      
      Container mainPane = getContentPane();
      mainPane.setLayout(new FlowLayout());
      JButton test = new JButton("마우스 오버 이벤트");
      test.setBackground(Color.LIGHT_GRAY);
      mainPane.add(test);
      
      test.addMouseListener(new InnerMouseListener());
      
      setVisible(true);
   }
	   
   public static void main(String[] args) {
	   MouseEvent1 control = new MouseEvent1();
   }
   
   // 메인클래스 안에 내부클래스 작성
   public class InnerMouseListener implements MouseListener {

	    @Override
		public void mouseEntered(MouseEvent e) {
	    	JButton temp1 = (JButton)e.getSource();
	    	temp1.setBackground(Color.GREEN);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			JButton temp1 = (JButton)e.getSource();
	    	temp1.setBackground(Color.LIGHT_GRAY);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

   }

}
