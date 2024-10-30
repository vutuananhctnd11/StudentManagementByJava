package Model;

public class Student {

	private String student_id;
	private String student_name;
	private String student_date;
	private String student_home;

	public Student() {

	}

	public Student(String student_id, String student_name, String student_date, String student_home) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_date = student_date;
		this.student_home = student_home;
	}



	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_date() {
		return student_date;
	}

	public void setStudent_date(String student_date) {
		this.student_date = student_date;
	}

	public String getStudent_home() {
		return student_home;
	}

	public void setStudent_home(String student_home) {
		this.student_home = student_home;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_date="
				+ student_date + ", student_home=" + student_home + "]";
	}

}
