package Model;

import View.*;
import Controller.*;
import java.util.List;

public interface CourseManager {
	public boolean addCourse(Course t);

	public boolean editCourse(Course t);

	public boolean delCourse(Course t);

	public List<Course> sortedCredits(boolean select);

	public List<Course> sortedCountClass(boolean select);

	public List<Course> searchNameCourse(String nameCourse);

	public List<Course> searchNameDepartment(String nameDepartment);

	public List<Course> searchNameSemester(String semester);
}
