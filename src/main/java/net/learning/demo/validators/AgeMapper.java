package net.learning.demo.validators;

import net.learning.demo.model.DataHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgeMapper implements IMapper<DataHolder,String>  {

@Override
public DataHolder apply(DataHolder dataHolder, String val) {
        return Optional.ofNullable(dataHolder)
                .map(data -> {
                        data.setName("abhijit");
                        data.setAge(55);
                }).orElse(dataHolder);

        return dataHolder;

        }
}
