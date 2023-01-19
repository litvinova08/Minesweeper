package minesweeper;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// generateGrid();
		Grid grid = new Grid();
		grid.printGrid();

		// generateBombs();
		String[] bombCoordinates = grid.getBombs();

		// createScanner for user input
		Scanner scanner = new Scanner(System.in);
//		 grab user input
		System.out.println("Enter column value");
		String column = scanner.nextLine(); // it should be a number like 0
		System.out.println("Enter a row value");
		String row = scanner.nextLine(); // it should be a number like 0
		String[] inputCoordinates = { column, row };

		// create a cell object for the cell chosen by the user
		Cell cell = new Cell(inputCoordinates);

		// compare cell fields with bombs locations
		int numberOfBombs = cell.getNumberOfBombs(bombCoordinates);
		System.out.println("This cell is surrounded with " + numberOfBombs + " bombs");

		// updateGrid
		grid.updateGrid(inputCoordinates, numberOfBombs);

	}
}
