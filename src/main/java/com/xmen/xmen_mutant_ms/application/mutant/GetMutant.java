package com.xmen.xmen_mutant_ms.application.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.stats.Stats;
import com.xmen.xmen_mutant_ms.domain.gateway.mutant.MutantGateway;
import com.xmen.xmen_mutant_ms.domain.use_cases.mutant.GetMutantUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetMutant implements GetMutantUseCase {

    private final MutantGateway mutantGateway;

    @Override
    public Stats getStatsMutants() {

        Long countMutantsAndNonMutants = mutantGateway.getCountMutantsAndNonMutants(),
                countMutants = mutantGateway.getCountMutants(),
                countMutantDna = countMutants,
                countHumanDna = countMutantsAndNonMutants - countMutants;
        Double ratio =  countMutantDna.doubleValue() / countHumanDna.doubleValue();

        return Stats.builder()
                .countMutantDna(countMutantDna)
                .countHumanDna(countHumanDna)
                .ratio(ratio)
                .build();

    }

}
