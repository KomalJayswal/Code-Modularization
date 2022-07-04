package net.learning.demo.validators;

import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Function<Optional<DataHolder>, Optional<DataHolder>>
@Service
public class NameValidator implements IValidator<DataHolder>  {
    @Override
    public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
                .filter(d -> d.getName().equals("komal"))
                .orElseThrow(() -> new RuntimeException());
    }




        /*public static DataHolder apply(DataHolder dataHolder) {

            if(!dataHolder.getName().equals("komal"))
              throw new RuntimeException();

            return dataHolder;
        }*/
}