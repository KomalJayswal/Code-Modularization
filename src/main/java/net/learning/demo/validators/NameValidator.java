package net.learning.demo.validators;

import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;

@Service
public class NameValidator implements IValidator {

    @Override
    public DataHolder apply(DataHolder dataHolder) {

            if(!dataHolder.getName().equals("komal"))
              throw new RuntimeException();

            return dataHolder;
    }
}