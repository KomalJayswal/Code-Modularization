package net.learning.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OhmErrors {

    private String errorCode;
    private String errorMessage;
    private String tag;
    private String technicalMessage;
}
