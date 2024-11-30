# LinkedStack

The `LinkedStack` class implements a stack data structure using a singly linked list. The stack follows the Last-In-First-Out (LIFO) principle, meaning the last element added is the first to be removed. This class provides various methods to manipulate and inspect the stack.

## Fields

- **topNode**: The top node of the stack (the one that will be popped next).
- **length**: The total number of nodes in the stack.

## Methods

### Public Methods

- **size()**: Returns the number of elements in the stack.

- **setSize(int size)**: Sets the length of the stack. If the size is less than the current length, the stack is truncated. If `size` is 0, the stack is cleared.

- **push(int data)**: Adds a new element with the specified `data` to the top of the stack.

- **pop()**: Removes and returns the element at the top of the stack. Returns `-1` if the stack is empty.

- **peek()**: Returns the data of the top element without removing it. Returns `-1` if the stack is empty.

- **copy()**: Returns a shallow copy of the stack. The new stack will have the same elements but will be independent of the original stack.

- **isEmpty()**: Returns `true` if the stack is empty, otherwise `false`.

- **clear()**: Clears the stack by setting `topNode` to `null` and the length to 0.

- **toArray()**: Converts the stack to an array of integers.

- **toString()**: Returns a string representation of the stack in the format `<value1, value2, value3, ...>`. Returns `<>` if the stack is empty.

## Example Usage

```java
LinkedStack stack = new LinkedStack();
stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.size());       // Output: 3
System.out.println(stack.peek());       // Output: 30
System.out.println(stack.pop());        // Output: 30
System.out.println(stack.toString());   // Output: <20, 10>
stack.clear();
System.out.println(stack.isEmpty());    // Output: true
```

## Notes

- **Stack Operations**: The `push` method adds a new element to the top of the stack, and `pop` removes an element from the top. This follows the LIFO order.

- **Shallow Copy**: The `copy()` method creates a shallow copy of the stack. The order of elements in the copied stack will be the same as the original.

- **Stack Representation**: The `toString()` method provides a convenient way to display the stack in a human-readable format.
