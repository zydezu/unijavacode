import java.util.Random;

/**
 * Represents a Sudoku puzzle generator that uses the ISudokuGrid interface to interact with a Sudoku grid.
 */
public class SudokuGenerator {

    private ISudokuGrid grid;

    /**
     * Constructs a SudokuGenerator with a given Sudoku grid.
     *
     * @param grid The Sudoku grid to generate the puzzle on.
     */
    public SudokuGenerator(ISudokuGrid grid) {
        this.grid = grid;
    }

    /**
     * Generates a Sudoku puzzle with blank spaces.
     */
    public void generate() {
        generate(0, 0);
        removeValues();
    }

    // Recursive method to generate the Sudoku puzzle
    private boolean generate(int row, int col) {
        // Base case: If all cells are filled, puzzle is generated
        if (row == grid.getSize()) {
            return true;
        }

        // Calculate next row and column indices
        int nextRow = (col == grid.getSize() - 1) ? row + 1 : row;
        int nextCol = (col == grid.getSize() - 1) ? 0 : col + 1;

        // Try filling the cell with random values
        int[] values = shuffleValues();
        for (int value : values) {
            if (isValidMove(row, col, value)) {
                grid.setValue(row, col, value);
                if (generate(nextRow, nextCol)) {
                    return true;
                }
                grid.setValue(row, col, 0); // Backtrack
            }
        }

        // No valid value found for this cell, backtrack
        return false;
    }

    // Helper method to shuffle values from 1 to grid size
    private int[] shuffleValues() {
        int[] values = new int[grid.getSize()];
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 1;
        }
        Random rand = new Random();
        for (int i = values.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = values[index];
            values[index] = values[i];
            values[i] = temp;
        }
        return values;
    }

    // Check if a move (placing a value in a cell) is valid
    private boolean isValidMove(int row, int col, int value) {
        // Check row
        for (int i = 0; i < grid.getSize(); i++) {
            if (grid.getValue(row, i) == value) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < grid.getSize(); i++) {
            if (grid.getValue(i, col) == value) {
                return false;
            }
        }

        // Check subgrid
        int subgridSize = (int) Math.sqrt(grid.getSize());
        int startRow = row - row % subgridSize;
        int startCol = col - col % subgridSize;
        for (int i = startRow; i < startRow + subgridSize; i++) {
            for (int j = startCol; j < startCol + subgridSize; j++) {
                if (grid.getValue(i, j) == value) {
                    return false;
                }
            }
        }

        return true;
    }

    // Remove values to create blank spaces in the puzzle
    private void removeValues() {
        Random rand = new Random();
        int emptyCells = grid.getSize() * grid.getSize() / 2; // Remove half of the values
        for (int i = 0; i < emptyCells; i++) {
            int row = rand.nextInt(grid.getSize());
            int col = rand.nextInt(grid.getSize());
            if (grid.getValue(row, col) != 0) {
                grid.setValue(row, col, 0);
            } else {
                i--; // Try again if the selected cell is already empty
            }
        }
    }
}
