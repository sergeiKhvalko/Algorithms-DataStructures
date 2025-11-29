class LinkedListNode {
  constructor(value, next = null) {
    this.value = value;
    this.next = next;
  }

  toString() {
    return `${this.value}`;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
  }

  append(value) {
    const newNode = new LinkedListNode(value);

    if (!this.head || !this.tail) {
      this.head = newNode;
      this.tail = newNode;
      return this;
    }

    this.tail.next = newNode;
    this.tail = newNode;

    return this;
  }

  prepend(value) {
    const newNode = new LinkedListNode(value, this.head);
    this.head = newNode;

    if (!this.tail) {
      this.tail = newNode;
    }

    return this;
  }

  find(value) {
    let currentNode = this.head;
    while (currentNode) {
      if (currentNode.value === value) {
        return currentNode;
      }
      currentNode = currentNode.next;
    }
    return null;
  }

  delete(value) {
    let deletedNode = null;

    while (this.head && this.head.value === value) {
      deletedNode = this.head;
      this.head = this.head.next;
    }

    let currentNode = this.head;
    if (currentNode !== null) {
      while (currentNode.next) {
        if (currentNode.next.value === value) {
          deletedNode = currentNode.next.value;
          currentNode.next = currentNode.next.next;
        } else {
          currentNode = currentNode.next;
        }
      }
    }

    if (this.tail?.value === value) {
      this.tail = currentNode;
    }

    return deletedNode;
  }

  insertAfter(searchValue, insertValue) {
    const prevNode = this.find(searchValue);
    if (!prevNode) {
      return null;
    }

    const newNode = new LinkedListNode(insertValue, prevNode.next);
    prevNode.next = newNode;
    if (newNode.next === null) {
      this.tail = newNode;
    }

    return this;
  }

  toArray() {
    const nodes = [];
    let currentNode = this.head;
    while (currentNode) {
      nodes.push(currentNode.value);
      currentNode = currentNode.next;
    }

    return nodes;
  }

  toString() {
    return this.toArray()
      .map((value) => value.toString())
      .toString();
  }
}

const list = new LinkedList();
list.append(1).append(2).prepend(7);
// list.delete(1);
// list.delete(7);
// list.delete(2);
list.insertAfter(2, 8);
list.insertAfter(2, 9);
list.insertAfter(7, 19);
list.insertAfter(8, 999);
list.insertAfter(88, 999);
console.log(list.toArray());
console.log(list.toString());
console.log(list.tail);
