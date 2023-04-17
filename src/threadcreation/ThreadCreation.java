package threadcreation;

public class ThreadCreation {
  public static void main(String[] args) throws InterruptedException {
    Print printThread = new Print();
    printThread.start();
    printThread.join();

    PrintUsingRunable printUsingRunable = new PrintUsingRunable();
    Thread thread = new Thread(printUsingRunable);
    thread.start();
    thread.join();

    Thread t = new Thread(() -> {
      System.out.println("print ananoymous thread");
    });
    t.start();
    t.join();
  }
}

class Print extends Thread {
  public void run() {
    for(int i = 0; i < 100; i++)
      System.out.println("In thread");
  }
}

class PrintUsingRunable implements Runnable {

  @Override
  public void run() {
    for(int i = 0; i < 100; i++)
      System.out.println("In thread using runnable");
  }
}

