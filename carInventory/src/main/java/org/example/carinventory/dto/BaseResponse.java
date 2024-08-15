package org.example.carinventory.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BaseResponse<T> {
    private final Boolean status;
    private final String message;
    private final T payload;
}
