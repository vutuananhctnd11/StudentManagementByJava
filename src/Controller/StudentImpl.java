package Controller;

import Model.*;
import View.*;
import Controller.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentImpl implements StudentManager {
	
	protected static ArrayList<StudentInf> litStudent;
	
	public ArrayList<StudentInf> getlitStudent() {
		return litStudent;
	}

	public void setlitStudent(ArrayList<StudentInf> litStudent) {
		this.litStudent = litStudent;
	}

	public static void index () throws IOException {

		File file = new File("Student.txt");
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader inr = new InputStreamReader(fin);
		BufferedReader bfr = new BufferedReader(inr);
		String s = bfr.readLine();
		while (s!=null) {
			String[] s1 = s.split(",");
			StudentInf t1 = new StudentInf();
			for (int i=0; i<s1.length; i++) {
				s1[i]= s1[i].trim();
			}
			t1.setStudent_id(s1[0]);;
			t1.setStudent_name(s1[1]);
			t1.setStudent_date(s1[2]);
			t1.setStudent_home(s1[3]);
			t1.setStudent_phone(s1[4]);
			t1.setStudent_class(s1[5]);
			t1.setStudent_gpa(Double.parseDouble(s1[6]));
			litStudent.add(t1);
			s = bfr.readLine();
		}
		bfr.close();
		inr.close();
		fin.close();
	}
	public StudentImpl() {
		litStudent = new ArrayList<>();
		try {
			index();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printInfor() {
		for (StudentInf std: litStudent) {
			System.out.println(std);
		}
	}
	@Override
	public boolean addStudent(StudentInf c) {
		// TODO Auto-generated method stub
		if (c!= null) {
			litStudent.add(c);
			return true;
		}
		return false;
	}

	@Override
	public boolean editStudent(StudentInf c) {
		// TODO Auto-generated method stub
		for (StudentInf std : litStudent) {
			if (std.getStudent_id().compareTo(c.getStudent_id())==0) {
				std.setStudent_name(c.getStudent_name());
				std.setStudent_date(c.getStudent_date());
				std.setStudent_home(c.getStudent_home());
				std.setStudent_phone(c.getStudent_phone());
				std.setStudent_class(c.getStudent_class());
				std.setStudent_gpa(c.getStudent_gpa());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delStudent(StudentInf c) {
		// TODO Auto-generated method stub
		for ( StudentInf std: litStudent) {
			if (std.getStudent_id().compareTo(c.getStudent_id())==0) {
				litStudent.remove(std);
				return true;
			}
		}
			return false;
	}

	@Override
	//tìm kiếm theo tên
	public List<StudentInf> searchStudent(String name) {
		// TODO Auto-generated method stub
		name = name.toLowerCase();
		List<StudentInf> search = new ArrayList<>();
		for (StudentInf std: litStudent) {
			
			String stdName = std.getStudent_name();
			stdName = stdName.toLowerCase();
			if (stdName.compareTo(name)==0) {
				search.add(std);
			}
		}
		return search;
	}
	//tìm kiếm theo gpa
	public List<StudentInf> searchStdGPA(double gpa){
		List<StudentInf> search = new ArrayList<StudentInf>();
		for (StudentInf std : litStudent) {
			if (std.getStudent_gpa()<= gpa) {
				search.add(std);
			}
		}
		return search;
	}
	//tìm kiếm theo lớp
	public List<StudentInf> searchStdCLASS (String lop){
		lop = lop.toLowerCase();
		List<StudentInf> search = new ArrayList<StudentInf>();
		for (StudentInf std: litStudent) {
			String lopF = std.getStudent_class();
			lopF = lopF.toLowerCase();
			if (lopF.compareTo(lop)==0) {
				search.add(std);
			}
		}
		return search;
	}

	@Override
	public List<StudentInf> sortedStudent(boolean ascending) {
		// TODO Auto-generated method stub
		if (ascending) {
			Collections.sort(litStudent, new Comparator<StudentInf>() {
				@Override
				public int compare (StudentInf c1, StudentInf c2) {
					return Double.compare(c1.getStudent_gpa(), c2.getStudent_gpa()); 
				}
			});
		}
		else {
			Collections.sort(litStudent, new Comparator<StudentInf>() {
				@Override
				public int compare (StudentInf c1, StudentInf c2) {
					return Double.compare(c2.getStudent_gpa(), c1.getStudent_gpa()); 
				}
			});
		}
		
		return litStudent;
	}



}
