package net.learning.demo.common;

import net.learning.demo.model.DataHolder;

public class Orch {

    private Orch() {
    }

    public static <R> void validate(IValidator<R> iValidator, R r) {
        iValidator.accept(r);
    }

    public static <R> R map(IMapper<R, R> iMapper, R r) {
        iMapper.apply(r);
        return r;
    }

    public static <R> DataHolder map(IMultiMapper iMultiMapper, R... r) {
        return (DataHolder) iMultiMapper.apply(r[0], r[1]);
    }
}
