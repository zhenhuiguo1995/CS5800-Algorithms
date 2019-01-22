import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Test;

public class HeapTest {
  private int[] inputArray;
  private Heap heap;

  @org.junit.Before
  public void setUp() throws Exception {
    this.inputArray = new int[] {3, 2, 1, 8, 5, 6, 9};
    heap = new Heap(inputArray);
  }

  @org.junit.Test
  public void insert() throws Exception {
    this.heap.insert(20);
    assertEquals(20, this.heap.getMax());
    this.heap.insert(11);
    assertEquals(20, this.heap.getMax());
    this.heap.insert(29);
    assertEquals(29, this.heap.getMax());
  }

  @org.junit.Test
  public void getMax() throws Exception {
    assertEquals(heap.getArrayList().get(0).intValue(), heap.getMax());
  }

  @org.junit.Test
  public void deleteMax() throws Exception {
    this.heap.deleteMax();
    assertEquals(8, this.heap.getMax());
    this.heap.deleteMax();
    assertEquals(6, this.heap.getMax());
  }

  @org.junit.Test
  public void swap() throws Exception {
    Random random = new Random();
    int firstIndex = random.nextInt(this.heap.getSize());
    int secondIndex = random.nextInt(this.heap.getSize());
    while (secondIndex == firstIndex) {
      secondIndex = random.nextInt(this.heap.getSize());
    }
    int first = this.heap.getArrayList().get(firstIndex);
    int second = this.heap.getArrayList().get(secondIndex);
    this.heap.swap(firstIndex, secondIndex);
    assertEquals(this.heap.getArrayList().get(firstIndex).intValue(), second);
    assertEquals(this.heap.getArrayList().get(secondIndex).intValue(), first);
  }

  @org.junit.Test
  public void sort() throws Exception {
    for (int i = 0; i < inputArray.length; i ++) {
      this.heap.deleteMax();
    }
    assertArrayEquals(this.heap.getArrayList().stream().mapToInt(i -> i).toArray(),
        new int[]{1, 2, 3, 5, 6, 8, 9});
  }


  @Test
  public void getSize() throws Exception {
    assertEquals(this.heap.getSize(), this.heap.getArrayList().size());
    assertEquals(this.heap.getSize(), this.inputArray.length);
  }

}