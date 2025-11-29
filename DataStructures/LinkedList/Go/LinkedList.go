package main

import (
	"fmt"
	"strings"
)

type LinkedListNode struct {
	Value int
	Next *LinkedListNode
}

func (node *LinkedListNode) String() string{
	return fmt.Sprintf("%d", node.Value)
}

type LinkedList struct {
	Head *LinkedListNode
	Tail *LinkedListNode
}

func (l *LinkedList) Append(value int) *LinkedList {
	newNode := &LinkedListNode{Value: value}

	if l.Head == nil || l.Tail == nil {
		l.Head = newNode
		l.Tail = newNode
		return l
	}

	l.Tail.Next = newNode
	l.Tail = newNode

	return l
}

func (l *LinkedList) Prepend(value int) *LinkedList {
	newNode := &LinkedListNode{Value: value, Next: l.Head}
	l.Head = newNode

	if l.Tail == nil {
		l.Tail = newNode
	}

	return l
}

func (l *LinkedList) Find(value int) *LinkedListNode {
	current := l.Head
	for current != nil {
		if current.Value == value {
			return current
		}
		current = current.Next
	}
	return nil
}

func (l *LinkedList) Delete(value int) *LinkedListNode{
	var deletedNode *LinkedListNode

	for l.Head != nil && l.Head.Value == value {
		deletedNode = l.Head
		l.Head = l.Head.Next
	}

	current := l.Head
	if current != nil {
		for current.Next != nil {
			if current.Next.Value == value {
				deletedNode = current.Next
				current.Next = current.Next.Next
			} else {
				current = current.Next
			}
		}
	}

	if l.Tail != nil && l.Tail.Value == value {
		l.Tail = current
	}

	return deletedNode
}

func (l *LinkedList) InsertAfter(searchValue, insertValue int) *LinkedList {
	prevNode := l.Find(searchValue)
	if prevNode == nil {
		return l
	}
	newNode := &LinkedListNode{Value: insertValue, Next: prevNode.Next}
	prevNode.Next = newNode

	if newNode.Next == nil {
		l.Tail = newNode
	}

	return l
}

func (l *LinkedList) ToArray() []*LinkedListNode {
	nodes := []*LinkedListNode{}
	current := l.Head
	for current != nil {
		nodes = append(nodes, current)
		current = current.Next
	}

	return nodes
}

func (l *LinkedList) ToString() string {
	arr := l.ToArray()
	strValues := make([]string, len(arr))

	for i, v := range arr {
		strValues[i] = fmt.Sprintf("%d", v.Value)
	}

	return strings.Join(strValues, ",")
}

func (l *LinkedList) Size() int {
	var count int
	current := l.Head
	for current != nil {
		count += 1
		current = current.Next
	}

	return count
}

func (l *LinkedList) RemoveAfter(value int) bool {
	node := l.Find(value)
	if node == nil || node.Next == nil {
		return false
	}

	removed := node.Next
	node.Next = removed.Next

	if removed == l.Tail {
		l.Tail = node
	}

	return true
}

func (l *LinkedList) Reverse() {
	var prev *LinkedListNode
	current := l.Head
	l.Tail = l.Head

	for current != nil {
		next := current.Next
		current.Next = prev
		prev = current
		current = next
	}

	l.Head = prev
}



func main() {
	list := &LinkedList{}
	list.Append(1).Append(2).Prepend(7)

	list.InsertAfter(2, 8)
	list.InsertAfter(2, 9)
	list.InsertAfter(7, 19)
	list.InsertAfter(8, 999)
	list.InsertAfter(88, 999) // нет такого значения → ничего не делает

	fmt.Println(list.ToArray())
	fmt.Println(list.ToString())

	fmt.Println("tail:", list.Tail.Value)
	fmt.Println("size:", list.Size())

	list.Reverse()
	fmt.Println(list.ToArray())
	fmt.Println(list.ToString())

	fmt.Println("tail:", list.Tail.Value)
	fmt.Println("size:", list.Size())
}