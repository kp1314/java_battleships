

/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {

  protected NumberCanvas passengers;

  // declarations required
  public static int Max = 9;
  private int count = 0;


  public Controller(NumberCanvas nc) {
    passengers = nc;
  }

  public synchronized void newPassenger() throws InterruptedException {
    // complete implementation
    // use "passengers.setValue(integer value)" to update display
    passengers.setValue(++count);
    //while (count > Max) wait();
  //  while (carSize >= count && carSize > 0) notifyAll();
    while (count >= Max) wait();
    notifyAll();
  }

  //returns the new number of passengers
  public synchronized int getPassengers(int mcar) throws InterruptedException {
     // complete implementation for part I
     // update for part II
     // use "passengers.setValue(integer value)" to update display

    while (!(mcar > 0 && count >= mcar)) wait();
    count -= (mcar);
    passengers.setValue(count);
    notifyAll();

    return mcar; // dummy value to allow compilation
  }

  public synchronized void goNow() {
    // complete implementation for part II
  }

}