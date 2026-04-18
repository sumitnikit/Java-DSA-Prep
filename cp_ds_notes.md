# 🚀 CP Data Structures — C++ vs Java

## 1. Array
```java
// C++: int arr[n]
int[] arr = new int[n];
long[] arr = new long[n];

// 2D
int[][] arr = new int[n][m];

// Fill
Arrays.fill(arr, 0);
Arrays.fill(arr, Integer.MAX_VALUE);
```

## 2. ArrayList (Vector)
```java
// C++: vector<int>
ArrayList<Integer> list = new ArrayList<>();

list.add(5);           // push_back
list.get(i);           // arr[i]
list.set(i, val);      // arr[i] = val
list.remove(i);        // erase by index
list.size();           // size()
list.isEmpty();        // empty()
Collections.sort(list);// sort
list.clear();          // clear()
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
// C++: priority_queue<int>

// Min heap (default in Java)
PriorityQueue<Integer> minPQ = new PriorityQueue<>();

// Max heap
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

minPQ.offer(5);        // push
minPQ.poll();          // pop (removes min)
minPQ.peek();          // top (doesn't remove)
minPQ.isEmpty();       // empty
minPQ.size();          // size

// Custom comparator
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
```

## 7. HashMap
```java
// C++: unordered_map<int,int>
HashMap<Integer, Integer> map = new HashMap<>();

map.put(key, val);          // insert/update
map.get(key);               // access (null if missing)
map.getOrDefault(key, 0);   // access with default ✅
map.containsKey(key);       // count/find
map.remove(key);            // erase
map.size();                 // size
map.isEmpty();              // empty

// iterate
for(Map.Entry<Integer,Integer> e : map.entrySet()){
    int k = e.getKey();
    int v = e.getValue();
}

// increment count
map.merge(key, 1, Integer::sum);  // ✅ most used in CP!
```

## 8. TreeMap
```java
// C++: map<int,int> (sorted!)
TreeMap<Integer, Integer> map = new TreeMap<>();

map.put(key, val);          // insert
map.get(key);               // access
map.firstKey();             // begin->first
map.lastKey();              // rbegin->first
map.floorKey(x);            // largest key <= x
map.ceilingKey(x);          // smallest key >= x
map.lowerKey(x);            // largest key < x
map.higherKey(x);           // smallest key > x  ✅ very useful!
map.remove(key);            // erase
```

## 9. HashSet
```java
// C++: unordered_set<int>
HashSet<Integer> set = new HashSet<>();

set.add(5);                 // insert
set.contains(5);            // count/find ✅
set.remove(5);              // erase
set.size();                 // size
set.isEmpty();              // empty
```

## 10. TreeSet
```java
// C++: set<int> (sorted, unique!)
TreeSet<Integer> set = new TreeSet<>();

set.add(5);                 // insert
set.contains(5);            // find
set.remove(5);              // erase
set.first();                // *begin()
set.last();                 // *rbegin()
set.floor(x);               // largest <= x
set.ceiling(x);             // smallest >= x
set.lower(x);               // largest < x
set.higher(x);              // smallest > x ✅
set.size();                 // size
```

## 11. Pair
```java
// C++: pair<int,int>
// Java: use int[] or Map.Entry

// Option 1 — int array (fastest in CP)
int[] pair = new int[]{a, b};
pair[0];  // first
pair[1];  // second

// Option 2 — AbstractMap.SimpleEntry
Map.Entry<Integer,Integer> p =
    new AbstractMap.SimpleEntry<>(a, b);
p.getKey();    // first
p.getValue();  // second
```

## 12. Sorting
```java
// Array
Arrays.sort(arr);                              // ascending
// descending (only Integer[] not int[])
Arrays.sort(arr, Collections.reverseOrder());

// 2D array by first element
Arrays.sort(arr, (a,b) -> a[0] - b[0]);

// ArrayList
Collections.sort(list);
Collections.sort(list, (a,b) -> b-a);         // descending

// Custom object
Arrays.sort(arr, (a,b) -> {
    if(a[0] != b[0]) return a[0] - b[0];      // sort by first
    return a[1] - b[1];                        // then by second
});
```
```java
Collections.sort(list);           // sort
Collections.reverse(list);        // reverse
Collections.max(list);            // max element
Collections.min(list);            // min element
Collections.frequency(list, x);   // count occurrences
Collections.fill(list, val);      // fill with value
Collections.swap(list, i, j);     // swap elements
// ```
```javaC++Javavector<int>ArrayList<Integer>stack<int>Deque<Integer> (ArrayDeque)queue<int>Deque<Integer> (ArrayDeque)deque<int>Deque<Integer> (ArrayDeque)priority_queuePriorityQueue<Integer>map<int,int>TreeMap<Integer,Integer>unordered_mapHashMap<Integer,Integer>set<int>TreeSet<Integer>unordered_setHashSet<Integer>pair<int,int>int[] or long[]multiset<int>TreeMap<Integer,Integer>
```
1. int[]          → arrays, pairs
2. ArrayList      → dynamic arrays
3. HashMap        → frequency counting
4. TreeMap        → ordered map, floor/ceiling
5. PriorityQueue  → Dijkstra, greedy
6. TreeSet        → ordered unique set
7. ArrayDeque     → stack, queue, deque
8. HashSet        → quick lookup
