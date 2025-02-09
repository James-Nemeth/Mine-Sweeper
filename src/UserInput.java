import java.util.Scanner;

public class UserInput {
    private String[][] grid;
    private int size;

    public UserInput(int size, String[][] grid) {
        this.size = size;
        this.grid = grid;
    }

    public void userMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        System.out.print("Enter row (0 to " + (size - 1) + "): ");
        row = scanner.nextInt();

        System.out.print("Enter column (0 to " + (size - 1) + "): ");
        col = scanner.nextInt();

        if (row >= 0 && row < size && col >= 0 && col < size) {
            if (grid[row][col].equals(" ")) {
                grid[row][col] = "+";
            } else {
                System.out.println("Spot already taken. Try again.");
            }
        } else {
            System.out.println("Invalid coordinates. Please try again.");
        }
    }
}
