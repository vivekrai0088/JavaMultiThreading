package unisexbathroom;

import java.util.concurrent.Semaphore;

public class UnisexBathroom {

  private Gender isUseBy = Gender.NEITHER;
  private Semaphore maxSize = new Semaphore(3);
  private int size = 0;

  public void useBathroom() throws InterruptedException {
    System.out.println("Using bathroom by " + isUseBy.name() + " with size " + size);
    Thread.sleep(1000);
    System.out.println("Done using bathroom by " + isUseBy.name() + " with size " + size);
  }

  public void useMaleBathroom() throws InterruptedException {
    synchronized (this) {
      while (isUseBy.equals(Gender.FEMALE)) {
        wait();
      }
      maxSize.acquire();
      size++;
      isUseBy = Gender.MALE;

    }

    useBathroom();
    maxSize.release();

    synchronized (this) {
      size--;
      if(size == 0) {
        isUseBy = Gender.NEITHER;
      }
      notifyAll();
    }
  }

  public void useFemaleBathroom() throws InterruptedException {
    synchronized (this) {
      while (isUseBy.equals(Gender.MALE)) {
        wait();
      }
      maxSize.acquire();
      size++;
      isUseBy = Gender.FEMALE;
    }

    useBathroom();
    maxSize.release();

    synchronized (this) {
      size--;
      if(size == 0) {
        isUseBy = Gender.NEITHER;
      }
      notifyAll();
    }
  }
}
