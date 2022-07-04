package com.example.demo.validators;

import com.example.demo.model.DataHolder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Function;
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