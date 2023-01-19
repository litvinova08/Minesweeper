package minesweeper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cell {

	public String[] coordinates;
	public String[] cellsAround;

	public Cell(String[] coordinates) {
		this.coordinates = coordinates;
		this.cellsAround = getCellsAround();
	}

	// to generate coordinates of all eight cells around the chosen cell
	public String[] getCellsAround() {
		int x = Integer.valueOf(this.coordinates[0]);
		int y = Integer.valueOf(this.coordinates[1]);
		Integer[][] cellsAroundInts = { { x - 1, y }, { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 }, { x + 1, y },
				{ x + 1, y - 1 }, { x, y - 1 }, { x - 1, y - 1 } };
		String[] cellsAroundStr = new String[8];

		for (int i = 0; i < cellsAroundInts.length; i++) {

			List<Integer> numbers = Arrays.asList(cellsAroundInts[i]);
			String joinedCoordinates = numbers.stream().map(el -> el.toString()).collect(Collectors.joining(""));

			cellsAroundStr[i] = joinedCoordinates;
		}
		return cellsAroundStr;
	}

	// to get a number of bombs around this cell
	public int getNumberOfBombs(List<String> bombs) {
//		List<String> bombsList = Arrays.asList(bombs);

		int counter = 0;

		for (int i = 0; i < this.cellsAround.length; i++) {
			if (bombs.contains(this.cellsAround[i])) {
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
