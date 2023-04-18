package buildmolecule;

public class H2OMachineThread extends Thread {
  H2OMachine molecule;
  String atom;

  public H2OMachineThread(H2OMachine molecule, String atom) {
    this.molecule = molecule;
    this.atom = atom;
  }

  public void run() {
    if("H".equals(atom)) {
      try {
        molecule.hydrogenAtom();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else if("O".equals(atom)) {
      try {
        molecule.oxygenAtom();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
