package com.xmen.xmen_mutant_ms.domain.entities.mutant;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Mutant {

    private UUID id;
    private String[] dna;
    private Date createdAt;
    private boolean isMutant;

}
