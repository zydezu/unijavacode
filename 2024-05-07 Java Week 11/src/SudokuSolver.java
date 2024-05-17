import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
    private ISudokuGrid grid;

    /**
     * Constructs a SudokuSolver with a given Sudoku grid.
     *
     * @param grid The Sudoku grid to solve.
     */
    public SudokuSolver(ISudokuGrid grid) {
        this.grid = grid;
    }

    /**
     * Solves the Sudoku puzzle using backtracking algorithm.
     *
     * @return true if the puzzle is solvable, false otherwise.
     */
    public boolean solve() {
        return solve(0, 0);
    }

    // Recursive method to solve the Sudoku puzzle
    private boolean solve(int row, int col) {
        // Base case: If all cells are filled, puzzle is solved
        if (row == grid.getSize()) {
            return true;
        }

        // Calculate next row and column indices
        int nextRow = (col == grid.getSize() - 1) ? row + 1 : row;
        int nextCol = (col == grid.getSize() - 1) ? 0 : col + 1;

        // If the cell is already filled, move to the next cell
        if (grid.getValue(row, col) != 0) {
            return solve(nextRow, nextCol);
        }

        // Try filling the cell with values 1 to grid size
        for (int value = 1; value <= grid.getSize(); value++) {
            if (isValidMove(row, col, value)) {
                grid.setValue(row, col, value);
                if (solve(nextRow, nextCol)) {
                    return true;
                }
                grid.setValue(row, col, 0); // Backtrack
            }
        }

        // No valid value found for this cell, backtrack
        return false;
    }

    /**
     * Checks if the current state of the Sudoku grid is valid.
     *
     * @return true if the Sudoku grid is valid, false otherwise.
     */
    public boolean isValid() {
        return grid.isValid();
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

    /**
     * Checks if the Sudoku puzzle has a unique solution.
     *
     * @return true if the solution is unique, false otherwise.
     */
    public boolean hasUniqueSolution() {
        // Copy the grid to solve multiple times without modifying the original grid
        ISudokuGrid copyGrid = grid.copyGrid();
        // Solve the puzzle
        if (!solve()) {
            return false; // No solution found
        }
        // Check if there is another solution
        boolean hasAnotherSolution = solve();
        // Restore the original grid
        grid = copyGrid;
        return !hasAnotherSolution; // If there is no another solution, return true
    }

    /**
     * Returns a list of all solutions to the Sudoku puzzle.
     *
     * @return A list of solutions represented as ISudokuGrid instances.
     */
    public List<ISudokuGrid> getAllSolutions() {
        List<ISudokuGrid> solutions = new ArrayList<>();
        // Copy the grid to solve without modifying the original grid
        ISudokuGrid copyGrid = grid.copyGrid();
        // Solve the puzzle
        if (solve()) {
            solutions.add(grid.copyGrid());
            // Find other solutions if they exist
            while (solve()) {
                solutions.add(grid.copyGrid());
            }
        }
        // Restore the original grid
        grid = copyGrid;
        return solutions;
    }
}
