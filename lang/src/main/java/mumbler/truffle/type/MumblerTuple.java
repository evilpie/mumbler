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

    private MumblerTuple(Object[] elements) {
        this.elements = elements;
    }


    public static MumblerTuple tuple(Object[] objs) {
        return new MumblerTuple(objs);
    }

    public long size() {
        return this.elements.length;
    }

    public Object first() {
        return this.elements[0];
    }

    public Object second() {
        return this.elements[1];
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
