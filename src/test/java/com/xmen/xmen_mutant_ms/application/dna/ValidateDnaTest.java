package com.xmen.xmen_mutant_ms.application.dna;

import com.xmen.xmen_mutant_ms.domain.entities.dna.Dna;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ValidateDnaTest {

    @InjectMocks
    private ValidateDna validateDna;

    @Test
    void testCheckDnaFormateReturnTrue() {

        String[] dna = {
                "ATCA",
                "GGTA",
                "CAGT",
                "TCTA"
        };

        var result = validateDna.checkDnaFormat(dna);

        Assert.assertEquals(result, Boolean.TRUE);

    }

    @Test
    void testCheckDnaFormatReturnFalseWithWrongSize() {

        String[] dna = {
                "ATCA",
                "GGTA",
                "CAGT",
                "TCTAN"
        };

        var result = validateDna.checkDnaFormat(dna);

        Assert.assertEquals(result, Boolean.FALSE);

    }

    @Test
    void testCheckDnaFormatReturnFalseWithWrongBases() {

        String[] dna = {
                "ATCA",
                "GRTA",
                "CAGT",
                "TZAA"
        };

        var result = validateDna.checkDnaFormat(dna);

        Assert.assertEquals(result, Boolean.FALSE);

    }

    @Test
    void testAssignNeighboringElementsInDnaMatrix() {

        Dna[][] matrix = {
                {
                    Dna.builder()
                            .nitrogenBase("A")
                            .build(),
                    Dna.builder()
                            .nitrogenBase("G")
                            .build(),
                },
                {
                    Dna.builder()
                            .nitrogenBase("A")
                            .build(),
                    Dna.builder()
                            .nitrogenBase("A")
                            .build()
                }
        };

        Dna item = matrix[1][1];

        Integer indexX = 1, indexY = 1;

        validateDna.assignNeighboringElementsInDnaMatrix(matrix, item,indexX, indexY);

        Assert.assertEquals(matrix[1][1].getNitrogenBase(), "A");
        Assert.assertEquals(matrix[1][1].getLeft().getNitrogenBase(), "A");
        Assert.assertEquals(matrix[1][1].getTopLeft().getNitrogenBase(), "A");

    }

    @Test
    void testAssignNeighboringElementsInDnaMatrixOppositeDiagonal() {

        Dna[][] matrix = {
                {
                        Dna.builder()
                                .nitrogenBase("A")
                                .build(),
                        Dna.builder()
                                .nitrogenBase("G")
                                .build(),
                },
                {
                        Dna.builder()
                                .nitrogenBase("G")
                                .build(),
                        Dna.builder()
                                .nitrogenBase("T")
                                .build()
                }
        };

        Dna item = matrix[1][0];

        Integer indexX = 0, indexY = 1;

        validateDna.assignNeighboringElementsInDnaMatrix(matrix, item,indexX, indexY);

        Assert.assertEquals(matrix[1][0].getNitrogenBase(), "G");
        Assert.assertEquals(matrix[1][0].getTopRight().getNitrogenBase(), "G");

    }

    @Test
    void testAnalyzeNeighboringElementsInDnaMatrixLeft() {

        Dna dna = Dna.builder()
                .nitrogenBase("A")
                .left(Dna.builder()
                        .nitrogenBase("A")
                        .left(Dna.builder()
                                .nitrogenBase("A")
                                .left(Dna.builder()
                                        .nitrogenBase("A")
                                        .build())
                                .build())
                        .build())
                .build();

        var result = validateDna.analyzeNeighboringElementsInDnaMatrix(dna);

        Assert.assertEquals(result,  1);

    }

    @Test
    void testAnalyzeNeighboringElementsInDnaMatrixTopLeft() {

        Dna dna = Dna.builder()
                .nitrogenBase("A")
                .topLeft(Dna.builder()
                        .nitrogenBase("A")
                        .topLeft(Dna.builder()
                                .nitrogenBase("A")
                                .topLeft(Dna.builder()
                                        .nitrogenBase("A")
                                        .build())
                                .build())
                        .build())
                .build();

        var result = validateDna.analyzeNeighboringElementsInDnaMatrix(dna);

        Assert.assertEquals(result,  1);

    }

    @Test
    void testAnalyzeNeighboringElementsInDnaMatrixTop() {

        Dna dna = Dna.builder()
                .nitrogenBase("A")
                .top(Dna.builder()
                        .nitrogenBase("A")
                        .top(Dna.builder()
                                .nitrogenBase("A")
                                .top(Dna.builder()
                                        .nitrogenBase("A")
                                        .build())
                                .build())
                        .build())
                .build();

        var result = validateDna.analyzeNeighboringElementsInDnaMatrix(dna);

        Assert.assertEquals(result,  1);

    }

    @Test
    void testAnalyzeNeighboringElementsInDnaMatrixTopRight() {

        Dna dna = Dna.builder()
                .nitrogenBase("A")
                .topRight(Dna.builder()
                        .nitrogenBase("A")
                        .topRight(Dna.builder()
                                .nitrogenBase("A")
                                .topRight(Dna.builder()
                                        .nitrogenBase("A")
                                        .build())
                                .build())
                        .build())
                .build();

        var result = validateDna.analyzeNeighboringElementsInDnaMatrix(dna);

        Assert.assertEquals(result,  1);

    }

    @Test
    void testAnalyzeNeighboringElementsInDnaMatrixReturn0() {

        Dna dna = Dna.builder()
                .nitrogenBase("A")
                .build();

        var result = validateDna.analyzeNeighboringElementsInDnaMatrix(dna);

        Assert.assertEquals(result,  0);

    }
}
