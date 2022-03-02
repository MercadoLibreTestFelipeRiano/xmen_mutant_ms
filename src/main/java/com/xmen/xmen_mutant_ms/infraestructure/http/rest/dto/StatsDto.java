package com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto;

import com.xmen.xmen_mutant_ms.domain.entities.stats.Stats;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = false)
public class StatsDto {

    Long count_mutant_dna;
    Long count_human_dna;
    Double ratio;

    public static StatsDto convertStatsToStatsDto(Stats stats){
        return StatsDto.builder()
                .count_mutant_dna(stats.getCountMutantDna())
                .count_human_dna(stats.getCountHumanDna())
                .ratio(stats.getRatio())
                .build();
    }
}
