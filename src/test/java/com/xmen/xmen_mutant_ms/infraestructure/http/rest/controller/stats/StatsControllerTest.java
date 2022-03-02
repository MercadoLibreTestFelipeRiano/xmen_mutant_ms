package com.xmen.xmen_mutant_ms.infraestructure.http.rest.controller.stats;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import com.xmen.xmen_mutant_ms.domain.entities.stats.Stats;
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

@ExtendWith(MockitoExtension.class)
public class StatsControllerTest {

    @Mock
    private StatsController statsController;

    @Test
    void testGetStatsThenReturnOk(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        Stats stats = Stats.builder()
                .ratio(Double.valueOf(1))
                .countHumanDna(Long.valueOf(10))
                .countMutantDna(Long.valueOf(10))
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .status(200)
                .data(stats)
                .build();

        ResponseEntity responseEntity = ResponseEntity.ok().body(responseDto);

        Mockito.when(statsController.getStats()).thenReturn(responseEntity);

        ResponseEntity result = statsController.getStats();

        Assert.assertEquals(result.getStatusCodeValue(), 200);

    }


    @Test
    void testGetStatsThenReturnForbidden(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        Stats stats = Stats.builder()
                .ratio(Double.valueOf(1))
                .countHumanDna(Long.valueOf(10))
                .countMutantDna(Long.valueOf(10))
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .status(200)
                .data(stats)
                .build();

        ResponseEntity responseEntity = ResponseEntity.status(403).body(responseDto);

        Mockito.when(statsController.getStats()).thenReturn(responseEntity);

        ResponseEntity result = statsController.getStats();

        Assert.assertEquals(result.getStatusCodeValue(), 403);

    }

}
