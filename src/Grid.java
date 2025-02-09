public class Grid {
    public int size;
    private String[][] grid;
    private Bomb bomb;
    private UserInput userInput;

    public Grid(int size) {
        this.size = size;
        this.grid = new String[size][size];
        initialiseGrid();
        bomb = new Bomb(10, grid);
        userInput = new UserInput(size, grid);
    }

    private void initialiseGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = " ";
            }
        }
    }

    public void getUserMove() {
        userInput.userMove();
    }

    public void printGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].equals("X")) {
                    System.out.print("{  } ");
                } else {
                    System.out.print("{ " + grid[i][j] + " } ");
                }
            }
            System.out.println();
        }
    }
}
