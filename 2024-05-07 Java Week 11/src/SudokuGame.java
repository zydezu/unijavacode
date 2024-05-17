import java.util.Scanner;

/**
 * Represents a Sudoku game that can be played using the command prompt.
 */
public class SudokuGame {

    private ISudokuGrid grid;
    private SudokuSolver solver;

    /**
     * Constructs a SudokuGame with a given Sudoku grid.
     *
     * @param grid The Sudoku grid to play the game on.
     */
    public SudokuGame(ISudokuGrid grid) {
        this.grid = grid;
        this.solver = new SudokuSolver(grid);
    }

    /**
     * Starts the Sudoku game.
     */
    public void start() {
        generatePuzzle(); // Generate the puzzle grid
        printBoard();
        playGame(); // Start the game loop
    }

    // Generate the puzzle grid with missing values
    private void generatePuzzle() {
        SudokuGenerator generator = new SudokuGenerator(grid);
        generator.generate();
    }

    // Print the Sudoku board for the player
    private void printBoard() {
        System.out.println("Sudoku Puzzle:");
        grid.printGrid();
        System.out.println();
    }

    // Start the game loop
    private void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the row, column, and value (separated by space), or 'q' to quit:");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Quitting the game.");
                break;
            }
            if (input.equalsIgnoreCase("s")) {
                this.solver.solve();
                grid.printGrid();
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid input. Please enter row, column, and value separated by space.");
                continue;
            }
            try {
                int row = Integer.parseInt(parts[0]) - 1;
                int col = Integer.parseInt(parts[1]) - 1;
                int value = Integer.parseInt(parts[2]);
                if (!isValidInput(row, col, value)) {
                    System.out.println("Invalid input. Please enter valid row, column, and value.");
                    continue;
                }
                grid.setValue(row, col, value);
                System.out.println("Updated Sudoku grid:");
                grid.printGrid();
                if (grid.isFull() && solver.isValid()) {
                    System.out.println("Congratulations! You solved the Sudoku puzzle!");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter valid row, column, and value.");
            }
        }
        scanner.close();
    }

    // Checks if the user input is valid
    private boolean isValidInput(int row, int col, int value) {
        return row >= 0 && row < grid.getSize() &&
                col >= 0 && col < grid.getSize() &&
                value >= 1 && value <= grid.getSize();
    }

    public static void main(String[] args) {
        // Create an instance of SudokuGrid
        ISudokuGrid grid = new SudokuGrid();

        // Create an instance of SudokuGame using the SudokuGrid instance
        SudokuGame game = new SudokuGame(grid);

        // Start the game
        game.start();
    }
}
