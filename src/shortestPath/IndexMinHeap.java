package shortestPath;

/**
 * Created by Pete Wilcox on 3/20/2016.
 * petercwilcox@gmail.com
 */
public class IndexMinHeap
{
    // Minimum-ordered priority queue
    private int[] keys;
    private int[] vals;
    private int   size;

    // Sink an element to its proper place
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

    // Swim an element upwards
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
        keys = new int[1];
        vals = new int[1];
        size = 0;
    }

    // Add an element, resizing if necessary
    public void insert(int i, int j)
    {
        if (++size >= keys.length)
        {
            resize();
        }

        keys[size] = j;
        vals[size] = i;
        swim(size);

    }

    // Swap the first and last elements,
    // remove the last, sink the first,
    // resize if necessary
    public int remove()
    {
        exch(1, size);
        int temp    = vals[size];
        int tempKey = keys[size--];
        sink(1);
        if (size <= keys.length / 2)
        {
            resize();
        }
        return temp;
    }

    private boolean less(int a, int b)
    {
        return keys[a] < keys[b];
    }

    private void exch(int a, int b)
    {
        int tempKey = keys[a];
        keys[a] = keys[b];
        keys[b] = tempKey;

        int tempVal = vals[a];
        vals[a] = vals[b];
        vals[b] = tempVal;
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

        for (int i = 1; i <= size; i++)
        {
            output = output + "(" + vals[i] + ", " + keys[i] + ")";
        }
        return output;
    }

    // Helper to resize as necessary
    private void resize()
    {
        int[] newKeys = new int[2 * size];
        int[] newVals = new int[2 * size];
        for (int i = 1; i <= size &&
                        i < keys.length &&
                        i < newKeys.length; i++)
        {
            newKeys[i] = keys[i];
            newVals[i] = vals[i];
        }
        keys = newKeys;
        vals = newVals;
    }

    public boolean contains(int v)
    {
        for (int i = 0; i < size; i++)
        {
            if (vals[i] == v)
            {
                return true;
            }
        }
        return false;
    }


    public void change(int item, int key)
    {
        if (contains(item))
        {
            int oldIndex = 0;
            for (int i = 0; i < size; i++)
            {
                if (vals[i] == item)
                {
                    oldIndex = i;
                    keys[i] = key;
                }
            }


            if (oldIndex > 1 && less(oldIndex, oldIndex / 2))
            {
                swim(oldIndex);
            }
            else if (oldIndex < size)
            {
                sink(oldIndex);
            }
        }
    }

    public int minKey()
    {
        return keys[1];
    }

    public int minItem()
    {
        return vals[1];
    }
}