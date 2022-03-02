package com.xmen.xmen_mutant_ms.domain.use_cases.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.stats.Stats;
import org.springframework.stereotype.Repository;

@Repository
public interface GetMutantUseCase {
    Stats getStatsMutants();
}
