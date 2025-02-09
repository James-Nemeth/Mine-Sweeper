public class Grid {
    public int size;
    private String[][] grid;

    public Grid(int size) {
        this.size = size;
        this.grid = new String[size][size];
        initialiseGrid();
        Bomb bomb = new Bomb(10, grid);
    }

    private void initialiseGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = " ";
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("{ " + grid[i][j] + " } ");
            }
            System.out.println();
        }
    }
}
