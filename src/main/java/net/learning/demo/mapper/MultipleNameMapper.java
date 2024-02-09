package net.learning.demo.mapper;

import net.learning.demo.common.IMultiMapper;
import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MultipleNameMapper implements IMultiMapper<DataHolder, String> {

    /**
     * Add multiple Names.
     *
     * @param dataHolder the input data.
     * @param name       the from request payload.
     * @return dataHolder.
     */
    @Override
    public DataHolder apply(DataHolder dataHolder, String name) {
        return Optional.ofNullable(name)
                .filter(n -> !n.isEmpty())
                .map(n -> {
                    dataHolder.setName(dataHolder.getName().concat(", ").concat(n));
                    return dataHolder;
                })
                .orElse(dataHolder);
    }
}
