package readwritelock;

public class ReadWriteLock {

  private int readers = 0;
  private boolean isWriterLocked = false;

  public synchronized void aquireReadLock() throws InterruptedException {
    while(isWriterLocked) {
      wait();
    }
    readers++;
    System.out.println("Acquired Read Lock");
  }

  public synchronized void aquireWriteLock() throws InterruptedException {
    while (isWriterLocked || readers != 0) {
      wait();
    }
    isWriterLocked = true;
    System.out.println("Aquired Write lock");
  }

  public synchronized void releaseReadLock() {
    readers--;
    notify();
    System.out.println("Released read lock");
  }

  public synchronized void releaseWriteLock() {
    isWriterLocked = false;
    notify();
    System.out.println("Release write lock");
  }

}
