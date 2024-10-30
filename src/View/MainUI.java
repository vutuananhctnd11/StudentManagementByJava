package View;
import Model.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String userName="";
					MainUI frame = new MainUI(userName);
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
	public MainUI(String userName) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\tải xuống.jpg"));
		setTitle("Quản lý sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Xin chào ");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(406, 17, 199, 36);
		contentPane.add(lblLogin);
		
		lblLogin.setText("Xin chào "+userName);
		
		JLabel lblNewLabel_1 = new JLabel("MENU");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel_1.setBounds(297, 10, 113, 56);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblngXut = new JLabel("<html><u>Đăng xuất</u></htlm>");
		lblngXut.setForeground(new Color(0, 0, 255));
		lblngXut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangNhapUI login = new DangNhapUI();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblngXut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblngXut.setBounds(615, 17, 93, 36);
		contentPane.add(lblngXut);
		
		Image img1 = new ImageIcon("resources\\key.png").getImage();
		Image resize = img1.getScaledInstance(25, 25, DO_NOTHING_ON_CLOSE);
		JButton studentManagementButton = new JButton(new ImageIcon(resize));
		studentManagementButton.setBackground(new Color(175, 238, 238));
		studentManagementButton.setText(" Quản lý sinh viên");
		studentManagementButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		studentManagementButton.setBounds(324, 122, 360, 36);
		contentPane.add(studentManagementButton);
		
		JButton subjectManagementButton = new JButton(new ImageIcon(resize));
		subjectManagementButton.setBackground(new Color(175, 238, 238));
		subjectManagementButton.setText("  Quản lý học phần");
		subjectManagementButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		subjectManagementButton.setBounds(324, 172, 360, 36);
		contentPane.add(subjectManagementButton);
		
		JButton testManagementButton = new JButton(new ImageIcon(resize));
		testManagementButton.setBackground(new Color(175, 238, 238));
		testManagementButton.setText("     Quản lý lịch thi");
		testManagementButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		testManagementButton.setBounds(324, 220, 360, 36);
		contentPane.add(testManagementButton);
		
		Image img = new ImageIcon("resources\\cs1.png").getImage();
		resize = img.getScaledInstance(300, 350, DO_NOTHING_ON_CLOSE);
		JLabel background = new JLabel(new ImageIcon(resize));
		background.setBounds(0, 0, 287, 284);
		contentPane.add(background);
		
		//quản lý lịch thi
		testManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestSchedule t = new TestSchedule();
				TestScheduleUI testUI;
				try {
					testUI = new TestScheduleUI(t); 
					testUI.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(); 
				}
				
				
			}
		});
		
		//quản lý sinh viên
		studentManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaoDienQLSV studentUI = new GiaoDienQLSV();
				studentUI.setVisible(true);
				studentUI.setLocationRelativeTo(null);
			}
		});
		//quản lý Học phần
		subjectManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI courseUI = new GUI();
				courseUI.setVisible(true);
				courseUI.setLocationRelativeTo(null);
			}
		});
		
	}
}
