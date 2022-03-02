package com.xmen.xmen_mutant_ms.application.mutant;

import com.xmen.xmen_mutant_ms.application.dna.IsMutantDna;
import com.xmen.xmen_mutant_ms.application.dna.ValidateDna;
import com.xmen.xmen_mutant_ms.domain.entities.dna.Dna;
import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.domain.gateway.mutant.MutantGateway;
import com.xmen.xmen_mutant_ms.domain.use_cases.mutant.CreateMutantUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateMutant implements CreateMutantUseCase {

    private final ValidateDna validateDna;
    private final IsMutantDna isMutantDna;

    private final MutantGateway mutantGateway;


    @Override
    public Mutant create(Mutant mutant) throws Exception {

        if (!validateDna.checkDnaFormat(mutant.getDna())){
            throw new Exception(
                    "The entered DNA chain does not match the parameters, check if the chain dimension is NxN or if the nitrogenous bases belong to the set ( A, T, C, G )."
            );
        }

        mutant.setMutant(isMutantDna.isMutant(mutant.getDna()));

        return mutantGateway.saveMutant(mutant);

    }
}
