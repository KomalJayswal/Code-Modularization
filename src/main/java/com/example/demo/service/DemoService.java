package com.example.demo.service;

import com.example.demo.model.DataHolder;
import com.example.demo.model.Response;
import com.example.demo.validators.AgeValidator;
import com.example.demo.validators.NameValidator;
import com.example.demo.validators.Orch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.validators.Orch.*;

@Service
public class DemoService {

    @Autowired
    private NameValidator nameValidator;

    @Autowired
    private AgeValidator ageValidator;

    /*public static void main(String[] args){
        DataHolder dataHolder = new DataHolder("komal","Jayswal");
        Response response = new Response();
        Function<DataHolder,Optional<DataHolder>> function1=new Function<DataHolder, Optional<DataHolder>>() {
            @Override
            public Optional<DataHolder> apply(DataHolder l1) {
                return Optional.ofNullable(l1);
            }
        };

        System.out.println("annonymous impl : "+function1.apply(dataHolder));
    }*/

    public Response submit(DataHolder dataHolder){

        validate(nameValidator,dataHolder).validate(ageValidator,dataHolder).map(ageValidator,dataHolder);

        //validation.apply(dataHolder,NameValidator::apply);

        return new Response("done");
    }
}