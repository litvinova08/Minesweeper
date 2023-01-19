package minesweeper;

import java.util.Arrays;
import java.util.List;

public class Grid {

	// TBD GENERATE A GRID WITH DIFFERENT NUMBERS OF CELLS
	public char[][] grid = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public void printGrid() {
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				System.out.print(this.grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	// TBD GENERATE RANDOMLY
	public List<String> getBombs() {
		String[] arr = { "00", "06", "21", "31", "36", "49", "70", "74", "97", "99" };
		List<String> bombs = Arrays.asList(arr);
		return bombs;
	}

	public void updateGrid(String[] coordinates, int numberOfBombs) {
		int x = Integer.valueOf(coordinates[0]);
		int y = Integer.valueOf(coordinates[1]);
		this.grid[x][y] = Character.forDigit(numberOfBombs, 10);
		printGrid();
	}
}
