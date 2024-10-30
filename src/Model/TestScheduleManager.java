package Model;

import java.util.List;
import Model.*;


public interface TestScheduleManager {

	public boolean addTest (TestSchedule t);
	public boolean editTest (TestSchedule t);
	public boolean delTest (TestSchedule t);
	public List<TestSchedule> sortedTest (int a);
	public List<TestSchedule> searchTest (int a,String name);
	public List<TestSchedule> searchTest (Date d);
}
