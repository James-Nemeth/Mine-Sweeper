import java.util.Random;

public class Bomb {
    private int size;
    private String[][] grid;

    public Bomb(int size, String[][] grid) {
        this.size = size;
        this.grid = grid;
        generateBombs();
    }

    public void generateBombs() {
        Random random = new Random();
        int bombAmount = 10;

        while (bombAmount > 0) {
            int row = random.nextInt(size);
            int column = random.nextInt(size);

            if (grid[row][column].equals(" ")) {
                grid[row][column] = "X";
                bombAmount--;
            }
        }
    }
}
