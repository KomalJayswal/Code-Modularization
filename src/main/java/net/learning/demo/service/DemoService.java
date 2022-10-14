package net.learning.demo.service;

import net.learning.demo.common.Orch;
import net.learning.demo.mapper.AgeMapper;
import net.learning.demo.model.DataHolder;
import net.learning.demo.model.OhmErrors;
import net.learning.demo.validators.AgeValidator;
import net.learning.demo.validators.NameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    public List<OhmErrors> submit(DataHolder dataHolder){

         Orch.validate(nameValidator,dataHolder);//.validate(ageValidator,dataHolder).map(ageMapper,dataHolder,"abhijit");

        List<OhmErrors> err = (List<OhmErrors>) ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest().getAttribute("ohmErrors");
        err.add(OhmErrors.builder()
                .errorCode("12345")
                .errorMessage("error messages")
                .tag("01")
                .technicalMessage("05")
                .build());
        return err;
        //validation.apply(dataHolder,NameValidator::apply);

       // return new Response("done");
    }
    private void call(List<Integer> n){
        n.add(2);
        n.add(3);
        n.add(4);
    }
}