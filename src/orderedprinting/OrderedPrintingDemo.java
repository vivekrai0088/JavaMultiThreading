package orderedprinting;

public class OrderedPrintingDemo {
  public static void main(String[] args) throws InterruptedException {
    OrderedPrinting orderedPrinting = new OrderedPrinting(0);

    Thread t1 = new Thread(() -> {
      try {
        orderedPrinting.printFirst();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t2 = new Thread(() -> {
      try {
        orderedPrinting.printSecond();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t3 = new Thread(() -> {
      try {
        orderedPrinting.printThird();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();
  }
}
