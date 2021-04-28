package com.hk.app;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Exam2 extends JFrame {
	//중앙
	JLabel lab1, labE, labM, labK,labS, labA= null;
	JTextField txt1, txtE, txtM, txtK, txtS, txtA = null;
	
	//하단
	JButton btn1 = null;
	JButton btn2 = null;
	JButton btn3 = null;
	
	public Exam2() {
		
		setTitle("윈도우제목-Exam2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(500, 300);
		Container mainPane = getContentPane();
		//보더 왼쪽
		JPanel[] sPanel = new JPanel[5];
		for(int i=0; i<sPanel.length; i++) {
			//JPanel sPanel = new JPanel();
			sPanel[i] = new JPanel();
		}
		
		labS = new JLabel("번호:");
		txtS = new JTextField("", 5);
		lab1 = new JLabel("이름:");
		txt1 = new JTextField("", 5);
		labE = new JLabel("영어:");
		txtE = new JTextField("", 5);
		labM = new JLabel("수학:");
		txtM = new JTextField("", 5);
		labK = new JLabel("국어:");
		txtK = new JTextField("", 5);
		
		sPanel[0].add(labS); sPanel[0].add(txtS);
		sPanel[1].add(lab1); sPanel[1].add(txt1);
		sPanel[2].add(labE); sPanel[2].add(txtE);
		sPanel[3].add(labM); sPanel[3].add(txtM);
		sPanel[4].add(labK); sPanel[4].add(txtK);
		
		JPanel top = new JPanel(new GridLayout(5,1,0,0));
		for(int i=0; i<sPanel.length; i++) {
			top.add(sPanel[i]);
		}
		mainPane.add(top, BorderLayout.WEST);
		
		//보더 중앙- 테이블
		String[] colNames = {"번호","이름","영어","수학","국어","합계","평균"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		mainPane.add(scrollpane, BorderLayout.CENTER);
		
		//보더 하단
		JPanel bottom = new JPanel(new GridLayout(1,3,0,0));
		btn1 = new JButton("1번 추가");
		btn2 = new JButton("2번 삭제");
		btn3 = new JButton("3번 전체평균");
		bottom.add(btn1);
		bottom.add(btn2);
		bottom.add(btn3);
		
		List avgs = new ArrayList();
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showMessageDialog(null, "test");
				String[] row = new String[7];
				row[0] = txtS.getText();
				row[1] = txt1.getText();
				row[2] = txtE.getText(); //영어
				row[3] = txtM.getText(); //수학
				row[4] = txtK.getText(); //국어
				int sum = Integer.valueOf(txtE.getText()) +
						Integer.valueOf(txtM.getText()) +
						Integer.valueOf(txtK.getText());
				 row[5] = ""+sum;
				 double avg = sum / 3.0;
				 row[6] = ""+avg;
				 
				 avgs.add(avg);
				 //JOptionPane.showMessageDialog(null, ""+avgs.size());
				 
				 model.addRow(row);
				 
				 txtS.setText("");
				 txt1.setText("");
				 txtE.setText("");
				 txtM.setText("");
				 txtK.setText("");
				 
				 // 웹개발 - 플로우차트 + 정보설계 + 디자인(프로토타입)
				 // 윈도우개발 - 플로우차트(메뉴구성도) + UML(클래스다이어그램)
				
			}});
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double avgOfTotal = 0.0;
				for(int i=0; i<avgs.size(); i++) {
					avgOfTotal += (double)avgs.get(i);
				}
				double temp = avgOfTotal/avgs.size();
				double temp2 = Double.parseDouble(String.format("%.2f", temp));
				JOptionPane.showMessageDialog(null, ""+ temp2 );
				
			}});
		
		mainPane.add(bottom, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		Exam2 main = new Exam2();
	}

}
