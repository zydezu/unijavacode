/**
 * This interface defines methods for interacting with a Sudoku grid.
 * Implementing classes should provide concrete implementations of these methods.
 */
public interface ISudokuGrid {
    /**
     * Initializes the Sudoku grid with a given size.
     * 
     * @param size The size of the Sudoku grid.
     */
    void initializeGrid(int size);

    /**
     * Gets the size of the Sudoku grid.
     * 
     * @return The size of the Sudoku grid.
     */
    int getSize();

    /**
     * Sets a value at a specific row and column in the Sudoku grid.
     * 
     * @param row The row index.
     * @param col The column index.
     * @param value The value to be set.
     * @throws IllegalArgumentException if the provided value is invalid.
     */
    void setValue(int row, int col, int value) throws IllegalArgumentException;

    int getValue(int row, int col) throws IllegalArgumentException;

    /**
     * Checks if the Sudoku grid is valid.
     * 
     * @return true if the Sudoku grid is valid, false otherwise.
     */
    boolean isValid();

    /**
     * Checks if the Sudoku grid is full.
     * 
     * @return true if the Sudoku grid is full, false otherwise.
     */
    boolean isFull();

    /**
     * Clears the Sudoku grid (reset all cells to zero).
     */
    void clearGrid();

    /**
     * Prints the Sudoku grid.
     */
    void printGrid();

    /**
     * Copies the Sudoku grid.
     * 
     * @return A copy of the Sudoku grid.
     */
    ISudokuGrid copyGrid();

}
