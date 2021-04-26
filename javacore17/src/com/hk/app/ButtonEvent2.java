package com.hk.app;

import java.awt.*;

import javax.swing.*;

public class ButtonEvent2 extends JFrame {

	JButton btn = new JButton("테스트버튼");
	
	public ButtonEvent2() {
		
		setTitle("윈도우제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		Container mainPane = getContentPane();
		mainPane.setLayout(new FlowLayout());
		mainPane.add(btn);
		
		MyActionEvent btnEvent = new MyActionEvent();
		btn.addActionListener(btnEvent);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ButtonEvent2 control = new ButtonEvent2();
	}

}

// 1번째 이벤트 리스너를 구성하는 방법 - 독립클래스
// 코드 복잡하고 여러군데에서 사용해야 하는 경우
