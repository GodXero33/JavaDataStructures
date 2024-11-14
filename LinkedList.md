# LinkedList

The `LinkedList` class implements a singly linked list where each node stores an integer value and points to the next node in the list. The class provides several methods for manipulating the list, including appending, inserting, removing elements, and traversing the list.

## Fields

- **headNode**: The first node in the list (or `null` if the list is empty).
- **length**: The total number of nodes in the list.

## Methods

### Public Methods

- **size()**: Returns the number of nodes in the list. 
- **setSize(int size)**: Sets the length of the list. If `size` is less than the current length, the list is truncated. If `size` is 0, the list is cleared.
  
- **append(int data)**: Appends a new node with the specified `data` to the end of the list.

- **insert(int index, int data)**: Inserts a new node with the specified `data` at the given `index` in the list.

- **remove(int data)**: Removes the first occurrence of the specified `data` from the list. 

- **pop(int index)**: Removes and returns the data at the specified `index`.

- **pop()**: Removes and returns the data from the last node in the list (same as `pop(length - 1)`).

- **clear()**: Clears the list by setting the `headNode` to `null` and the `length` to 0.

- **indexOf(int data)**: Returns the index of the first occurrence of the specified `data`. Returns `-1` if the data is not found.

- **count(int data)**: Returns the number of occurrences of the specified `data` in the list.

- **copy()**: Returns a shallow copy of the list.

- **reverse()**: Reverses the order of nodes in the list.

- **set(int index, int data)**: Updates the value of the node at the specified `index` with the new `data`.

- **get(int index)**: Returns the value of the node at the specified `index`. If the index is out of bounds, it returns `-1`.

- **isEmpty()**: Returns `true` if the list is empty; otherwise, returns `false`.

- **toArray()**: Converts the list to an array of integers.

- **toString()**: Returns a string representation of the list in the format `<value1, value2, value3, ...>`. Returns `<>` if the list is empty.

## Example Usage

```java
LinkedList list = new LinkedList();
list.append(1);
list.append(2);
list.append(3);

System.out.println(list.size());       // Output: 3
System.out.println(list.get(1));       // Output: 2
list.remove(2);
System.out.println(list.toString());  // Output: <1, 3>
list.reverse();
System.out.println(list.toString());  // Output: <3, 1>
```

## Notes

- **Pop**: The `pop()` method removes the node at the given index and returns the value. If no index is provided, it removes and returns the last node.
- **Shallow Copy**: The `copy()` method creates a shallow copy of the list, meaning the new list's nodes point to the same data as the original list’s nodes.
- **List Representation**: The `toString()` method provides a convenient way to display the list in a human-readable format.
