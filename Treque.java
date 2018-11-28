package comp2402a2;

import java.util.AbstractList;
import java.util.List;
import java.lang.*;

/**
 * 
 */

public class Treque<T> extends AbstractList<T> {
  
  
  public ArrayDeque<T> back;
  public ArrayDeque<T> front;
   
 public Treque(Class<T> t) {
 front = new ArrayDeque<T>(t);
 back = new ArrayDeque<T>(t);  
  }
  public int size() {
 return front.size() + back.size();
  }
  
  public T get(int i) {

 if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
 if(i < front.size()) return front.get(i);

 else return back.get(i-front.size());
  }
  
  
  public T set(int i, T x) {
 if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
 if (i<front.size()) return front.set(i,x);

 else return back.set(i-front.size(),x);
  }
  
  public void add(int i, T x) {
 if (i < front.size()) front.add(i,x);
 else back.add(i-front.size(),x);
   check();
  }
  
  public T remove(int i) {
    if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
 T x;

 if(i < front.size()) x = front.remove(i);

 else x = back.remove(i-front.size());

 check();
 return x;
  }

  private void check() {

 if (front.size() == back.size() + 2){
  back.add(0, front.remove(front.size()-1));

 } else if (back.size() == front.size() + 2) {
  front.add(front.size(), back.remove(0));
 } 
  }
  public void clear() {
    
    back.clear();
    front.clear();
  }
  

    public static void main(String[] args) {
     //List<Integer> tr = new ArrayDeque<Integer>(Integer.class);
    Treque<Integer> tr = new Treque<>(Integer.class);
    int K = 1000000;
    Stopwatch s = new Stopwatch();
    System.out.print("Appending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.add(i);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    System.out.print("Prepending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.add(0, i);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    System.out.print("Midpending(?!) " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.add(tr.size()/2, i);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    
    System.out.print("Removing " + K + " items from the back...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.remove(tr.size()-1);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    System.out.print("Removing " + K + " items from the front...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.remove(0);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    System.out.print("Removing " + K + " items from the middle...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      tr.remove(tr.size()/2);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
  }
  
}
