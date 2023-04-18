package buildmolecule;

public class Main {
  public static void main(String[] args) {
    H2OMachine molecule = new H2OMachine();

    Thread t1 = new H2OMachineThread(molecule, "H");
    Thread t2 = new H2OMachineThread(molecule, "O");
    Thread t3 = new H2OMachineThread(molecule,"H");
    Thread t4 = new H2OMachineThread(molecule,"O");
    Thread t5 = new H2OMachineThread(molecule, "H");
    Thread t6 = new H2OMachineThread(molecule, "H");

    t3.start();
    t2.start();
    t1.start();
    t4.start();
    t5.start();
    t6.start();
  }
}
