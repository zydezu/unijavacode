import java.util.Arrays;

/**
 * Represents a Sudoku grid.
 * Implements the ISudokuGrid interface to provide methods for interacting with the grid.
 */
public class SudokuGrid implements ISudokuGrid {

    private int[][] grid; // 2D array to store the Sudoku grid
    private int size; // Size of the Sudoku grid

    /**
     * Default constructor that creates an empty Sudoku grid.
     * The default size of the grid is 9x9.
     */
    public SudokuGrid() {
        this.size = 9;
        initializeGrid(size);
    }

    /**
     * Initializes the Sudoku grid with the specified size.
     *
     * @param size         The size of the Sudoku grid.
     * @throws IllegalArgumentException if the specified size is non-positive.
     */
    @Override
    public void initializeGrid(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be a positive integer.");
        }
        this.size = size;
        this.grid = new int[size][size];
    }

    /**
     * Gets the size of the Sudoku grid.
     *
     * @return The size of the Sudoku grid.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Sets a value at a specific row and column in the Sudoku grid.
     *
     * @param row   The row index.
     * @param col   The column index.
     * @param value The value to be set.
     * @throws IllegalArgumentException if the provided row, column, or value is invalid.
     */
    @Override
    public void setValue(int row, int col, int value) throws IllegalArgumentException {
        if (!isValidCell(row, col) || !isValidValue(value)) {
            throw new IllegalArgumentException("Invalid row, column, or value.");
        }
        grid[row][col] = value;
    }

    /**
     * Gets the value at a specific row and column in the Sudoku grid.
     *
     * @param row The row index.
     * @param col The column index.
     * @return The value at the specified position.
     * @throws IllegalArgumentException if the provided row or column index is invalid.
     */

    @Override
    public int getValue(int row, int col) throws IllegalArgumentException {
        if (!isValidCell(row, col)) {
            throw new IllegalArgumentException("Invalid row or column.");
        }
        return grid[row][col];
    }

    /**
     * Checks if the Sudoku grid is valid.
     *
     * @return true if the Sudoku grid is valid, false otherwise.
     */
    @Override
    public boolean isValid() {
        // To be implemented
        return true; // Placeholder
    }

    /**
     * Checks if the Sudoku grid is full.
     *
     * @return true if the Sudoku grid is full, false otherwise.
     */
    @Override
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) {
                    return false; // Found an empty cell
                }
            }
        }
        return true; // All cells are filled
    }

    /**
     * Clears the Sudoku grid (reset all cells to zero).
     */
    @Override
    public void clearGrid() {
        for (int[] row : grid) {
            Arrays.fill(row, 0);
        }
    }

    /**
     * Prints the Sudoku grid.
     * The 3x3 groups are separated by '|' and '-' characters.
     */
    @Override
    public void printGrid() {
        for (int i = 0; i < size; i++) {
            // Print horizontal separator every 3 rows
            if (i > 0 && i % 3 == 0) {
                System.out.println("------+-------+------");
            }
    
            for (int j = 0; j < size; j++) {
                // Print vertical separator every 3 columns
                if (j > 0 && j % 3 == 0) {
                    System.out.print("| ");
                }
    
                // Print value
                int value = grid[i][j];
                System.out.print(value != 0 ? value : "□"); // Use square character for blank values
                System.out.print(" ");
            }
            System.out.println();
        }
    
    }
    
    /**
     * Copies the Sudoku grid.
     *
     * @return A copy of the Sudoku grid.
     */
    @Override
    public ISudokuGrid copyGrid() {
        SudokuGrid copy = new SudokuGrid();
        copy.grid = Arrays.copyOf(grid, grid.length);
        return copy;
    }

    // Private helper method to check if a cell is valid
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    // Private helper method to check if a value is valid
    private boolean isValidValue(int value) {
        return value >= 0 && value <= size;
    }

    public static void main(String[] args) {
        // Create an instance of SudokuGrid
        SudokuGrid sudokuGrid = new SudokuGrid();

        // Print the empty grid
        System.out.println("Empty Sudoku Grid:");
        sudokuGrid.printGrid();
        //print the sudoku grid

        System.err.println();
        //generate a full sudoku grid


    }
}
