package com.xmen.xmen_mutant_ms.infraestructure.persistence.services.mutant;

import com.xmen.xmen_mutant_ms.domain.gateway.mutant.MutantGateway;
import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.infraestructure.persistence.entities.mutant.MutantDto;
import com.xmen.xmen_mutant_ms.infraestructure.persistence.repository.mutant.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService implements MutantGateway {

    @Autowired
    private MutantRepository mutantRepository;

    @Override
    public Mutant saveMutant(Mutant mutant) {
        return MutantDto.convertMutantDtoToMutant(
                mutantRepository.save(MutantDto.convertMutantToMutantDto(mutant))
        );
    }

    @Override
    public Long getCountMutants() {
        return mutantRepository.countByIsMutant(true);
    }

    @Override
    public Long getCountMutantsAndNonMutants() {
        return mutantRepository.count();
    }

}
