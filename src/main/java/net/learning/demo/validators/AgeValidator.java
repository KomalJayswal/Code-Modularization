package net.learning.demo.validators;

import net.learning.ExceptionHandlerUtility.exceptions.CustomException;
import net.learning.demo.common.IValidator;
import net.learning.demo.model.DataHolder;
import net.learning.demo.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class AgeValidator implements IValidator<DataHolder> {

    @Override
    public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
                .map(dataHolder1 -> {
                    return Optional.of(dataHolder1.getAge())
                            .map(age -> {
                                return Optional.of(age)
                                        .filter(age1 -> Pattern.compile(Constants.AGE_REGEX).matcher(String.valueOf(age1)).matches())
                                        .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "Invalid Age !!!"));
                            })
                            .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST,"Age is missing"));

                })
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST,"Data is missing"));
    }
}

