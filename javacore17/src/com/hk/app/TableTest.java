package com.hk.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableTest extends JFrame {

	ArrayList<MemberVO> members = new ArrayList<MemberVO>();

	public TableTest() {

		setTitle("회원 명단 추가삭제 프로그램");

		setDefaultCloseOperation(EXIT_ON_CLOSE);		

		setAlwaysOnTop(true);

		setBounds(200, 100, 400, 200);

		//표 제목줄
		String[] colNames = new String[] {"이름", "나이", "성별"};

		//표에 들어갈 데이터들.. /처음엔 빈 테이블 만들기 위해.. 데이터관리객체 생성
		DefaultTableModel model = new DefaultTableModel(colNames, 0);

		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		//테이블 아래쪽에 데이터 입력 할수있는 패널
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2, 1));

		JPanel panel = new JPanel();
		JTextField tfName = new JTextField(6);
		JTextField tfAge = new JTextField(3);
		JRadioButton rb1 = new JRadioButton("여성");
		JRadioButton rb2 = new JRadioButton("남성");
		JRadioButton rb3 = new JRadioButton();
		ButtonGroup rg = new ButtonGroup();
		rg.add(rb1);	rg.add(rb2); rg.add(rb3);
		rb1.setSelected(true);

		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("나이"));
		panel.add(tfAge);
		panel.add(rb1);		panel.add(rb2);
		bottomPanel.add(panel);

		JPanel panel2 = new JPanel();
		JButton btnAdd = new JButton("추가");
		JButton btnDel = new JButton("삭제");
		panel2.add(btnAdd);	panel2.add(btnDel);
		bottomPanel.add(panel2);		

		btnAdd.addActionListener(new ActionListener() {			

			@Override

			public void actionPerformed(ActionEvent e) {

				//입력된 값 테이블에 추가하기

				//입력된 값들을 한줄 데이터 덩어리(배열)로 만들어줘야 함    ←←←

				String[] rows = new String[3];

				rows[0] = tfName.getText();

				rows[1] = tfAge.getText();

				if(rb1.isSelected()) rows[2] = "여성";

				else rows[2] = "남성";

				model.addRow(rows); //한줄단위로만 대입 가능하므로↑↑

				

				//입력후 텍스트 필드 값 제거

				tfName.setText("");

				tfAge.setText("");

				rb3.setSelected(true); //라디오 초기화

				

				//어레이 리스트에 멤버 객체 추가

				String name = rows[0];

				int age = Integer.parseInt(rows[1]);

				String gender = rows[2];

				members.add(new MemberVO(name, age, gender));

				System.out.println("회원 숫자:" + members.size());

			}

		});		

		//선택한 줄 지우기

		btnDel.addActionListener(new ActionListener() {			

			@Override

			public void actionPerformed(ActionEvent e) {

				//선택한 줄(row)의 번호 알아내기

				int rowIndex = table.getSelectedRow();

				//선택 안하고 누를 경우 리턴값 -1

				if(rowIndex == -1) return;

				model.removeRow(rowIndex);

								

				members.remove(rowIndex); //데이터 지우기

				System.out.println("회원 숫자:" + members.size());

			}

		});		

		

		add(bottomPanel,BorderLayout.SOUTH);		

		setVisible(true);

	}

	class MemberVO { //회원 1명 정보 저장하는 클래스 : 오로지 데이터 저장용

		private String name;  //VO클래스

		private int age;

		private String gender;

		public MemberVO(String name, int age, String gender) {

			this.name = name;

			this.age = age;

			this.gender = gender;

		}

	}



	public static void main(String[] args) {

		new TableTest();

	}

}
