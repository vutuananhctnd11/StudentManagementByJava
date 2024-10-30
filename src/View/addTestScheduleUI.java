package View;

import java.awt.EventQueue;
import Model.*;
import View.*;
import Controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class addTestScheduleUI extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField dateTextField;
	private JTextField timeTextField;
	private JTextField studentNumberTextField;
	private JTextField roomTextField;
	private JTextField lecturerTextField;
	private JTextField idTextField;
//	static TestScheduleImpl testImpl = new TestScheduleImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					addTestScheduleUI frame = new addTestScheduleUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addTestScheduleUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\Button-Add-icon.png"));
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setResizable(false);
		setTitle("Thêm Lịch Thi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên môn thi:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 71, 125, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNgyThi = new JLabel("Ngày thi:");
		lblNgyThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgyThi.setBounds(10, 115, 125, 32);
		contentPane.add(lblNgyThi);
		
		JLabel lblCaThi = new JLabel("Ca thi:");
		lblCaThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCaThi.setBounds(10, 159, 125, 32);
		contentPane.add(lblCaThi);
		
		JLabel lblSSvThi = new JLabel("Số SV thi:");
		lblSSvThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSSvThi.setBounds(10, 205, 125, 32);
		contentPane.add(lblSSvThi);
		
		JLabel lblPhngThi = new JLabel("Phòng thi:");
		lblPhngThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhngThi.setBounds(10, 250, 125, 32);
		contentPane.add(lblPhngThi);
		
		JLabel lblGingVinCoi = new JLabel("Giảng Viên coi thi:");
		lblGingVinCoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGingVinCoi.setBounds(10, 301, 153, 32);
		contentPane.add(lblGingVinCoi);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameTextField.setBounds(180, 69, 224, 36);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		dateTextField = new JTextField();
		dateTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateTextField.setColumns(10);
		dateTextField.setBounds(180, 113, 224, 36);
		contentPane.add(dateTextField);
		
		timeTextField = new JTextField();
		timeTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		timeTextField.setColumns(10);
		timeTextField.setBounds(180, 157, 224, 36);
		contentPane.add(timeTextField);
		
		studentNumberTextField = new JTextField();
		studentNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		studentNumberTextField.setColumns(10);
		studentNumberTextField.setBounds(180, 203, 224, 36);
		contentPane.add(studentNumberTextField);
		
		roomTextField = new JTextField();
		roomTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		roomTextField.setColumns(10);
		roomTextField.setBounds(180, 249, 224, 36);
		contentPane.add(roomTextField);
		
		lecturerTextField = new JTextField();
		lecturerTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lecturerTextField.setColumns(10);
		lecturerTextField.setBounds(180, 297, 224, 36);
		contentPane.add(lecturerTextField);
		
		JButton yesButton = new JButton("Xác nhận");
		yesButton.setBackground(new Color(255, 255, 255));
		
		yesButton.setForeground(new Color(255, 0, 0));
		yesButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		yesButton.setBounds(43, 359, 136, 45);
		contentPane.add(yesButton);
		
		JButton noButton = new JButton("Hủy bỏ");
		noButton.setBackground(new Color(255, 255, 255));
		noButton.setForeground(Color.RED);
		noButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		noButton.setBounds(237, 359, 136, 45);
		contentPane.add(noButton);
		
		JLabel lblMLchThi = new JLabel("Mã lịch thi:");
		lblMLchThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMLchThi.setBounds(10, 27, 125, 32);
		contentPane.add(lblMLchThi);
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idTextField.setColumns(10);
		idTextField.setBounds(180, 25, 224, 36);
		contentPane.add(idTextField);
		
		Image img2 = new ImageIcon("resources\\background1.jpg").getImage();
		Image resize = img2.getScaledInstance(460, 450, DO_NOTHING_ON_CLOSE);
		JLabel bgLBL = new JLabel(new ImageIcon(resize));
		bgLBL.setBounds(0, 0, 451, 436);
		contentPane.add(bgLBL);
		
		
		
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean fail=false;//check lỗi các ô nhập trước đó
				TestSchedule t = new TestSchedule();
				try {
					//nhập mã lịch thi
					String id = idTextField.getText();
					if (id.equals("") && !fail) {
						fail=true;
						JOptionPane.showMessageDialog(null, "Chưa nhập id !", "Thông báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
					t.setTestSchedule_id(id);
					//nhập tên môn thi
					String name = nameTextField.getText();
					if (name.equals("") && !fail) {
						fail=true;
						JOptionPane.showMessageDialog(null, "Chưa nhập tên môn thi !", "Thông báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
					t.setTestSchedule_name(name);
					//nhập ngày thi
					Date date = new Date();
					String dateString = dateTextField.getText();
					if (dateString.equals("") && !fail) {
						fail=true;
						JOptionPane.showMessageDialog(null, "Chưa nhập ngày thi !", "Thông báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
					int count=0;
					for (int i=0; i<dateString.length(); i++) {
						if (dateString.charAt(i)=='/') count++;
					}
					if (count !=2 && !fail || dateString.length()<8) {
						fail=true;
						JOptionPane.showMessageDialog(null, "Định dạng ngày thi là: DD/MM/YYYY !", "Thông báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String[] s = dateString.split("/");
					date.setDay(Integer.parseInt(s[0]));
					date.setMonth(Integer.parseInt(s[1]));
					date.setYear(Integer.parseInt(s[2]));
					t.setTestSchedule_date(date);
					//nhập ca thi
					String time = timeTextField.getText();
					if (time.equals("") && !fail) {
						fail=true;
						JOptionPane.showMessageDialog(null, "Chưa nhập ca thi !", "Thông báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
					t.setTestSchedule_time(time);
					//nhập số sinh viên thi
					String studentNumber = studentNumberTextField.getText();
					try {
						int n = Integer.parseInt(studentNumber);
						t.setTestSchedule_numberStudent(n);
					} catch (Exception e2) {
						if (!fail) {
							JOptionPane.showMessageDialog(null, "Số SV phải là một số tự nhiên!", "Thông báo", JOptionPane.ERROR_MESSAGE);
						}
						fail=true;
						return;
					}
					//nhập phòng thi
					String room = roomTextField.getText();
					if (room.equals("") && !fail) {
						fail=true;
						JOptionPane.showMessageDialog(null, "Chưa nhập phòng thi !", "Thông báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
					t.setTestschedule_room(room);
					//nhập giảng viên coi thi
					String lecturer = lecturerTextField.getText();
					if (lecturer.equals("") && !fail) {
						if (!fail) {
							JOptionPane.showMessageDialog(null, "Chưa nhập tên giảng viên coi thi !", "Thông báo", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					t.setTestSchedule_lecturer(lecturer);
				} catch (Exception e2) {
					if (!fail) {
						JOptionPane.showMessageDialog(null, "Lỗi dữ liệu !", "Thông báo", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				TestScheduleUI main;
				try {
					
					for (TestSchedule t1: TestScheduleUI.testImpl.getListTest()) {
						if (t1.getTestSchedule_id().compareTo(idTextField.getText())==0) {
							fail=true;
							JOptionPane.showMessageDialog(null, "Trùng ID! Xin nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					TestScheduleUI.testImpl.addTest(t);
//					System.out.println(TestScheduleUI.testImpl.listTest);
//					System.out.println("1");
					main = new TestScheduleUI(t);
//					main.addNewTest(t);
//					System.out.println(main.testImpl.listTest);
//					System.out.println("2");
					main.setVisible(true);
					main.setLocationRelativeTo(null);
					dispose();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//cập nhật dữ liệu vào file 
				File file = new File("TestSchedule.txt");
				try {
					FileWriter writer = new FileWriter(file);
					for (TestSchedule test: TestScheduleUI.testImpl.getListTest()) {
						String str = test.getTestSchedule_id()+", "+test.getTestSchedule_name()+", "+test.getTestSchedule_date()+", "+
								test.getTestSchedule_time()+", "+test.getTestSchedule_numberStudent()+", "+test.getTestschedule_room()+", "+
								test.getTestSchedule_lecturer()+"\n";
						writer.write(str);
					}
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
}
