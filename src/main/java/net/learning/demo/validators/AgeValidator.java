package net.learning.demo.validators;

import com.sun.jdi.InternalException;
import net.learning.demo.common.IValidator;
import net.learning.demo.model.DataHolder;
import net.learning.demo.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class AgeValidator implements IValidator<DataHolder> {

    /**
     * Age must be from 18 to 100. It won't match ages below 18 or any non-numeric characters.
     *
     * @param dataHolder the input argument
     */
    @Override
    public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
                .map(dataHolder1 -> Optional.of(dataHolder1.getAge())
                        .map(age -> Optional.of(age)
                                .filter(age1 -> Pattern.compile(Constants.AGE_REGEX).matcher(String.valueOf(age1)).matches())
                                .orElseThrow(() -> new RuntimeException("Invalid Age !!!"))));
    }
}

