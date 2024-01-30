package caribou.personal;

import org.junit.jupiter.api.Test;

import static caribou.personal.TableStatuses.ALIVE;
import static caribou.personal.TableStatuses.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
	
	@Test
	void oneCellCanBeDead() {
		final Board board = new Board(1, 1);
		
		assertThat(board.getElement(0, 0)).isEqualTo(DEAD);
	}
	
	@Test
	void oneCellCanBeAlive() {
		final Board board = new Board(1, 1);
		board.setAlive(0, 0);
		
		assertThat(board.getElement(0, 0)).isEqualTo(ALIVE);
	}
	
	@Test
	void oneCellWithLessThanTwoLiveNeighbourDiesByUnderpopulation() {
		final Board board = new Board(2, 2);
		board.setAlive(0, 0);
		board.setAlive(1, 1);
		
		final Board nextBoard = new Game(board).getNextBoard();
		
		assertThat(nextBoard.getElement(0, 0)).isEqualTo(DEAD);
		assertThat(nextBoard.getElement(1, 0)).isEqualTo(DEAD);
		assertThat(nextBoard.getElement(0, 1)).isEqualTo(DEAD);
		assertThat(nextBoard.getElement(1, 1)).isEqualTo(DEAD);
	}
	
	@Test
	void oneCellWithMoreThanThreeLiveNeighbourDiesByOverpopulation() {
		final Board board = new Board(3, 2);
		board.setAlive(0, 0);
		board.setAlive(1, 0);
		board.setAlive(2, 0);
		board.setAlive(0, 1);
		board.setAlive(1, 1);
		board.setAlive(2, 1);
		
		final Board nextBoard = new Game(board).getNextBoard();
		
		assertThat(nextBoard.getElement(1, 1)).isEqualTo(DEAD);
	}
	
	@Test
	void oneLiveCellWithThreeNeighbourSurvives() {
		final Board board = new Board(3, 2);
		board.setAlive(1, 0);
		board.setAlive(0, 1);
		board.setAlive(1, 1);
		board.setAlive(2, 1);
		
		final Board nextBoard = new Game(board).getNextBoard();
		
		assertThat(nextBoard.getElement(1, 0)).isEqualTo(ALIVE);
	}
	
	@Test
	void oneLiveCellWithTwoNeighbourSurvives() {
		final Board board = new Board(3, 3);
		board.setAlive(0, 0);
		board.setAlive(1, 0);
		board.setAlive(0, 1);
		
		final Board nextBoard = new Game(board).getNextBoard();
		
		assertThat(nextBoard.getElement(0, 0)).isEqualTo(ALIVE);
		assertThat(nextBoard.getElement(1, 0)).isEqualTo(ALIVE);
		assertThat(nextBoard.getElement(0, 1)).isEqualTo(ALIVE);
	}
	
	@Test
	void oneDeadCellWithThreeNeighbourBecomeAlive() {
		final Board board = new Board(3, 3);
		board.setAlive(0, 0);
		board.setAlive(1, 0);
		board.setAlive(0, 1);
		
		final Board nextBoard = new Game(board).getNextBoard();
		
		assertThat(nextBoard.getElement(1, 1)).isEqualTo(ALIVE);
	}
}