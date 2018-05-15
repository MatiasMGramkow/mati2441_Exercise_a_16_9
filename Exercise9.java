import java.util.LinkedList;

public class Exercise9
    /*
    Write a method called stutter that doubles the size of a
    list by replacing every integer in the list with two of that
    integer. For example, suppose a variable list stores the
    values [1, 8, 19, 4, 17], after a call of list.stutter(),
    it should store [1, 1, 8, 8, 19, 19, 4, 4, 17, 17].
     */
{
    public static void main(String[] args)
    {
        Listen liste = new Listen();
        liste.add(1);
        liste.add(8);
        liste.add(19);
        liste.add(4);
        liste.add(17);

        System.out.println("Listen indeholder: " + liste);

        liste.stutter();
        System.out.println("\n After stutter method: " + liste);
    }
}
class List
{


    public int data;
    public List next;

    public List()
    {
        this(0, null);
    }

    public List(int data)
    {
        this(data, null);
    }

    public List(int data, List next)
    {
        this.data = data;
        this.next = next;
    }
}

class Listen
{
    private List front;

    public Listen()
    {
        front = null;
    }

    public int size()
    {
        int count = 0;
        List current = front;

        while(current != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }

    public int gette (int index)
    {
        return node (index).data;
    }

    public String toString()
    {
        if (front == null)
        {
            return "[]";
        } else
        {
            String result = "[" + front.data;
            List current = front.next;

            while (current != null)
            {
                result = result + ", " + current.data;
                current = current.next;
            }
            result = result + "] ";
            return result;
        }
    }

    public int indexOf (int value)
    {
        int index = 0;
        List current = front;
        while (current != null)
        {
            if(current!= null)
            {
                return index;
            }
            current = current.next;
        }
        return -1;
    }
    public void add (int value)
    {
        if(front == null)
        {
            front = new List(value);
        }
        else
        {
            List current = front;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = new List(value);
        }
    }

    public void add (int index, int value)
    {
        if(index == 0)
        {
            front = new List(value, front);
        }
        else {
            List current = node (index -1);
            current.next = new List(value, current.next);
        }
    }

    public void remove (int index)
    {
        if (index == 0)
        {
            front = front.next;
        }
        else{
            List current = node (index -1);
            current.next = current.next.next;
        }
    }

    private List node (int index)
    {
        List current = front;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current;
    }

    public void stutter ()
    {
        if(front==null)
        {
            System.out.println("Listen er tom, OH NO!");
        }
        else {
            List current = front;
            int index = 1;
            while (current!= null)
            {
                int value =current.data;
                add(index, value);
                index = index +2;
                current = current.next.next;
            }
        }
    }
}
