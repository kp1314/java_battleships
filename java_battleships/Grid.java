public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
      for (int i = 0; i < HEIGHT; i++) {
        for (int j = 0; j < WIDTH; j++) {
          grid[i][j] = Piece.WATER;
        }
      }
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {

      int row = c.getRow();
      int column = c.getColumn();
    
      if ((row >= HEIGHT || row < 0) ||
         (column < 0 || column >= WIDTH)) {
         return false;
      } 
      while (isDown) {
        for (int i = row; i < (row + size); i ++) {
          if (grid[i][column] != Piece.WATER) {
            return false;
          }
        } return true;
      } 
        for (int i = column; i < column + size; i++) {
          if (grid[row][column] != Piece.WATER) {
            return false;
          }
        } return true;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
    assert canPlace(c, size, isDown): "You can't place the ship in these ends mehartys"; 
      int row = c.getRow();
      int column = c.getColumn();
 
      if (isDown) { 
        for (int i = row; i < (row + size); i ++) {
          grid[i][column] = Piece.SHIP;
        }
      } else { 
        for (int i = column; i < column + size; i++) {
          grid[row][i] = Piece.SHIP;
        }
      }
    }

    public boolean wouldAttackSucceed(Coordinate c) {
      return grid[c.getRow()][c.getColumn()] == Piece.SHIP;
    }
   
    public void attackCell(Coordinate c) {
    
      int row = c.getRow();
      int column = c.getColumn();
      Piece point = grid[row][column];

      switch (point) {
        case SHIP  : grid[row][column] = Piece.DAMAGED_SHIP;break;
        case WATER : grid[row][column] = Piece.MISS;break;
        default: break;
      } 
    }

    public boolean areAllSunk() { 
    //pre: assume that the grid has ships on it.
    //post: tells you if all of the ships are sunk.
      for (int i = 0; i < HEIGHT; i++) {
        for (int j = 0; j < WIDTH; j++) {
          if (grid[i][j] == Piece.SHIP) {
            return false;
          }
        }
      } return true;
    }

    public String toPlayerString() {
      Piece[][] playerGrid = Util.deepClone(grid);
      Util.hideShips(playerGrid);
      return renderGrid(playerGrid);
    }

    public String toString() {
      return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
