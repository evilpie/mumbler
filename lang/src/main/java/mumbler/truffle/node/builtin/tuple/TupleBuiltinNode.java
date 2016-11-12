package mumbler.truffle.node.builtin.tuple;

import mumbler.truffle.node.MumblerNode;
import mumbler.truffle.node.MumblerRootNode;
import mumbler.truffle.node.builtin.BuiltinNode;
import mumbler.truffle.type.MumblerFunction;
import mumbler.truffle.type.MumblerTuple;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;

import java.util.Arrays;
import java.util.List;


public class TupleBuiltinNode extends MumblerNode {

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        List l = Arrays.asList(virtualFrame.getArguments());
        return MumblerTuple.tuple(l.subList(1, l.size()).toArray());
    }

    public static MumblerFunction createBuiltinFunction(VirtualFrame outerFrame) {
        TupleBuiltinNode node = new TupleBuiltinNode();
        return new MumblerFunction(Truffle.getRuntime().createCallTarget(
                            new MumblerRootNode(new MumblerNode[] {node},
                            new FrameDescriptor())));

    }
}