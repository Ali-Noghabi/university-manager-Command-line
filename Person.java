public class Person {
    String FName, LName;

    public Person() {
    }

    public Person(String FName, String LName) {
        this.FName = FName;
        this.LName = LName;
    }

    public void SetFName(String FName) {
        this.FName = FName;
    }

    public void SetLName(String LName) {
        this.LName = LName;
    }

    public String GetFName() {
        return this.FName;
    }

    public String GetLName() {
        return this.LName;
    }

}