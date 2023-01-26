package intro;

    public class Student {

        String name;
        char sex;
        int age;
        int cours;


        public Student(String name, char sex, int age, int cours) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.cours = cours;
        }

        @Override
        public String toString() {
            return "lambda{" +
                    "name='" + name + '\'' +
                    ", sex=" + sex +
                    ", age=" + age +
                    ", cours=" + cours +
                    '}';
        }
    }

