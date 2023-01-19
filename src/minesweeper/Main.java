package minesweeper;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Let's play Minesweeper!");

		// generateGrid();
		Grid grid = new Grid();
		grid.printGrid();

		// createScanner for user input
		Scanner scanner = new Scanner(System.in);

		while (Tracker.getUncheckedCellsCounter() > 0) {

//		 grab user input
			System.out.println("Enter column value between 0 and 9");
			String column = scanner.nextLine(); // it should be a number like 0
			System.out.println("Enter a row value between 0 and 9");
			String row = scanner.nextLine(); // it should be a number like 0
			String[] inputCoordinates = { column, row };

			// create a cell object for the cell chosen by the user
			Cell cell = new Cell(inputCoordinates);

			if (cell.hasBomb(grid.getBombs())) {
				System.out.println("BOOOM, you failed!");
				scanner.close();
				break;
			} else {
				// compare cell fields with bombs locations
				int numberOfBombs = cell.getNumberOfBombs(grid.getBombs());
				System.out.println("This cell is surrounded with " + numberOfBombs + " bombs");
				grid.updateGrid(inputCoordinates, numberOfBombs);
				Tracker.decrementCounter();
				System.out.println(Tracker.getUncheckedCellsCounter() + " more cells to check");
			}
		}
	}
}