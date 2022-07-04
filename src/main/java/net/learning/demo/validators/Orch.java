package net.learning.demo.validators;

public class Orch {

    private static final Orch ORCH = new Orch();

    public static <R> Orch validate(IValidator iValidator, R r){
        iValidator.accept(r);
        return ORCH;
    }

    public static <R> Orch map(IMapper iMapper, R... r){
        //iValidator.apply(r);
        return ORCH;
    }
}
