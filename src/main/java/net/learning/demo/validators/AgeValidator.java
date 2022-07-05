package net.learning.demo.validators;

import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgeValidator /*implements IValidator*/ {

    //@Override
    public DataHolder apply(DataHolder dataHolder) {

        if(dataHolder.getAge()>60)
            throw new RuntimeException();

        return dataHolder;
    }
}
