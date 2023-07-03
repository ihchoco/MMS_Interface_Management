package com.example.demo.dto;

import com.example.demo.constant.IntegrationInOutType;
import com.example.demo.constant.IntegrationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntegrationDto {

    private IntegrationInOutType integrationInOutType;

    private String integrationName;

    private IntegrationType integrationType;

    private String sender;

    private String receiver;

    private String tobeManager;

    private String confirmedFlag;

    private String deleteFlag;

    private String integratedFlag;

    private String comment;

    private String description;

}
