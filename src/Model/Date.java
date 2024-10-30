package Model;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date() {
		
	}

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		String s = "";
		if (getDay()<10) {
			s+= "0"+day+"/";
		} else s+=day+"/";
		if (getMonth()<10) {
			s+="0"+month+"/";
		} else s+=month+"/";
		s+=year;
		return s;
	}
	
}
