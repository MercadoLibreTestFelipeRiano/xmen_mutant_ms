package com.xmen.xmen_mutant_ms.config;

import com.xmen.xmen_mutant_ms.application.dna.IsMutantDna;
import com.xmen.xmen_mutant_ms.application.dna.ValidateDna;
import com.xmen.xmen_mutant_ms.domain.gateway.mutant.MutantGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UseCaseConfigurationTest {

    @InjectMocks
    private UseCaseCofiguration useCaseConfiguration;

    @Mock
    private MutantGateway mutantGateway;

    @Mock
    private ValidateDna validateDna;

    @Mock
    private IsMutantDna isMutantDna;

    @Test
    void testGetMutant(){
        assertNotNull(useCaseConfiguration.getMutant(mutantGateway));
    }

    @Test
    void testCreateMutant(){
        assertNotNull(
                useCaseConfiguration.createMutant(
                        mutantGateway,validateDna,isMutantDna
                )
        );
    }

}
