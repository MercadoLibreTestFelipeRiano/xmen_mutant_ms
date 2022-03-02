package com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class ResponseError {
    String Error;
}
