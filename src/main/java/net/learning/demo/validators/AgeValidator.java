package net.learning.demo.validators;

import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgeValidator implements IValidator<DataHolder>  {

@Override
public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
        .filter(d -> d.getName().equals("komal"))
        .orElseThrow(() -> new RuntimeException());

        }
}
