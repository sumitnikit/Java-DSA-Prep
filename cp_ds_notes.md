# 🚀 CP Data Structures — C++ vs Java

## 1. Array
```java
int[] arr = new int[n];
long[] arr = new long[n];
int[][] arr = new int[n][m];

Arrays.fill(arr, 0);
Arrays.fill(arr, Integer.MAX_VALUE);
```

## 2. ArrayList (Vector)
```java
ArrayList<Integer> list = new ArrayList<>();

list.add(5);            // push_back
list.get(i);            // arr[i]
list.set(i, val);       // arr[i] = val
list.remove(i);         // erase by index
list.size();            // size()
list.isEmpty();         // empty()
Collections.sort(list); // sort
list.clear();           // clear()
```

## 3. Stack
```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(5);     // push
stack.pop();       // pop
stack.peek();      // top
stack.isEmpty();   // empty
stack.size();      // size
```

## 4. Queue
```java
Deque<Integer> queue = new ArrayDeque<>();

queue.offer(5);    // push
queue.poll();      // pop (removes)
queue.peek();      // front (doesn't remove)
queue.isEmpty();   // empty
queue.size();      // size
```

## 5. Deque
```java
Deque<Integer> dq = new ArrayDeque<>();

dq.addFirst(5);    // push_front
dq.addLast(5);     // push_back
dq.removeFirst();  // pop_front
dq.removeLast();   // pop_back
dq.peekFirst();    // front
dq.peekLast();     // back
```

## 6. Priority Queue
```java
PriorityQueue<Integer> minPQ = new PriorityQueue<>();
PriorityQueue<Integer> maxPQ =
    new PriorityQueue<>(Collections.reverseOrder());

minPQ.offer(5);    // push
minPQ.poll();      // pop
minPQ.peek();      // top
```

## 7. HashMap
```java
HashMap<Integer,Integer> map = new HashMap<>();

map.put(k,v);
map.get(k);
map.getOrDefault(k,0);
map.containsKey(k);
map.remove(k);

map.merge(k,1,Integer::sum);
```

## 8. TreeMap
```java
TreeMap<Integer,Integer> map = new TreeMap<>();

map.floorKey(x);
map.ceilingKey(x);
map.lowerKey(x);
map.higherKey(x);
```

## 9. HashSet
```java
HashSet<Integer> set = new HashSet<>();
```

## 10. TreeSet
```java
TreeSet<Integer> set = new TreeSet<>();
```

## 11. Pair
```java
int[] p = {a,b};
```

## 12. Sorting
```java
Arrays.sort(arr);
Collections.sort(list);
```
