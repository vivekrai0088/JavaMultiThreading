package readwritelock;

public class ReadWriteLockDemonstration {
  public static void main(String[] args) {
    ReadWriteLock readWriteLock = new ReadWriteLock();
    Thread readerThread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Trying to aquire read lock for thread 1");
        try {
          readWriteLock.aquireReadLock();
        } catch (InterruptedException e) {
          System.out.println("Unable to aquire read lock 1");
          e.printStackTrace();
        }
        System.out.println("Aquired read lock for thread 1");
      }
    });

    Thread readerThread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Read lock about to release: " + System.currentTimeMillis());
        readWriteLock.releaseReadLock();
        System.out.println("Released read lock for thread 2");

      }
    });
  }
}
