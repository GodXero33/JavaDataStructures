# ArrayQueue

The `ArrayQueue` class is a custom implementation of a queue using a dynamic array. The queue automatically grows or shrinks as elements are added or removed, based on a specified growth factor.

## Constructors

- **ArrayQueue(int initialSize, double fact)**: Initializes an `ArrayQueue` with a specified initial size and growth factor.
- **ArrayQueue(int initialSize)**: Initializes an `ArrayQueue` with a specified initial size and a default growth factor of `0.5`.
- **ArrayQueue()**: Initializes an `ArrayQueue` with a default size of `10` and a default growth factor of `0.5`.

## Methods

### Private Methods

- **grow()**: Expands the underlying array by `(1 + fact)` when the queue reaches its current capacity.
- **shrink()**: Shrinks the underlying array by a factor of `fact + 1` when the queue size falls below a certain threshold.
- **checkShrink()**: Checks if the queue needs to shrink based on the current length and automatically shrinks it if necessary.

### Public Methods

- **size()**: Returns the current number of elements in the queue.
- **setSize(int size)**: Reduces the logical size of the queue to the specified size.
- **enqueue(int data)**: Adds an element to the rear of the queue, growing the array if necessary.
- **dequeue()**: Removes and returns the element at the front of the queue.
- **peek()**: Returns the element at the front of the queue without removing it.
- **clear()**: Empties the queue, resetting it to its initial size.
- **copy()**: Returns a shallow copy of the queue.
- **isEmpty()**: Checks if the queue is empty.
- **toArray()**: Converts the queue to a standard array.
- **toString()**: Converts the queue to a string format for easy viewing.

## Example Usage

```java
ArrayQueue queue = new ArrayQueue();
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);
System.out.println(queue.dequeue()); // Output: 10
System.out.println(queue.peek());    // Output: 20
```

## Notes
- **Growth Factor (`fact`)**: Controls the rate of resizing when the queue needs more capacity. A larger factor results in fewer but larger reallocations.
- **Shrinking**: Automatically reduces size to avoid wasted space when elements are removed.
