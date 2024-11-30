# LinkedQueue

The `LinkedQueue` class implements a queue data structure using a singly linked list. The queue follows the First-In-First-Out (FIFO) principle, meaning the first element added is the first to be removed. This class provides various methods to manipulate and inspect the queue.

## Fields

- **frontNode**: The front node of the queue (the one that will be dequeued next).
- **rearNode**: The last node of the queue (the one that was most recently enqueued).
- **length**: The total number of nodes in the queue.

## Methods

### Public Methods

- **size()**: Returns the number of elements in the queue.

- **setSize(int size)**: Sets the length of the queue. If the size is less than the current length, the queue is truncated. If `size` is 0, the queue is cleared.

- **enqueue(int data)**: Adds a new element with the specified `data` to the rear of the queue.

- **dequeue()**: Removes and returns the element at the front of the queue. Returns `-1` if the queue is empty.

- **peek()**: Returns the data of the front element without removing it. Returns `-1` if the queue is empty.

- **copy()**: Returns a shallow copy of the queue. The new queue will have the same elements but will be independent of the original queue.

- **isEmpty()**: Returns `true` if the queue is empty, otherwise `false`.

- **clear()**: Clears the queue by setting both `frontNode` and `rearNode` to `null` and the length to 0.

- **toArray()**: Converts the queue to an array of integers.

- **toString()**: Returns a string representation of the queue in the format `<value1, value2, value3, ...>`. Returns `<>` if the queue is empty.

## Example Usage

```java
LinkedQueue queue = new LinkedQueue();
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

System.out.println(queue.size());       // Output: 3
System.out.println(queue.peek());       // Output: 10
System.out.println(queue.dequeue());    // Output: 10
System.out.println(queue.toString());   // Output: <20, 30>
queue.clear();
System.out.println(queue.isEmpty());    // Output: true
```

## Notes

- **Queue Operations**: The `enqueue` method adds a new element to the rear of the queue, and `dequeue` removes an element from the front. This follows the FIFO order.
  
- **Shallow Copy**: The `copy()` method creates a shallow copy of the queue. The order of elements in the copied queue will be the same as the original.

- **Queue Representation**: The `toString()` method provides a convenient way to display the queue in a human-readable format.
