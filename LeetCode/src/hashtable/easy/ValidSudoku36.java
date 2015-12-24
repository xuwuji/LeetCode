package hashtable.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ24ÈÕ
 */
public class ValidSudoku36 {
	public boolean isValidSudoku(char[][] board) {
		HashMap<Integer, HashSet<Integer>> row_map = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> column_map = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> block_map = new HashMap<Integer, HashSet<Integer>>();

		int board_row_size = board.length;
		int board_column_size = board[0].length;

		for (int row = 0; row < board_row_size; row++) {
			for (int column = 0; column < board_column_size; column++) {
				char c = board[row][column];
				if (c != '.') {
					Integer block = (row / 3) * 3 + (column / 3);
					Integer i = Integer.valueOf(c);
					HashSet<Integer> row_set = row_map.get(row);
					HashSet<Integer> column_set = column_map.get(column);
					HashSet<Integer> block_set = block_map.get(block);
					if (row_set != null) {
						if (!row_set.contains(i)) {
							row_set.add(i);
							row_map.put(row, row_set);
						} else {
							return false;
						}
					} else {
						row_set = new HashSet<Integer>();
						row_set.add(i);
						row_map.put(row, row_set);
					}

					if (column_set != null) {
						if (!column_set.contains(i)) {
							column_set.add(i);
							column_map.put(column, column_set);
						} else {
							return false;
						}
					} else {
						column_set = new HashSet<Integer>();
						column_set.add(i);
						column_map.put(column, column_set);
					}

					if (block_set != null) {
						if (!block_set.contains(i)) {
							block_set.add(i);
							block_map.put(block, block_set);
						} else {
							return false;
						}
					} else {
						block_set = new HashSet<Integer>();
						block_set.add(i);
						block_map.put(block, block_set);
					}
				}
			}
		}
		return true;
	}
}
