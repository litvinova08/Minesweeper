package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cell {

	public String[] coordinates;
	public ArrayList<String> cellsAround;

	public Cell(String[] coordinates) {
		this.coordinates = coordinates; 
		this.cellsAround = getCellsAround();
	}

	// to generate coordinates of all eight cells around the chosen cell
	public ArrayList<String> getCellsAround() {
		
		//get Integersof the chosen cell coordinates
		int x = Integer.valueOf(this.coordinates[0]);
		int y = Integer.valueOf(this.coordinates[1]);
		
		//generate coordinates of eight cells around the chosen cell
		int[][] cellsAroundInts = { { x - 1, y }, { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 }, { x + 1, y },
				{ x + 1, y - 1 }, { x, y - 1 }, { x - 1, y - 1 } };
		
		//convert 2D array of Interegs to a List of Strings with cells coordinates
		ArrayList<String> cellsAroundStr = new ArrayList<>();
		
		for (int[] coordinates : cellsAroundInts) {
//			String joined = StringUtils.join(ArrayUtils.toObject(intArray), separator);
			
			cellsAroundStr.add(Arrays.toString(coordinates));
		}
//		
//		for (int i = 0; i < cellsAroundInts.length; i++) {
//
//			List<Integer> numbers = Arrays.asList(cellsAroundInts[i]);
//			String joinedCoordinates = numbers.stream().map(el -> el.toString()).collect(Collectors.joining(""));
//
//			cellsAroundStr[i] = joinedCoordinates;
//		}
		return cellsAroundStr;
	}

	// to get a number of bombs around this cell
	public int getNumberOfBombs(List<String> bombs) {
		
		//to count the number of bombs around the chosen cell
		int counter = 0;
		
		for (String cell : cellsAround) {
			if (bombs.contains(cell)) {
				counter = counter + 1;
			}
		}

//		for (int i = 0; i < this.cellsAround.size(); i++) {
//			if (bombs.contains(this.cellsAround[i])) {
//				counter = counter + 1;
//			}
//		}
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
