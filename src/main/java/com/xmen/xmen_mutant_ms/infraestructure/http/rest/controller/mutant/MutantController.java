package com.xmen.xmen_mutant_ms.infraestructure.http.rest.controller.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.domain.use_cases.mutant.CreateMutantUseCase;
import com.xmen.xmen_mutant_ms.domain.use_cases.mutant.GetMutantUseCase;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.request.RequestDna;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.response.ResponseDto;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.response.ResponseError;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.StatsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MutantController {

    @Autowired
    private CreateMutantUseCase createMutantUseCase;

    @PostMapping("/mutant")
    public ResponseEntity<?> createMutant(@RequestBody RequestDna requestDna){
        try {
            Mutant response = createMutantUseCase.create(
                    Mutant.builder()
                            .dna(requestDna.getDna())
                            .build()
            );

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(
                            ResponseDto.builder()
                                    .status(200)
                                    .data(response)
                                    .build()
                    );
        }catch (Exception e){
            ResponseError error = ResponseError.builder()
                    .Error(e.getMessage())
                    .build();
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(
                            ResponseDto.builder()
                                    .status(403)
                                    .data(error)
                                    .build()
                    );
        }
    }


}
