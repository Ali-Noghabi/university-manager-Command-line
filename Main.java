import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Object;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scn = new Scanner(System.in);
            while (scn.hasNext()) {

                String Enter = scn.nextLine();
                int flagif = 0;
                // Add Student Done DOne
                {
                    Pattern addStudnetPattern = Pattern.compile("^add student (.*?)$");
                    Matcher addStudentMatcher = addStudnetPattern.matcher(Enter);
                    if (addStudentMatcher.find() == true) {
                        // System.out.println("im here");
                        String[] AddStudentArray = addStudentMatcher.group(1).split(" ");
                        int flag = 0;
                        if (AddStudentArray.length == 0) {
                            System.out.println("missing argument: name");
                        } else if (AddStudentArray.length == 1) {
                            System.out.println("missing argument: family");
                        } else if (AddStudentArray.length == 2) {
                            flag = 1;
                        } else if (AddStudentArray.length == 3) {
                            System.out.println("missing argument: year");
                        } else if (AddStudentArray.length == 4) {
                            Student A = new Student(AddStudentArray[0], AddStudentArray[1],
                                    Integer.parseInt(AddStudentArray[3]));
                            System.out.println(A.GetUserName());
                        }
                        if (flag == 1) {
                            Student A = new Student(AddStudentArray[0], AddStudentArray[1], 99);
                            System.out.println(A.GetUserName());
                        }
                        flagif = 1;
                    }
                    if (Enter.equals("add student")) {
                        System.out.println("missing argument: name");
                        flagif = 1;
                    }
                }

                // Student A = new Student("Ali", "Abdollahian", 98);
                // Student B = new Student("Ali", "Abdollahian", 98);
                // Student C = new Student("Ali", "Abdollahian", 99);
                // Student D = new Student("Ali", "Abdollahian", 97);

                // List Students Done DOne
                {
                    Pattern listStudentsPattern = Pattern.compile("^list student (.*?)$");
                    Matcher listStudentsMatcher = listStudentsPattern.matcher(Enter);
                    if (listStudentsMatcher.find() == true) {
                        // System.out.println("im here");

                        String[] ListStudentsArray = listStudentsMatcher.group(1).split(" ");
                        int EnterYear = Integer.parseInt(ListStudentsArray[1]);
                        for (Student tempStudent : Student.Students) {
                            if (tempStudent.GetEnterYear() == EnterYear) {
                                System.out.println(tempStudent.toString());
                            }
                        }
                        flagif = 1;
                    }
                    if (Enter.equals("list student") == true) {
                        for (Student tempStudent : Student.Students) {
                            System.out.println(tempStudent.toString());
                        }
                        flagif = 1;
                    }
                }

                // Add prof Done
                {
                    Pattern addProfPattern = Pattern.compile("^add prof (.*?)$");
                    Matcher addprofMatcher = addProfPattern.matcher(Enter);
                    if (addprofMatcher.find() == true) {
                        // System.out.println("im here");
                        String[] AddprofArray = addprofMatcher.group(1).split(" ");
                        int flag = 0;
                        if (AddprofArray.length == 0) {
                            System.out.println("missing argument: username");
                        } else if (AddprofArray.length == 1) {
                            System.out.println("missing argument: name");
                        } else if (AddprofArray.length == 2) {
                            System.out.println("missing argument: family");
                        } else if (AddprofArray.length == 3) {
                            if (Prof.SearchProf(AddprofArray[0]) == false) {
                                Prof A = new Prof(AddprofArray[0], AddprofArray[1], AddprofArray[2]);

                            } else {
                                System.out.println("prof with username " + AddprofArray[0] + " exists.");
                            }

                        }
                        flagif = 1;

                    }
                    if (Enter.equals("add prof")) {
                        System.out.println("missing argument: username");
                        flagif = 1;
                    }
                }

                // Prof AP = new Prof("c0ntraria", "ilya ", "khalafi");
                // Prof CP = new Prof("dr_elahi", "james", "green");
                // Prof DP = new Prof("Ali", "Abdollahian", "97");

                // List Profs Done
                {

                    if (Enter.equals("list prof") == true) {
                        String[] ListProfsArray = Enter.split(" ");
                        for (Prof tempProf : Prof.Profs) {
                            System.out.println(tempProf.toString());
                        }
                        flagif = 1;
                    }
                }

                // Add Course Done
                {
                    Pattern addCoursePattern = Pattern.compile("^add course (.*?)$");
                    Matcher addCourseMatcher = addCoursePattern.matcher(Enter);
                    if (addCourseMatcher.find() == true) {
                        // System.out.println("im here");
                        String[] AddCourseArray = addCourseMatcher.group(1).split(" ");
                        int flag = 0;
                        if (AddCourseArray.length == 0) {
                            System.out.println("missing argument: name");
                        } else if (AddCourseArray.length == 1) {
                            System.out.println("missing argument: username");
                        } else if (AddCourseArray.length == 2) {
                            System.out.println("missing argument: sem");
                        } else if (AddCourseArray.length == 3) {
                            flag = 1;
                        } else if (AddCourseArray.length == 4)
                            System.out.println("missing argument: weight");
                        else if (AddCourseArray.length == 5) {
                            if (Prof.SearchProf(AddCourseArray[1]) == false) {
                                // System.out.println("1");
                                System.out.println("prof with username " + AddCourseArray[1] + " not found.");
                            }
                            if (Course.SearchCourse(AddCourseArray[0], AddCourseArray[1], AddCourseArray[2]) == true) {
                                // System.out.println("2");
                                System.out.println("course " + AddCourseArray[0] + ":" + AddCourseArray[1] + ":"
                                        + AddCourseArray[2] + " exists.");
                            } else if (Prof.SearchProf(AddCourseArray[1]) == true && Course
                                    .SearchCourse(AddCourseArray[0], AddCourseArray[1], AddCourseArray[2]) == false) {
                                // System.out.println("3");
                                Course A = new Course(AddCourseArray[0], AddCourseArray[1], AddCourseArray[2],
                                        Integer.parseInt(AddCourseArray[4]));

                            }

                        }
                        if (flag == 1) {
                            Prof TempProf = Prof.SearchProfReturn(AddCourseArray[1]);
                            TempProf.IncreaseIncome(800);
                            Prof.Profs.remove(Prof.SearchProfReturn(AddCourseArray[1]));
                            Prof.Profs.add(TempProf);
                            Course A = new Course(AddCourseArray[0], AddCourseArray[1], AddCourseArray[2], 3);

                        }
                        flagif = 1;
                    }
                    if (Enter.equals("add course")) {
                        flagif = 1;
                        System.out.println("missing argument: name");
                    }
                }

                // Course AC = new Course("AP", "dr_elahi", "99-2", 3);
                // Course BC = new Course("combinatorics", "paknezhad", "99-2", 4);
                // Course DC = new Course("chert", "dr_elahi", "99-3", 3);
                // List Courses
                {
                    Pattern listCoursesPattern = Pattern.compile("^course list (.*?)$");
                    Matcher listCoursesMatcher = listCoursesPattern.matcher(Enter);
                    if (listCoursesMatcher.find() == true) {
                        // System.out.println("im here");

                        String[] ListCoursesArray = listCoursesMatcher.group(1).split(" ");
                        // int EnterYear = Integer.parseInt(ListCoursesArray[1]);
                        if (ListCoursesArray.length == 2 && ListCoursesArray[0].equals("-p")) {
                            // System.out.println("here");

                            if (Prof.SearchProfReturn(ListCoursesArray[1]) != null) {
                                Prof temp = Prof.SearchProfReturn(ListCoursesArray[1]);
                                // System.out.println(temp.GetLName());
                                // temp.Courses.removeIf(filter)
                                for (Course tempCourse : temp.Courses) {
                                    System.out.println(tempCourse.toString2() + " " + tempCourse.Students.size());
                                }
                            }
                        }
                        if (ListCoursesArray.length == 2 && ListCoursesArray[0].equals("-s")) {
                            for (Course tempCourse : Course.Courses) {
                                if (tempCourse.GetSem().equals(ListCoursesArray[1]) == true) {
                                    System.out.println(tempCourse.toString2() + " " + tempCourse.Students.size());
                                }
                            }
                        }
                        if (ListCoursesArray.length == 4) {
                            if (Prof.SearchProfReturn(ListCoursesArray[1]) != null) {
                                Prof temp = Prof.SearchProfReturn(ListCoursesArray[1]);
                                for (Course tempCourse : Course.Courses) {
                                    if (tempCourse.GetSem().equals(ListCoursesArray[3]) == true
                                            && tempCourse.GetProfUserName().equals(temp.GetUserName())) {
                                        System.out.println(tempCourse.toString2() + " " + tempCourse.Students.size());
                                    }
                                }
                            }
                        }
                        flagif = 1;

                    }
                    if (Enter.equals("course list")) {
                        for (Course tempCourse : Course.Courses) {
                            System.out.println(tempCourse.toString2() + " " + tempCourse.Students.size());
                        }
                        flagif = 1;
                    }
                }

                // Asssign Course
                {
                    Pattern AssignCoursePattern = Pattern.compile("^assign course (.*?)$");
                    Matcher AssignCourseMatcher = AssignCoursePattern.matcher(Enter);
                    // System.out.println("hi");
                    if (AssignCourseMatcher.find() == true) {
                        // System.out.println("im here");
                        String[] AssignCourseArray1 = AssignCourseMatcher.group(1).split(":");
                        Boolean res = true;
                        String TempArray2 = "";
                        String TempSem = "";
                        Student tempStudent = null;
                        if (AssignCourseArray1.length == 0) {
                            System.out.println("missing argument: name");
                        } else if (AssignCourseArray1.length == 1) {
                            System.out.println("missing argument: username");
                        } else if (AssignCourseArray1.length == 2) {
                            System.out.println("missing argument: sem");
                        } else {
                            String[] AssignCourseArray2 = AssignCourseArray1[2].split(" ");
                            if (AssignCourseArray2.length == 0) {
                                System.out.println("missing argument: sem");
                            } else if (AssignCourseArray2.length == 1) {
                                System.out.println("missing argument: number");
                            }
                            res = Course.SearchCourse(AssignCourseArray1[0], AssignCourseArray1[1],
                                    AssignCourseArray2[0]);
                            TempArray2 = AssignCourseArray2[1];
                            tempStudent = Student.SearchStudentByUserName(Integer.parseInt(TempArray2));
                            TempSem = AssignCourseArray2[0];

                        }
                        if (res == false)
                            System.out.println("course not found.");
                        else {

                            Course tempCourse = Course.SearchCourseBySem(TempSem);
                            if (tempCourse.Students.containsKey(tempStudent.GetUserName()) == false) {
                                tempStudent.Courses.add(Course.SearchCourseBySem(TempSem));
                                tempCourse.Students.put(tempStudent.GetUserName(), 0);
                                Course.Courses.remove(Course.SearchCourseBySem(TempSem));
                                Course.Courses.add(tempCourse);
                            }
                            // System.out.println(Student.Students.get().Courses.get(0).GetName());
                        }
                        if (Student.SearchStudentByUserName(Integer.parseInt(TempArray2)) == null) {
                            System.out.println("student not found");
                        }
                        flagif = 1;
                    }
                    if (Enter.equals("assign course")) {
                        System.out.println("missing argument: name");
                        flagif = 1;
                    }
                }

                // Show Course
                {
                    Pattern tuitionStudentPattern = Pattern.compile("^show course (.*?)$");
                    Matcher tuitionStudentMatcher = tuitionStudentPattern.matcher(Enter);
                    if (tuitionStudentMatcher.find() == true) {
                        // System.out.println("im here");
                        String[] TuitionStudentArray = tuitionStudentMatcher.group(1).split(" ");
                        int flag = 0;
                        if (TuitionStudentArray.length == 0) {
                            System.out.println("missing argument: number");
                        } else if (TuitionStudentArray.length == 1) {
                            System.out.println("missing argument: sem");
                        } else if (TuitionStudentArray.length == 2) {
                            Student tempStudent = Student
                                    .SearchStudentByUserName(Integer.parseInt(TuitionStudentArray[0]));
                            for (Course tempCourse : tempStudent.Courses) {
                                System.out.println(tempCourse.GetName() + " " + tempCourse.GetProfUserName() + " "
                                        + tempCourse.GetSem() + " " + tempCourse.Students.size());
                            }
                        }
                        flagif = 1;

                    }
                    if (Enter.equals("show course")) {
                        flagif = 1;
                        System.out.println("missing argument: number");
                    }
                }

                // tuition Done
                {
                    Pattern tuitionStudentPattern = Pattern.compile("^tuition student (.*?)$");
                    Matcher tuitionStudentMatcher = tuitionStudentPattern.matcher(Enter);
                    if (tuitionStudentMatcher.find() == true) {
                        // System.out.println("im here");
                        String[] TuitionStudentArray = tuitionStudentMatcher.group(1).split(" ");
                        int flag = 0;
                        if (TuitionStudentArray.length == 0) {
                            System.out.println("missing argument: number");
                        } else if (TuitionStudentArray.length == 1) {
                            System.out.println("missing argument: sem");
                        } else if (TuitionStudentArray.length == 2) {
                            Student tempStudent = Student
                                    .SearchStudentByUserName(Integer.parseInt(TuitionStudentArray[0]));
                            // int weight = Course.SearchCourseBySem(TuitionStudentArray[1]).GetWeight();
                            for (Course tempCourse : tempStudent.Courses) {
                                if (tempCourse.GetSem().equals(TuitionStudentArray[1]) == true) {
                                    tempStudent.IncreaseTuition(tempCourse.GetWeight() * 50);
                                }

                            }

                            Student.Students
                                    .remove(Student.SearchStudentByUserName(Integer.parseInt(TuitionStudentArray[0])));
                            Student.Students.add(tempStudent);
                            System.out.println(tempStudent.GetTuition());
                        }
                        flagif = 1;

                    }

                    if (Enter.equals("tuition student")) {
                        System.out.println("missing argument: number");
                    }
                }



                // Salary
                {

                    Pattern tuitionStudentPattern = Pattern.compile("^salary prof (.*?)$");
                    Matcher tuitionStudentMatcher = tuitionStudentPattern.matcher(Enter);
                    if (tuitionStudentMatcher.find() == true) {
                        // System.out.println("im here");
                        String[] TuitionStudentArray = tuitionStudentMatcher.group(1).split(" ");
                        int flag = 0;
                        int sum = 0;
                        if (TuitionStudentArray.length == 0) {
                            System.out.println("missing argument: username");
                        } else if (TuitionStudentArray.length == 1) {
                            Prof tempProf = Prof.SearchProfReturn(TuitionStudentArray[0]);
                            for (Course tempCourse : tempProf.Courses) {
                                sum += 800 * tempCourse.GetWeight();
                            }
                            System.out.println(sum);
                        } else if (TuitionStudentArray.length > 1) {
                            Prof tempProf = Prof.SearchProfReturn(TuitionStudentArray[0]);
                            String[] NewArray = new String[100];
                            for (int i = 2; i < TuitionStudentArray.length; i++) {
                                NewArray[i - 2] = TuitionStudentArray[i];
                            }
                            for (String tempString : NewArray) {
                                for (Course tempCourse : tempProf.Courses) {
                                    if (tempCourse.GetSem().equals(tempString) == true) {
                                        sum += 800 * tempCourse.GetWeight();

                                    }

                                }
                            }
                            System.out.println(sum);
                        }
                        flagif = 1;
                    }
                    if (Enter.equals("salary prof")) {
                        System.out.println("missing argument: username");
                    }
                }

                // profit
                {
                    Pattern addCoursePattern = Pattern.compile("^profit (.*?)$");
                    Matcher addCourseMatcher = addCoursePattern.matcher(Enter);
                    if (addCourseMatcher.find() == true) {
                        String tempSem = addCourseMatcher.group(1);
                        int sum = 0;
                        for (Student tEmpStudent : Student.Students) {
                            for (Course tempCourse : tEmpStudent.Courses) {
                                if (tempCourse.GetSem().equals(tempSem))
                                    sum += (tempCourse.GetWeight() * 50);

                            }

                        }
                        for (Prof tempProf : Prof.Profs) {
                            // Prof tempProf = Prof.SearchProfReturn(TuitionStudentArray[0]);
                            for (Course tempCourse : tempProf.Courses) {
                                if (tempCourse.GetSem().equals(tempSem))
                                    sum -= 800 * tempCourse.GetWeight();
                            }
                        }
                        System.out.println(sum);
                        flagif = 1;
                    }
                    if (Enter.equals("profit")) {
                        System.out.println("missing argument: sem");
                    }
                    ///////
                    if (Enter.equalsIgnoreCase("exit")) {
                        break;
                    }
                }

                if (Enter.equals("show course")) {
                    flagif = 1;
                    System.out.println("missing argument: number");
                }

                if (Enter.equalsIgnoreCase("quit")) {
                    flagif = 1;
                    break;
                }
                if (flagif == 0) {
                    System.out.println("INVALID COMMAND");
                }

            }
        } catch (Exception e) {

        }
    }
}






