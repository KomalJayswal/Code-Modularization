package net.learning.demo.common;

import net.learning.demo.mapper.IMapper;
import net.learning.demo.model.DataHolder;
import net.learning.demo.validators.IValidator;

public class Orch {

    private static final Orch ORCH = new Orch();

    public static <R> void validate(IValidator iValidator, R r){
        iValidator.accept(r);
        //return ORCH;
    }

    public static <R> DataHolder map(IMapper iMapper, R... r){
        return (DataHolder) iMapper.apply(r[0],r[1]);
        //return ORCH;
    }
}
