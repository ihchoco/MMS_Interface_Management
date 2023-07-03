package com.example.demo.repository;

import com.example.demo.constant.IntegrationInOutType;
import com.example.demo.constant.IntegrationType;
import com.example.demo.dto.IntegrationDto;
import com.example.demo.entity.Integration;
import com.example.demo.service.IntegrationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
class IntegrationRepositoryTest {

    @Autowired
    IntegrationRepository repository;

    @Test
    @DisplayName("save 테스트")
    public void Integration_save테스트(){
        IntegrationDto integrationDto = new IntegrationDto();
        integrationDto.setIntegrationName("AGC 전송");
        integrationDto.setIntegrationType(IntegrationType.DB_LINK);
        integrationDto.setIntegrationInOutType(IntegrationInOutType.INNER);
        integrationDto.setSender("EMS");
        integrationDto.setReceiver("MMS");

        Integration integration = Integration.createintegration(integrationDto);
        repository.save(integration);
    }

    @Test
    @DisplayName("find 테스트")
    public void Integration_select테스트(){
        //given
        this.Integration_save테스트();

        //when
        //Integration findIntegration = repository.findByIntegrationName("AGC 전송");
        List<Integration> integrationList = repository.findByIntegrationName("AGC 전송");

        //then
        //Assertions.assertThat(findIntegration.getIntegrationName()).isEqualTo("AGC 전송");
        Assertions.assertThat(integrationList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("validate 테스트")
    public void Integration_validate테스트(){
        //given
        this.Integration_save테스트();

        //when
        //Integration findIntegration = repository.findByIntegrationName("AGC 전송");
        Integration findIntegration = repository.findByIntegrationNameAndSenderAndReceiver("AGC 전송", "EMS", "MMS");

        //then
        Assertions.assertThat(findIntegration.getIntegrationName()).isEqualTo("AGC 전송");
    }



}