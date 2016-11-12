package mumbler.truffle.node.builtin.tuple;

import mumbler.truffle.node.builtin.BuiltinNode;
import mumbler.truffle.type.MumblerTuple;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName="fst")
@GenerateNodeFactory
public abstract class FstBuiltinNode extends BuiltinNode {
    @Specialization
    protected Object fst(MumblerTuple tuple) {
        return tuple.first();
    }
}
