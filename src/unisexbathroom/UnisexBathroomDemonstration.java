package unisexbathroom;

public class UnisexBathroomDemonstration {

  public static void main(String[] args) throws InterruptedException {
    UnisexBathroom unisexBathroom = new UnisexBathroom();

    Thread femaleThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          unisexBathroom.useFemaleBathroom();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread maleThread1 = new Thread(() -> {
      try {
        unisexBathroom.useMaleBathroom();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread maleThread2 = new Thread(() -> {
      try {
        unisexBathroom.useMaleBathroom();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread maleThread3 = new Thread(() -> {
      try {
        unisexBathroom.useMaleBathroom();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread maleThread4 = new Thread(() -> {
      try {
        unisexBathroom.useMaleBathroom();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    femaleThread.start();
    maleThread1.start();
    maleThread2.start();
    maleThread3.start();
    maleThread4.start();

    femaleThread.join();
    maleThread1.join();
    maleThread2.join();
    maleThread3.join();
    maleThread4.join();
  }
}
