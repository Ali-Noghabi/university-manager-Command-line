import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {
    private int EnterYear;
    private int SumTuition = 0;
    private int UserName;
    private static boolean Flag = false;
    private static HashMap<Integer, Integer> EnterYears = new HashMap<Integer, Integer>();
    public static ArrayList<Student> Students = new ArrayList<Student>();
    public ArrayList<Course> Courses = new ArrayList<Course>();

    public Student() {
    }

    public Student(String FName, String LName, int EnterYear) {
        super(FName, LName);
        this.EnterYear = EnterYear;
        if (EnterYears.containsKey(EnterYear) == true) {
            int temp = EnterYears.get(EnterYear);
            temp++;
            EnterYears.put(EnterYear, temp);
        } else
            EnterYears.put(EnterYear, 1);
        UserName = EnterYears.get(EnterYear) + (EnterYear * 1000);
        Students.add(this);
    }

    public static Student SearchStudentByUserName(int c) {
        for (Student student : Students) {
            if (student.GetUserName() == c)
                return student;
        }
        return null;
    }

    public void SetEnterYear(int c) {
        this.EnterYear = c;
    }

    public void SetSumTuition(int c) {
        this.SumTuition = c;
    }

    public int GetEnterYear() {
        return EnterYear;
    }

    public int GetUserName() {
        return UserName;
    }

    public int GetTuition() {
        return SumTuition;
    }

    public void IncreaseTuition(int c) {
        if (Flag == false) {
            SumTuition += c;
            Flag = true;
        }
    }

    public String toString() {
        return FName + " " + LName + " " + UserName;
    }
}