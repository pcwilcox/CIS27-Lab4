package shortestPath;

import java.util.Iterator;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class Stack<Item>
        implements Iterable<Item>
{
    private Node first;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }

    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N++;
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator
            implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
        }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
