public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Please insert your Coordinates");
        Grid grid = new Grid(10);
        grid.printGrid();
        grid.getUserMove();
    }
}
