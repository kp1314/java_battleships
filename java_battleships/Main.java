import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Grid grid = makeInitialGrid();
        while (!grid.areAllSunk()) {
          System.out.println(grid.toPlayerString());
          System.out.println("Please enter the coordinate " +
              "of the area you would like to attack:");
          String move = input.next();
          while (move.charAt(0) > 'J' || move.charAt(0) < 'A' ||
                 move.charAt(1) > '9' || move.charAt(1) < '0') {
            System.out.println("Please enter a valid coordinate:");
            move = input.next();
          }
          Coordinate coordinate = Util.parseCoordinate(move); 
            if (grid.wouldAttackSucceed(coordinate)) {
              System.out.println("You scored a HIT at " + move + "!!");
            } else {
              System.out.println("Sorry " + move + " is a MISS");
          } 
          grid.attackCell(coordinate); 
        }  System.out.println("You WON AGHHHHHH");
    }
 
    private static Grid makeInitialGrid() {
        Grid grid = new Grid();

        String[] coords = { "A7", "B1", "B4", "D3", "F7", "H1", "H4" };
        int[] sizes = { 2, 4, 1, 3, 1, 2, 5 };
        boolean[] isDowns = { false, true, true, false, false, true, false };

        for (int i = 0; i < coords.length; i++) {
            Coordinate c = Util.parseCoordinate(coords[i]);
            grid.placeShip(c, sizes[i], isDowns[i]);
        }

        return grid;
    }
}
