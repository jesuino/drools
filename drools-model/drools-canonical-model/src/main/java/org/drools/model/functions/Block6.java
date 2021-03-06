package org.drools.model.functions;

import java.io.Serializable;

public interface Block6<T1, T2, T3, T4, T5, T6> extends Serializable {

    void execute(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6) throws Exception;

    default BlockN asBlockN() {
        return new Impl(this);
    }

    class Impl extends IntrospectableLambda implements BlockN {

        private final Block6 block;

        public Impl(Block6 block) {
            this.block = block;
        }

        @Override
        public void execute(Object... objs) throws Exception {
            block.execute(objs[0], objs[1], objs[2], objs[3], objs[4], objs[5]);
        }

        @Override
        public Object getLambda() {
            return block;
        }
    }
}
