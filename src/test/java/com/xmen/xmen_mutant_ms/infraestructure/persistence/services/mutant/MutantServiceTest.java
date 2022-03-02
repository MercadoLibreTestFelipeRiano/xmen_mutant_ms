package com.xmen.xmen_mutant_ms.infraestructure.persistence.services.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.generator.ObjectGenerator;
import com.xmen.xmen_mutant_ms.infraestructure.persistence.entities.mutant.MutantDto;
import com.xmen.xmen_mutant_ms.infraestructure.persistence.repository.mutant.MutantRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MutantServiceTest {

    @InjectMocks
    private MutantService mutantService;

    @Mock
    private MutantRepository mutantRepository;

    @Test
    void testSaveMutant() {

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

        Mutant mutant = ObjectGenerator.createObject(Mutant.class).builder()
                .dna(dna)
                .build();

        MutantDto mutantDto = MutantDto.convertMutantToMutantDto(mutant);

        Mockito.when(mutantRepository.save(Mockito.any())).thenReturn(mutantDto);

        Mutant result = mutantService.saveMutant(mutant);

        Assert.assertEquals(result.getDna(), mutant.getDna());
        Assert.assertEquals(result.isMutant(), mutant.isMutant());

    }

    @Test
    void testGetCountMutants() {

        Long countMutants = Long.valueOf(10);

        Mockito.when(mutantRepository.countByIsMutant(Mockito.any())).thenReturn(Long.valueOf(10));

        Long result = mutantService.getCountMutants();

        Assert.assertEquals(result, countMutants);

    }

    @Test
    void testGetCountMutantsAndNonMutants() {

        Long countMutantsAndNonMutants = Long.valueOf(10);

        Mockito.when(mutantRepository.count()).thenReturn(Long.valueOf(10));

        Long result = mutantService.getCountMutantsAndNonMutants();

        Assert.assertEquals(result, countMutantsAndNonMutants);

    }

}
