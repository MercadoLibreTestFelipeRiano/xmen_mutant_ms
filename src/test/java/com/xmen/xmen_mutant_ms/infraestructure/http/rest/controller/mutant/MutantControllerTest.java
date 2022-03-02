package com.xmen.xmen_mutant_ms.infraestructure.http.rest.controller.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.domain.use_cases.mutant.CreateMutantUseCase;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.request.RequestDna;
import com.xmen.xmen_mutant_ms.infraestructure.http.rest.dto.response.ResponseDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class MutantControllerTest {

    @Mock
    private MutantController mutantController;

    @Test
    void testCreateMutantThenReturnOk(){

        String[] dna = {
                "GTCGACGT",
                "CGGAAGCT",
                "CGCACACT",
                "ACTGAGTT",
                "CGGAATTT",
                "GTGACGGT",
                "ACTGAGCT",
                "GCTCATTT",
        };

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        Mutant mutant  = Mutant.builder()
                .id(UUID.randomUUID())
                .dna(dna)
                .createdAt(new Date())
                .isMutant(Boolean.TRUE)
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .status(200)
                .data(mutant)
                .build();

        ResponseEntity responseEntity = ResponseEntity.ok().body(responseDto);

        RequestDna requestDna = new RequestDna();
        requestDna.setDna(dna);

        Mockito.when(mutantController.createMutant(requestDna)).thenReturn(responseEntity);

        ResponseEntity result = mutantController.createMutant(requestDna);

        Assert.assertEquals(result.getStatusCodeValue(), 200);

    }

    @Test
    void testCreateMutantThenReturnForbidden(){

        String uri = "/mutant";
        String[] dna = {
                "GTCGACGT",
                "CGGAAGCT",
                "CGCACACTX",
                "ACTGAGTT",
                "CGGAATTT",
                "GTGACGGT",
                "ACTGAGCT",
                "GCTCATTT",
        };

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        Mutant mutant  = Mutant.builder()
                .id(UUID.randomUUID())
                .dna(dna)
                .createdAt(new Date())
                .isMutant(Boolean.TRUE)
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .status(403)
                .data(mutant)
                .build();

        ResponseEntity responseEntity = ResponseEntity.status(403).body(responseDto);

        RequestDna requestDna = new RequestDna();
        requestDna.setDna(dna);

        Mockito.when(mutantController.createMutant(requestDna)).thenReturn(responseEntity);

        ResponseEntity result = mutantController.createMutant(requestDna);

        Assert.assertEquals(result.getStatusCodeValue(), 403);

    }

}
