ArrayList in Java:

1. Before using the **add** method of an ArrayList, it must be **initialized**, otherwise a null pointer exception will be raised

   ```java
   // when declaring the type of an ArrayList, you have to use a reference type
   ArrayList<Integer> arrayList = new ArrayList<>();
   ```

   You cannot just declare an object with type ArrayList and use the methods of ArrayList

   ```java
   //the following code will raise an exception
   ArrayList<Integer> arrayList;
   arrayList.add(3);
   -> Null Pointer exception
   ```

   

2. **Converting an ArrayList to an int array(primitive type)**

```java
// in jave8, the following code works.
arrayList.stream().mapToInt(i -> i).toArray();
```

3. **assertArrayEquals** will compare two array of the same type and returns true if every one of their elements are equal.

