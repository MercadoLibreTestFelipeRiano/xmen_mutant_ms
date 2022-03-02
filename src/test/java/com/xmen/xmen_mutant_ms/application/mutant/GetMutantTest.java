package com.xmen.xmen_mutant_ms.application.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.stats.Stats;
import com.xmen.xmen_mutant_ms.domain.gateway.mutant.MutantGateway;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetMutantTest {

    @InjectMocks
    private GetMutant getMutant;

    @Mock
    private MutantGateway mutantGateway;

    @Test
    void testGetStatsMutants() {
        Long countMutantDna = Long.valueOf(10),
                countHumanDna = Long.valueOf(20);
        Double ratio = countMutantDna.doubleValue() / countHumanDna.doubleValue();

        Stats stats = Stats.builder()
                .countMutantDna(countMutantDna)
                .countHumanDna(countHumanDna)
                .ratio(ratio)
                .build();

        Mockito.when(mutantGateway.getCountMutants()).thenReturn(countMutantDna);
        Mockito.when(mutantGateway.getCountMutantsAndNonMutants()).thenReturn(countMutantDna + countHumanDna);

        Stats statsResult  = getMutant.getStatsMutants();

        Assert.assertEquals(statsResult.getCountMutantDna(), stats.getCountMutantDna());
        Assert.assertEquals(statsResult.getCountHumanDna(), stats.getCountHumanDna());
        Assert.assertEquals(statsResult.getRatio(), stats.getRatio());
    }
}
