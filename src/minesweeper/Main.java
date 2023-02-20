package minesweeper;


import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Let's play Minesweeper!");

		Grid grid = new Grid();
		grid.printGrid();

		List<String> bombs = grid.getBombs();

		// createScanner for user input
		Scanner scanner = new Scanner(System.in);

		while (Tracker.getUncheckedCellsCounter() > 0) {

			System.out.println("Enter a column coordinate: ");
			String column = Tracker.validateInput(scanner);
			System.out.println("Enter a row coordinate: ");
			String row = Tracker.validateInput(scanner);
			String[] inputCoordinates = { column, row };

			// create a cell object for the cell chosen by the user
			Cell cell = new Cell(inputCoordinates);

			if (cell.hasBomb(bombs)) {
				System.out.println("BOOOM, you failed!");
				scanner.close();
				break;
			} else {
				int numberOfBombs = cell.getNumberOfBombs(bombs);
				System.out.println("This cell is surrounded with " + numberOfBombs + " bombs");
				grid.updateGrid(inputCoordinates, numberOfBombs);
				Tracker.getUpdated(cell);
			}
		}
		if (Tracker.getUncheckedCellsCounter() == 0) {
			System.out.println("You are a Winner!!!");
		}
		
	}

}