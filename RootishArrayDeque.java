package comp2402a2;

import java.util.AbstractList;
import java.util.List;


/**
 */
public class RootishArrayDeque<T> extends AbstractList<T> {
 private RootishArrayStack<T> front;
 private RootishArrayStack<T> back;
 private Class<T> t;



 public RootishArrayDeque(Class<T> rad) {
     front = new RootishArrayStack<>(rad);
     back = new RootishArrayStack<>(rad);
     t=rad;

 }

 public T get(int i) {
  if (i < front.size()){
      return front.get(front.size()-i -1);
        }else {
      return back.get(i - front.size());
        }
 }

 public T set(int i, T x) {
     if (i < front.size()){
         return front.set(front.size()-i-1,x);
        }else {
         return back.set(i-front.size(),x);
        }
    }

 public void add(int i, T x) {
  if (i < front.size()){
      front.add(front.size()-i,x);
        }else{
      back.add(i-front.size(),x);
        }
        check();

    }

 public T remove(int i) {
  T x ;
  if( i < front.size()){
      x=front.remove(front.size()-i-1);
      check();
      return x;
        }else {
      x = back.remove(i-front.size());
      check();
      return x;
        }

 }

 public void check(){
     int n = size();
     if (3*front.size()<back.size()){
         int s = (int)Math.ceil(n/2-front.size());
            RootishArrayStack<T> frontTwo = new RootishArrayStack<>(t);
            RootishArrayStack<T> backTwo = new RootishArrayStack<>(t);
            frontTwo.addAll(back.subList(0,s));
            frontTwo.addAll(front);
            backTwo.addAll(back.subList(s,back.size()));
            front=frontTwo;
            back=backTwo;
        }else if (3*back.size()<front.size()){
         int s = front.size()-n/2;
            RootishArrayStack<T> frontTwo = new RootishArrayStack<>(t);
            RootishArrayStack<T> backTwo = new RootishArrayStack<>(t);
            frontTwo.addAll(front.subList(s,front.size()));
            backTwo.addAll(front.subList(0,s));
            backTwo.addAll(back);
            front=frontTwo;
            back=backTwo;
        }
    }


 public int size() {return front.size()+back.size();}

 public static void main(String[] args) {
  //List<Integer> rad = new ArrayDeque<Integer>(Integer.class);
  List<Integer> rad = new RootishArrayDeque<Integer>(Integer.class);
  int K = 1000000;
  Stopwatch s = new Stopwatch();
  System.out.print("Appending " + K + " items...");
  System.out.flush();
  s.start();
  for (int i = 0; i < K; i++) {
   rad.add(i);
  }
  s.stop();
  System.out.println("done (" + s.elapsedSeconds() + "s)");

  System.out.print("Prepending " + K + " items...");
  System.out.flush();
  s.start();
  for (int i = 0; i < K; i++) {
   rad.add(0, i);
  }
  s.stop();
  System.out.println("done (" + s.elapsedSeconds() + "s)");

  System.out.print("Removing " + K + " items from the back...");
  System.out.flush();
  s.start();
  for (int i = 0; i < K; i++) {
   rad.remove(rad.size()-1);
  }
  s.stop();
  System.out.println("done (" + s.elapsedSeconds() + "s)");

  System.out.print("Removing " + K + " items from the front...");
  System.out.flush();
  s.start();
  for (int i = 0; i < K; i++) {
   rad.remove(0);
  }
  s.stop();
  System.out.println("done (" + s.elapsedSeconds() + "s)");
 }



}
