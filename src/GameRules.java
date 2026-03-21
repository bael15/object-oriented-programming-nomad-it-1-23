import java.util.Random;
import java.util.Scanner;

public class GameRules {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Field field = new Field(5);

        Turtle_game turtle = new Turtle_game (
                random.nextInt(field.getSize()),
                random.nextInt(field.getSize()),
                random.nextInt(4)
        );

        System.out.println("Spawned");
        field.printField(turtle);

        while (true) {

            System.out.println("1 - forward | 2 - right | 3 - left | 0 - exit");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("See you next time");
                break;
            }

            if (choice == 1) {
                turtle.moveForward(field.getSize());
            } else if (choice == 2) {
                turtle.turnRight();
            } else if (choice == 3) {
                turtle.turnLeft();
            } else {
                System.out.println("Invalid choice");
            }

            field.printField(turtle);
        }

        scanner.close();
    }
}