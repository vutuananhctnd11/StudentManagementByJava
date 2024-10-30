package View;

import java.awt.BorderLayout;
import Model.*;
import View.*;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Model.Date;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class TestScheduleUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable testTable;
	private JTextField searchTextField;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	static TestScheduleImpl testImpl = new TestScheduleImpl();
	static TestSchedule t = new TestSchedule();
	/**
	 * Launch the application.
	 * @throws IOException 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestScheduleUI frame = new TestScheduleUI(t);
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
	
	public TestScheduleUI(TestSchedule t) throws IOException {
		setResizable(false);

		
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\Test-paper-icon (1).png"));
		setTitle("Quản lý lịch thi");
		setBackground(new Color(224, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 620);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		testTable = new JTable();
		testTable.setBackground(new Color(240, 248, 255));
		testTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		testTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		testTable.setBounds(10, 114, 966, 385);
		testTable.setRowHeight(25);
		
		
		//Hiển thị tiêu đề cột
		Object[] column = {"Mã Lịch thi", "Tên môn thi", "Ngày thi", "Ca thi", "Số sinh viên thi", "Phòng thi", "Tên giảng viên coi thi"};
		Object[] row = new Object[0];
		defaultTableModel.setColumnIdentifiers(row);
		testTable.setModel(defaultTableModel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 114, 1042, 385);
		scrollPane.setViewportView(testTable);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH LỊCH THI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(368, 10, 350, 49);
		contentPane.add(lblNewLabel);
		
		JLabel searchLbl = new JLabel("Tìm kiếm theo:");
		searchLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchLbl.setBounds(22, 71, 135, 31);
		contentPane.add(searchLbl);
		
		searchTextField = new JTextField();
		searchTextField.setBackground(new Color(240, 248, 255));
		searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchTextField.setBounds(336, 69, 229, 35);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		
		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Ngày thi", "Giảng viên coi thi", "Môn thi"}));
		searchComboBox.setBackground(new Color(240, 248, 255));
		searchComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchComboBox.setForeground(new Color(0, 0, 0));
		searchComboBox.setBounds(155, 69, 171, 35);
		contentPane.add(searchComboBox);
		
		JButton searchButton = new JButton("Tìm kiếm");
		searchButton.setBackground(new Color(240, 248, 255));

		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchButton.setBounds(575, 69, 113, 35);
		contentPane.add(searchButton);
		
		JLabel sortLbl_1 = new JLabel("Sắp xếp theo:");
		sortLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sortLbl_1.setBounds(722, 73, 113, 31);
		contentPane.add(sortLbl_1);
		
		JComboBox sortComboBox = new JComboBox();
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Ngày thi gần nhất", "Ngày thi xa nhất", "Số SV thi tăng dần", "Số SV thi giảm dần"}));
		sortComboBox.setForeground(Color.BLACK);
		sortComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sortComboBox.setBackground(new Color(240, 248, 255));
		sortComboBox.setBounds(845, 69, 217, 35);
		contentPane.add(sortComboBox);
		
		
		Image img1 = new ImageIcon("resources\\Button-Add-icon.png").getImage();
        Image resizedImg = img1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JButton btnNewButton = new JButton(new ImageIcon(resizedImg));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setText(" Thêm");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(213, 518, 152, 44);
		contentPane.add(btnNewButton);
		
		Image img2 = new ImageIcon("resources\\Pencil-icon.png").getImage();
        resizedImg = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JButton editButton = new JButton(new ImageIcon(resizedImg));
        editButton.setBackground(new Color(255, 255, 255));
        editButton.setText(" Sửa");
		editButton.setForeground(Color.RED);
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		editButton.setBounds(471, 518, 144, 44);
		contentPane.add(editButton);
		
		Image img3 = new ImageIcon("resources\\Button-Close-icon.png").getImage();
		resizedImg = img3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton deleteButton = new JButton(new ImageIcon(resizedImg));
		deleteButton.setBackground(new Color(255, 255, 255));
		deleteButton.setText(" Xóa");
		deleteButton.setForeground(Color.RED);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteButton.setBounds(701, 518, 144, 44);
		contentPane.add(deleteButton);
		
		Image img4 = new ImageIcon("resources\\bg2.jpg").getImage();
		resizedImg = img4.getScaledInstance(1300, 700, DO_NOTHING_ON_CLOSE);
		JLabel bgLBL = new JLabel(new ImageIcon(resizedImg));
		bgLBL.setBounds(0, 0, 1098, 583);
		contentPane.add(bgLBL);
		
		
		
		//thêm cột cho bảng
		defaultTableModel.addColumn("Mã lịch thi");
		defaultTableModel.addColumn("Tên môn thi");
		defaultTableModel.addColumn("Ngày thi");
		defaultTableModel.addColumn("Ca thi");
		defaultTableModel.addColumn("Số SV thi");
		defaultTableModel.addColumn("Phòng thi");
		defaultTableModel.addColumn("Giảng viên coi thi");
		
		
		defaultTableModel.setRowCount(0);
		for (TestSchedule t1: testImpl.getListTest()) {
			
			defaultTableModel.addRow(new Object[] {t1.getTestSchedule_id(), t1.getTestSchedule_name(), t1.getTestSchedule_date(),
					t1.getTestSchedule_time(), t1.getTestSchedule_numberStudent(), t1.getTestschedule_room(), t1.getTestSchedule_lecturer()});
		}
		//thêm lịch thi
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				addTestScheduleUI add = new addTestScheduleUI();
				add.setVisible(true);
				add.setLocationRelativeTo(null);
				disable();
				
			}
			
		});
		
		//CHọn 1 dòng trên bảng
		TestSchedule t_select = new TestSchedule();
		t_select.setTestSchedule_id(null);
		testTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = testTable.getSelectedRow();
				t_select.setTestSchedule_id(defaultTableModel.getValueAt(i, 0).toString()); ;
			}
		});
		
		// sửa lịch thi
		editButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (t_select.getTestSchedule_id()==null) {
        			JOptionPane.showMessageDialog(null, "Chưa chọn lịch cần sửa!","Thông báo",JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		editTestScheduleUI edit;
				try {
					edit = new editTestScheduleUI(t_select);
					edit.setVisible(true);
	        		edit.setLocationRelativeTo(null);
				} catch (IOException e1) {
				}
        		
        	}
        });
		
		//xóa lịch thi
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (t_select.getTestSchedule_id()==null) {
        			JOptionPane.showMessageDialog(null, "Chưa chọn lịch cần xóa!","Thông báo",JOptionPane.ERROR_MESSAGE);
        			return;
        		}
				testImpl.delTest(t_select);
				int x = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa lịch thi này ?", "Thông báo", JOptionPane.DEFAULT_OPTION);
    			if ( x== JOptionPane.YES_OPTION) {
    				JOptionPane.showMessageDialog(null, "Đã xóa thành công!","Thông báo",JOptionPane.DEFAULT_OPTION);
        			defaultTableModel.setRowCount(0);
        			for (TestSchedule t2: testImpl.getListTest()) {
        				defaultTableModel.addRow(new Object[] {t2.getTestSchedule_id(), t2.getTestSchedule_name(), t2.getTestSchedule_date(),
        						t2.getTestSchedule_time(), t2.getTestSchedule_numberStudent(), t2.getTestschedule_room(), t2.getTestSchedule_lecturer()});
        			}
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
		
		//sắp xếp lại danh sách
		sortComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sortComboBox.getSelectedIndex()==1) testImpl.sortedTest(1);
				else if(sortComboBox.getSelectedIndex()==2) testImpl.sortedTest(2);
				else if(sortComboBox.getSelectedIndex()==3) testImpl.sortedTest(3);
				else if(sortComboBox.getSelectedIndex()==4) testImpl.sortedTest(4);
				//cập nhật lại bảng
				defaultTableModel.setRowCount(0);
				for (TestSchedule t1: testImpl.getListTest()) {
					defaultTableModel.addRow(new Object[] {t1.getTestSchedule_id(), t1.getTestSchedule_name(), t1.getTestSchedule_date(),
							t1.getTestSchedule_time(), t1.getTestSchedule_numberStudent(), t1.getTestschedule_room(), t1.getTestSchedule_lecturer()});
				}
			}
		});
		
		//tìm kiếm
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<TestSchedule> result = new ArrayList<TestSchedule>();
				//tìm kiếm theo ngày thi
				if(searchComboBox.getSelectedIndex()==0) {
					Date d = new Date();
					int count=0;
					String strDate = searchTextField.getText();
					for (int i=0; i< strDate.length(); i++) {
						if (strDate.charAt(i)=='/') {
							count++;
						}
					}
					if (strDate.length()<8 ||strDate.length()>10 || count!=2) {
	        			JOptionPane.showMessageDialog(null, "Định dạng ngày thi là DD/MM/YYYY !","Thông báo",JOptionPane.ERROR_MESSAGE);
	        			return;
					}
					String[] s = strDate.split("/");
					d.setDay(Integer.parseInt(s[0]));
					d.setMonth(Integer.parseInt(s[1]));
					d.setYear(Integer.parseInt(s[2]));
					result = testImpl.searchTest(d);
					searchTextField.setText("");
					if (result.size()==0) {
	        			JOptionPane.showMessageDialog(null, "Không có lịch thi nào !","Thông báo",JOptionPane.DEFAULT_OPTION);
					}
				}
				//tìm kiếm theo tên giảng viên
				if (searchComboBox.getSelectedIndex()==1) {
					String name = searchTextField.getText();
					if (name.equals("")) {
		        		JOptionPane.showMessageDialog(null, "Chưa nhập tên Giảng viên cần tìm kiếm","Thông báo",JOptionPane.DEFAULT_OPTION);
		        		return;
					}
					result = testImpl.searchTest(1, name);
					if (result.size()==0) {
	        			JOptionPane.showMessageDialog(null, "Không tìm thấy Giảng viên có tên "+name,"Thông báo",JOptionPane.DEFAULT_OPTION);
					}
				}
				if(searchComboBox.getSelectedIndex()==2) {
					String name = searchTextField.getText();
					if (name.equals("")) {
		        		JOptionPane.showMessageDialog(null, "Chưa nhập tên môn thi cần tìm kiếm","Thông báo",JOptionPane.DEFAULT_OPTION);
		        		return;
					}
					result = testImpl.searchTest(2, name);
					if (result.size()==0) {
	        			JOptionPane.showMessageDialog(null, "Không tìm thấy Môn thi "+name,"Thông báo",JOptionPane.DEFAULT_OPTION);
					}
				}
				
				//cập nhật lại bảng
				defaultTableModel.setRowCount(0);
				for (TestSchedule t1: result) {
					defaultTableModel.addRow(new Object[] {t1.getTestSchedule_id(), t1.getTestSchedule_name(), t1.getTestSchedule_date(),
							t1.getTestSchedule_time(), t1.getTestSchedule_numberStudent(), t1.getTestschedule_room(), t1.getTestSchedule_lecturer()});
				}
				
			}
		});
	}
//	public void addNewTest (TestSchedule t) {
//		System.out.println(testImpl.getListTest());
//		System.out.println("3");
//		testImpl.addTest(t);
//		defaultTableModel.setRowCount(0);
//		for (TestSchedule t1: testImpl.getListTest()) {
//			defaultTableModel.addRow(new Object[] {t1.getTestSchedule_id(), t1.getTestSchedule_name(), t1.getTestSchedule_date(),
//					t1.getTestSchedule_time(), t1.getTestSchedule_numberStudent(), t1.getTestschedule_room(), t1.getTestSchedule_lecturer()});
//		}
//	}
}
