package caribou.personal;

import static caribou.personal.TableStatuses.*;

public class Game {
	private final Board board;
	
	public Game(final Board board) {
		this.board = board;
	}
	
	public Board getNextBoard() {
		Board result = new Board(this.board.getX(), this.board.getY());
		for (int x = 0; x < this.board.getX(); x++) {
			for (int y = 0; y < this.board.getY(); y++) {
				final TableStatuses element = this.board.getElement(x, y);
				final Integer neighbourCount = this.getNeighbourCount(x, y);
				if (element == ALIVE && neighbourCount == 3) {
					result.setAlive(x, y);
				}
				if (element == ALIVE && neighbourCount == 2) {
					result.setAlive(x, y);
				}
				if (element == DEAD && neighbourCount == 3) {
					result.setAlive(x, y);
				}
//				if (element == ALIVE )
			}
		}
		
		return result;
	}
	
	private Integer getNeighbourCount(int x, int y) {
		return (this.board.getElement(x - 1, y - 1) == ALIVE ? 1 : 0) +
				(this.board.getElement(x - 1, y) == ALIVE ? 1 : 0) +
				(this.board.getElement(x - 1, y + 1) == ALIVE ? 1 : 0) +
				(this.board.getElement(x, y - 1) == ALIVE ? 1 : 0) +
				(this.board.getElement(x, y + 1) == ALIVE ? 1 : 0) +
				(this.board.getElement(x + 1, y - 1) == ALIVE ? 1 : 0) +
				(this.board.getElement(x + 1, y) == ALIVE ? 1 : 0) +
				(this.board.getElement(x + 1, y + 1) == ALIVE ? 1 : 0);
	}
}
