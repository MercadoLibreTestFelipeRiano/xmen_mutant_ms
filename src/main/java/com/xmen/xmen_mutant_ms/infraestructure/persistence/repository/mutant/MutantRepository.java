package com.xmen.xmen_mutant_ms.infraestructure.persistence.repository.mutant;

import com.xmen.xmen_mutant_ms.infraestructure.persistence.entities.mutant.MutantDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MutantRepository extends JpaRepository<MutantDto, UUID>{

    long countByIsMutant(Boolean isMutant);

}
