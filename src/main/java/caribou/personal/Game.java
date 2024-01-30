package caribou.personal;

import static caribou.personal.TableStatuses.*;

public class Game {
	private final Board board;
	
	public Game(final Board board) {
		this.board = board;
	}
	
	public Board getNextBoard() {
		final Board result = new Board(this.board.getX(), this.board.getY());
		for (int x = 0; x < this.board.getX(); x++) {
			for (int y = 0; y < this.board.getY(); y++) {
				if (this.willBeAlive(x, y)) {
					result.setAlive(x, y);
				}
			}
		}
		
		return result;
	}
	
	private boolean willBeAlive(final int x, final int y) {
		final int neighbourCount = this.getNeighbourCount(x, y);
		return (neighbourCount == 3) ||
				(this.board.getElement(x, y) == ALIVE && neighbourCount == 2);
	}
	
	private int getNeighbourCount(final int x, final int y) {
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
