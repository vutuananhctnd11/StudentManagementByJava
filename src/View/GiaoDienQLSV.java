package View;

import Model.*;
import View.*;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GiaoDienQLSV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static StudentImpl stdImpl = new StudentImpl();
	private JTable carTable;
	private JTextField id;
	private JLabel lblTnXe;
	private JLabel lblGiTin;
	private JLabel lblSLng;
	private JLabel lblNmSx;
	private JLabel lblHngSx;
	private JTextField nameTextField;
	private JTextField ngay;
	private JTextField home;
	private JTextField phone;
	private JTextField lop;
	private JTextField gpa;
	private JLabel idLabel_1;
	private JButton editButton;
	private JButton delButton;
	private JButton refreshButton;
	private JTextField searchTextField;
	private JButton searchButton;
	private JLabel idLabel_1_2;
	private JButton sortButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienQLSV frame = new GiaoDienQLSV();
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
	public GiaoDienQLSV() {
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            }
        });
		MainUI mainUI = new MainUI("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 580);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Quản lý sinh viên");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image img = new ImageIcon("resources\\bg2.jpg").getImage();
		Image resizedImg = img.getScaledInstance(1200, 580, Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH SINH VIÊN");
		lblNewLabel.setBounds(515, 10, 394, 39);
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		carTable = new JTable();
		carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		carTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		carTable.setBounds(275, 75, 701, 298);
		
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		//hiển thị tiêu đề cột
		Object[] column = {"ID xe","Tên xe","Giá Tiền","Số lượng","Năm SX","Hãng SX","Số chỗ ngồi"};
		Object[] row = new Object[0];
		defaultTableModel.setColumnIdentifiers(row);
		carTable.setModel(defaultTableModel);
		carTable.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 120, 871, 398);
		scrollPane.setViewportView(carTable);
		contentPane.add(scrollPane);
		
		//Hiển thị dữ liệu khi kích chuột chọn 1 dòng trong bảng
		carTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = carTable.getSelectedRow();
				id.setText(defaultTableModel.getValueAt(i, 0).toString());
				id.disable();
				nameTextField.setText(defaultTableModel.getValueAt(i, 1).toString());
				ngay.setText(defaultTableModel.getValueAt(i, 2).toString());
				home.setText(defaultTableModel.getValueAt(i, 3).toString());
				phone.setText(defaultTableModel.getValueAt(i, 4).toString());
				lop.setText(defaultTableModel.getValueAt(i, 5).toString());
				gpa.setText(defaultTableModel.getValueAt(i, 6).toString());
			}
		});
		
		JLabel idLabel = new JLabel("Mã SV");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLabel.setBounds(25, 76, 61, 24);
		contentPane.add(idLabel);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		id.setBounds(117, 75, 163, 25);
		contentPane.add(id);
		id.setColumns(10);
		
		lblTnXe = new JLabel("Họ tên");
		lblTnXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnXe.setBounds(25, 120, 61, 24);
		contentPane.add(lblTnXe);
		
		lblGiTin = new JLabel("Ngày sinh");
		lblGiTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiTin.setBounds(25, 160, 82, 24);
		contentPane.add(lblGiTin);
		
		lblSLng = new JLabel("Quê quán");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSLng.setBounds(25, 204, 82, 24);
		contentPane.add(lblSLng);
		
		lblNmSx = new JLabel("SĐT");
		lblNmSx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmSx.setBounds(25, 247, 61, 24);
		contentPane.add(lblNmSx);
		
		lblHngSx = new JLabel("Lớp");
		lblHngSx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHngSx.setBounds(25, 291, 82, 24);
		contentPane.add(lblHngSx);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTextField.setColumns(10);
		nameTextField.setBounds(117, 119, 163, 25);
		contentPane.add(nameTextField);
		
		ngay = new JTextField();
		ngay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ngay.setColumns(10);
		ngay.setBounds(117, 159, 163, 25);
		contentPane.add(ngay);
		
		home = new JTextField();
		home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		home.setColumns(10);
		home.setBounds(117, 203, 163, 25);
		contentPane.add(home);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setColumns(10);
		phone.setBounds(117, 246, 163, 25);
		contentPane.add(phone);
		
		lop = new JTextField();
		lop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lop.setColumns(10);
		lop.setBounds(117, 290, 163, 25);
		contentPane.add(lop);
		
		gpa = new JTextField();
		gpa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gpa.setColumns(10);
		gpa.setBounds(117, 336, 163, 25);
		contentPane.add(gpa);
		
		idLabel_1 = new JLabel("GPA");
		idLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLabel_1.setBounds(25, 337, 82, 24);
		contentPane.add(idLabel_1);
		
		//thêm dữ liệu
		JButton addButton = new JButton("Thêm");
		addButton.setBackground(new Color(255, 255, 255));
		addButton.setForeground(new Color(255, 0, 0));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInf t1 = new StudentInf();
				t1.setStudent_id(id.getText());
				boolean check=true;
				//kiểm tra id có trùng hay không
					for (StudentInf studentInf: stdImpl.getlitStudent()) {
						if (studentInf.getStudent_id().compareTo(t1.getStudent_id())==0) {
							JOptionPane.showMessageDialog(null, "ID đã tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.DEFAULT_OPTION);
							check = false;
						}
					}
				
				if (check) {
					try {
						t1.setStudent_name(nameTextField.getText());
						t1.setStudent_date(ngay.getText());
						t1.setStudent_home(home.getText());
						t1.setStudent_phone(phone.getText());
						t1.setStudent_class(lop.getText());
						t1.setStudent_gpa(Double.parseDouble(gpa.getText()));
						stdImpl.addStudent(t1);
						defaultTableModel.setRowCount(0); // xóa dữ liệu bảng
						for ( StudentInf std : stdImpl.getlitStudent()) {
							defaultTableModel.addRow(new Object[] {std.getStudent_id(),std.getStudent_name(),std.getStudent_date(),
									std.getStudent_home(),std.getStudent_phone(),std.getStudent_class(),std.getStudent_gpa()});
						}
						
						JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.DEFAULT_OPTION);

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Sai định dạng! Hoặc chưa điền đầy đủ thông tin", "Thông báo", JOptionPane.DEFAULT_OPTION);
					}
				}
			}
		});
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addButton.setBounds(42, 410, 103, 39);
		contentPane.add(addButton);
		
		// sửa dữ liệu
		editButton = new JButton("Sửa");
		editButton.setBackground(new Color(255, 255, 255));
		editButton.setForeground(new Color(255, 0, 0));
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = carTable.getSelectedRow();
				id.disable();
				try {
					String name = nameTextField.getText();
					String date = ngay.getText() ;
					String nha = home.getText();
					String sdt = phone.getText();
					String lophoc = lop.getText();
					double x = Double.parseDouble(gpa.getText());
					for (StudentInf studentInf : stdImpl.getlitStudent()) {
						if (studentInf.getStudent_id().compareTo(id.getText())==0) {
							studentInf.setStudent_name(name);
							studentInf.setStudent_date(date);
							studentInf.setStudent_home(nha);
							studentInf.setStudent_phone(sdt);
							studentInf.setStudent_class(lophoc);
							studentInf.setStudent_gpa(x);
						}
					}
					defaultTableModel.setRowCount(0);
					for (StudentInf std : stdImpl.getlitStudent()) {
						defaultTableModel.addRow(new Object[] {std.getStudent_id(),std.getStudent_name(),std.getStudent_date(),
								std.getStudent_home(),std.getStudent_phone(),std.getStudent_class(),std.getStudent_gpa()});
					}
					JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ", "Thông báo", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editButton.setBounds(190, 410, 103, 39);
		contentPane.add(editButton);
		
		delButton = new JButton("Xóa");
		delButton.setBackground(new Color(255, 255, 255));
		delButton.setForeground(new Color(255, 0, 0));
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().compareTo("")==0) {
					JOptionPane.showMessageDialog(null, "Chưa chọn dữ liệu cần xóa!", "Thông báo", JOptionPane.DEFAULT_OPTION);
				}
				else {
					StudentInf c = new StudentInf();
					c.setStudent_id(id.getText());
						stdImpl.delStudent(c);
						id.setText("");
						nameTextField.setText("");
						ngay.setText("");
						home.setText("");
						phone.setText("");
						lop.setText("");
						gpa.setText("");
						defaultTableModel.setRowCount(0);
						for (StudentInf std : stdImpl.getlitStudent()) {
							defaultTableModel.addRow(new Object[] {std.getStudent_id(),std.getStudent_name(),std.getStudent_date(),
									std.getStudent_home(),std.getStudent_phone(),std.getStudent_class(),std.getStudent_gpa()});
						}
						JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.DEFAULT_OPTION);		
				}
			}
		});
		delButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		delButton.setBounds(42, 485, 103, 39);
		contentPane.add(delButton);
		
		//Nút clear
		refreshButton = new JButton("Clear");
		refreshButton.setBackground(new Color(255, 255, 255));
		refreshButton.setForeground(new Color(255, 0, 0));
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.enable();
				id.setText("");
				nameTextField.setText("");
				ngay.setText("");
				home.setText("");
				phone.setText("");
				lop.setText("");
				gpa.setText("");
			}
		});
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		refreshButton.setBounds(190, 485, 103, 39);
		contentPane.add(refreshButton);
		
		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"GPA", "Họ tên", "Tên lớp"}));
		searchComboBox.setBounds(408, 73, 108, 31);
		contentPane.add(searchComboBox);
		
		JLabel idLabel_1_1 = new JLabel("Tìm kiếm theo:");
		idLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idLabel_1_1.setBounds(305, 76, 108, 24);
		contentPane.add(idLabel_1_1);
		
		searchTextField = new JTextField();
		searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchTextField.setColumns(10);
		searchTextField.setBounds(523, 73, 212, 31);
		contentPane.add(searchTextField);
		
		//nút tìm kiếm
		searchButton = new JButton("Tìm kiếm");
		searchButton.setForeground(new Color(255, 0, 0));
		searchButton.setBackground(new Color(255, 255, 255));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<StudentInf> result = new ArrayList<StudentInf>();
				if (searchTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Chưa nhập thông tin tìm kiếm","Thông báo", JOptionPane.DEFAULT_OPTION);
				}
				else {
					try {
						if (searchComboBox.getSelectedIndex()==1) {
							String name = searchTextField.getText();
							result = stdImpl.searchStudent(name);		
						}
						if (searchComboBox.getSelectedIndex()==0) {
							double gpa = Double.parseDouble(searchTextField.getText());
							result = stdImpl.searchStdGPA(gpa);
						}
						if (searchComboBox.getSelectedIndex()==2) {
							String lop = searchTextField.getText();
							result = stdImpl.searchStdCLASS(lop);
						}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không hợp lệ","Cảnh báo", JOptionPane.DEFAULT_OPTION);
					}
					
					//hiển thị kết quả
					defaultTableModel.setRowCount(0);
					for(StudentInf std : result) {
						defaultTableModel.addRow(new Object[] {std.getStudent_id(),std.getStudent_name(),std.getStudent_date(),
								std.getStudent_home(),std.getStudent_phone(),std.getStudent_class(),std.getStudent_gpa()});
						
					}
				}
				
								
			}
		});
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchButton.setBounds(745, 69, 103, 39);
		contentPane.add(searchButton);
		
		idLabel_1_2 = new JLabel("Sắp xếp theo GPA");
		idLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idLabel_1_2.setBounds(851, 76, 142, 24);
		contentPane.add(idLabel_1_2);
		
		JRadioButton ascendingRadioButton = new JRadioButton("Tăng dần");
		buttonGroup.add(ascendingRadioButton);
		ascendingRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ascendingRadioButton.setBounds(976, 62, 93, 28);
		ascendingRadioButton.setOpaque(false);
		contentPane.add(ascendingRadioButton);
		
		JRadioButton decreaseRadioButton = new JRadioButton("Giảm dần");
		buttonGroup.add(decreaseRadioButton);
		decreaseRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		decreaseRadioButton.setBounds(976, 90, 93, 28);
		decreaseRadioButton.setOpaque(false);
		contentPane.add(decreaseRadioButton);
		
		//Nút sắp xếp
		sortButton = new JButton("Sắp xếp");
		sortButton.setForeground(new Color(255, 0, 0));
		sortButton.setBackground(new Color(255, 255, 255));
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<StudentInf> result = new ArrayList<StudentInf>();
				if (ascendingRadioButton.isSelected()) {
					result = stdImpl.sortedStudent(true);
				} else {
					result = stdImpl.sortedStudent(false);
				}
				
				//hiển thị kết quả
				defaultTableModel.setRowCount(0);
				for(StudentInf std : result) {
					defaultTableModel.addRow(new Object[] {std.getStudent_id(),std.getStudent_name(),std.getStudent_date(),
							std.getStudent_home(),std.getStudent_phone(),std.getStudent_class(),std.getStudent_gpa()});
					
				}
			}
		});
		sortButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortButton.setBounds(1075, 69, 101, 39);
		contentPane.add(sortButton);
		JLabel background = new JLabel(new ImageIcon(resizedImg));
		background.setBounds(0, 0, 1200, 580);
		contentPane.add(background);
		
		defaultTableModel.addColumn("Mã sinh viên");
		defaultTableModel.addColumn("Họ tên");
		defaultTableModel.addColumn("Ngày sinh");
		defaultTableModel.addColumn("Quê quán");
		defaultTableModel.addColumn("SĐT");
		defaultTableModel.addColumn("Lớp");
		defaultTableModel.addColumn("GPA");
		

		for ( StudentInf std : stdImpl.getlitStudent()) {
			defaultTableModel.addRow(new Object[] {std.getStudent_id(),std.getStudent_name(),std.getStudent_date(),
							std.getStudent_home(),std.getStudent_phone(),std.getStudent_class(),std.getStudent_gpa()});
		}
		
	}
}
