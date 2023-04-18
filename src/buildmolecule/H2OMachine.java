package buildmolecule;

import java.util.Arrays;
import java.util.Collections;

public class H2OMachine {

  Object sync;
  String[] molecule;
  int count;

  public H2OMachine() {
    sync = new Object();
    molecule = new String[3];
    count = 0;
  }

  public void hydrogenAtom() throws InterruptedException {
    synchronized (sync) {
      while(Collections.frequency(Arrays.asList(molecule), "H") == 2) {
        sync.wait();
      }

      molecule[count] = "H";
      count++;

      // if molecule is complete, then exit
      if(count == 3) {
        for(String element: molecule) {
          System.out.print(element);
        }
        System.out.println();
        Arrays.fill(molecule, null);
        count = 0;
      }
      sync.notifyAll();
    }
  }

  public void oxygenAtom() throws InterruptedException {
    synchronized (sync) {
      while(Collections.frequency(Arrays.asList(molecule), "O") == 1) {
        sync.wait();
      }

      molecule[count] = "O";
      count++;

      if(count == 3) {
        for(String element: molecule) {
          System.out.print(element);
        }
        System.out.println();
        Arrays.fill(molecule, null);
        count = 0;
      }
      sync.notifyAll();
    }
  }
}
