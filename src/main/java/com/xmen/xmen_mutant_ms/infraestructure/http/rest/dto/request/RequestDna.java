package com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class RequestDna {
    String[] dna;
}
