package Model;
import java.util.*;
public class StudentInf extends Student{

	private String student_phone;
	private String student_class;
	private double student_gpa;
	
	public StudentInf () {
		
	}

	public StudentInf(String student_phone, String student_class, double student_gpa) {
		super();
		this.student_phone = student_phone;
		this.student_class = student_class;
		this.student_gpa = student_gpa;
	}

	public String getStudent_phone() {
		return student_phone;
	}

	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}

	public String getStudent_class() {
		return student_class;
	}

	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}

	public double getStudent_gpa() {
		return student_gpa;
	}

	public void setStudent_gpa(double student_gpa) {
		this.student_gpa = student_gpa;
	}

	@Override
	public String toString() {
		return "StudentInf [student_phone=" + student_phone + ", student_class=" + student_class + ", student_gpa="
				+ student_gpa + "]";
	}
	
	
}
