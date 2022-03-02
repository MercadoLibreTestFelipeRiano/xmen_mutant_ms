package com.xmen.xmen_mutant_ms.domain.gateway.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;

public interface MutantGateway {

    Mutant saveMutant(Mutant mutant);
    Long getCountMutants();
    Long getCountMutantsAndNonMutants();

}
