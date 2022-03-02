package com.xmen.xmen_mutant_ms.infraestructure.persistence.entities.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.generator.ObjectGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MutantDtoTest {

    @Test
    void testConvertMutantToMutantDto() {

        String[] dna = {
                "GTCGACGT",
                "CGGAAGCT",
                "CGCACACT",
                "ACTGAGTT",
                "CGGAATTT",
                "GTGACGGT",
                "ACTGAGCT",
                "GCTCATTT"
        };

        Mutant mutant = ObjectGenerator.createObject(Mutant.class).toBuilder()
                .dna(dna)
                .build();

        MutantDto result = MutantDto.convertMutantToMutantDto(mutant);

        Assert.assertEquals(mutant.isMutant(), result.isMutant());
        Assert.assertEquals(mutant.getCreatedAt(), result.getCreatedAt());
        Assert.assertEquals(mutant.getId(), result.getId());
        Assert.assertEquals(String.join(",", mutant.getDna()), result.getDna());

    }

    @Test
    void testConvertMutantDtoToMutant() {

        MutantDto mutantDto = ObjectGenerator.createObject(MutantDto.class);

        Mutant result = MutantDto.convertMutantDtoToMutant(mutantDto);

        Assert.assertEquals(mutantDto.isMutant(), result.isMutant());
        Assert.assertEquals(mutantDto.getCreatedAt(), result.getCreatedAt());
        Assert.assertEquals(mutantDto.getId(), result.getId());
        Assert.assertEquals(mutantDto.getDna(), result.getDna());

    }
}
