package com.xmen.xmen_mutant_ms.infraestructure.persistence.entities.mutant;

import com.xmen.xmen_mutant_ms.domain.entities.mutant.Mutant;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Entity
@Table(name = "mutant", indexes = {
        @Index(name = "is_mutant_INDEX", columnList = "is_mutant")
})
public class MutantDto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "dna", nullable = false)
    private String dna;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "is_mutant", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isMutant;

    public static Mutant convertMutantDtoToMutant(MutantDto mutantDto){
        return Mutant.builder()
                .id(mutantDto.id)
                .dna(Objects.equals(null, mutantDto.dna) ? null :mutantDto.dna.split(","))
                .createdAt(mutantDto.createdAt)
                .isMutant(mutantDto.isMutant)
                .build();
    }

    public static MutantDto convertMutantToMutantDto(Mutant mutant){

        MutantDto mutantDto = new MutantDto();

        mutantDto.id = mutant.getId();
        mutantDto.dna = Objects.equals(null, mutant.getDna()) ? null : String.join(",",mutant.getDna());
        mutantDto.createdAt = mutant.getCreatedAt();
        mutantDto.isMutant = mutant.isMutant();

        return mutantDto;
    }

}
