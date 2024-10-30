package Controller;

import java.io.BufferedReader;
import Model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TestScheduleImpl implements TestScheduleManager {
	protected static List<TestSchedule> listTest ;
	 
	public TestScheduleImpl () {
		listTest = new ArrayList<TestSchedule>();
		try {
			index();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<TestSchedule> getListTest() {
		return listTest;
	}

	public void setListTest(List<TestSchedule> listTest) {
		this.listTest = listTest;
	}

//	//đọc dữ liệu txt
	public static void index () throws IOException {

		File file = new File("TestSchedule.txt");
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader inr = new InputStreamReader(fin);
		BufferedReader bfr = new BufferedReader(inr);
		String s = bfr.readLine();
		while (s!=null) {
			String[] s1 = s.split(",");
			TestSchedule t1 = new TestSchedule();
			for (int i=0; i<s1.length; i++) {
				s1[i]= s1[i].trim();
			}
			t1.setTestSchedule_id(s1[0]);
			t1.setTestSchedule_name(s1[1]);
			String[] strDate = s1[2].split("/");
			Date date = new Date();
			date.setDay(Integer.parseInt(strDate[0]));
			date.setMonth(Integer.parseInt(strDate[1]));
			date.setYear(Integer.parseInt(strDate[2]));
			t1.setTestSchedule_date(date);
			t1.setTestSchedule_time(s1[3]);
			t1.setTestSchedule_numberStudent(Integer.parseInt(s1[4]));
			t1.setTestschedule_room(s1[5]);
			t1.setTestSchedule_lecturer(s1[6]);
			listTest.add(t1);
			s = bfr.readLine();
		}
		bfr.close();
		inr.close();
		fin.close();
	}

	@Override
	public boolean addTest(TestSchedule t) {
		// TODO Auto-generated method stub
		if (t!= null) {
			listTest.add(t);
			return true;
		}
		return false;
	}

	@Override
	public boolean editTest(TestSchedule t) {
		// TODO Auto-generated method stub
		for (TestSchedule testSchedule : listTest) {
			if (testSchedule.getTestSchedule_id().compareTo(t.getTestSchedule_id())==0) {
				testSchedule.setTestSchedule_name(t.getTestSchedule_name());
				testSchedule.setTestSchedule_date(t.getTestSchedule_date());
				testSchedule.setTestSchedule_time(t.getTestSchedule_time());
				testSchedule.setTestSchedule_numberStudent(t.getTestSchedule_numberStudent());
				testSchedule.setTestschedule_room(t.getTestschedule_room());
				testSchedule.setTestSchedule_lecturer(t.getTestSchedule_lecturer());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delTest(TestSchedule t) {
		// TODO Auto-generated method stub
		listTest.removeIf(test -> test.getTestSchedule_id().compareTo(t.getTestSchedule_id())==0);
		return false;
	}

	@Override
	public List<TestSchedule> sortedTest(int a) {
		// TODO Auto-generated method stub
		if (a==1 || a==2) {
			Collections.sort(listTest, new Comparator<TestSchedule>() {
				@Override
				public int compare(TestSchedule t1, TestSchedule t2) {
					// TODO Auto-generated method stub
					if (t1.getTestSchedule_date().getYear()!= t2.getTestSchedule_date().getYear()) {
						return t1.getTestSchedule_date().getYear() - t2.getTestSchedule_date().getYear();
					}
					if (t1.getTestSchedule_date().getMonth() != t2.getTestSchedule_date().getMonth()) {
						return t1.getTestSchedule_date().getMonth() - t2.getTestSchedule_date().getMonth();
					}
					return t1.getTestSchedule_date().getDay() - t2.getTestSchedule_date().getDay();

				}
				
			});
			if (a==2) Collections.reverse(listTest);
		}
		if (a==3 || a==4) {
			Collections.sort(listTest, new Comparator<TestSchedule>() {
				@Override
				public int compare(TestSchedule t1, TestSchedule t2) {
					// TODO Auto-generated method stub
					return t1.getTestSchedule_numberStudent() - t2.getTestSchedule_numberStudent();
				}
				
			});
			if (a==4) Collections.reverse(listTest);
		}
		return listTest;
	}

	@Override
	public List<TestSchedule> searchTest(int a, String s) {
		// TODO Auto-generated method stub
		List<TestSchedule> result = new ArrayList<TestSchedule>();
		//tìm kiếm theo tên giảng viên
		s = s.toLowerCase();
		if(a==1) {
			for (TestSchedule t: listTest) {
				String lecturer = t.getTestSchedule_lecturer();
				lecturer = lecturer.toLowerCase();
				if (lecturer.compareTo(s)==0) {
					result.add(t);
				}
			}
		}
		//tìm kiếm theo tên môn học
		if (a==2) {
			for (TestSchedule t: listTest) {
				String name = t.getTestSchedule_name();
				name = name.toLowerCase();
				if (name.compareTo(s)==0) {
					result.add(t);
				}
			}
		}
		return result;
	}

	@Override
	public List<TestSchedule> searchTest(Date d) {
		// TODO Auto-generated method stub
		List<TestSchedule> result = new ArrayList<TestSchedule>();
		for (TestSchedule t: listTest) {
			if (t.getTestSchedule_date().getDay()==d.getDay() && t.getTestSchedule_date().getMonth()==d.getMonth() &&
					t.getTestSchedule_date().getYear()==d.getYear()) {
				result.add(t);
			}
		}
		return result;
	}

}
