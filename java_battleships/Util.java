import java.util.Arrays;

public class Util {

    private static int letterToIndex(char letter) {
    assert (letter >= 'A' && letter <= 'Z'): "Letter must " +
        "be in the range A - Z inclusive";
      return (letter - 'A');
    }

    private static int numberToIndex(char number) {
    assert (number >= '0' && number <= '9'): "Number must " +
        "be in the range 0 - 9 inclusive";
      return (number - '0');
    }

    public static Coordinate parseCoordinate(String s) {
    assert (s.length() == 2): "String length must be 2";
    assert (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'):
           "First character must be a capital letter";
    assert (s.charAt(1) >= '0' && s.charAt(1) <= '9'): 
           "Second character must be a decimal digit";
      int row = letterToIndex(s.charAt(0));
      int column = numberToIndex(s.charAt(1));
    
      Coordinate position = new Coordinate(row, column);
      return position;
    }

    public static Piece hideShip(Piece piece) {
      if (piece == Piece.SHIP) {
        return Piece.WATER;
      } 
      return piece;
    }

    public static void hideShips(Piece[][] grid) {
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          grid[i][j] = hideShip(grid[i][j]);
        }
      }  
    }

    public static Piece[][] deepClone(Piece[][] input) {
        Piece[][] output = new Piece[input.length][];
        for (int i = 0; i < input.length; i++) {
            output[i] = Arrays.copyOf(input[i], input[i].length);
        }
        return output;
    }
}
