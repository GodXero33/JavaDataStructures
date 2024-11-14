# ArrayList

The `ArrayList` class is a custom implementation of a dynamic array structure that automatically grows and shrinks as elements are added or removed. This implementation allows for efficient resizing based on a specified growth factor.

## Constructors

- **ArrayList(int initialSize, double fact)**: Initializes an `ArrayList` with a specified initial size and growth factor.
- **ArrayList(int initialSize)**: Initializes an `ArrayList` with a specified initial size and a default growth factor of `0.5`.
- **ArrayList()**: Initializes an `ArrayList` with a default size of `10` and a default growth factor of `0.5`.

## Methods

### Private Methods

- **grow()**: Expands the underlying array by `(1 + fact)` when the list reaches its current capacity.
- **shrink()**: Shrinks the underlying array by a factor of `fact + 1` when the list size falls below a certain threshold.
- **checkShrink()**: Checks if the list needs to shrink based on the current `length` and automatically shrinks it if necessary.

### Public Methods

- **size()**: Returns the current number of elements in the list.
- **setSize(int size)**: Reduces the logical size of the list to the specified size.
- **append(int data)**: Adds an element to the end of the list, growing the array if needed.
- **insert(int index, int data)**: Inserts an element at the specified index, shifting elements to the right.
- **remove(int data)**: Removes the first occurrence of the specified element from the list.
- **pop(int index)**: Removes and returns the element at the specified index.
- **pop()**: Removes and returns the last element of the list.
- **clear()**: Empties the list, resetting it to its initial size.
- **indexOf(int data)**: Returns the index of the first occurrence of the specified element, or `-1` if not found.
- **count(int data)**: Counts and returns the occurrences of the specified element.
- **copy()**: Returns a shallow copy of the list.
- **reverse()**: Reverses the order of elements in the list.
- **set(int index, int data)**: Updates the element at the specified index.
- **get(int index)**: Returns the element at the specified index, or `-1` if the index is out of bounds.
- **isEmpty()**: Checks if the list is empty.
- **toArray()**: Converts the list to a standard array.
- **toString()**: Converts the list to a string format for easy viewing.

## Example Usage

```java
ArrayList list = new ArrayList();
list.append(10);
list.append(20);
list.insert(1, 15); // Insert 15 at index 1
System.out.println(list.toString()); // Output: <10, 15, 20>
```

## Notes
- **Growth Factor (`fact`)**: Controls the rate of resizing when the list needs more capacity. A larger factor results in fewer but larger reallocations.
- **Shrinking**: Automatically reduces size to avoid wasted space when elements are removed.
