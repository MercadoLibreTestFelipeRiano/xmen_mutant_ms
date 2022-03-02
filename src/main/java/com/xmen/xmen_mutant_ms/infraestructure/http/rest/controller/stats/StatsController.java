package com.xmen.xmen_mutant_ms.infraestructure.http.rest.controller.stats;

import com.xmen.xmen_mutant_ms.domain.use_cases.mutant.GetMutantUseCase;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.StatsDto;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.response.ResponseDto;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.response.ResponseError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StatsController {

    @Autowired
    private GetMutantUseCase getMutantUseCase;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        try {

            StatsDto response = StatsDto.convertStatsToStatsDto(
                    getMutantUseCase.getStatsMutants()
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
