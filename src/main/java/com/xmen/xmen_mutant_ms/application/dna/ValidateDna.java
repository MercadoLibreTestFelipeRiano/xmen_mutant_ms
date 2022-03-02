package com.xmen.xmen_mutant_ms.application.dna;

import com.xmen.xmen_mutant_ms.domain.entities.dna.Dna;
import com.xmen.xmen_mutant_ms.domain.use_cases.dna.ValidateDnaUseCase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ValidateDna implements ValidateDnaUseCase {

    @Override
    public Boolean checkDnaFormat(String[] dna) {

        List<String> nitrogenousBases = new ArrayList<>();
        nitrogenousBases.add("A");
        nitrogenousBases.add("T");
        nitrogenousBases.add("C");
        nitrogenousBases.add("G");
        String[] row;

        for (int i = 0; i < dna.length; i++) {
            if (dna[i].length() != dna.length) {
                return Boolean.FALSE;
            }
            row = dna[i].split("");
            for (int j = 0; j < row.length; j++){
                if(!nitrogenousBases.contains(row[j])){
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public void assignNeighboringElementsInDnaMatrix(Dna[][] matrix, Dna item, Integer indexX, Integer indexY) {

        var leftCondition = (indexX > 0);
        var rightCondition = (indexX < (matrix[0].length - 1));
        var topCondition = (indexY > 0);

        item.setTopRight(
                (topCondition
                && rightCondition
                && (matrix[indexY - 1][indexX + 1].getNitrogenBase().equals(item.getNitrogenBase())))
                ? matrix[indexY - 1][indexX + 1]
                : null
        );

        item.setTopLeft(
                (topCondition
                && leftCondition
                && (matrix[indexY - 1][indexX - 1].getNitrogenBase().equals(item.getNitrogenBase())))
                ? matrix[indexY - 1][indexX - 1]
                : null
        );

        item.setTop(
                (topCondition
                && (matrix[indexY - 1][indexX].getNitrogenBase().equals(item.getNitrogenBase())))
                ? matrix[indexY - 1][indexX]
                : null
        );

        item.setLeft(
                (leftCondition
                && (matrix[indexY][indexX - 1].getNitrogenBase().equals(item.getNitrogenBase())))
                ? matrix[indexY][indexX - 1]
                : null
        );

    }

    @Override
    public int analyzeNeighboringElementsInDnaMatrix(Dna dna) {

        var left = dna.getLeft();
        var topLeft = dna.getTopLeft();
        var top = dna.getTop();
        var topRight = dna.getTopRight();

        Integer leftCount = 1, topLeftCount = 1, topCount = 1, topRightCount = 1, result = 0;

        while (Objects.nonNull(left) || Objects.nonNull(topLeft) || Objects.nonNull(top)
                || Objects.nonNull(topRight)) {
            if (Objects.nonNull(left)) {
                left = left.getLeft();
                leftCount++;
            }
            if (Objects.nonNull(topLeft)) {
                topLeft = topLeft.getTopLeft();
                topLeftCount++;
            }
            if (Objects.nonNull(top)) {
                top = top.getTop();
                topCount++;
            }
            if (Objects.nonNull(topRight)) {
                topRight = topRight.getTopRight();
                topRightCount++;
            }
        }

        if (!leftCount.equals(0) && leftCount % 4 == 0)
            result++;
        if (!topLeftCount.equals(0) && topLeftCount % 4 == 0)
            result++;
        if (!topCount.equals(0) && topCount % 4 == 0)
            result++;
        if (!topRightCount.equals(0) && topRightCount % 4 == 0)
            result++;

        return result;

    }

}
