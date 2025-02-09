public class Grid {
    public int size;
    private String[][] grid;

    public Grid(int size) {
        this.size = size;
        this.grid = new String[size][size];
        initialiseGrid();
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
                System.out.print("{ } ");
            }
            System.out.println();
        }
    }
}
