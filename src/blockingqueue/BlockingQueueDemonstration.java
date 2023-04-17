package blockingqueue;

public class BlockingQueueDemonstration {
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(5);

    Thread producer1 = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          blockingQueue.enqueue(new Integer(i));
          System.out.println("Producer enqueued " + i);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread consumer1 = new Thread(() -> {
      try {
        for (int i = 0; i < 5; i++) {
          System.out.println("Consumer 1 dequeued: " + blockingQueue.dequeue());
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread consumer2 = new Thread(() -> {
      try {
        for (int i = 0; i < 5; i++) {
          System.out.println("Consumer 2 dequeued: " + blockingQueue.dequeue());
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    producer1.start();
    Thread.sleep(2000);
    consumer1.start();
    consumer2.start();

    producer1.join();

    consumer1.join();
    consumer2.join();

  }
}
