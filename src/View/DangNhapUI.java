package View;

import Model.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DangNhapUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	static List<Account> user = new ArrayList<Account>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//lấy dữ liệu tài khoản ra list
					
					File file = new File("Account.txt");
					FileInputStream fin = new FileInputStream(file);
					InputStreamReader inr = new InputStreamReader(fin);
					BufferedReader bfr = new BufferedReader(inr);
					String line = bfr.readLine();
					while (line !=null) {
						String[] catChuoi = line.split(",");
						catChuoi[1] = catChuoi[1].trim();
						Account acc = new Account(catChuoi[0],catChuoi[1]);
						user.add(acc);
						line = bfr.readLine();
					}
					bfr.close();
					inr.close();
					fin.close();
					
					DangNhapUI frame = new DangNhapUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\tải xuống.jpg"));
		setResizable(false);
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(22, 0, 287, 44);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 46, 287, 357);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập");
		lblNewLabel_2.setBounds(22, 107, 134, 26);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(41, 133, 205, 34);
		panel.add(userNameTextField);
		userNameTextField.setBackground(new Color(224, 255, 255));
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu");
		lblNewLabel_2_1.setBounds(22, 177, 96, 26);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(41, 205, 205, 34);
		panel.add(passwordField);
		passwordField.setBackground(new Color(224, 255, 255));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton loginButton = new JButton("Đăng nhập"); 
		loginButton.setBounds(69, 255, 149, 34);
		panel.add(loginButton);
		loginButton.setForeground(new Color(240, 255, 255));
		loginButton.setBackground(new Color(30, 144, 255));
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Image img1 = new ImageIcon("resources\\logohaui.jpg").getImage();
		Image resize = img1.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		JLabel logo = new JLabel(new ImageIcon(resize));
		logo.setBounds(97, 10, 87, 87);
		panel.add(logo);
		
		JLabel copyright = new JLabel("Copyright 2024 © Group 4");
		copyright.setBounds(54, 322, 179, 30);
		panel.add(copyright);
		copyright.setBackground(new Color(255, 250, 250));
		copyright.setForeground(new Color(0, 0, 0));
		copyright.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		Image img2 = new ImageIcon("resources\\background1.jpg").getImage();
		resize = img2.getScaledInstance(287, 457, DO_NOTHING_ON_CLOSE);
		JLabel bg1LBL = new JLabel(new ImageIcon(resize));
		bg1LBL.setBounds(0, 0, 287, 357);
		panel.add(bg1LBL);
		
		Image img = new ImageIcon("resources\\cs1.png").getImage();
		resize = img.getScaledInstance(600, 450, DO_NOTHING_ON_CLOSE);
		JLabel background = new JLabel(new ImageIcon(resize));
		background.setBounds(0, 0, 586, 413);
		contentPane.add(background);
		
		//nút đăng nhập
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameTextField.getText();
				String password = String.valueOf(passwordField.getPassword());
				boolean checkLogin=false;
				for (Account acc: user) {
					if (acc.getUserName().equals(userName) && acc.getPassWord().equals(password)) {
						checkLogin=true;
						MainUI main = new MainUI(userName);
						main.setVisible(true);
						main.setLocationRelativeTo(null);
						dispose();
					}
				}
				if(!checkLogin) {
					JOptionPane.showMessageDialog(null, "Đăng nhập không thành công","Thông báo",JOptionPane.DEFAULT_OPTION, null);
				}
			}
		});
	}
}
