package com.xmen.xmen_mutant_ms;

import com.xmen.xmen_mutant_ms.application.mutant.GetMutant;
import com.xmen.xmen_mutant_ms.domain.use_cases.mutant.GetMutantUseCase;
import com.xmen.xmen_mutant_ms.infraestructure.persistence.services.mutant.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class XmenMutantMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(XmenMutantMsApplication.class, args);
	}
}
