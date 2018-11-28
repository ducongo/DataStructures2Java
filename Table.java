package comp2402a2;

import java.util.ArrayList;
import java.util.List;

/**
 * Ricardo Cherestal
 */
public class Table<T> implements AbstractTable<T> {
 private int numberCols;
 private int numberRows;
 private List<List<T>> table;

 public Table(Class<T> t) {
        table= new ArrayList<List<T>>();
  numberCols=0;
  numberRows=0;

 }

 public int cols() {
  return numberCols;
 }

 public int rows() {
  return numberRows;
 }
 public T get(int i, int j) {
        if (i < 0 || i > rows() - 1 || j < 0 || j > cols() - 1)
            throw new IndexOutOfBoundsException();
        return table.get(i).get(j);
 }
 public T set(int i, int j, T x) {
  if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1)
   throw new IndexOutOfBoundsException();
  // Put your own code here instead of throwing this exception
  return table.get(i).set(j,x);
 }
 public void addRow(int i) {
  if (i < 0 || i > rows()) throw new IndexOutOfBoundsException();
  // Put your own code here instead of throwing this exception
        List<T> newrow = new ArrayList<T>();
        for (int k = 0 ; k<cols() ;k++){
            newrow.add(null);
        }
        table.add(i,newrow);
        numberRows++;
 }

 public void removeRow(int i) {
  if (i < 0 || i > rows() - 1) throw new IndexOutOfBoundsException();
  table.remove(i);
  numberRows--;
 }
 public void addCol(int j) {
  if (j < 0 || j > cols()) throw new IndexOutOfBoundsException();
  for (int l=0;l<rows();l++){
      table.get(l).add(j,null);
        }
        numberCols++;
 }

 public void removeCol(int j) {
  if (j < 0 || j > cols() - 1) throw new IndexOutOfBoundsException();
  for (int u=0; u<rows();u++){
      table.get(u).remove(j);
        }
        numberCols--;
    }

 public String toString() {
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < rows(); i++) {
   for (int j = 0; j < cols(); j++) {
    sb.append(String.valueOf(get(i, j)));
    sb.append(" ");
   }
   sb.append("\n");
  }
  return sb.toString();
 }


 public static void main(String[] args) {
  int nrows = 9, ncols = 6;
  Table<Integer> t = new Table<Integer>(Integer.class);
  for (int i = 0; i < ncols; i++) {
   t.addCol(t.cols());
  }
  for (int i = 0; i < nrows; i++) {
   t.addRow(t.rows());
  }
  for (int i = 1; i <= nrows; i++) {
   t.set(i-1, (i-1)%t.cols(), 1111*i);
  }
  System.out.println(t.toString());
  t.addCol(2);
        t.addRow(3);
  System.out.println(t.toString());
 }
}
