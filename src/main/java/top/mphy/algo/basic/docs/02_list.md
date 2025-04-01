## 列表

### 1. 定义

可以理解为动态数组，长度自动扩容，可以用数组和链表实现。关键实现要点：

- 定义 `size` 和 `capacity`，分别表示元素数量和列表容量
- `public MyList()` 用 `new Object[]{}` 实现，默认为空列表
- 扩容：列表底层的数组长度不够，需要扩容
- 缩容：删除了大部分元素时，列表底层的数组空出较多多余空间，可以触发缩容
- `toArray` 转数组方法用 `Arrays.copyOf(array, size, array.getClass())` 实现，且需要返回 `Object[]`， 因为存在类型擦除，即使返回泛型类型 `E[]`，调用也要用 `Object[]` 承接。

源码实现：[MyList](../core/list/MyList.java)

### 2. Java 原地排序 API

#### 2.1 `int[]` 非包装类型数组排序

##### 1、`Arrays.sort(arr)` 默认排序从小到大

```java
// array 默认排序从小到大
int[] arr = {3,1,2};
Arrays.sort(arr);
Assertions.assertArrayEquals(new int[] {1,2,3}, arr);
```

### 2.2 `Integer[]` 包装类型数组排序

##### 1、`Arrays.sort(Array)` 默认排序从小到大

```java
// Array 默认排序从小到大
Integer[] Array = {3, 1, 2};
Arrays.sort(Array);
Assertions.assertArrayEquals(new Integer[] {1,2,3}, Array);
```

##### 2、`Arrays.sort(Array, (x, y) -> y - x)` 自定义排序

```java
// Array 自定义排序：从大到小排序
Arrays.sort(Array, (x, y) -> y - x);
Assertions.assertArrayEquals(new Integer[] {3,2,1}, Array);
```

#### 3、`Arrays.sort(Array, Collections.reverseOrder())` 从大到小排序

```java
// Array 自定义排序：从大到小排序
Arrays.sort(Array, Collections.reverseOrder());
```

### 2.3 `List` 排序


#### 1、`Collections.sort(list)` 默认排序

```java
// List 默认排序
List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2));
Collections.sort(list);
int[] sortedArray = list.stream().mapToInt(Integer::intValue).toArray();
Assertions.assertArrayEquals(new int[]{1,2,3}, sortedArray);
```

#### 2、`Collections.sort(list, (x, y) -> y - x)` 自定义排序

```java
// List 自定义排序：从大到小排序
Collections.sort(list, (x, y) -> y - x);
int[] sortedArray2 = list.stream().mapToInt(Integer::intValue).toArray();
Assertions.assertArrayEquals(new int[]{3,2,1}, sortedArray2);
```

#### 3、`list.sort((x, y) -> y - x)` 自定义排序

```java
// List 自定义排序：从大到小排序
list.sort((x, y) -> y - x);
int[] sortedArray3 = list.stream().mapToInt(Integer::intValue).toArray();
Assertions.assertArrayEquals(new int[]{3,2,1}, sortedArray2);
```

### 3. Java 非原地排序 API

### 3.1 `Arrays.stream(list).sorted().toArray()`

```java
Integer[] list = {3, 1, 2};
Assertions.assertArrayEquals(
        new Integer[] {1,2,3},
        Arrays.stream(list).sorted().toArray()
);
```

### 3.2 `Stream.of(list).sorted().toArray()`

```java
Integer[] list = {3, 1, 2};
Assertions.assertArrayEquals(
        new Integer[] {1,2,3},
        Stream.of(list).sorted((x, y) -> y - x).toArray()
);
```