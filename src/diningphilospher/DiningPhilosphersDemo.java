package diningphilospher;

public class DiningPhilosphersDemo {

  public static void main(String[] args) throws InterruptedException {
    DiningPhilosphers diningPhilosphers = new DiningPhilosphers();

    Thread p0 = new Thread(new Runnable() {
      @Override
      public void run() {
        startLifeCycleOfPhilospher(diningPhilosphers, 0);
      }
    });

    Thread p1 = new Thread(new Runnable() {
      @Override
      public void run() {
        startLifeCycleOfPhilospher(diningPhilosphers, 1);
      }
    });

    Thread p2 = new Thread(new Runnable() {
      @Override
      public void run() {
        startLifeCycleOfPhilospher(diningPhilosphers, 2);
      }
    });

    Thread p3 = new Thread(new Runnable() {
      @Override
      public void run() {
        startLifeCycleOfPhilospher(diningPhilosphers, 3);
      }
    });

    Thread p4 = new Thread(new Runnable() {
      @Override
      public void run() {
        startLifeCycleOfPhilospher(diningPhilosphers, 4);
      }
    });

    p0.start();
    p1.start();
    p2.start();
    p3.start();
    p4.start();

    p0.join();
    p1.join();
    p2.join();
    p3.join();
    p4.join();
  }

  public static void startLifeCycleOfPhilospher(DiningPhilosphers diningPhilosphers, int id) {
    try {
      diningPhilosphers.lifecycleOfPhilospher(id);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
