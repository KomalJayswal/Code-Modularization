package net.learning.demo.validators;

import net.learning.demo.model.DataHolder;
import net.learning.demo.model.OhmErrors;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Function<Optional<DataHolder>, Optional<DataHolder>>
@Service
public class NameValidator implements IValidator<DataHolder>  {
    @Override
    public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
                .filter(d -> d.getName().equals("komal"))
                .orElseThrow(() ->{
                    setValidationInHttpServletRequest();
                    System.out.println("komal :- "+((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                            .getRequest().getAttribute("ohmErrors"));
                    throw new RuntimeException();
                });
    }




        /*public static DataHolder apply(DataHolder dataHolder) {

            if(!dataHolder.getName().equals("komal"))
              throw new RuntimeException();

            return dataHolder;
        }*/

    public void setValidationInHttpServletRequest() {
        List<OhmErrors> ohmErrors = new ArrayList<>();
        OhmErrors ohmError = OhmErrors.builder()
                .errorCode("12345")
                .errorMessage("error messages")
                .tag("01")
                .technicalMessage("05")
                .build();
        ohmErrors.add(ohmError);

        ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest().setAttribute("ohmErrors", ohmErrors);
    }
}