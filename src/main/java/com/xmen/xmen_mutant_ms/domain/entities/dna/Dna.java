package com.xmen.xmen_mutant_ms.domain.entities.dna;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Dna {

    String nitrogenBase;
    Dna topLeft;
    Dna topRight;
    Dna top;
    Dna left;

}
