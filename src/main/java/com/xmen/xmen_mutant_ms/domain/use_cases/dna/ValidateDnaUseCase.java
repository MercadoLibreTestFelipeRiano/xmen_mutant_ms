package com.xmen.xmen_mutant_ms.domain.use_cases.dna;

import com.xmen.xmen_mutant_ms.domain.entities.dna.Dna;

public interface ValidateDnaUseCase {
    Boolean checkDnaFormat(String[] dna);
    void assignNeighboringElementsInDnaMatrix(Dna[][] matrix, Dna item, Integer indexX, Integer indexY);
    int analyzeNeighboringElementsInDnaMatrix(Dna dna);
}
