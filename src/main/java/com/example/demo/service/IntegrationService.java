package com.example.demo.service;

import com.example.demo.dto.IntegrationUpdateDto;
import com.example.demo.entity.Integration;
import com.example.demo.repository.IntegrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class IntegrationService {

    private final IntegrationRepository integrationRepository;

    public List<Integration> getAllIntegration(){
        return integrationRepository.findAll();
    }

    public Integration saveIntegration(Integration integration){
        validateDuplicateIntegration(integration);
        return integrationRepository.save(integration);
    }

    public void deleteIntegration(Integration integration){
        integrationRepository.deleteById(integration.getId());
    }

    public Long updateIntegration(Long id, IntegrationUpdateDto integrationUpdateDto){
        Integration findIntegration = integrationRepository.findById(id).get();
        if(findIntegration == null){
            throw new IllegalArgumentException("해당 연계가 없습니다. id = "+id);
        }
        findIntegration.update(integrationUpdateDto);

        return id;
    }

    public Integration getIntegration(Long id){
        Integration findIntegration = integrationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 연계가 없습니다. id = "+id)
        );
        return findIntegration;
    }

    public List<Integration> getIntegrationByName(String name){
        List<Integration> integrationList = integrationRepository.findByIntegrationName(name);

        return integrationList;
    }


    public void validateDuplicateIntegration(Integration integration){
        Integration findIntegration = integrationRepository.findByIntegrationNameAndSenderAndReceiver(integration.getIntegrationName(), integration.getSender(), integration.getReceiver());
        if(findIntegration != null){
            throw new IllegalStateException("이미 등록된 연계(Integration)입니다");
        }
    }

}
