package cn.student.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import cn.student.Student.StudentAction;

public class UpdateView {

	private JFrame frame;
	private String Sno;

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	/**
	 * Create the application.
	 */

	public UpdateView(String Sno) {
		super();
		this.Sno = Sno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("修改数据界面");
		frame.setBounds(100, 100, 458, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 440, 574);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("学号:");
		label_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		label_1.setBounds(53, 59, 57, 38);
		panel_1.add(label_1);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		textArea.setBounds(119, 59, 270, 38);
		panel_1.add(textArea);

		JLabel label_2 = new JLabel("姓名:");
		label_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		label_2.setBounds(53, 123, 57, 38);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("性别:");
		label_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		label_3.setBounds(53, 174, 57, 38);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("院系:");
		label_4.setBounds(53, 225, 57, 38);
		label_4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("住址:");
		label_5.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		label_5.setBounds(53, 276, 57, 38);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("出生日期:");
		label_6.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		label_6.setBounds(35, 327, 75, 38);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("电话号码:");
		label_7.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		label_7.setBounds(35, 378, 75, 38);
		panel_1.add(label_7);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		textArea_1.setBounds(119, 118, 270, 38);
		panel_1.add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		textArea_2.setBounds(119, 169, 270, 38);
		panel_1.add(textArea_2);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		textArea_3.setBounds(119, 220, 270, 38);
		panel_1.add(textArea_3);

		JTextArea textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		textArea_4.setBounds(119, 271, 270, 38);
		panel_1.add(textArea_4);

		JTextArea textArea_5 = new JTextArea();
		textArea_5.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		textArea_5.setBounds(119, 322, 270, 38);
		panel_1.add(textArea_5);

		JTextArea textArea_6 = new JTextArea();
		textArea_6.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		textArea_6.setBounds(119, 378, 270, 38);
		panel_1.add(textArea_6);
		
		String[][] str =StudentAction.getSno(Sno);
		int index =str.length-1;
		textArea.setText(str[index][0]);
		textArea_1.setText(str[index][1]);
		textArea_2.setText(str[index][2]);
		textArea_3.setText(str[index][3]);
		textArea_4.setText(str[index][4]);
		textArea_5.setText(str[index][5]);
		textArea_6.setText(str[index][6]);

		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 该代码有问题，未完成；
				 */

				String sno_1 = textArea.getText();
				String sname_1 = textArea_1.getText();
				String ssex_1 = textArea_2.getText();
				String sdept_1 = textArea_3.getText();
				String shome_1 = textArea_4.getText();
				String semail_1 = textArea_5.getText();
				String stel_1 = textArea_6.getText();
				// TODO Auto-generated method stub
				StudentAction.Update(sno_1, sname_1, ssex_1, sdept_1, shome_1, semail_1, stel_1,Sno);
				new WindowView();
				frame.setVisible(false);
					
			}
					
		});
		button.setBounds(35, 456, 130, 52);
		panel_1.add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new WindowView();
			}
		});
		button_1.setBounds(262, 456, 130, 52);
		panel_1.add(button_1);

		JLabel label = new JLabel("请修改数据！");
		label.setBounds(184, 15, 127, 31);
		panel_1.add(label);
		label.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));

	}
}