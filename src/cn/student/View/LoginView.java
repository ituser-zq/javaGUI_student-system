package cn.student.View;
/**
 * @author ZQ
 * @time
 * @function
 */
import java.awt.Color;//��ɫ
import java.awt.EventQueue;
import java.awt.Font;//����
import java.awt.event.ActionEvent;//�¼�����
import java.awt.event.ActionListener;//�¼�����

import javax.swing.JButton;//��ť
import javax.swing.JFrame;//���
import javax.swing.JLabel;//��ǩ
import javax.swing.JOptionPane;//��Ϣ����public class UserLogIn extends JFrame
import javax.swing.JPanel;//���
import javax.swing.JPasswordField;//�����
import javax.swing.JTextField;//�ı���

import cn.student.Audio.AudioAction;

@SuppressWarnings("serial")

/*
 * �Զ�����洰�ڣ�����������ɫ
 */
public class LoginView extends JFrame {
	public JPanel pnluser;
	public JLabel lbluserLogIn;
	public JLabel lbluserName;
	public JLabel lbluserPWD;
	public JTextField txtName;
	public JPasswordField pwdPwd;
	public JButton btnSub;
	public JButton btnReset;

	public LoginView() {
		pnluser = new JPanel();
		lbluserLogIn = new JLabel();
		lbluserName = new JLabel();
		lbluserPWD = new JLabel();
		txtName = new JTextField();
		pwdPwd = new JPasswordField();
		btnSub = new JButton();
		btnReset = new JButton();
		userInit();
	}

	public void userInit() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ùرտ�ܵ�ͬʱ��������
		this.setBounds(550, 200,550,427);;// ���ÿ�ܴ�СΪ��853,��625
		this.setResizable(false);// ���ÿ�ܲ����Ըı��С
		this.setTitle("�û���¼");// ���ÿ�ܱ���
		this.pnluser.setLayout(null);// ������岼�ֹ���
		this.pnluser.setBackground(Color.LIGHT_GRAY);// ������屳����ɫ
		this.lbluserLogIn.setText("ѧ������ϵͳ");// ���ñ�ǩ����
		this.lbluserLogIn.setFont(new Font("�����п�", Font.BOLD | Font.ITALIC, 40));// ���ñ�ǩ����
		this.lbluserLogIn.setForeground(Color.MAGENTA);// ���ñ�ǩ������ɫ
		this.lbluserName.setText("�û���:");
		lbluserName.setFont(new Font("����", Font.BOLD | Font.ITALIC,20));
		this.lbluserPWD.setText("����:");
		lbluserPWD.setFont(new Font("����", Font.BOLD | Font.ITALIC,20));
		this.btnSub.setText("��¼");
		btnSub.setFont(new Font("����", Font.BOLD | Font.ITALIC,20));
		this.btnReset.setText("����û�");
		btnReset.setFont(new Font("����", Font.BOLD | Font.ITALIC,20));
		this.lbluserLogIn.setBounds(132, 25, 293, 88);// ���ñ�ǩx����120,y����15,��60,��20
		this.lbluserName.setBounds(48, 164, 89, 36);
		this.lbluserPWD.setBounds(58, 213, 73, 30);
		this.txtName.setBounds(164, 164, 275, 36);
		txtName.setFont(new Font("����", Font.BOLD | Font.ITALIC,20));
		this.pwdPwd.setBounds(164, 210, 275, 36);
		pwdPwd.setFont(new Font("����", Font.BOLD | Font.ITALIC,20));
		this.btnSub.setBounds(107, 305, 137, 62);
		this.btnSub.addActionListener(new ActionListener()// ������ʵ��ActionListener�ӿ�
		{
			public void actionPerformed(ActionEvent e) {
				btnsub_ActionEvent(e);
			}
		});
		this.btnReset.setBounds(268, 305, 137, 62);
		this.btnReset.addActionListener(new ActionListener()// ������ʵ��ActionListener�ӿ�
		{
			public void actionPerformed(ActionEvent e) {
				btnreset_ActionEvent(e);
			}
		});
		this.pnluser.add(lbluserLogIn);// ���ر�ǩ�����
		this.pnluser.add(lbluserName);
		this.pnluser.add(lbluserPWD);
		this.pnluser.add(txtName);
		this.pnluser.add(pwdPwd);
		this.pnluser.add(btnSub);
		this.pnluser.add(btnReset);
		getContentPane().add(pnluser);// ������嵽���
		
		this.setVisible(true);// ���ÿ�ܿ���
	}

	public void btnsub_ActionEvent(ActionEvent e) {
		String name = String.valueOf(txtName.getText());
		String pwd = String.valueOf(pwdPwd.getPassword());
		String [][] str = AudioAction.QueueArray(name);
		int index = str.length;

		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (index!=0 && pwd.equals(str[0][0])) {
			new WindowView();// ��¼����ɹ�����԰������Ľ���
			this.setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(null, "�˺Ż��������,������������û�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	public void btnreset_ActionEvent(ActionEvent e) {
		String id = txtName.getText();
		String password = String.valueOf(pwdPwd.getPassword());
		if(!id.equals("")){
			if(!password.equals("")){
				String[][] str = AudioAction.QueueArray(id);
				int index = str.length;
				if (index == 1) {
					JOptionPane.showMessageDialog(null, "��ѧ���ظ�����������д��", "����",
							JOptionPane.ERROR_MESSAGE);
					return;
				}else{
					AudioAction.Add(id, password);
					txtName.setText("");
					pwdPwd.setText("");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "����",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else{
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "����",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
