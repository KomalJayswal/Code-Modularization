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
public class NameValidator implements IValidator<DataHolder> {

    @Override
    public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
                .map(dataHolder1 -> {
                    return Optional.ofNullable(dataHolder1.getName())
                            .filter(name2 -> !name2.isEmpty())
                            .map(name1 -> {
                                return Optional.of(name1)
                                        .filter(name -> Pattern.compile(Constants.NAME_REGEX).matcher(name).matches())
                                        .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "Invalid Name !!!"));
                            })
                            .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "Name is missing"));

                })
                .orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Data is missing"));
    }
}
