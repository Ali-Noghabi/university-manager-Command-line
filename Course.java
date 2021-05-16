import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String Name, ProfUserName, Sem;
    private int weight;
    public static ArrayList<Course> Courses = new ArrayList<Course>();
    public HashMap<Integer, Integer> Students = new HashMap<Integer, Integer>();

    public Course(String Name, String ProfUserName, String Sem, int weight) {
        this.Name = Name;
        this.ProfUserName = ProfUserName;
        this.Sem = Sem;
        this.weight = weight;
        Courses.add(this);
        int i = -1;
        for (Prof tempProf : Prof.Profs) {
            i++;
            if (tempProf.GetUserName().equals(ProfUserName) == true && tempProf.Courses.contains(this) == false) {
                Prof Temp = tempProf;
                Temp.Courses.add(this);
                Prof.Profs.set(i, Temp);
            }

        }
    }

    public static Boolean SearchCourse(String A, String B, String C) {
        for (Course tempCourse : Courses) {
            if (tempCourse.GetName().equals(A) == true && tempCourse.GetProfUserName().equals(B) == true
                    && tempCourse.GetSem().equals(C) == true) {
                return true;
            }
        }
        return false;
    }

    public String GetName() {
        return Name;
    }

    public String GetProfUserName() {
        return ProfUserName;
    }

    public String GetSem() {
        return Sem;
    }

    public int GetWeight() {
        return weight;
    }

    public String toString() {
        return Name + " " + ProfUserName + " " + Sem + " " + weight;
    }

    public String toString2() {
        return Name + " " + ProfUserName + " " + Sem;
    }

    public void AddGrade(int A, int B) {
        if (Students.containsKey(A) == true) {
            System.out.println("nomre dare");
        } else
            Students.put(A, B);
    }

    public static Course SearchCourseBySem(String c) {
        for (Course course : Courses) {
            if (course.GetSem().equals(c)) {
                return course;
            }
        }
        return null;
    }

}
