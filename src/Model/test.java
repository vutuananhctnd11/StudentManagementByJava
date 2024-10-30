package Model;

import Model.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ext.Attributes2;

public class test {

	public static void main(String[] args) throws IOException {
		
//		File file = new File("TestSchedule.txt");
//		FileReader in = new FileReader(file);
//		int c = in.read();
//		String s= "";
//		TestScheduleImpl testImpl = new TestScheduleImpl();
//		while (c!= -1) {
//			s += (char)c;
//			c = in.read();
//			if (c=='\n') {
//				String[] s1 = s.split(",");
//				TestSchedule t = new TestSchedule();
//				for (int i=0; i<s1.length; i++) {
//					s1[i]= s1[i].trim();
//				}
//				t.setTestSchedule_id(s1[0]);
//				t.setTestSchedule_name(s1[1]);
//				
//				String[] strDate = s1[2].split("/");
//				Date date = new Date();
//				date.setDay(Integer.parseInt(strDate[0]));
//				date.setMonth(Integer.parseInt(strDate[1]));
//				date.setYear(Integer.parseInt(strDate[2]));
//				t.setTestSchedule_date(date);
//				t.setTestSchedule_time(s1[3]);
//				t.setTestSchedule_numberStudent(Integer.parseInt(s1[4]));
//				t.setTestschedule_room(s1[5]);
//				t.setTestSchedule_lecturer(s1[6]);
//				testImpl.addTest(t);
//				System.out.println(t);
//				s="";
//			}
//			
//		
//		}
//		
//		in.close();

		
		
		
		List<Account> user = new ArrayList<Account>();
			
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
		
	}
}
