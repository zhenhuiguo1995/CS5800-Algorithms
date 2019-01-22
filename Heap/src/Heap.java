import java.util.ArrayList;
import java.util.List;

public class Heap {
  private ArrayList<Integer> arrayList = new ArrayList<>();
  private int size;

  /**
   * Creates a heap stored at array
   * @param array
   */
  public Heap(int[] array){
    this.size = 0;
    for (int i = 0; i < array.length; i ++) {
      insert(array[i]);
    }
  }


  /**
   * Insert an integer to the end of the heap.
   * Time complexity: O(log n)
   * @param x the number to be inserted.
   */
  public void insert(int x){
    this.arrayList.add(x);
    int index = this.size;
    this.size += 1;
    while (index > 0 && (index - 1)/2 >= 0 &&
        arrayList.get((index - 1)/2) < arrayList.get(index)) {
        swap((index - 1)/2, index);
        index = (index - 1)/2;
    }
  }


  /**
   * Get the max element from the heap.
   * Time complexity: O(1).
   * @return
   */
  public int getMax() {
    return this.arrayList.get(0);
  }

  /**
   * Delete the max element from the heap and maintain the balance.
   * Time complexity: O(log n)
   */
  public void deleteMax() {
    swap(0, this.size - 1);
    this.size -= 1;
    heapify(0);
  }

  /**
   * Swap two elements in the array.
   * @param firstIndex the index of the first element
   * @param secondIndex the index of the last element
   */
  public void swap(int firstIndex, int secondIndex){
    int first = this.arrayList.get(firstIndex);
    int second = this.arrayList.get(secondIndex);
    this.arrayList.set(firstIndex, second);
    this.arrayList.set(secondIndex, first);
  }

  /**
   * Maintain the heap property of the heap rooted at i.
   * @param i the index of the root.
   */
  public void heapify(int i) {
    int max = i;
    int leftChild = i * 2 + 1;
    int rightChild = i * 2 + 2;
    if (leftChild < this.size && this.arrayList.get(leftChild) > this.arrayList.get(max)) {
      max = leftChild;
    }
    if (rightChild < this.size && this.arrayList.get(rightChild) > this.arrayList.get(max)) {
      max = rightChild;
    }
    if (max == i) {
      return;
    } else {
      swap(max, i);
      heapify(max);
    }

  }

  /**
   * Sorts an array in increasing order.
   * @param array the array to be sorted.
   * Time complexity: O(nlogn)
   * Space complexity: O(1)
   */
  public void sort(int[] array) {

  }


  /**
   * @return the arrayList object
   */
  public ArrayList<Integer> getArrayList() {
    return arrayList;
  }

  /**
   * Returns the size of the heap
   * @return
   */
  public int getSize() {
    return size;
  }
}

