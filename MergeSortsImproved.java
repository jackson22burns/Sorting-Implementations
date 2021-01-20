
/**
 * Improved MergeSort class.
 */

public class MergeSortsImproved { 
  private static int MERGE_SORT_THRESHOLD = 10;

  /**
   * Merge sort the provided array using an improved merge operation.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort1(T[] items)  {
    if (items.length > 0) {
      int size = (int) Math.ceil((double)items.length / 2);
      T[] temp = (T[]) new Comparable[size]; 
      mergeSort1(items, temp, 0, items.length - 1); 
    }

  }
  
  /**
   * Recursive helper method for the improved merge sort.
   * @param items The array to sort
   * @param temp Temporary array for merge operation
   * @param left Index of the left end of the region to sort
   * @param right Index of the right end of the region to sort.
   */
  private static <T extends Comparable<T>> void mergeSort1(T[] items, T[] temp, int left, 
      int right) {
    if (left == right) {
      return; // Region has one record 
    }

    int mid = (left + right) / 2; // Select midpoint 

    mergeSort1(items, temp, left, mid); // Mergesort first half
    mergeSort1(items, temp, mid + 1, right); // Mergesort second half 

    improvedMerge(items, temp, left, mid, right);
  }
  
  /**
   * Merge two sorted sub-arrays.
   */
  private static <T extends Comparable<T>> void improvedMerge(T[] items, T[] temp, int left, 
          int mid, int right) {
    int j = 0;
    for (int i = left; i <= mid; i++) {
      temp[j] = items[i];// Copy subarray to temp
      j++;
    }

    int i1 = 0;
    int i2 = mid + 1;


    for (int curr = left; curr <= right; curr++) {
      if (left == mid + 1) { // Left subarray exhausted 
        items[curr] = items[i2++];
      } else if (i2 == right + 1) { // Right subarray exhausted
        items[curr] = temp[i1++];
        left++;
      } else if (temp[i1].compareTo(items[i2]) <= 0) {
        items[curr] = temp[i1++];
        left++;
      } else {
        items[curr] = items[i2++];
      }
    }
  }
  //////////////////////////////////////////////////////////////////////////////////////

  /**
   * Merge sort the provided array by using an improved merge operation and
   * switching to insertion sort for small sub-arrays.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort2(T[] items) {
    T[] temp = (T[]) new Comparable[items.length];
    mergeSort2(items, temp, 0, items.length - 1); 
  }
  
  /**
   * Recursive helper method for the improved merge sort, 
   * switching to insertion for small sub_arrays.
   * @param items The array to sort
   * @param temp Temporary array for merge operation
   * @param left Index of the left end of the region to sort
   * @param right Index of the right end of the region to sort.
   */
  public static <T extends Comparable<T>> void mergeSort2(T[] items, T[] temp, int left, 
      int right) {
    if (right - left <= MERGE_SORT_THRESHOLD) {
      BasicSorts.insertionSort(items, left, right);
    } else {
      int mid = (left + right) / 2; // Select midpoint
        
      mergeSort2(items, temp, left, mid); // Mergesort first half
      mergeSort2(items, temp, mid + 1, right); // Mergesort second half 

      improvedMerge(items, temp, left, mid, right); 
    }
  
  }
  
  /////////////////////////////////////////////////////////////////////
  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the
   * fallback method used by introspective sort.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort2(T[] items, int start, int end) {
    int size = (int) Math.ceil((double)items.length / 2);
    T[] temp = (T[]) new Comparable[size]; 
    mergeSort1(items, temp, start, end);
  }
  
 
}
/*
 * This work complies with the JMU Honor Code.
* References and Acknowledgments: I received no outside help with this
* programming assignment.
*/
