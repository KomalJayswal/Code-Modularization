package net.learning.demo.service;

import net.learning.demo.mapper.MultipleNameMapper;
import net.learning.demo.mapper.DefaultAgeMapper;
import net.learning.demo.model.DataHolder;
import net.learning.demo.validators.AgeValidator;
import net.learning.demo.validators.NameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.learning.demo.common.Orch.map;
import static net.learning.demo.common.Orch.validate;

@Service
public class DemoService {

    @Autowired
    private NameValidator nameValidator;
    @Autowired
    private AgeValidator ageValidator;
    @Autowired
    private MultipleNameMapper multipleNameMapper;
    @Autowired
    private DefaultAgeMapper defaultAgeMapper;

    public DataHolder submit(DataHolder dataHolder) {

        validate(nameValidator, dataHolder);
        validate(ageValidator, dataHolder);

        map(multipleNameMapper, dataHolder, "admin");
        map(defaultAgeMapper, dataHolder);
      

        return dataHolder;
    }
}