import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntroSortTest {

	Integer[] items;
    IntroSort i = new IntroSort();
	  @Test
	  void testTenValuesUnsorted() { 
	    items = new Integer[10];  
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

	    Integer[] correctItems = {1, 3, 4, 7, 9, 11, 12, 14, 23, 29};
	    IntroSort.introSort(items);

	    for (int i = 0; i < items.length; i++) {
	      assertEquals(correctItems[i], items[i]); 
	    }
	  }

	  @Test
	  void testRepeatedValues() {
	    items = new Integer[10];
	        
	    items[0] = 3;
	    items[1] = 1;
	    items[2] = 5;
	    items[3] = 9;
	    items[4] = 2;
	    items[5] = 2;
	    items[6] = 6;
	    items[7] = 4;
	    items[8] = 10;
	    items[9] = 8; 

	    Integer[] correctItems = {1, 2, 2, 3, 4, 5, 6, 8, 9, 10};
	    IntroSort.introSort(items);

	    for (int i = 0; i < items.length; i++) {
	      assertEquals(correctItems[i], items[i]);
	    }
	  }

	  @Test 
	  void testNull() {
	    items = null;
	    assertThrows(NullPointerException.class, () -> IntroSort.introSort(items));
	  }

	  @Test
	  void testOneItem() {
	    items = new Integer[1];
	    Integer[] correctItems = new Integer[1];
	      
	    items[0] = 1;
	    correctItems[0] = 1;
	      
	    IntroSort.introSort(items);
	    for (int i = 0; i < items.length; i++) {
	      assertEquals(items[i], correctItems[i]);
	    }
	      
	  }

	  @Test
	  void testTwoItems() {
	    items = new Integer[2];
	    Integer[] correctItems = new Integer[2];
	      
	    items[0] = 2;
	    items[1] = 1;
	      
	    correctItems[0] = 1;
	    correctItems[1] = 2;
	      
	    IntroSort.introSort(items);
	    for (int i = 0; i < items.length; i++) {
	      assertEquals(items[i], correctItems[i]);
	    }
	      
	  }
	  
      @Test
      void testEmptyArray() {
        items = new Integer[0];
        IntroSort.introSort(items);
      }

}
/*
 * This work complies with the JMU Honor Code.
* References and Acknowledgments: I received no outside help with this
* programming assignment.
*/

