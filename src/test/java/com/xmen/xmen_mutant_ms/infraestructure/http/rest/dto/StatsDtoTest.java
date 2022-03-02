package com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto;

import com.xmen.xmen_mutant_ms.domain.entities.stats.Stats;
import com.xmen.xmen_mutant_ms.generator.ObjectGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StatsDtoTest {

    @Test
    void testConvertStatsDtoToStats() {

        Stats stats = ObjectGenerator.createObject(Stats.class);

        StatsDto statsDto = StatsDto.convertStatsToStatsDto(stats);

        Assert.assertEquals(stats.getRatio(), statsDto.getRatio());
        Assert.assertEquals(stats.getCountHumanDna(), statsDto.getCount_human_dna());
        Assert.assertEquals(stats.getCountMutantDna(), statsDto.getCount_mutant_dna());

    }
}
