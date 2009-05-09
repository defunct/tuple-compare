package com.mallardsoft.tuple.compare.api;

import static org.testng.Assert.assertEquals;

import java.util.Comparator;
import org.testng.annotations.Test;

import com.mallardsoft.tuple.Pair;
import com.mallardsoft.tuple.Triple;
import com.mallardsoft.tuple.Tuple;
import com.mallardsoft.tuple.compare.TupleComparator;

public class TupleComparatorTest
{
    @Test
    public void compare()
    {
       Pair<String, String> pair = Tuple.from("A", "B");
       Triple<String, String, Integer> triple = Tuple.from("A", "B", 1);
       Comparator<Tuple<?, ?>> comparator = new TupleComparator();
       assertEquals(comparator.compare(pair, triple), -1);
    }
}
