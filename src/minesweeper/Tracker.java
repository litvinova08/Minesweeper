package minesweeper;

import java.util.List;

public class Tracker {
	
	List<Cell> checkedCells;
	static int uncheckedCellsCounter = 90;
	
	public static int getUncheckedCellsCounter() {
		return uncheckedCellsCounter;
	}
	public void setUncheckedCellsCounter(int uncheckedCellsCounter) {
		this.uncheckedCellsCounter = uncheckedCellsCounter;
	}
	
	public static void getUpdated(Cell cell) {
		decrementCounter();
	}
	
	public static void decrementCounter() {
		uncheckedCellsCounter--;
	}
	
	
	
//	public static boolean canContinue() {
//				
//	}

}
