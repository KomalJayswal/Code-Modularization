package net.learning.demo.service;

import net.learning.demo.mapper.AgeMapper;
import net.learning.demo.model.DataHolder;
import net.learning.demo.model.OhmErrors;
import net.learning.demo.model.Response;
import net.learning.demo.validators.AgeValidator;
import net.learning.demo.validators.NameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static net.learning.demo.common.Orch.*;

@Service
public class DemoService {

    @Autowired
    private NameValidator nameValidator;

    @Autowired
    private AgeValidator ageValidator;

    @Autowired
    private AgeMapper ageMapper;

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

    public DataHolder submit(DataHolder dataHolder){

        return validate(nameValidator,dataHolder).validate(ageValidator,dataHolder).map(ageMapper,dataHolder,"abhijit");

        //validation.apply(dataHolder,NameValidator::apply);

       // return new Response("done");
    }
}