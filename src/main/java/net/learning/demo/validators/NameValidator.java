package net.learning.demo.validators;

import com.sun.jdi.InternalException;
import net.learning.demo.common.IValidator;
import net.learning.demo.model.DataHolder;
import net.learning.demo.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class NameValidator implements IValidator<DataHolder> {

    /**
     * Name must be entirely of one or more alphabetic characters or whitespace characters, from the beginning to the end of the string.
     *
     * @param dataHolder the input argument.
     */
    @Override
    public void accept(DataHolder dataHolder) {
        Optional.ofNullable(dataHolder)
                .map(dataHolder1 -> Optional.ofNullable(dataHolder1.getName())
                        .filter(name2 -> !name2.isEmpty())
                        .map(name1 -> Optional.of(name1)
                                .filter(name -> Pattern.compile(Constants.NAME_REGEX).matcher(name).matches())
                                .orElseThrow(() -> new RuntimeException("Invalid Name !!!")))
                        .orElseThrow(() -> new RuntimeException("Name is missing")));
    }
}
