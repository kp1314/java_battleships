

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {

  /* declarations required */
  private boolean carIsWaitingAtPlatform = false;

  public PlatformAccess() {

  }

  public synchronized void arrive() throws InterruptedException {
    // complete implementation
    while (carIsWaitingAtPlatform) wait();
      carIsWaitingAtPlatform = true;
    notifyAll();
  }

  public synchronized void depart() throws InterruptedException {
    // complete implementation
    while (!carIsWaitingAtPlatform) wait();
    carIsWaitingAtPlatform = false;
    notifyAll();
  }

}