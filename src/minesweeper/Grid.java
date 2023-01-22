package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {

	// TBD GENERATE A GRID WITH DIFFERENT NUMBERS OF CELLS
	public String[][] grid = { { " ", " 1", "2", "3", "4", "5", "6", "7", "8", "9", "10" },
			{ "1 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "2 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "3 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "4 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "5 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "6 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "7 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "8 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "9 ", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "10", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" } };

//			{ '1', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

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
//		String[] arr = { "00", "06", "21", "31", "36", "49", "70", "74", "97", "99" };	
		ArrayList<String> arr = new ArrayList<>();
		while (arr.size() < 10) {

//			int randomNum = 10 + (int) (Math.random() * 90);
			
			//bomb coordinates cannot have 0 because this index is used for grid navigation
			int randomColumn = 1 + (int) (Math.random() * 10);
			int randomRow = 1 + (int) (Math.random() * 10);
			
			String randomStr = Integer.toString(randomColumn) + Integer.toString(randomRow);
			
			if (!arr.contains(randomStr)) {
				arr.add(randomStr);
			}
		}
//		List<String> bombs = Arrays.asList(arr);
		return arr;
	}
	

	public void updateGrid(String[] coordinates, int numberOfBombs) {
		int x = Integer.valueOf(coordinates[0]);
		int y = Integer.valueOf(coordinates[1]);
		this.grid[x][y] = Integer.toString(numberOfBombs);
//		this.grid[x][y] = Character.forDigit(numberOfBombs, 10);
		printGrid();
	}
}
