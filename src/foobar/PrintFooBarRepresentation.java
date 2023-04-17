package foobar;

public class PrintFooBarRepresentation {
  public static void main(String[] args) throws InterruptedException {
    PrintFooBar printFooBar = new PrintFooBar(0);

    Thread fooPrinterThread = new Thread(() -> {
      try {
        for(int i = 0; i < 5; i++)
          printFooBar.PrintFoo();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread barPrinterThread = new Thread(() -> {
      try {
        for(int i = 0; i < 5; i++)
          printFooBar.PrintBar();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });



    fooPrinterThread.start();
    barPrinterThread.start();
    fooPrinterThread.join();
    barPrinterThread.join();
  }
}
