package minesweeper;

import java.util.List;
import java.util.Scanner;

public class Tracker {

	List<Cell> checkedCells;
	static int uncheckedCellsCounter = 90;

	public static int getUncheckedCellsCounter() {
		return uncheckedCellsCounter;
	}

	public void setUncheckedCellsCounter(int uncheckedCellsCounter) {
		Tracker.uncheckedCellsCounter = uncheckedCellsCounter;
	}

	public static void getUpdated(Cell cell) {
		decrementCounter();
		System.out.println(Tracker.getUncheckedCellsCounter() + " more cells to check");
	}

	public static void decrementCounter() {
		uncheckedCellsCounter--;
	}

	public static String validateInput(Scanner scanner) {
		String input;
		do {
			System.out.println("Enter a value between 1 and 10");
			input = scanner.nextLine();
		} while (Integer.valueOf(input) <= 0 || Integer.valueOf(input) > 10);
		return input;
	}
}
