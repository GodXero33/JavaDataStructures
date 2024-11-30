# ArrayStack

The `ArrayStack` class is a custom implementation of a stack using a dynamic array. The stack automatically grows or shrinks as elements are added or removed, based on a specified growth factor.

## Constructors

- **ArrayStack(int initialSize, double fact)**: Initializes an `ArrayStack` with a specified initial size and growth factor.
- **ArrayStack(int initialSize)**: Initializes an `ArrayStack` with a specified initial size and a default growth factor of `0.5`.
- **ArrayStack()**: Initializes an `ArrayStack` with a default size of `10` and a default growth factor of `0.5`.

## Methods

### Private Methods

- **grow()**: Expands the underlying array by `(1 + fact)` when the stack reaches its current capacity.
- **shrink()**: Shrinks the underlying array by a factor of `fact + 1` when the stack size falls below a certain threshold.
- **checkShrink()**: Checks if the stack needs to shrink based on the current length and automatically shrinks it if necessary.

### Public Methods

- **size()**: Returns the current number of elements in the stack.
- **setSize(int size)**: Reduces the logical size of the stack to the specified size.
- **push(int data)**: Adds an element to the top of the stack, growing the array if necessary.
- **pop()**: Removes and returns the element at the top of the stack. Returns `-1` if the stack is empty.
- **peek()**: Returns the element at the top of the stack without removing it. Returns `-1` if the stack is empty.
- **clear()**: Empties the stack, resetting it to its initial size.
- **copy()**: Returns a shallow copy of the stack.
- **isEmpty()**: Checks if the stack is empty.
- **toArray()**: Converts the stack to a standard array, with the most recently added element at the front.
- **toString()**: Converts the stack to a string format for easy viewing, displaying elements from top to bottom.

## Example Usage

```java
ArrayStack stack = new ArrayStack();
stack.push(10);
stack.push(20);
stack.push(30);
System.out.println(stack.pop());   // Output: 30
System.out.println(stack.peek());  // Output: 20
```

## Notes
- **Growth Factor (`fact`)**: Controls the rate of resizing when the stack needs more capacity. A larger factor results in fewer but larger reallocations.
- **Shrinking**: Automatically reduces size to avoid wasted space when elements are removed.
