import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class InsertionSortPartialTest {

  @Test
  void testSortPartialArray() {
    Integer[] items = new Integer[10];  
    items[0] = 3;
    items[1] = 12;
    items[2] = 7;
    items[3] = 1; 
    items[4] = 23;
    items[5] = 29;
    items[6] = 9;
    items[7] = 11;
    items[8] = 4; 
    items[9] = 14; 
    BasicSorts.insertionSort(items, 3, 7);

    Integer[] correct = {3, 12, 7, 1, 9, 11, 23, 29, 4, 14};
    for (int i = 0; i < items.length; i++) {
      assertEquals(correct[i], items[i]); 
    }
  }
  
  @Test
  void testSortPartialArrayReverse() {
    Integer[] items = new Integer[10];  
    items[0] = 3;
    items[1] = 12;
    items[2] = 7;
    items[3] = 10;
    items[4] = 9;
    items[5] = 8;
    items[6] = 7;
    items[7] = 6;
    items[8] = 4; 
    items[9] = 14; 
    BasicSorts.insertionSort(items, 3, 7);

    Integer[] correct = {3, 12, 7, 6, 7, 8, 9, 10, 4, 14};
    for (int i = 0; i < items.length; i++) {
      assertEquals(correct[i], items[i]); 
    }
  }
}
/*
 * This work complies with the JMU Honor Code.
* References and Acknowledgments: I received no outside help with this
* programming assignment.
*/
