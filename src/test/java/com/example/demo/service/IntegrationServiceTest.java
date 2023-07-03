package com.example.demo.service;

import com.example.demo.constant.IntegrationInOutType;
import com.example.demo.constant.IntegrationType;
import com.example.demo.dto.IntegrationDto;
import com.example.demo.dto.IntegrationUpdateDto;
import com.example.demo.entity.Integration;
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
class IntegrationServiceTest {

    @Autowired
    IntegrationService integrationService;

    @Test
    @DisplayName("saveIntegration 테스트")
    public void saveIntegration_테스트(){
        //given
        IntegrationDto integrationDto = new IntegrationDto();
        integrationDto.setIntegrationName("AGC 전송");
        integrationDto.setIntegrationType(IntegrationType.DB_LINK);
        integrationDto.setIntegrationInOutType(IntegrationInOutType.INNER);
        integrationDto.setSender("EMS");
        integrationDto.setReceiver("MMS");

        Integration integration = Integration.createintegration(integrationDto);

        //when
        integrationService.saveIntegration(integration);

        IntegrationDto integrationDto2 = new IntegrationDto();
        integrationDto2.setIntegrationName("AGC 전송");
        integrationDto2.setIntegrationType(IntegrationType.DB_LINK);
        integrationDto2.setIntegrationInOutType(IntegrationInOutType.INNER);
        integrationDto2.setSender("EMS");
        integrationDto2.setReceiver("MMS");

        Integration integration2 = Integration.createintegration(integrationDto2);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            integrationService.saveIntegration(integration2);
        });
        assertEquals("이미 등록된 연계(Integration)입니다", e.getMessage());
    }

    @Test
    @DisplayName("findAll 테스트")
    public void findAll_테스트(){
        this.saveIntegration_테스트();

        List<Integration> list = integrationService.getAllIntegration();

        assertEquals(list.size(), 1);
    }

    @Test
    @DisplayName("delete 테스트")
    public void delete_테스트(){
        this.saveIntegration_테스트();

        List<Integration> list = integrationService.getAllIntegration();

        integrationService.deleteIntegration(list.get(0));

        List<Integration> list2 = integrationService.getAllIntegration();

        assertEquals(list2.size(), 0);
    }

    @Test
    @DisplayName("update 테스트")
    public void update_테스트(){
        this.saveIntegration_테스트();
        List<Integration> list = integrationService.getIntegrationByName("AGC 전송");

        IntegrationUpdateDto updateIntegration =  new IntegrationUpdateDto();
        updateIntegration.setIntegrationName("AGC -> GC변경");
        updateIntegration.setIntegrationType(IntegrationType.DB_LINK);
        updateIntegration.setIntegrationInOutType(IntegrationInOutType.INNER);
        updateIntegration.setSender("EMS");
        updateIntegration.setReceiver("MMS");

        integrationService.updateIntegration(list.get(0).getId(), updateIntegration);

    }
}