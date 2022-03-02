package com.xmen.xmen_mutant_ms.application.mutant;

import com.xmen.xmen_mutant_ms.application.dna.IsMutantDna;
import com.xmen.xmen_mutant_ms.application.dna.ValidateDna;
import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.domain.gateway.mutant.MutantGateway;
import com.xmen.xmen_mutant_ms.generator.ObjectGenerator;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateMutantTest {

    @InjectMocks
    private CreateMutant createMutant;

    @Mock
    private IsMutantDna isMutantDna;

    @Mock
    private ValidateDna validateDna;

    @Mock
    private MutantGateway mutantGateway;

    @Test
    void testCreateThenTrowException() {

        Mutant mutant = ObjectGenerator.createObject(Mutant.class);

        Mockito.when(validateDna.checkDnaFormat(Mockito.any())).thenReturn(Boolean.FALSE);

        Assertions.assertThrows(Exception.class, () -> {
            createMutant.create(mutant);
        });

    }

    @SneakyThrows
    @Test
    void testCreateThenReturnMutant() {

        Mutant mutant = ObjectGenerator.createObject(Mutant.class)
                .toBuilder()
                .isMutant(Boolean.TRUE)
                .build();

        Mockito.when(validateDna.checkDnaFormat(Mockito.any())).thenReturn(Boolean.TRUE);
        Mockito.when(isMutantDna.isMutant(Mockito.any())).thenReturn(Boolean.TRUE);
        Mockito.when(mutantGateway.saveMutant(Mockito.any())).thenReturn(mutant);

        var mutantResponse = createMutant.create(mutant);

        Assert.assertEquals(mutant, mutantResponse);

    }

    @SneakyThrows
    @Test
    void testCreateThenReturnHuman() {

        Mutant mutant = ObjectGenerator.createObject(Mutant.class)
                .toBuilder()
                .isMutant(Boolean.TRUE)
                .build();

        Mockito.when(validateDna.checkDnaFormat(Mockito.any())).thenReturn(Boolean.TRUE);
        Mockito.when(isMutantDna.isMutant(Mockito.any())).thenReturn(Boolean.FALSE);
        Mockito.when(mutantGateway.saveMutant(Mockito.any())).thenReturn(mutant);

        var mutantResponse = createMutant.create(mutant);

        Assert.assertEquals(mutant, mutantResponse);

    }
}
