package com.mallardsoft.tuple.compare;

import java.util.Comparator;

import com.mallardsoft.tuple.Variable;

import com.mallardsoft.tuple.End;

import com.mallardsoft.tuple.Tuple;

public class TupleComparator implements Comparator<Tuple<?, ?>>
{
    @SuppressWarnings("unchecked")
    private int uncheckedCompare(Object o1, Object o2)
    {
        if (o1 instanceof End)
        {
            if (o2 instanceof End)
            {
                return 0;
            }
            return -1;
        }
        else if (o2 instanceof End)
        {
            return 1;
        }
        Tuple t1 = (Tuple) o1;
        Tuple t2 = (Tuple) o2;
        Variable v1 = new Variable();
        Variable v2 = new Variable();
        Object r1 = t1.extract(v1);
        Object r2 = t2.extract(v2);
        Object f1 = v1.get();
        Object f2 = v2.get();
        if (f1 == null)
        {
            if (f2 == null)
            {
                return uncheckedCompare(r1, r2);
            }
            return -1;
        }
        else if (f2 == null)
        {
            return 1;
        }
        if (!((f1 instanceof Comparable) && (f2 instanceof Comparable)))
        {
            throw new IllegalArgumentException();
        }
            
        int compare = ((Comparable) f1).compareTo(f2);
        if (compare == 0)
        {
            return uncheckedCompare(r1, r2);
        }

        return compare;
    }

    public int compare(Tuple<?, ?> o1, Tuple<?, ?> o2)
    {
        return uncheckedCompare(o1, o2);
    }
}
