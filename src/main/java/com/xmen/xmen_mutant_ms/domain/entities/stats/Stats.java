package com.xmen.xmen_mutant_ms.domain.entities.stats;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = false)
public class Stats {
    Long countMutantDna;
    Long countHumanDna;
    Double ratio;
}
