package cn.student.View;
/**
 * @author ZQ
 * @time
 * @function
 */
import java.awt.Color;//颜色
import java.awt.EventQueue;
import java.awt.Font;//字体
import java.awt.event.ActionEvent;//事件处理
import java.awt.event.ActionListener;//事件监听

import javax.swing.JButton;//按钮
import javax.swing.JFrame;//框架
import javax.swing.JLabel;//标签
import javax.swing.JOptionPane;//消息窗口public class UserLogIn extends JFrame
import javax.swing.JPanel;//面板
import javax.swing.JPasswordField;//密码框
import javax.swing.JTextField;//文本框

import cn.student.Audio.AudioAction;

@SuppressWarnings("serial")

/*
 * 自定义界面窗口，设置字体颜色
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭框架的同时结束程序
		this.setBounds(550, 200,550,427);;// 设置框架大小为长853,宽625
		this.setResizable(false);// 设置框架不可以改变大小
		this.setTitle("用户登录");// 设置框架标题
		this.pnluser.setLayout(null);// 设置面板布局管理
		this.pnluser.setBackground(Color.LIGHT_GRAY);// 设置面板背景颜色
		this.lbluserLogIn.setText("学生管理系统");// 设置标签标题
		this.lbluserLogIn.setFont(new Font("华文行楷", Font.BOLD | Font.ITALIC, 40));// 设置标签字体
		this.lbluserLogIn.setForeground(Color.MAGENTA);// 设置标签字体颜色
		this.lbluserName.setText("用户名:");
		lbluserName.setFont(new Font("宋体", Font.BOLD | Font.ITALIC,20));
		this.lbluserPWD.setText("密码:");
		lbluserPWD.setFont(new Font("宋体", Font.BOLD | Font.ITALIC,20));
		this.btnSub.setText("登录");
		btnSub.setFont(new Font("宋体", Font.BOLD | Font.ITALIC,20));
		this.btnReset.setText("添加用户");
		btnReset.setFont(new Font("宋体", Font.BOLD | Font.ITALIC,20));
		this.lbluserLogIn.setBounds(132, 25, 293, 88);// 设置标签x坐标120,y坐标15,长60,宽20
		this.lbluserName.setBounds(48, 164, 89, 36);
		this.lbluserPWD.setBounds(58, 213, 73, 30);
		this.txtName.setBounds(164, 164, 275, 36);
		txtName.setFont(new Font("宋体", Font.BOLD | Font.ITALIC,20));
		this.pwdPwd.setBounds(164, 210, 275, 36);
		pwdPwd.setFont(new Font("宋体", Font.BOLD | Font.ITALIC,20));
		this.btnSub.setBounds(107, 305, 137, 62);
		this.btnSub.addActionListener(new ActionListener()// 匿名类实现ActionListener接口
		{
			public void actionPerformed(ActionEvent e) {
				btnsub_ActionEvent(e);
			}
		});
		this.btnReset.setBounds(268, 305, 137, 62);
		this.btnReset.addActionListener(new ActionListener()// 匿名类实现ActionListener接口
		{
			public void actionPerformed(ActionEvent e) {
				btnreset_ActionEvent(e);
			}
		});
		this.pnluser.add(lbluserLogIn);// 加载标签到面板
		this.pnluser.add(lbluserName);
		this.pnluser.add(lbluserPWD);
		this.pnluser.add(txtName);
		this.pnluser.add(pwdPwd);
		this.pnluser.add(btnSub);
		this.pnluser.add(btnReset);
		getContentPane().add(pnluser);// 加载面板到框架
		
		this.setVisible(true);// 设置框架可显
	}

	public void btnsub_ActionEvent(ActionEvent e) {
		String name = String.valueOf(txtName.getText());
		String pwd = String.valueOf(pwdPwd.getPassword());
		String [][] str = AudioAction.QueueArray(name);
		int index = str.length;

		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (index!=0 && pwd.equals(str[0][0])) {
			new WindowView();// 登录界面成功后可以绑定其他的界面
			this.setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(null, "账号或密码错误,可以申请添加用户", "错误", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "该学号重复，请重新填写！", "错误",
							JOptionPane.ERROR_MESSAGE);
					return;
				}else{
					AudioAction.Add(id, password);
					txtName.setText("");
					pwdPwd.setText("");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "密码不能为空", "错误",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else{
			JOptionPane.showMessageDialog(null, "用户名不能为空", "错误",
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
