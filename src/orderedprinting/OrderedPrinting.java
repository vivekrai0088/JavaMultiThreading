package orderedprinting;

public class OrderedPrinting {

  int flag;

  public OrderedPrinting(int flag) {
    this.flag = flag;
  }

  public synchronized void printFirst() throws InterruptedException {
    while(flag == 1 || flag == 2) {
      wait();
    }
    System.out.println("First");
    flag = 1;
    notifyAll();
  }

  public synchronized void printSecond() throws InterruptedException {
    while(flag == 0 || flag == 2) {
      wait();
    }
    System.out.println("Second");
    flag = 2;
    notifyAll();
  }

  public synchronized void printThird() throws InterruptedException {
    while(flag == 0 || flag == 1) {
      wait();
    }
    System.out.println("Third");
    notifyAll();
  }
}
