import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeSort1Test {

	Integer[] items;
	NewInteger[] stableItems;
    MergeSortsImproved m = new MergeSortsImproved();

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
	    MergeSortsImproved.mergeSort1(items);

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
	    MergeSortsImproved.mergeSort1(items);

	    for (int i = 0; i < items.length; i++) {
	      assertEquals(correctItems[i], items[i]);
	    }
	  }

      @Test
      void testEmptyArray() {
        items = new Integer[0];
        MergeSortsImproved.mergeSort1(items);
      }
      
	  @Test 
	  void testNull() {
	    items = null;
	    assertThrows(NullPointerException.class, () -> MergeSortsImproved.mergeSort1(items));
	  }

	  @Test
	  void testOneItem() {
	    items = new Integer[1];
	    Integer[] correctItems = new Integer[1];
	      
	    items[0] = 1;
	    correctItems[0] = 1;
	      
	    MergeSortsImproved.mergeSort1(items);
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
	      
	    MergeSortsImproved.mergeSort1(items);
	    for (int i = 0; i < items.length; i++) {
	      assertEquals(items[i], correctItems[i]);
	    }
	      
	  }

	  @Test
	  public void testOneStability() {
	    stableItems = new NewInteger[4];
	    stableItems[0] = new NewInteger("first", 4);
	    stableItems[1] = new NewInteger("", 2);
	    stableItems[2] = new NewInteger("", 1);
	    stableItems[3] = new NewInteger("second", 4);
	    MergeSortsImproved.mergeSort1(stableItems);

	    assertEquals("first", stableItems[2].getId());
	  }

	  @Test
	  public void testTwoStability() {
	    stableItems = new NewInteger[8];
	    stableItems[0] = new NewInteger("first", 7);
	    stableItems[1] = new NewInteger("", 3);
	    stableItems[2] = new NewInteger("", 1);
	    stableItems[3] = new NewInteger("first", 5);
	    stableItems[4] = new NewInteger("second", 7);
	    stableItems[5] = new NewInteger("", 9);
	    stableItems[6] = new NewInteger("", 11);
	    stableItems[7] = new NewInteger("second", 5); 
	    MergeSortsImproved.mergeSort1(stableItems);

	    assertEquals(5, stableItems[2].getInt()); 
	    assertEquals("first", stableItems[2].getId()); 
	    assertEquals(7, stableItems[4].getInt()); 
	    assertEquals("first", stableItems[4].getId()); 
	  }


	  class NewInteger implements Comparable<NewInteger> {
	    String id;
	    int integer; 
	    
	    public NewInteger(String id, int integer) {
	      this.id = id;
	      this.integer = integer; 
	    }
	    
	    public String getId() {
	      return id;
	    }
	    
	    public int getInt() {
	      return integer;
	    }
	    
	    public int compareTo(NewInteger o) {
	      if (this.integer < o.integer) {
	        return -1;
	      } else if (o.integer < this.integer) {
	        return 1;
	      } else {
	        if (this.id.equals("first")) {
	          return -1;
	        } else if (this.id.equals("second")) {
	          return 1;
	        } else {
	          return 0;
	        }
	      }
	    }
	  }
}
/*
* This work complies with the JMU Honor Code.
* References and Acknowledgments: Deven helped with my stability tests 
* by hinting at using a wrapper class. 
*/



