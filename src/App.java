import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper!");

        Grid grid = new Grid(10);

        while (!grid.isGameOver()) {
            grid.printGrid();
            grid.getUserMove();
        }

        System.out.println("Game Over! Would you like to play again? (yes/no)");
        String playAgain = scanner.next().toLowerCase();

        if (playAgain.equals("yes")) {
            main(null);
        } else {
            System.out.println("Thanks for playing!");
        }

        scanner.close();
    }
}
