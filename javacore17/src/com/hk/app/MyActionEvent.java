package com.hk.app;

import java.awt.event.*;
import javax.swing.*;

public class MyActionEvent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("테스트버튼")) {
			JOptionPane.showMessageDialog(null, "테스트입니다");
		}
		
	}

}
