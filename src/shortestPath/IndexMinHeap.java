package shortestPath;

import java.util.ArrayList;

/**
 * Created by Pete Wilcox on 3/20/2016.
 * petercwilcox@gmail.com
 */
public class IndexMinHeap<Key extends Comparable<Key>, Item>
{
    private ArrayList<Key> keys;
    private ArrayList<Item> vals;
    private int size;

    // Sink the element when added
    private void sink(int i)
    {
        while (2 * i < size)
        {
            int j = 2 * i;
            if (j < size && less(j + 1, j))
            {
                j++;
            }
            if (!less(j, i))
            {
                break;
            }
            exch(i, j);
            i = j;
        }
    }

    //
    private void swim(int i)
    {
        while (i > 1 && less(i, i / 2))
        {
            exch(i / 2, i);
            i /= 2;
        }
    }

    public IndexMinHeap()
    {
        keys = new ArrayList<>();
        vals = new ArrayList<>();
        size = 0;
    }

    public void insert(Item i, Key k)
    {
        keys.add(k);
        vals.add(i);
        size++;
        swim(size);

    }

    public Item remove()
    {
        exch(1, size--);
        Item temp = vals.remove(size);
        Key k = keys.remove(size);
        sink(1);
        return temp;
    }

    private boolean less(int a, int b)
    {
        return keys.get(a - 1).compareTo(keys.get(b - 1)) < 0;
    }

    private void exch(int a, int b)
    {
        Key tempKey = keys.get(a - 1);
        Item tempItem = vals.get(a - 1);
        keys.set(a - 1, keys.get(b - 1));
        vals.set(a - 1, vals.get(b - 1));
        keys.set(b - 1, tempKey);
        vals.set(b - 1, tempItem);
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public String toString()
    {
        String output = "";

        for (Key i : keys)
        {
            output = output + i + " ";
        }
        return output;
    }

    public boolean contains(Item item)
    {
        return vals.contains(item);
    }


    public void change(Item item, Key key)
    {
        if (contains(item))
        {
            int oldIndex = vals.indexOf(item);
            keys.set(oldIndex, key);
            if (less(oldIndex, oldIndex / 2))
                swim(oldIndex);
            else sink(oldIndex);
        }
    }

    public Key minKey() {
        return keys.get(1);
    }

    public Item minItem() {
        return vals.get(1);
    }
}