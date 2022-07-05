package net.learning.demo.validators;

import net.learning.demo.model.DataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IValidator extends Function<DataHolder ,DataHolder> {

    @Override
    public DataHolder apply(DataHolder dataHolder);
}

