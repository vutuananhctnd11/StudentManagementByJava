package View;

import Model.*;
import View.*;
import Controller.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	CourseManagerImp CourseImp = new CourseManagerImp();

	private JTextField idTextField;
	private JLabel lblCourseName;
	private JLabel lblCourseDepartment;
	private JLabel lblCourseCredits;
	private JLabel lblCourseSemester;
	private JLabel lblCourseCountClass;
//	private JLabel lblCourseGuideName;
	private JTextField nameTextField;
	private JTextField searchTextFiled;
	private JTextField departmentTextField;
	private JTextField creditsTextField;
	private JTextField semesterTextField;
	private JTextField countClassTextField;
//	private JTextField guideNameTextField;
	private JLabel idLabel_1;
	private JButton editButton;
	private JButton delButton;
	private JButton refreshButton;
	private DefaultTableModel defaultTableModel;
	private JButton searchButton;
	private JTextField searchTextField;
	private JButton sortButton;
	private JLabel idLabel_1_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable CourseTable;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\tải xuống.jpg"));

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1090, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Quản lý học phần");
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH SÁCH HỌC PHẦN");
		lblNewLabel.setBounds(482, 26, 386, 39);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);

		CourseTable = new JTable();
		CourseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CourseTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CourseTable.setBounds(275, 75, 701, 298);

		defaultTableModel = new DefaultTableModel();
		// Display column titles
		Object[] column = { "Mã học phần", "Tên học phần", "Khoa Giảng dạy", "Số tín chỉ", "Học Kỳ cần học",
				"Số lớp được mở" };
		defaultTableModel.setColumnIdentifiers(column);
		CourseTable.setModel(defaultTableModel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(340, 75, 650, 298);
		scrollPane.setViewportView(CourseTable);
		contentPane.add(scrollPane);

		JLabel idLabel = new JLabel("Mã học phần");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLabel.setBounds(25, 76, 130, 24);
		contentPane.add(idLabel);

		idTextField = new JTextField();
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idTextField.setBounds(150, 75, 184, 25);
		contentPane.add(idTextField);
		idTextField.setColumns(10);

		lblCourseName = new JLabel("Tên học phần");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourseName.setBounds(25, 120, 130, 24);
		contentPane.add(lblCourseName);

		lblCourseDepartment = new JLabel("Khoa Giảng dạy");
		lblCourseDepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourseDepartment.setBounds(25, 160, 130, 24);
		contentPane.add(lblCourseDepartment);

		lblCourseCredits = new JLabel("Số tín chỉ");
		lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourseCredits.setBounds(25, 204, 130, 24);
		contentPane.add(lblCourseCredits);

		lblCourseSemester = new JLabel("Học Kỳ cần học");
		lblCourseSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourseSemester.setBounds(25, 247, 130, 24);
		contentPane.add(lblCourseSemester);

		lblCourseCountClass = new JLabel("Số lớp được mở");
		lblCourseCountClass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourseCountClass.setBounds(25, 291, 130, 24);
		contentPane.add(lblCourseCountClass);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTextField.setColumns(10);
		nameTextField.setBounds(150, 119, 184, 25);
		contentPane.add(nameTextField);

		departmentTextField = new JTextField();
		departmentTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		departmentTextField.setColumns(10);
		departmentTextField.setBounds(150, 159, 184, 25);
		contentPane.add(departmentTextField);

		creditsTextField = new JTextField();
		creditsTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		creditsTextField.setColumns(10);
		creditsTextField.setBounds(150, 203, 184, 25);
		contentPane.add(creditsTextField);

		semesterTextField = new JTextField();
		semesterTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		semesterTextField.setColumns(10);
		semesterTextField.setBounds(150, 246, 184, 25);
		contentPane.add(semesterTextField);

		countClassTextField = new JTextField();
		countClassTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		countClassTextField.setColumns(10);
		countClassTextField.setBounds(150, 290, 184, 25);
		contentPane.add(countClassTextField);

		CourseTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int i = CourseTable.getSelectedRow();
				idTextField.setText(defaultTableModel.getValueAt(i, 0).toString());
				idTextField.disable();
				nameTextField.setText(defaultTableModel.getValueAt(i, 1).toString());
				departmentTextField.setText(defaultTableModel.getValueAt(i, 2).toString());
				creditsTextField.setText(defaultTableModel.getValueAt(i, 3).toString());
				semesterTextField.setText(defaultTableModel.getValueAt(i, 4).toString());
				countClassTextField.setText(defaultTableModel.getValueAt(i, 5).toString());

			}

		});

		// thêm

		JButton addButton = new JButton("Add");
		addButton.setIcon(new ImageIcon("resources\\Hopstarter-Button-Button-Add.16.png"));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course t = new Course();
				t.setMaHp(idTextField.getText());
				boolean check = true;
				// Check for duplicate ID
				for (Course Course : CourseImp.getCourses()) {
					if (Course.getMaHp().equals(t.getMaHp())) {
						JOptionPane.showMessageDialog(addButton, "ID đã trùng", "Thông báo",
								JOptionPane.DEFAULT_OPTION);
						check = false;
					}
				}

				if (check) {
					try {
						t.setTenHp(nameTextField.getText());
						t.setKhoa(departmentTextField.getText());
						t.setSoTin(Integer.parseInt(creditsTextField.getText()));
						t.setHocKyCanHoc(semesterTextField.getText());
						t.setSoLopMo(Integer.parseInt(countClassTextField.getText()));

						CourseImp.addCourse(t);
						JOptionPane.showMessageDialog(addButton, "Thêm thành công!", "Thông báo",
								JOptionPane.DEFAULT_OPTION);

						refreshCourseTable();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(addButton, "Lỗi", "Thông báo", JOptionPane.DEFAULT_OPTION);
					}
				}
			}
		});
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addButton.setBounds(42, 410, 116, 39);
		contentPane.add(addButton);

		// sua

		editButton = new JButton("Edit");
		editButton.setIcon(new ImageIcon("resources\\Custom-Icon-Design-Pretty-Office-10-Pencil.16.png"));
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = CourseTable.getSelectedRow();
				String id = idTextField.getText();
				boolean check = false;
				idTextField.disable();
				try {

					String name = nameTextField.getText();
					String khoa = departmentTextField.getText();
					int sotin = Integer.parseInt(creditsTextField.getText());

					String hocky = semesterTextField.getText();
					int solop = Integer.parseInt(countClassTextField.getText());

					for (Course t : CourseImp.getCourses()) {
						if (t.getMaHp().compareTo(idTextField.getText()) == 0) {
							t.setTenHp(name);
							t.setKhoa(khoa);
							t.setSoTin(sotin);
							t.setHocKyCanHoc(hocky);
							t.setSoLopMo(solop);
							check = true;
							CourseImp.editCourse(t);
						}
					}
					defaultTableModel.setRowCount(0);
					for (Course t : CourseImp.getCourses()) {
						defaultTableModel.addRow(new Object[] { t.getMaHp(), t.getTenHp(), t.getKhoa(), t.getSoTin(),
								t.getHocKyCanHoc(), t.getSoLopMo() });
					}
					if (check == true) {
						JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "Id không tìm thấy", "Thông báo",
								JOptionPane.DEFAULT_OPTION);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ", "Thông báo",
							JOptionPane.DEFAULT_OPTION);
				}
			}
		});

		// tìm

		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "Tên học phần", "Tên khoa", "Học kỳ cần học" }));
		searchComboBox.setBounds(510, 414, 142, 31);
		contentPane.add(searchComboBox);
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editButton.setBounds(190, 410, 116, 39);
		contentPane.add(editButton);

		searchTextField = new JTextField();
		searchTextField.setToolTipText("Nhập dữ liệu");
		searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchTextField.setColumns(10);
		searchTextField.setBounds(660, 414, 142, 31);
		contentPane.add(searchTextField);

		searchButton = new JButton("Tìm");
		searchButton.setIcon(new ImageIcon("resources\\Zerode-Plump-Search.16.png"));

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Course> result = new ArrayList<>();
				if (searchTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Chưa nhập thông tin tìm kiếm", "Thông báo",
							JOptionPane.DEFAULT_OPTION);
				} else {
					try {
						if (searchComboBox.getSelectedIndex() == 0) {
							String name = searchTextField.getText();
							result = CourseImp.searchNameCourse(name);

						} else if (searchComboBox.getSelectedIndex() == 1) {
							String khoa = searchTextField.getText();
							result = CourseImp.searchNameDepartment(khoa);
							System.out.println(result);

						} else {
							String hk = searchTextField.getText();
							result = CourseImp.searchNameSemester(hk);
							System.out.println(result);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không hợp lệ", "Cảnh báo",
								JOptionPane.DEFAULT_OPTION);
					}

					// Xóa các hàng cũ trong bảng
					defaultTableModel.setRowCount(0);

					// Thêm các kết quả tìm kiếm mới vào cuối bảng
					for (Course Course : result) {
						defaultTableModel.addRow(new Object[] { Course.getMaHp(), Course.getTenHp(), Course.getKhoa(),
								Course.getSoTin(), Course.getHocKyCanHoc(), Course.getSoLopMo() });
					}
				}
			}

		});

		// sắp xếp

		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchButton.setBounds(826, 410, 116, 39);
		contentPane.add(searchButton);

//		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		searchButton.setBounds(826, 410, 103, 39);
//		contentPane.add(searchButton);

		idLabel_1_2 = new JLabel("Sắp xếp theo :");
		idLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLabel_1_2.setBounds(380, 492, 142, 24);
		contentPane.add(idLabel_1_2);

		JRadioButton ascendingRadioButton = new JRadioButton("Số tín");
		buttonGroup.add(ascendingRadioButton);
		ascendingRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ascendingRadioButton.setBounds(528, 490, 108, 28);
		contentPane.add(ascendingRadioButton);

		JRadioButton decreaseRadioButton = new JRadioButton("Số lớp được mở");
		buttonGroup.add(decreaseRadioButton);
		decreaseRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		decreaseRadioButton.setBounds(640, 490, 161, 28);
		contentPane.add(decreaseRadioButton);

		// Nút sắp xếp
		sortButton = new JButton("Sắp xếp");
		sortButton.setIcon(new ImageIcon("resources\\Pictogrammers-Material-Sort.16.png"));
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Course> result = new ArrayList<>();
				if (ascendingRadioButton.isSelected()) {
					result = CourseImp.sortedCredits(true);
				} else {
					result = CourseImp.sortedCredits(false);
				}

				// hiển thị kết quả
				defaultTableModel.setRowCount(0);
				for (Course t : result) {
					defaultTableModel.addRow(new Object[] { t.getMaHp(), t.getTenHp(), t.getKhoa(), t.getSoTin(),
							t.getHocKyCanHoc(), t.getSoLopMo() });

				}
			}
		});

		// xóa
		sortButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sortButton.setBounds(826, 485, 116, 39);
		contentPane.add(sortButton);

		delButton = new JButton("Delete");
		delButton.setIcon(new ImageIcon("resources\\Hopstarter-Button-Button-Delete.16.png"));
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = CourseTable.getSelectedRow();
				if (selectedRow >= 0) {
					String CourseId = (String) CourseTable.getValueAt(selectedRow, 0);
					Course CourseToDelete = null;
					for (Course Course : CourseImp.getCourses()) {
						if (Course.getMaHp().equals(CourseId)) {
							CourseToDelete = Course;
							break;
						}
					}
					if (CourseToDelete != null) {
						CourseImp.delCourse(CourseToDelete);
						refreshCourseTable();
						JOptionPane.showMessageDialog(delButton, "Xóa thành công", "Thông báo",
								JOptionPane.DEFAULT_OPTION);
					} else {
						JOptionPane.showMessageDialog(delButton, "Học phần không tìm thấy", "Thông báo",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(delButton, "Chọn vào 1 mục để xóa", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// refesh
		delButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		delButton.setBounds(42, 480, 116, 39);
		contentPane.add(delButton);

		refreshButton = new JButton("Refresh");
		refreshButton.setIcon(new ImageIcon("resources\\Hopstarter-Button-Button-Refresh.16.png"));
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshCourseTable();
				idTextField.setEnabled(true);
				creditsTextField.setText("");
				idTextField.setText("");
				countClassTextField.setText("");
				semesterTextField.setText("");
				departmentTextField.setText("");
				nameTextField.setText("");
			}
		});
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		refreshButton.setBounds(190, 480, 116, 39);
		contentPane.add(refreshButton);

		Image img1 = new ImageIcon("resources\\background1.jpg").getImage();
		Image resize = img1.getScaledInstance(1090, 600, DO_NOTHING_ON_CLOSE);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(resize));

		lblNewLabel_1.setBounds(0, -35, 1088, 618);
		contentPane.add(lblNewLabel_1);

		refreshCourseTable(); // Call the method to load the Course data when the GUI starts
	}

	private void refreshCourseTable() {
		defaultTableModel.setRowCount(0);
		for (Course Course : CourseImp.getCourses()) {
			Object[] row = new Object[7];
			row[0] = Course.getMaHp();
			row[1] = Course.getTenHp();
			row[2] = Course.getKhoa();
			row[3] = Course.getSoTin();
			row[4] = Course.getHocKyCanHoc();
			row[5] = Course.getSoLopMo();

			defaultTableModel.addRow(row);
		}
	}
}
