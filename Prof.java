import java.util.ArrayList;

public class Prof extends Person {
    private String Username;
    public int SumSalary = 0;
    public static ArrayList<Prof> Profs = new ArrayList<Prof>();
    public ArrayList<Course> Courses = new ArrayList<Course>();

    public Prof() {
    }

    public Prof(String UserName, String FName, String LName) {
        super(FName, LName);
        this.Username = UserName;
        Profs.add(this);
    }

    public void SetUserName(String UserName) {
        this.Username = UserName;
    }

    public String GetUserName() {
        return Username;
    }

    public void IncreaseIncome(int c) {
        SumSalary += c;
    }

    public String toString() {
        return Username + " " + FName + " " + LName;
    }

    public static Boolean SearchProf(String c) {
        for (Prof prof : Profs) {
            if (prof.GetUserName().equals(c) == true) {
                return true;
            }
        }
        return false;
    }

    public static Prof SearchProfReturn(String c) {
        for (Prof prof : Profs) {
            if (prof.GetUserName().equals(c) == true) {
                return prof;
            }
        }
        return null;
    }
}
