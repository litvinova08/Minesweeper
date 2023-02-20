//package minesweeper;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class CellTest {
//
//	static Cell cell;
//	static List<String> bombs;
//
//	@BeforeAll
//	static void create() {
//
//
//		String[] arr = { "73", "62", "85", "36", "44", "62", "41", "18", "25", "20" };
//		bombs = Arrays.asList(arr);
//		String column = "4";
//		String row = "4";
//		String[] inputCoordinates = { column, row };
//		cell = new Cell(inputCoordinates);
//	}
//
//	@Test
//	@DisplayName("Method is true if a cell has a bomb")
//	void hasABomb() {
//		assertTrue(cell.hasBomb(bombs));
//	}
//
//}
