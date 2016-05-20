package shortestPath;

import java.util.Iterator;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class Bag<Item>
        implements Iterable<Item>
{
    private Node first;

    private class Node
    {
        Item item;
        Node next;
    }

    public void add(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
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
