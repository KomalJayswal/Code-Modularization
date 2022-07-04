package com.example.demo.validators;

import com.example.demo.model.DataHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class AgeValidator implements IValidator<DataHolder>  {

@Override
public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
        .filter(d -> d.getName().equals("komal"))
        .orElseThrow(() -> new RuntimeException());

        }
}
