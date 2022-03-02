package com.xmen.xmen_mutant_ms.config;

import com.xmen.xmen_mutant_ms.application.dna.IsMutantDna;
import com.xmen.xmen_mutant_ms.application.dna.ValidateDna;
import com.xmen.xmen_mutant_ms.application.mutant.CreateMutant;
import com.xmen.xmen_mutant_ms.application.mutant.GetMutant;
import com.xmen.xmen_mutant_ms.domain.gateway.mutant.MutantGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseCofiguration {

    @Bean
    public GetMutant getMutant(MutantGateway mutantGateway){
        return new GetMutant(mutantGateway);
    }

    @Bean
    public CreateMutant createMutant(MutantGateway mutantGateway, ValidateDna validateDna, IsMutantDna isMutantDna){
        return new CreateMutant(validateDna, isMutantDna,mutantGateway);
    }

}
