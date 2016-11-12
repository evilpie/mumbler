package mumbler.truffle.type;

import static java.util.Arrays.asList;

import java.util.Iterator;
import java.util.List;

import mumbler.truffle.MumblerException;

public class MumblerTuple implements Iterable<Object> {

    // Todo: Figure out how to strictly type this.
    private final Object elements[];

    private MumblerTuple() {
        this.elements = null;
    }

    private MumblerTuple(Object first, Object second) {
        this.elements = new Object[2];
        this.elements[0] = first;
        this.elements[1] = second;
    }

    public static MumblerTuple tuple(Object first, Object second) {
        return new MumblerTuple(first, second);
    }

/*
    @SafeVarargs
    public static <T> MumblerList<T> list(T... objs) {
        return list(asList(objs));
    }

    public static <T> MumblerList<T> list(List<T> objs) {
        @SuppressWarnings("unchecked")
        MumblerList<T> l = (MumblerList<T>) EMPTY;
        for (int i=objs.size()-1; i>=0; i--) {
            l = l.cons(objs.get(i));
        }
        return l;
    }
*/

    public long size() {
        return this.elements.length;
    }


    @Override
    public Iterator<Object> iterator() {
        List<Object> list = asList(this.elements);
        return list.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MumblerTuple)) {
            return false;
        }

        // MumblerTuple<?> that = (MumblerTuple<?>) other;
        MumblerTuple that = (MumblerTuple) other;
        return this.elements.equals(that.elements);
    }

    @Override
    public String toString() {
        if (this.elements.length == 0) {
            return "()";
        }

        StringBuilder b = new StringBuilder("(");
        b.append(this.elements[0]);

        for (int i = 1; i < this.elements.length; ++i) {
            b.append(" ");
            b.append(this.elements[i]);
        }

        b.append(")");
        return b.toString();
    }
}
