package net.learning.demo.mapper;

import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Optional;

@Service
public class AgeMapper implements IMapper<DataHolder,String> {
    @Override
    public DataHolder apply(DataHolder dataHolder, String s) {
        return Optional.ofNullable(dataHolder)
                .map(data -> new DataHolder(s,55))
                .orElse(dataHolder);
    }
}


/**/