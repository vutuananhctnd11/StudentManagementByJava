package Controller;

import Model.*;
import View.*;
import Controller.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class CourseManagerImp implements CourseManager {

    protected static List<Course> courses = new ArrayList<>();

  

	public void setCourse(List<Course> setCourse) {
        this.courses = setCourse;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public CourseManagerImp() {
    	
		try {
			index();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

//	//đọc dữ liệu txt
	public static void index () throws IOException {

		File file = new File("courses.txt");
		  if (!file.exists()) {
	            System.out.println("File not found!");
	            return;
	        }
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader inr = new InputStreamReader(fin);
		BufferedReader bfr = new BufferedReader(inr);
		String s = bfr.readLine();
		
		while (s!=null) {
			String[] s1 = s.split(",");
			
			  if (s1.length != 6) {
	                System.out.println("Invalid data format: " + s);
	                s = bfr.readLine();
	                continue;
	            }
			
			Course t1 = new Course();
			for (int i=0; i<s1.length; i++) {
				s1[i]= s1[i].trim();
			}
			try {
				t1.setMaHp(s1[0]);
				t1.setTenHp(s1[1]);
				
				t1.setKhoa(s1[2]);
				t1.setSoTin(Integer.valueOf(s1[3]));
				t1.setHocKyCanHoc(s1[4]);
				t1.setSoLopMo(Integer.valueOf(s1[5]));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error parsing number: " + e.getMessage());
                s = bfr.readLine();
                continue;
			}
			
			courses.add(t1);
			s = bfr.readLine();
		}
		bfr.close();
		inr.close();
		fin.close();
	}
	
	
	 private void saveCoursesToFile() {
	        try (FileWriter writer = new FileWriter("CoursesEdit.txt")) {
	            for (Course course : courses) {
	                writer.write(String.format("%s,%s,%s,%d,%s,%d\n",
	                        course.getMaHp(), course.getTenHp(), course.getKhoa(),
	                        course.getSoTin(), course.getHocKyCanHoc(), course.getSoLopMo()));
	            }
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }
	    }
	
    @Override
    public boolean addCourse(Course t) {
    	for (Course existingCourse : courses) {
            if (existingCourse.getMaHp().equals(t.getMaHp())) {
                System.out.println("Error: Course ID already exists!");
                return false;
            }
        }

        boolean isAdded = courses.add(t);
        if (isAdded) {
            try (FileWriter writer = new FileWriter("courses.txt", true)) {
                writer.write(String.format("%s,%s,%s,%d,%s,%d\n",
                        t.getMaHp(), t.getTenHp(), t.getKhoa(),
                        t.getSoTin(), t.getHocKyCanHoc(), t.getSoLopMo()));
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                return false;
            }
        }
        return isAdded;
    }

    @Override
    public boolean editCourse(Course t) {
    	boolean idExists = false;
        for (Course existingCourse : courses) {
            if (existingCourse.getMaHp().equals(t.getMaHp())) {
                existingCourse.setTenHp(t.getTenHp());
                existingCourse.setKhoa(t.getKhoa());
                existingCourse.setSoTin(t.getSoTin());
                existingCourse.setHocKyCanHoc(t.getHocKyCanHoc());
                existingCourse.setSoLopMo(t.getSoLopMo());
                idExists = true;
                break;
            }
        }

        if (!idExists) {
            System.out.println("Error: Course ID not found!");
            return false;
        }

        saveCoursesToFile();

        return true;
    }

    @Override
    public boolean delCourse(Course t) {
    	boolean isDeleted = courses.remove(t);

        if (isDeleted) {
            // Read all lines from the file
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                return false;
            }

            // Remove the specific course line from the list
            lines.removeIf(line -> line.split(",")[0].trim().equals(t.getMaHp()));

            // Write all remaining lines back to the file
            try (FileWriter writer = new FileWriter("courses.txt")) {
                for (String line : lines) {
                    writer.write(line + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                return false;
            }
        }

        return isDeleted;
    }

    @Override
    public List<Course> sortedCredits(boolean select) {
        if(select == true) {
        	Collections.sort(courses, new Comparator<Course>() {
                public int compare(Course c1, Course c2) {
                    return c1.getSoTin() - c2.getSoTin();
                }
            });
        }else {
        	Collections.sort(courses, new Comparator<Course>() {
                public int compare(Course c1, Course c2) {
                    return c1.getSoLopMo() - c2.getSoLopMo();
                }
            });
        }
        return courses;
    }

    @Override
    public List<Course> sortedCountClass(boolean select) {
        // Implementation needed
        return null;
    }

    @Override
    public List<Course> searchNameCourse(String name) {
        name = name.toLowerCase();
        List<Course> result = new ArrayList<>();
        for (Course t : courses) {
            if (t.getTenHp().toLowerCase().equals(name)) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public List<Course> searchNameDepartment(String khoa) {
        khoa = khoa.toLowerCase();
        List<Course> result = new ArrayList<>();
        for (Course t : courses) {
            if (t.getKhoa().toLowerCase().equals(khoa)) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public List<Course> searchNameSemester(String hk) {
        hk = hk.toLowerCase();
        List<Course> result = new ArrayList<>();
        for (Course t : courses) {
            if (t.getHocKyCanHoc().toLowerCase().equals(hk)) {
                result.add(t);
            }
        }
        return result;
    }
}
