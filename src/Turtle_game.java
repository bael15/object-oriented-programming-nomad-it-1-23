public class Turtle_game {
    private int x;
    private int y;
    private int direction;

    public Turtle_game(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveForward(int size) {
        int newX = this.x;
        int newY = this.y;
        if (this.direction == 0) {
            --newX;
        }

        if (this.direction == 1) {
            ++newY;
        }

        if (this.direction == 2) {
            ++newX;
        }

        if (this.direction == 3) {
            --newY;
        }

        if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
            this.x = newX;
            this.y = newY;
        } else {
            System.out.println("Access denied!");
        }

    }

    public void turnRight() {
        this.direction = (this.direction + 1) % 4;
        System.out.println("right");
    }
    public void turnLeft() {
        this.direction = (this.direction + 3) % 4;
        System.out.println("left");
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}