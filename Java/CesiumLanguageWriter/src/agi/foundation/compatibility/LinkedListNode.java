package agi.foundation.compatibility;

//DERIVED FROM:
//
//System.Collections.Generic.LinkedListNode
//
//Author:
// David Waite
//
//(C) 2005 David Waite (mass@akuma.org)
//

//
//Copyright (C) 2005 David Waite
//
//Permission is hereby granted, free of charge, to any person obtaining
//a copy of this software and associated documentation files (the
//"Software"), to deal in the Software without restriction, including
//without limitation the rights to use, copy, modify, merge, publish,
//distribute, sublicense, and/or sell copies of the Software, and to
//permit persons to whom the Software is furnished to do so, subject to
//the following conditions:
//
//The above copyright notice and this permission notice shall be
//included in all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
//EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
//MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
//NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
//LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
//OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
//WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

/**
 * Represents a node in a LinkedList.
 * 
 * @param <T>
 *            Specifies the element type of the linked list.
 */
public final class LinkedListNode<T> {
    private T value;
    private LinkedList<T> list;
    LinkedListNode<T> next;
    LinkedListNode<T> previous;

    /**
     * Initializes a new instance of the LinkedListNode class, containing the specified
     * value.
     * 
     * @param value
     *            The value to contain in the LinkedListNode.
     */
    public LinkedListNode(T value) {
        this.value = value;
    }

    LinkedListNode(LinkedList<T> list, T value) {
        this.list = list;
        this.value = value;
        this.next = this;
        this.previous = this.next;
    }

    LinkedListNode(LinkedList<T> list, T value, LinkedListNode<T> previousNode, LinkedListNode<T> nextNode) {
        this.list = list;
        this.value = value;
        this.previous = previousNode;
        this.next = nextNode;
        previousNode.next = this;
        nextNode.previous = this;
    }

    final void detach() {
        previous.next = next;
        next.previous = previous;
        previous = null;
        next = previous;
        list = null;
    }

    final void selfReference(LinkedList<T> list) {
        next = this;
        previous = this;
        this.list = list;
    }

    final void insertBetween(LinkedListNode<T> previousNode, LinkedListNode<T> nextNode, LinkedList<T> list) {
        previousNode.next = this;
        nextNode.previous = this;
        this.next = nextNode;
        this.previous = previousNode;
        this.list = list;
    }

    /**
     * Gets the LinkedList that the LinkedListNode belongs to.
     * 
     * @return A reference to the LinkedList that the LinkedListNode belongs to, or null
     *         if the LinkedListNode is not linked.
     */
    public final LinkedList<T> getList() {
        return list;
    }

    /**
     * Gets the next node in the LinkedList.
     * 
     * @return A reference to the next node in the LinkedList, or null if the current node
     *         is the last element of the LinkedList.
     */
    public final LinkedListNode<T> getNext() {
        return (list != null && next != list.getFirst()) ? next : null;
    }

    /**
     * Gets the previous node in the LinkedList.
     * 
     * @return A reference to the previous node in the LinkedList, or null if the current
     *         node is the first element of the LinkedList.
     */
    public final LinkedListNode<T> getPrevious() {
        return (list != null && this != list.getFirst()) ? previous : null;
    }

    /**
     * Gets the value contained in the node.
     * 
     * @return The value contained in the node.
     */
    public final T getValue() {
        return value;
    }

    /**
     * Sets the value contained in the node.
     * 
     * @param value
     *            T The new value to contain in the LinkedListNode.
     */
    public final void setValue(T value) {
        this.value = value;
    }
}