package com.hk.app;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Exam1 extends JFrame {
	//중앙
	JLabel lab1, labE, labM, labK,labS, labA= null;
	JTextField txt1, txtE, txtM, txtK, txtS, txtA = null;
	
	//하단
	JButton btn1 = null;
	JButton btn2 = null;
	JButton btn3 = null;
	
	public Exam1() {
		
		setTitle("윈도우제목-Exam1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(400, 300);
		Container mainPane = getContentPane();
		//보더 중앙
		JPanel[] sPanel = new JPanel[6];
		for(int i=0; i<sPanel.length; i++) {
			//JPanel sPanel = new JPanel();
			sPanel[i] = new JPanel();
		}
		
		lab1 = new JLabel("이름:");
		txt1 = new JTextField("", 20);
		labE = new JLabel("영어:");
		txtE = new JTextField("", 20);
		labM = new JLabel("수학:");
		txtM = new JTextField("", 20);
		labK = new JLabel("국어:");
		txtK = new JTextField("", 20);
		labS = new JLabel("합계:");
		txtS = new JTextField("", 20);
		labA = new JLabel("평균:");
		txtA = new JTextField("", 20);
		
		sPanel[0].add(lab1); sPanel[0].add(txt1);
		sPanel[1].add(labE); sPanel[1].add(txtE);
		sPanel[2].add(labM); sPanel[2].add(txtM);
		sPanel[3].add(labK); sPanel[3].add(txtK);
		sPanel[4].add(labS); sPanel[4].add(txtS);
		sPanel[5].add(labA); sPanel[5].add(txtA);
		
		JPanel top = new JPanel(new GridLayout(6,1,0,0));
		for(int i=0; i<sPanel.length; i++) {
			top.add(sPanel[i]);
		}
		mainPane.add(top, BorderLayout.CENTER);
		
		//보더 하단
		JPanel bottom = new JPanel(new GridLayout(1,3,0,0));
		btn1 = new JButton("1번 합계");
		btn2 = new JButton("2번 평균");
		btn3 = new JButton("3번 알림창");
		bottom.add(btn1);
		bottom.add(btn2);
		bottom.add(btn3);
		
		mainPane.add(bottom, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		Exam1 main = new Exam1();
	}

}
