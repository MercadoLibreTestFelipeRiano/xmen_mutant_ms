package com.xmen.xmen_mutant_ms.domain.use_cases.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateMutantUseCase {
    Mutant create(Mutant mutant) throws Exception;
}
