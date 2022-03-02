package com.xmen.xmen_mutant_ms.application.dna;

import com.xmen.xmen_mutant_ms.domain.entities.dna.Dna;
import com.xmen.xmen_mutant_ms.domain.use_cases.dna.IsMutantDnaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class IsMutantDna implements IsMutantDnaUseCase {

    @Autowired
    private ValidateDna validateDna;

    @Override
    public Boolean isMutant(String[] dna) {

        Dna[][] dnaDatas = new Dna[dna.length][dna[0].length()];
        String[] row;
        Dna dnaDataItem;
        Integer result = 0;

        forY:
        for (int i = 0; i < dna.length; i++) {
            row = dna[i].split("");
            forX:
            for (int j = 0; j < row.length; j++) {

                dnaDataItem = Dna.builder()
                        .nitrogenBase(row[j])
                        .build();

                dnaDatas[i][j] = dnaDataItem;
                validateDna.assignNeighboringElementsInDnaMatrix(dnaDatas, dnaDataItem , j, i);
                result += validateDna.analyzeNeighboringElementsInDnaMatrix(dnaDataItem);
                if (result.intValue() > 1) return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
