public class Grid {
    private String[][] grid;
    private boolean[][] revealed;
    private int size;
    private Bomb bomb;
    private UserInput userInput;
    private boolean gameOver;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public Grid(int size) {
        this.size = size;
        this.grid = new String[size][size];
        this.revealed = new boolean[size][size];
        this.gameOver = false;
        initialiseGrid();
        bomb = new Bomb(size, grid);
        userInput = new UserInput(size, grid, revealed, this);
    }

    private void initialiseGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = " ";
                revealed[i][j] = false;
            }
        }
    }

    public void printGrid() {
        System.out.print("   ");
        for (int j = 0; j < size; j++) {
            System.out.print("  " + j + "   ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < size; j++) {
                if (!revealed[i][j]) {
                    System.out.print(ANSI_GREEN + "{   } " + ANSI_RESET);
                } else {
                    System.out.print(ANSI_YELLOW + "{ " + grid[i][j] + " } " + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public void getUserMove() {
        if (!gameOver) {
            userInput.userMove();
            checkGameState();
        }
    }

    private void checkGameState() {
        boolean allRevealed = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!revealed[i][j] && !isBomb(i, j)) {
                    allRevealed = false;
                    return;
                }
            }
        }
        if (allRevealed) {
            gameOver = true;
            System.out.println("Congratulations, You Win!");
        }
    }

    public boolean isBomb(int row, int col) {
        return grid[row][col].equals("X");
    }

    public void revealCell(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size || revealed[row][col]) {
            return;
        }

        revealed[row][col] = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
