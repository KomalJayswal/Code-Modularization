package net.learning.demo.service;

import net.learning.demo.model.DataHolder;
import net.learning.demo.model.Response;
import net.learning.demo.validators.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private IValidator validator;

    public Response submit(DataHolder dataHolder){

        validator.apply(dataHolder);

        return new Response("done");
    }
}