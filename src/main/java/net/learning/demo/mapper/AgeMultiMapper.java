package net.learning.demo.mapper;

import net.learning.demo.common.IMultiMapper;
import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AgeMultiMapper implements IMultiMapper<DataHolder, String> {
    @Override
    public DataHolder apply(DataHolder dataHolder, String name) {
        return Optional.ofNullable(name)
                .filter(n -> !n.isEmpty())
                .map(n -> {
                    dataHolder.setName(n);
                    return dataHolder;
                })
                .orElse(dataHolder);
    }
}
