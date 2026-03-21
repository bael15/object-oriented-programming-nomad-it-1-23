import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Buy milk");
        tasks.add("Wash Car");
        tasks.add("Learn Java");

        System.out.println("Size of list: " + tasks.size());
        tasks.remove(1);
        tasks.set(0,"Buy another milk");

        System.out.println("Final task list");
        for (String task: tasks){
            System.out.println(task);
        }
    }
}



public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList();
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter grade(neg num = end)");

        while(true){
            int grade=scanner.nextInt();
            if (grade < 0) {
                break;
            }
            grades.add(grade);
        }
        if (grades.isEmpty()) {
            System.out.println("No grades found");
            return;
        }
        int sum=0;
        for (int grade : grades) {
            sum += grade;
        }
        double average=(double) sum/grades.size();
        System.out.println("Average grade is "+average);

        int max = grades.get(0);

        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        System.out.println("Maximum grade is "+max);
        scanner.close();


    }
}


public class Task3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++){
            int num = random.nextInt(50) +1;
            numbers.add(num);
        }
        System.out.println("beofre changes");
        System.out.println(numbers);
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) % 2 != 0) {
                numbers.remove(i);
                i--;
            }
        }
        System.out.println("after changes");
        System.out.println(numbers);
    }
}


public class Task4{
    public static void main(String[] args) {
        ArrayList<String> contactsInPhone = new ArrayList<>();
        contactsInPhone.add("Yasuo");
        contactsInPhone.add("Sekiro");
        contactsInPhone.add("Akali");

        ArrayList<String> contactsInSim = new ArrayList<>();
        contactsInSim.add("Acheron");
        contactsInSim.add("Yone");
        contactsInSim.add("Archer");

        ArrayList<String> Allcontacts = new ArrayList<>();
        for (String contact : contactsInPhone) {
            if (!Allcontacts.contains(contact)) {
                Allcontacts.add(contact);
            }
        }
        for (String contact : contactsInSim) {
            if (!Allcontacts.contains(contact)) {
                Allcontacts.add(contact);
            }
        }
        Collections.sort(Allcontacts);

        System.out.println("all");
        for (String contact : Allcontacts) {
            System.out.println(contact);
        }
    }
}

void main() {

}