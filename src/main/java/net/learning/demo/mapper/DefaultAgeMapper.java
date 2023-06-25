package net.learning.demo.mapper;

import net.learning.demo.common.IMapper;
import net.learning.demo.model.DataHolder;
import net.learning.demo.utils.Constants;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class DefaultAgeMapper implements IMapper<DataHolder, DataHolder> {

    @Override
    public DataHolder apply(DataHolder dataHolder) {
        return Optional.ofNullable(dataHolder)
                .map(dataHolder1 -> {
                    dataHolder.setAge(Constants.DEFAULT_AGE);
                    return dataHolder;
                })
                .orElse(dataHolder);
    }
}
