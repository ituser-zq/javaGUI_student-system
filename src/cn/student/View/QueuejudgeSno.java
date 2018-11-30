package cn.student.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JPanel;


public class QueuejudgeSno {

	private JFrame frame;
	private JTextField textField;
	/**
	 * Create the application.
	 */
	public QueuejudgeSno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("查询界面");
		frame.setBounds(100, 100, 393, 285);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 375, 238);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("请输入要查询的学号");
		label.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(48, 33, 281, 45);
		panel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		
		textField.setBounds(48, 91, 281, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(114, 161, 148, 45);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Sno = textField.getText();
				new QueueSnoView(Sno);
				frame.setVisible(false);
			}
		});
		panel.add(button);
		frame.setVisible(true);
	}
}

