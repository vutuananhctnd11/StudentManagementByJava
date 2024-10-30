package View;

import Model.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Date;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editTestScheduleUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField dateTextField;
	private JTextField timeTextField;
	private JTextField numberTextField;
	private JTextField roomTextField;
	private JTextField lecturerTextField;
	private JTextField idTextField;
//	static TestScheduleImpl testImpl = new TestScheduleImpl();
	static TestSchedule t = new TestSchedule();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editTestScheduleUI frame = new editTestScheduleUI(t);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public editTestScheduleUI(TestSchedule t) throws IOException {
		setTitle("Sửa lịch thi");
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\Pencil-icon.png"));
		setBackground(new Color(240, 248, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên môn thi:");
		lblNewLabel.setBounds(23, 71, 119, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameTextField.setBounds(178, 71, 218, 37);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblNgyThi = new JLabel("Ngày thi:");
		lblNgyThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgyThi.setBounds(23, 118, 119, 37);
		contentPane.add(lblNgyThi);
		
		dateTextField = new JTextField();
		dateTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateTextField.setColumns(10);
		dateTextField.setBounds(178, 118, 218, 37);
		contentPane.add(dateTextField);
		
		JLabel lblCaThi = new JLabel("Ca thi:");
		lblCaThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCaThi.setBounds(23, 165, 119, 37);
		contentPane.add(lblCaThi);
		
		timeTextField = new JTextField();
		timeTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		timeTextField.setColumns(10);
		timeTextField.setBounds(178, 165, 218, 37);
		contentPane.add(timeTextField);
		
		JLabel lblSSvThi = new JLabel("Số SV thi:");
		lblSSvThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSSvThi.setBounds(23, 212, 119, 37);
		contentPane.add(lblSSvThi);
		
		numberTextField = new JTextField();
		numberTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numberTextField.setColumns(10);
		numberTextField.setBounds(178, 212, 218, 37);
		contentPane.add(numberTextField);
		
		JLabel lblPhngThi = new JLabel("Phòng thi:");
		lblPhngThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhngThi.setBounds(23, 259, 119, 37);
		contentPane.add(lblPhngThi);
		
		roomTextField = new JTextField();
		roomTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		roomTextField.setColumns(10);
		roomTextField.setBounds(178, 259, 218, 37);
		contentPane.add(roomTextField);
		
		JLabel lblGingVinCoi = new JLabel("Giảng viên coi thi:");
		lblGingVinCoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGingVinCoi.setBounds(23, 306, 159, 37);
		contentPane.add(lblGingVinCoi);
		
		lecturerTextField = new JTextField();
		lecturerTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lecturerTextField.setColumns(10);
		lecturerTextField.setBounds(178, 306, 218, 37);
		contentPane.add(lecturerTextField);
		
		JButton saveButton = new JButton("Lưu");
		saveButton.setBackground(new Color(255, 255, 255));
		saveButton.setForeground(new Color(255, 0, 0));
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		saveButton.setBounds(64, 367, 119, 37);
		contentPane.add(saveButton);
		
		JButton cancelButton = new JButton("Hủy bỏ");
		cancelButton.setBackground(new Color(255, 255, 255));
		cancelButton.setForeground(new Color(255, 0, 0));
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancelButton.setBounds(223, 367, 119, 37);
		contentPane.add(cancelButton);
		
		JLabel lblIdLchThi = new JLabel("ID lịch thi:");
		lblIdLchThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdLchThi.setBounds(23, 24, 119, 37);
		contentPane.add(lblIdLchThi);
		
		idTextField = new JTextField();
		idTextField.setEnabled(false);
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idTextField.setColumns(10);
		idTextField.setBounds(178, 24, 218, 37);
		contentPane.add(idTextField);
		
		
		Image img2 = new ImageIcon("resources\\background1.jpg").getImage();
		Image resize = img2.getScaledInstance(460, 450, DO_NOTHING_ON_CLOSE);
		JLabel bgLBL = new JLabel(new ImageIcon(resize));
		bgLBL.setBounds(0, 0, 428, 440);
		contentPane.add(bgLBL);
		
		//lấy id để hiện thông tin
		TestScheduleUI main = new TestScheduleUI(t);
		for (TestSchedule t1:TestScheduleUI.testImpl.getListTest()) {
			if (t1.getTestSchedule_id().compareTo(t.getTestSchedule_id())==0) {
				idTextField.setText(t.getTestSchedule_id());
				nameTextField.setText(t1.getTestSchedule_name());
				dateTextField.setText(t1.getTestSchedule_date().toString());
				timeTextField.setText(t1.getTestSchedule_time());
				numberTextField.setText(""+t1.getTestSchedule_numberStudent());
				roomTextField.setText(t1.getTestschedule_room());
				lecturerTextField.setText(t1.getTestSchedule_lecturer());
			}
		}
		//nút lưu
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean fail=false;
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
				if (count !=2 && !fail && dateString.length()!=10) {
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
				String studentNumber = numberTextField.getText();
				if (time.equals("") && !fail) {
					fail=true;
					JOptionPane.showMessageDialog(null, "Chưa nhập số SV thi !", "Thông báo", JOptionPane.ERROR_MESSAGE);
					return;
				}
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
				
				//sử dụng hàm editTest trong Class TestScheduleImpl
				TestScheduleUI.testImpl.editTest(t);
//				System.out.println(TestScheduleUI.testImpl.listTest);
//				main.setVisible(true);
				TestScheduleUI u;
				try {
					u = new TestScheduleUI(t);
					u.setVisible(true);
					u.setLocationRelativeTo(null);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
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
		// nút hủy
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
