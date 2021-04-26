package com.hk.app;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

// 1-JFrame을 이용해서 기본윈도우를 생성
public class ButtenEvent1 extends JFrame{

	// 2-생성자를 통해서 윈도우의 기본 설정
	public ButtenEvent1() {
		
		setTitle("윈도우제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("버튼 클릭 이벤트 예제");
		
		add(btn);
		// 이벤트 3 - 컴포넌트에 이벤트 등록 메소드를 사용한다
		// add(이벤트이름)Listener() 형태의 메소드
		btn.addActionListener(new MyActionListener());
		
		setSize(300,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	
		// 3 - 메인에서 윈도우 그리기
		ButtenEvent1 main = new ButtenEvent1();
	}
	
	//이벤트1 - 버튼을 클릭한다면 어떤이벤트를 쓰는지 그리고 어떤 이벤트리스너를 쓰는지 숙지
	// why? 자바에 정의된 인터페이스를 사용해서 만들기 때문이다 
	// 몇가지 방법중에서 내부클래스 사용하는 방법
	public class MyActionListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			// 이벤트 2 - 구현해야 될 메소드 작성 + 
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("버튼 클릭 이벤트 예제") ) {
				// 버튼 클릭 이벤트 예제 버튼이 클릭될 때 코드 작성
				JOptionPane.showMessageDialog(null, "테스트", "제목", JOptionPane.INFORMATION_MESSAGE);
				// 입력다이얼로그
				//JOptionPane.showInputDialog();
				// 확인취소 다이얼로그
				//JOptionPane.showConfirmDialog();
			}
			
		}
		// 인터페이스 -> 재정의
		
	}

}
