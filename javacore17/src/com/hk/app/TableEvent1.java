package com.hk.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableEvent1 extends JFrame{
	public TableEvent1() {
		
		setTitle("윈도우제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		Container mainpane = getContentPane();  // 기본-보더레이아웃
		
		//테이블 정의 
		//테이블 제목
		String[] colName = {"이름","나이","성별"};
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		JTable table = new JTable(model);  // 생성자로 실행시 데이터초기값 입력
		JScrollPane scrollpane = new JScrollPane(table);
		
		//컨트롤 버튼들
		JPanel bottompanel = new JPanel();
		bottompanel.setLayout(new GridLayout(2,1,0,0));
		
		JPanel innerpanel = new JPanel();
		JTextField tfName = new JTextField(6);
		JTextField tfAge = new JTextField(3);
		JRadioButton rb1 = new JRadioButton("여성");
		JRadioButton rb2 = new JRadioButton("남성");
		ButtonGroup rg = new ButtonGroup();
		rg.add(rb1); rg.add(rb2);
		rb1.setSelected(true);  // 첫번째 라디어 버튼 선택됨
		innerpanel.add(new JLabel("이름"));
		innerpanel.add(tfName);
		innerpanel.add(new JLabel("나이"));
		innerpanel.add(tfAge);
		innerpanel.add(rb1); innerpanel.add(rb2);
		
		JPanel innerpanel2 = new JPanel();
		JButton btnAdd = new JButton("추가");
		JButton btnDel = new JButton("삭제");
		innerpanel2.add(btnAdd);
		innerpanel2.add(btnDel);
		
		bottompanel.add(innerpanel);
		bottompanel.add(innerpanel2);
		
		
		mainpane.add(scrollpane, BorderLayout.CENTER);
		mainpane.add(bottompanel, BorderLayout.SOUTH);
		setVisible(true);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] row = new String[3];
				row[0] = tfName.getText();
				row[1] = tfAge.getText();
				if(rb1.isSelected()) {
					row[2] = "여성";
				}else {
					row[2] = "남성";
				}
				model.addRow(row); // 한줄단위로 입력됨
			}
		});
		
		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow(); // 선택된 줄 찾기
				if( rowIndex == -1) {
					return;
				}
				model.removeRow(rowIndex);
			}
		});
	
	}
	
	public static void main(String[] args) {
		TableEvent1 main = new TableEvent1();
		
	}

}
