package Model;

import Model.Date;

public class TestSchedule {

	private String testSchedule_id;
	private String testSchedule_name;
	private Date  testSchedule_date;
	private String testSchedule_time;
	private int testSchedule_numberStudent;
	private String testschedule_room;
	private String testSchedule_lecturer;
	
	public TestSchedule () {
		
	}

	public TestSchedule(String testSchedule_id, String testSchedule_name, Date testSchedule_date,
			String testSchedule_time, int testSchedule_numberStudent, String testschedule_room,
			String testSchedule_lecturer) {
		super();
		this.testSchedule_id = testSchedule_id;
		this.testSchedule_name = testSchedule_name;
		this.testSchedule_date = testSchedule_date;
		this.testSchedule_time = testSchedule_time;
		this.testSchedule_numberStudent = testSchedule_numberStudent;
		this.testschedule_room = testschedule_room;
		this.testSchedule_lecturer = testSchedule_lecturer;
	}

	public String getTestSchedule_id() {
		return testSchedule_id;
	}

	public String getTestSchedule_name() {
		return testSchedule_name;
	}

	public Date getTestSchedule_date() {
		return testSchedule_date;
	}

	public String getTestSchedule_time() {
		return testSchedule_time;
	}

	public int getTestSchedule_numberStudent() {
		return testSchedule_numberStudent;
	}

	public String getTestschedule_room() {
		return testschedule_room;
	}

	public String getTestSchedule_lecturer() {
		return testSchedule_lecturer;
	}

	public void setTestSchedule_id(String testSchedule_id) {
		this.testSchedule_id = testSchedule_id;
	}

	public void setTestSchedule_name(String testSchedule_name) {
		this.testSchedule_name = testSchedule_name;
	}

	public void setTestSchedule_date(Date testSchedule_date) {
		this.testSchedule_date = testSchedule_date;
	}

	public void setTestSchedule_time(String testSchedule_time) {
		this.testSchedule_time = testSchedule_time;
	}

	public void setTestSchedule_numberStudent(int testSchedule_numberStudent) {
		this.testSchedule_numberStudent = testSchedule_numberStudent;
	}

	public void setTestschedule_room(String testschedule_room) {
		this.testschedule_room = testschedule_room;
	}

	public void setTestSchedule_lecturer(String testSchedule_lecturer) {
		this.testSchedule_lecturer = testSchedule_lecturer;
	}

	@Override
	public String toString() {
		return testSchedule_id + " | " + testSchedule_name
				+ " | " + testSchedule_date + " | " + testSchedule_time
				+ " | " + testSchedule_numberStudent + " | "
				+ testschedule_room + " | " + testSchedule_lecturer+"\n";
	}
	
	
}
