package cn.student.View;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cn.student.Student.StudentAction;

public class QueueSnoView {

	private JFrame frame;
	private String sno;
	public static String[] result = { "ѧ��", "����", "�Ա�", "Ժϵ", "סַ", "��������", "�绰" };
	private JScrollPane jScrollPane;


	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	/**
	 * Create the application.
	 */
	public QueueSnoView(String sno) {
		this.sno=sno;
		initialize(sno);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String sno) {
		frame = new JFrame("��ѯ���");
		frame.setBounds(100, 100, 818, 313);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		String[][] str =StudentAction.getSno(sno);
		
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
		JPanel jPanelCenter = new JPanel();
		jPanelCenter.setBounds(0, 0, 800, 542);
		SpringLayout sl_jPanelCenter = new SpringLayout();
		jPanelCenter.setLayout(sl_jPanelCenter);
		

		JTable table = new JTable(model);
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		cr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, cr);
		initJTable(table, str);
		jScrollPane = new JScrollPane(table);
		sl_jPanelCenter.putConstraint(SpringLayout.NORTH, jScrollPane, 0, SpringLayout.NORTH, jPanelCenter);
		sl_jPanelCenter.putConstraint(SpringLayout.WEST, jScrollPane, 0, SpringLayout.WEST, jPanelCenter);
		sl_jPanelCenter.putConstraint(SpringLayout.SOUTH, jScrollPane, -282, SpringLayout.SOUTH, jPanelCenter);
		sl_jPanelCenter.putConstraint(SpringLayout.EAST, jScrollPane, 790, SpringLayout.WEST, jPanelCenter);
		jPanelCenter.add(jScrollPane);

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
