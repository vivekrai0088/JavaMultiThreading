package blockingqueue;

public class BlockingQueue<T> {

   T[] arr;
   int size;
   int capacity;
   int head;
   int tail;

   public BlockingQueue(int capacity) {
     this.capacity = capacity;
     arr = (T[]) new Object[capacity];
     size = 0;
     head = 0;
     tail = 0;
   }

   public synchronized void enqueue(T item) throws InterruptedException {
     while(size == capacity) {
       wait();
     }

     if(tail == capacity) {
       tail = 0;
     }
     arr[tail] = item;
     tail++;
     size++;
     notifyAll();
   }

   public synchronized T dequeue() throws InterruptedException {
     while(size == 0) {
       wait();
     }

     if(head == capacity) {
       head = 0;
     }

     T item = arr[head];
     head++;
     size--;
     notifyAll();
     return item;
   }
}
