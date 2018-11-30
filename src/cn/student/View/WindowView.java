package cn.student.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cn.student.Student.StudentAction;

import javax.swing.SpringLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class WindowView {

	private JFrame frame;
	private JTextField textField;
	public static String[] result = { "学号", "姓名", "性别", "院系", "住址", "出生日期", "电话" };
	private JScrollPane jScrollPane_1;

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public WindowView() {
		frame = new JFrame("学生信息情况汇总");
		frame.setBounds(100, 100, 818, 615);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 23, 800, 28);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_3 = new JButton("查找");
		btnNewButton_3.setBackground(Color.PINK);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sno = textField.getText();
				if (!"".equals(sno)) {
					String[][] str = StudentAction.getSno(sno);
					int index = str.length;
					if (index == 0) {
						JOptionPane.showMessageDialog(null, "没有该成员信息", "错误", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						new QueueSnoView(sno);
					}
				} else {
					JOptionPane.showMessageDialog(null, "请明确要修改的位置", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				/*
				 * 该方法已实现
				 */
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		panel.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sno = textField.getText();
				if (!"".equals(sno)) {
					String[][] str = StudentAction.getSno(sno);
					int index = str.length;
					if (index == 0) {
						JOptionPane.showMessageDialog(null, "没有该成员信息", "错误", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						StudentAction.delete(sno);
						new WindowView();
						frame.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "请明确要修改的位置", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		panel.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("添加");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddView();
				frame.setVisible(false);
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton = new JButton("更新");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Sno = textField.getText();
				/*
				 * 该功能未完善，可以实现对全部的数据进行修改。
				 */

				if (!"".equals(Sno)) {
					String[][] str = StudentAction.getSno(Sno);
					int index = str.length;
					if (index == 0) {
						JOptionPane.showMessageDialog(null, "没有该成员信息", "错误", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						new UpdateView(Sno);
						frame.setVisible(false);
					}

				} else {
					JOptionPane.showMessageDialog(null, "请明确要修改的位置", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		panel.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 540, 800, 28);
		frame.getContentPane().add(panel_2);

		JLabel lblNewLabel = new JLabel("欢迎登陆学生管理系统！");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 800, 22);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		frame.getContentPane().add(panel_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 22);
		panel_3.add(menuBar);
		
		JMenu menu = new JMenu("个人信息");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("查看信息");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new QueueSnoView("20162035");
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("修改信息");
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UpdateView("20162035");
				frame.setVisible(false);
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("查找");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("学号查找");
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * 根据学号查找
				 */
				new QueuejudgeSno();
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("姓名查找");
		menuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * 根据姓名查找
				 */
				new QueuejudgeSname();
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("性别查找");
		menuItem_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * 根据性别查找
				 */
				new QueuejudgeSex();
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("院系查找");
		menuItem_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * 根据院系查找
				 */
				new QueuejudgeSdept();
			}
		});
		menu_1.add(menuItem_5);
		
		JMenu menu_5 = new JMenu("\u5173\u4E8E");
		menuBar.add(menu_5);
		
		JMenuItem menuItem_9 = new JMenuItem("\u5173\u4E8E\u8BE5\u7CFB\u7EDF");
		menu_5.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u5173\u4E8E\u4F5C\u8005");
		menu_5.add(menuItem_10);
		
		

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() {

		JPanel jPanelCenter = new JPanel();
		jPanelCenter.setBounds(0, 53, 800, 489);

		String[][] str = StudentAction.queryAll();
		DefaultTableModel model = new DefaultTableModel(str, result) {

			/**
			 * @author ZQ
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		SpringLayout sl_jPanelCenter = new SpringLayout();
		jPanelCenter.setLayout(sl_jPanelCenter);

		JTable table = new JTable(model);
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		cr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, cr);
		initJTable(table, str);
		jScrollPane_1 = new JScrollPane(table);
		sl_jPanelCenter.putConstraint(SpringLayout.NORTH, jScrollPane_1, 0, SpringLayout.NORTH, jPanelCenter);
		sl_jPanelCenter.putConstraint(SpringLayout.WEST, jScrollPane_1, 0, SpringLayout.WEST, jPanelCenter);
		sl_jPanelCenter.putConstraint(SpringLayout.SOUTH, jScrollPane_1, -5, SpringLayout.SOUTH, jPanelCenter);
		sl_jPanelCenter.putConstraint(SpringLayout.EAST, jScrollPane_1, 790, SpringLayout.WEST, jPanelCenter);
		jPanelCenter.add(jScrollPane_1);

		frame.getContentPane().add(jPanelCenter);
		
		
	}

	public static void initJTable(JTable jTable, String[][] str) {
		((DefaultTableModel) jTable.getModel()).setDataVector(str, result);
		jTable.setRowHeight(70);
		TableColumn firsetColumn = jTable.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(70);
		firsetColumn.setMaxWidth(70);
		firsetColumn.setMinWidth(70);
		TableColumn secondColumn = jTable.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(70);
		secondColumn.setMaxWidth(70);
		secondColumn.setMinWidth(70);
		TableColumn thirdColumn = jTable.getColumnModel().getColumn(2);
		thirdColumn.setPreferredWidth(70);
		thirdColumn.setMaxWidth(70);
		thirdColumn.setMinWidth(70);
		TableColumn fourthColumn = jTable.getColumnModel().getColumn(3);
		fourthColumn.setPreferredWidth(160);
		fourthColumn.setMaxWidth(160);
		fourthColumn.setMinWidth(160);
		TableColumn Column_5 = jTable.getColumnModel().getColumn(4);
		Column_5.setPreferredWidth(170);
		Column_5.setMaxWidth(170);
		Column_5.setMinWidth(170);
		TableColumn secondColumn_5 = jTable.getColumnModel().getColumn(5);
		secondColumn_5.setPreferredWidth(100);
		secondColumn_5.setMaxWidth(100);
		secondColumn_5.setMinWidth(100);
		TableColumn secondColumn_6 = jTable.getColumnModel().getColumn(6);
		secondColumn_6.setPreferredWidth(160);
		secondColumn_6.setMaxWidth(160);
		secondColumn_6.setMinWidth(160);

	}
}