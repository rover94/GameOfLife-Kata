package caribou.personal;

import java.util.List;

import static caribou.personal.TableStatuses.*;

public class Board {
	private final TableStatuses[][] grid;
	private final int x;
	private final int y;
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Board(final int x, final int y) {
		this.x = x;
		this.y = y;
		this.grid = new TableStatuses[this.x][this.y];
		this.initializeGrid();
	}
	
	private void initializeGrid() {
		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				this.grid[i][j] = DEAD;
			}
		}
	}
	
	public TableStatuses getElement(final int x, final int y) {
 		if (x < 0 || y < 0) {
			 return DEAD;
		}
 		if (x >= this.x || y >= this.y) {
			 return DEAD;
		}
		return this.grid[x][y];
	}
	
	public void setAlive(final int x, final int y) {
		this.grid[x][y] = ALIVE;
	}
}
