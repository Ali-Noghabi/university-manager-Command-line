# University Manager Commandline
- A great and hard Example to Learn OOP
- Use Regex to Handle Commandline
- thats how to use :
```
// First you should add student like:
 
add student Name LastName -y EnterYear
add student ali noghabi -y 99

- when we add student automatically add StudentNumber for every student
for example:
- first add student with 99 enter year = 99001
- secound add student with 99 enter year = 99002
- first add student with 98 enter year = 98001

// You can List students by Enter Year like:

list student -p 99

//Then you should add Professor 

add prof UserName Name LastName
add prof Ali.Noghabi Ali Noghabi

// You can List Professors like:

list prof

//You should Add course 

add course CourseName ProfUserName semester -w credit
add course math Ali.Noghabi 99-2 -w 4

//You Can list Courses by Professor UserName (-p) and semester (-s)

course list
course list -p Ali.Noghabi
course list -s 99-2
course list -p Ali.Noghabi -s 99-2

//Lets Assign course to a student

assign course CourseName:ProfessorUserName:semester StudentNumber
assign course math:Ali.Noghabi:99-2 99001

//you can show courses that assigned 

show course StudentNumber semester
show course 99001 99-2

//you can get Professor Salary for every semester Or All semesters

salary prof ProfessorUserName -s semester1 semester2 ...
salary prof Ali.Noghabi -s 99-2
salary prof Ali.Noghabi -s 99-2 98-1

salary prof ProfessorUserName
salary prof Ali.Noghabi
