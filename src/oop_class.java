public class oop_class {

    public static class Student {
        String name;
        int ID, Age;

        // using constructor
        Student (String n,int id,int age){
            n=name;id=ID;age=Age;
        }

        // using method

       /* void setInfo(String name,int ID,int Age){
            this.name=name;
            this.ID=ID;
            this.Age=Age;
        }*/
        void display() {
            System.out.println("Name is " +name);
            System.out.println("The id is "+ID);
            System.out.println("Age is "+Age);
        }

        public static void main(String[] args) {

            Student s1 = new Student("Sohag",12,20);

            s1.display();
        }
    }
}