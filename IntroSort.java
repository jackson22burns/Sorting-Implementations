
/**
 * Introsort class.
 */
public class IntroSort {
  /**
   * Sort the provided items using the introsort algorithm.
   */
  public static <T extends Comparable<T>> void introSort(T[] items) {
    if (items.length > 0) {
      double maxDepth = 2 * Math.floor((double) Math.log(items.length));
      introSort(items, maxDepth, 0, items.length - 1);
    } 
  }

  private static <T extends Comparable<T>> void introSort(T[] items, double maxDepth, 
                                                          int left, int right) {
    if (right - left < 1) {
      return;
    } else if (maxDepth == 0) {
      MergeSortsImproved.mergeSort2(items, left, right);
    } else {  
      int pivotindex = (left + right) / 2;
      int p = QuickSort.partition(items, left, right, pivotindex);
      if ((p - left) > 1) {
        introSort(items, maxDepth--, left, p - 1);
      }
      if ((right - p) > 1) {
        introSort(items, maxDepth--, p + 1, right);
      }
    }
  }
 
}
/*
 * This work complies with the JMU Honor Code.
* References and Acknowledgments: I received no outside help with this
* programming assignment.
*/
