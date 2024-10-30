package Model;

import java.util.*;

public interface StudentManager {
	public boolean addStudent (StudentInf c);
	public boolean editStudent (StudentInf c);
	public boolean delStudent (StudentInf c);
	public List<StudentInf> searchStudent (String name);
	public List<StudentInf> sortedStudent (boolean ascending);

}
