package barrier;

public class Barrier {

  private int released = 0;
  private int threadsCount = 0;
  private int totalThread;

  public Barrier(int totalThread) {
    this.totalThread = totalThread;
  }

  public synchronized void await() throws InterruptedException {
    // block any new threads from proceeding till,
    // all threads from previous barrier are released
    while(threadsCount == totalThread) wait();
    threadsCount++;

    if(threadsCount == totalThread) {
      notifyAll();
      released = totalThread;
    } else {
      while(threadsCount < totalThread) {
        wait();
      }
    }

    released--;
    if(released == 0) {
      threadsCount = 0;
      // remember to wakeup any threads
      // waiting on line#14
      notifyAll();
    }
  }
}
