package com.xmen.xmen_mutant_ms.application.dna;

import com.xmen.xmen_mutant_ms.generator.ObjectGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IsMutantDnaTest {

    @InjectMocks
    private IsMutantDna isMutantDna;

    @Mock
    private ValidateDna validateDna;

    @Test
    void testIsMutantReturnFalse() {

        String[] dna = ObjectGenerator.createObject(String[].class);

        Mockito.when(validateDna.analyzeNeighboringElementsInDnaMatrix(Mockito.any())).thenReturn(0);

        var result = isMutantDna.isMutant(dna);

        Assert.assertEquals(result, Boolean.FALSE);

    }

    @Test
    void testIsMutantReturnTrue() {

        String[] dna = ObjectGenerator.createObject(String[].class);

        Mockito.when(validateDna.analyzeNeighboringElementsInDnaMatrix(Mockito.any())).thenReturn(1);

        var result = isMutantDna.isMutant(dna);

        Assert.assertEquals(result, Boolean.TRUE);

    }

}
