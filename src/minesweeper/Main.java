package minesweeper;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Let's play Minesweeper!");

		// generate a Grid
		Grid grid = new Grid();
		grid.printGrid();
		
		List<String> bombs = grid.getBombs();
		System.out.println(bombs);

		// createScanner for user input
		Scanner scanner = new Scanner(System.in);

		while (Tracker.getUncheckedCellsCounter() > 0) {

			System.out.println("Enter column value between 1 and 10");
			String column = scanner.nextLine();
			System.out.println("Enter a row value between 1 and 10");
			String row = scanner.nextLine(); 
			String[] inputCoordinates = { column, row }; 
			System.out.println(bombs);

			// create a cell object for the cell chosen by the user
			Cell cell = new Cell(inputCoordinates);
			cell.getCellsAround().stream().forEach(c -> System.out.println(c.toString()));

			if (cell.hasBomb(bombs)) {
				System.out.println("BOOOM, you failed!");
				scanner.close();
				break;
			} else {
				int numberOfBombs = cell.getNumberOfBombs(bombs);
				System.out.println("This cell is surrounded with " + numberOfBombs + " bombs");
				grid.updateGrid(inputCoordinates, numberOfBombs);
				Tracker.getUpdated(cell);
				System.out.println(Tracker.getUncheckedCellsCounter() + " more cells to check");
			}
		}
	}

	private static char[] typeOf(String c) {
		// TODO Auto-generated method stub
		return null;
	}
}