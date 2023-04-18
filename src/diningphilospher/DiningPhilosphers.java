package diningphilospher;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosphers {
  private static Random random = new Random(System.currentTimeMillis());

  private Semaphore[] forks = new Semaphore[5]; //five forks
  // allow only four philosophers at any given point intime to even try to acquire forks.
  private Semaphore maxDiners = new Semaphore(4);

  public DiningPhilosphers() {
    forks[0] = new Semaphore(1);
    forks[1] = new Semaphore(1);
    forks[2] = new Semaphore(1);
    forks[3] = new Semaphore(1);
    forks[4] = new Semaphore(1);
  }

  public void lifecycleOfPhilospher(int id) throws InterruptedException {
    while(true) {
      contemplate(id);
      eat(id);
    }
  }

  private void contemplate(int id) throws InterruptedException {
    System.out.println("Philospher " + id + " is contemplating");
    Thread.sleep(random.nextInt(50));
    System.out.println("Philospher " + id + " contemplating done");
  }

  private void eat(int id) throws InterruptedException {
    maxDiners.acquire();

    forks[id].acquire();
    forks[(id + 1) % 5].acquire();

    System.out.println("Philospher " + id + " gets a chance to eat");

    forks[id].release();
    forks[(id + 1) % 5].release();

    maxDiners.release();
  }
}
