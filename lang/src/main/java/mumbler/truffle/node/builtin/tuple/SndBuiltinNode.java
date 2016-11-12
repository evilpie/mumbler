package mumbler.truffle.node.builtin.tuple;

import mumbler.truffle.node.builtin.BuiltinNode;
import mumbler.truffle.type.MumblerTuple;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName="snd")
@GenerateNodeFactory
public abstract class SndBuiltinNode extends BuiltinNode {
    @Specialization
    protected Object snd(MumblerTuple tuple) {
        return tuple.second();
    }
}
