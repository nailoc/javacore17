package com.hk.app;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


// 4번째로 메인클래스 인터페이스 구현하는 방법
public class ButtonEvent4 extends JFrame implements ActionListener {

	public ButtonEvent4() {
			
		setTitle("윈도우제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Container mainPane = getContentPane();
		
		JButton btn = new JButton("버튼 클릭 이벤트 예제");
		btn.addActionListener(this);  // 메인클래스가 ActionListener를 상속했으므로 this로 가능
		mainPane.add(btn);
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ButtonEvent4 main = new ButtonEvent4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton temp = (JButton)e.getSource();
		if(temp.getText().equals("버튼 클릭 이벤트 예제")) {
			JOptionPane.showMessageDialog(null, "이벤트예제4번");
		}
		
	}
}

// 독립적으로 클래스
