import java.util.Random;

public class Bomb {
    private int size;
    private String[][] grid;

    public Bomb(int size, String[][] grid) {
        this.size = size;
        this.grid = grid;
        generateBombs();
        calculateNumbers();
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

    public void calculateNumbers() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col].equals("X")) {
                    continue;
                }

                int adjacentBombs = 0;
                for (int r = row - 1; r <= row + 1; r++) {
                    for (int c = col - 1; c <= col + 1; c++) {
                        if (r >= 0 && r < size && c >= 0 && c < size && grid[r][c].equals("X")) {
                            adjacentBombs++;
                        }
                    }
                }

                if (adjacentBombs > 0) {
                    grid[row][col] = String.valueOf(adjacentBombs);
                } else {
                    grid[row][col] = "0";
                }
            }
        }
    }

}
