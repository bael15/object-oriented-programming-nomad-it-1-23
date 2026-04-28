import java.awt.Color;
import java.util.Random;

public class GameBoard {
    public static final int BOARD_COLUMNS = 4;
    public static final int BOARD_ROWS = 4;
    public Tile[][] board = new Tile[BOARD_ROWS][BOARD_COLUMNS];
    // Увеличим размер массивов, чтобы избежать ошибок индексации
    public int[] powers = new int[12];
    public Color[] colors = new Color[2049]; // Индексация будет по значению плитки

    public GameBoard() {
        initPowers();

        // Сначала заполняем всё "пустыми" (1)
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                board[i][j] = new Tile(1, Color.LIGHT_GRAY, Color.BLACK);
            }
        }

        // Ставим первую игровую плитку
        int rV = randomValue();
        board[randomRow()][randomColumn()] = new Tile(rV, getTileColor(rV), Color.BLACK);
        printBoard();
    }

    private void initPowers() {
        // Заполняем цвета для всех возможных значений 2, 4, 8... 2048
        for (int i = 1; i <= 11; i++) {
            int value = (int) Math.pow(2, i);
            colors[value] = getTileColor(value);
        }
        // Цвет для пустой плитки (1)
        colors[1] = Color.LIGHT_GRAY;
    }

    private Color getTileColor(int value) {
        if (value <= 1) return Color.LIGHT_GRAY;

        Color start = new Color(255, 255, 255); // Белый
        Color end = new Color(255, 100, 0);   // Оранжевый

        int maxPower = 11;
        // Правильное вычисление степени двойки: log2(value)
        double currentPower = Math.log(value) / Math.log(2);
        float t = (float) (currentPower / maxPower);
        t = Math.min(1.0f, t); // Чтобы не выйти за пределы 1.0

        int r = (int) (start.getRed() + t * (end.getRed() - start.getRed()));
        int g = (int) (start.getGreen() + t * (end.getGreen() - start.getGreen()));
        int b = (int) (start.getBlue() + t * (end.getBlue() - start.getBlue()));

        return new Color(r, g, b);
    }

    // Вспомогательный метод для вывода, чтобы не дублировать код
    public void printBoard() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                System.out.print(board[i][j].getValue() + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public int randomColumn() { return new Random().nextInt(BOARD_COLUMNS); }
    public int randomRow() { return new Random().nextInt(BOARD_ROWS); }
    public int randomValue() { return Math.random() < 0.9 ? 2 : 4; }

    public void right() {
        moveRight();
        mergeRight();
        moveRight();
        spawnRandom();
        printBoard();
    }

    private void moveRight() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = BOARD_COLUMNS - 1; j >= 0; j--) {
                if (board[i][j].getValue() == 1) continue;
                Tile current = board[i][j];
                int targetCol = j;
                for (int k = j + 1; k < BOARD_COLUMNS; k++) {
                    if (board[i][k].getValue() == 1) targetCol = k;
                    else break;
                }
                if (targetCol != j) {
                    board[i][targetCol] = current;
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                }
            }
        }
    }

    private void mergeRight() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = BOARD_COLUMNS - 1; j > 0; j--) {
                Tile current = board[i][j];
                Tile next = board[i][j - 1];
                if (current.getValue() != 1 && current.getValue() == next.getValue()) {
                    int newVal = current.getValue() * 2;
                    board[i][j] = new Tile(newVal, getTileColor(newVal), Color.BLACK);
                    board[i][j - 1] = new Tile(1, colors[1], Color.BLACK);
                }
            }
        }
    }

    private void spawnRandom() {
        // Простая проверка, чтобы не попасть в бесконечный цикл
        boolean hasSpace = false;
        for(Tile[] row : board) for(Tile t : row) if(t.getValue() == 1) hasSpace = true;

        if (!hasSpace) return;

        while (true) {
            int r = randomRow();
            int c = randomColumn();
            if (board[r][c].getValue() == 1) {
                int val = randomValue();
                board[r][c] = new Tile(val, getTileColor(val), Color.BLACK);
                break;
            }
        }
    }

    // Метод left() реализуется аналогично, зеркально методу right
}