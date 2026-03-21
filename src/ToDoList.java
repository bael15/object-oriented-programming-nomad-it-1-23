import java.util.ArrayList;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Купить молоко");
        tasks.add("Помыть машину");
        tasks.add("Выучить Java");

        System.out.println("Текущий размер списка: " + tasks.size());

        tasks.remove(1);

        tasks.set(0, "Купить безлактозное молоко");

        System.out.println("Финальный список задач:");
        for (String task : tasks) {
            System.out.println(task);
        }
    }
}