package intro;

import java.util.ArrayList;

public class StudentInfo1 {

        void testStud(ArrayList<Student> arrayList, StudentCheck sc){
            for (Student s:arrayList){
                if (sc.check(s)){
                    System.out.println(s);
                }
            }
        }
    }
    class Test{   public static void main(String[] args) {

        Student st1 = new Student("Aman", 'm', 22, 7);
        Student st2 = new Student("Almaz", 'm', 26, 10);
        Student st3 = new Student("Dastan", 'm', 27, 6);
        Student st4 = new Student("Lera", 'f', 31, 2);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);

        StudentInfo1 info = new StudentInfo1();
        info.testStud(students,new checkOvercCours());
        System.out.println("----------------");
        info.testStud(students, new StudentCheck() {
            @Override
            public boolean check(Student s) {
                return s.age<30;}});


        System.out.println("__-----------------");


        info.testStud(students,(Student s)-> {return s.age<30;});


        System.out.println("__-----------------");
        info.testStud(students, new StudentCheck() {
            @Override
            public boolean check(Student s) {
                return false;
            }
        });

    }}
    interface StudentCheck{
        boolean check(Student s);
    }
    class checkOvercCours implements StudentCheck{
        @Override
        public boolean check(Student s) {
            return s.cours>8;
        }
    }

