package foobar;

public class PrintFooBar {

  int flag;

  public PrintFooBar(int flag) {
    this.flag = flag;
  }

  public synchronized void PrintFoo() throws InterruptedException {
    // think about clearance
    while(flag == 1) {
      wait();
    }
    System.out.println("FOO");
    flag = 1;
    notifyAll();
  }

  public synchronized void PrintBar() throws InterruptedException {
    while(flag == 0) {
      wait();
    }
    System.out.println("BAR");
    flag = 0;
    notifyAll();
  }
}
