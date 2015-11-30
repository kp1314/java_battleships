

/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {

  protected NumberCanvas passengers;

  // declarations required
  private int Max = 9;
  private int count = 0;
  private boolean carIsWaiting = false;
  private int carsize = 0;


  public Controller(NumberCanvas nc) {
    passengers = nc;
  }

  public synchronized void newPassenger() throws InterruptedException {
    // complete implementation
    // use "passengers.setValue(integer value)" to update display
    passengers.setValue(++count);
    while (count >= Max) wait();
    notifyAll();
  }

  //returns the new number of passengers
  public synchronized int getPassengers(int mcar) throws InterruptedException {
    // complete implementation for part I
    // update for part II
    // use "passengers.setValue(integer value)" to update display
    carsize = mcar;
    while (!(carsize >= 0 && count >= carsize)) wait();
    count -= carsize;
    passengers.setValue(count);
    notifyAll();


    return carsize; // dummy value to allow compilation
  }

  public synchronized void goNow() {
    // complete implementation for part II
    if (carIsWaiting && (count < carsize)) {
      carIsWaiting = false;
      carsize = count;
      notifyAll();
    }
  }

}