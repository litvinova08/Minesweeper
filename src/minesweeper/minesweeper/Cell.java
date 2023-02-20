package minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	public String[] coordinates;
	public ArrayList<String> cellsAround;

	public Cell(String[] coordinates) {
		this.coordinates = coordinates;
		this.cellsAround = getCellsAround();
	}

	// to generate coordinates of all eight cells around the chosen cell
	public ArrayList<String> getCellsAround() {

		// get Integers of the chosen cell coordinates
		int x = Integer.valueOf(this.coordinates[0]);
		int y = Integer.valueOf(this.coordinates[1]);

		// generate coordinates of eight cells around the chosen cell
		int[][] cellsAroundInts = { { x - 1, y }, { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 }, { x + 1, y },
				{ x + 1, y - 1 }, { x, y - 1 }, { x - 1, y - 1 } };

		// convert 2D array of Interegs to a List of Strings with cells coordinates
		ArrayList<String> cellsAroundStr = new ArrayList<>();

		for (int[] coordinates : cellsAroundInts) {
			cellsAroundStr.add(String.join("", convertIntArrToString(coordinates)));
		}
		return cellsAroundStr;
	}

	public static String convertIntArrToString(int[] intArr) {
		String rsl = "";
		for (int i = 0; i < intArr.length; i++) {
			String temp = Integer.toString(intArr[i]);
			rsl = rsl + temp;
		}
		return rsl;
	}

	// to get a number of bombs around this cell
	public int getNumberOfBombs(List<String> bombs) {

		// to count the number of bombs around the chosen cell
		int counter = 0;

		for (String cell : cellsAround) {
			if (bombs.contains(cell)) {
				counter = counter + 1;
			}
		}
		return counter;
	}

	// check if the cell has a bomb
	public boolean hasBomb(List<String> bombs) {
		String srtCoordinates = String.join("", this.coordinates);
		if (bombs.contains(srtCoordinates))
			return true;
		return false;
	}
}
