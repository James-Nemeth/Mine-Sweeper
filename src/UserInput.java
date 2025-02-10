import java.util.Scanner;

public class UserInput {
    private String[][] grid;
    private boolean[][] revealed;
    private int size;
    private Grid gameGrid;

    public UserInput(int size, String[][] grid, boolean[][] revealed, Grid gameGrid) {
        this.size = size;
        this.grid = grid;
        this.revealed = revealed;
        this.gameGrid = gameGrid;
    }

    public void userMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        System.out.print("Enter row (0 to " + (size - 1) + "): ");
        row = scanner.nextInt();

        System.out.print("Enter column (0 to " + (size - 1) + "): ");
        col = scanner.nextInt();
        if (row >= 0 && row < size && col >= 0 && col < size) {
            if (revealed[row][col]) {
                System.out.println("Spot already revealed. Try again.");
            } else {
                revealCell(row, col);

                if (grid[row][col].equals("0")) {
                    revealAdjacentCells(row, col);
                }
            }
        } else {
            System.out.println("Invalid coordinates. Please enter numbers between 0 and " + (size - 1) + ".");
        }
    }

    public void revealCell(int row, int col) {
        revealed[row][col] = true;

        if (grid[row][col].equals("X")) {
            System.out.println("Boom! You hit a bomb. Game Over!");
            gameGrid.setGameOver(true);
        } else {
            int bombCount = countAdjacentBombs(row, col);
            grid[row][col] = bombCount == 0 ? "0" : String.valueOf(bombCount);
        }
    }

    public void revealAdjacentCells(int row, int col) {
        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size && !revealed[newRow][newCol]) {
                revealCell(newRow, newCol);

                if (grid[newRow][newCol].equals("0")) {
                    revealAdjacentCells(newRow, newCol);
                }
            }
        }
    }

    public int countAdjacentBombs(int row, int col) {
        int bombCount = 0;

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                if (grid[newRow][newCol].equals("X")) {
                    bombCount++;
                }
            }
        }

        return bombCount;
    }

}
