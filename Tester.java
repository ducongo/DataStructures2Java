package comp2402a2;
import java.util.List;


/**
 */
public class Tester {
	public static boolean testPart1(List<Integer> ell) {
		List<Integer> tr = ell;
    int K = 1000;
    Stopwatch s = new Stopwatch();
		System.out.print("Appending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.add(i);
			ell.add(i);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");

    System.out.print("Appending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.add(i);
			ell.add(i);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");

    System.out.print("Prepending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.add(0, i);
			ell.add(0, i);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");

    System.out.print("Midpending(?!) " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.add(tr.size() / 2, i);
			ell.add(ell.size() / 2, i);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");


    System.out.print("Removing " + K + " items from the back...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.remove(tr.size() - 1);
			ell.remove(ell.size() - 1);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");

    System.out.print("Removing " + K + " items from the front...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.remove(0);
			ell.remove(0);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");

    System.out.print("Removing " + K + " items from the middle...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.remove(tr.size() / 2);
			ell.remove(ell.size() / 2);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");

		for (int i = 0; i < ell.size(); i++){
			if (ell.get(i) != tr.get(i)){
				return false;
			}
		}
		return true;
	}

	public static boolean testPart2(List<Integer> ell) {
		return true;
	}

	public static boolean testPart3(AbstractTable<Integer> ell) {
		return true;
	}

}
