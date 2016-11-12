package mumbler.truffle.node.builtin.tuple;

import mumbler.truffle.node.builtin.BuiltinNode;
import mumbler.truffle.type.MumblerTuple;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;

@GenerateNodeFactory
public abstract class TupleBuiltinNode extends BuiltinNode {
    @Specialization
    protected MumblerTuple tuple(Object first, Object second) {
        return MumblerTuple.tuple(first, second);
    }
}
