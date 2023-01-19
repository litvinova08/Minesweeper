package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellTest {

	static Cell cell;
	static List<String> bombs;

	@BeforeAll
	static void create() {

		String[] arr = { "00", "06", "21", "31", "36", "49", "70", "74", "97", "99" };
		bombs = Arrays.asList(arr);
		String column = "0";
		String row = "0";
		String[] inputCoordinates = { column, row };
		cell = new Cell(inputCoordinates);
	}

	@Test
	@DisplayName("Method is true if a cell has a bomb")
	void hasABomb() {
		assertTrue(cell.hasBomb(bombs));
	}

}
