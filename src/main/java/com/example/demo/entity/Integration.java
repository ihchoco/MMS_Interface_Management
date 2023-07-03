package com.example.demo.entity;

import com.example.demo.constant.IntegrationInOutType;
import com.example.demo.constant.IntegrationType;
import com.example.demo.dto.IntegrationDto;
import com.example.demo.dto.IntegrationUpdateDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "integration")
@Getter
@Setter
@ToString
public class Integration {

    @Id
    @Column(name = "integration_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private IntegrationInOutType interfaceInOutType;

    @Column(name = "integration_name", nullable = false)
    private String integrationName;

    @Column(name = "integration_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private IntegrationType integrationType;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "tobe_manager")
    private String tobeManager;

    @Column(name = "confirmed_flag")
    private String confirmedFlag;

    @Column(name = "delete_flag")
    private String deleteFlag;

    @Column(name = "integrated_flag")
    private String integratedFlag;

    @Column(name = "comment")
    private String comment;

    @Column(name = "description")
    private String description;

    public static Integration createintegration(IntegrationDto integrationDto){
        Integration integration = new Integration();
        integration.setInterfaceInOutType(integrationDto.getIntegrationInOutType());
        integration.setIntegrationName(integrationDto.getIntegrationName());
        integration.setIntegrationType(integrationDto.getIntegrationType());
        integration.setSender(integrationDto.getSender());
        integration.setReceiver(integrationDto.getReceiver());
        integration.setTobeManager(integrationDto.getTobeManager());
        integration.setConfirmedFlag(integrationDto.getConfirmedFlag());
        integration.setDeleteFlag(integrationDto.getDeleteFlag());
        integration.setIntegratedFlag(integrationDto.getIntegratedFlag());
        integration.setComment(integrationDto.getComment());
        integration.setDescription(integrationDto.getDescription());

        return integration;
    }

    public void update(IntegrationUpdateDto integrationUpdateDto){
        this.setInterfaceInOutType(integrationUpdateDto.getIntegrationInOutType());
        this.setIntegrationName(integrationUpdateDto.getIntegrationName());
        this.setIntegrationType(integrationUpdateDto.getIntegrationType());
        this.setSender(integrationUpdateDto.getSender());
        this.setReceiver(integrationUpdateDto.getReceiver());
        this.setTobeManager(integrationUpdateDto.getTobeManager());
        this.setConfirmedFlag(integrationUpdateDto.getConfirmedFlag());
        this.setDeleteFlag(integrationUpdateDto.getDeleteFlag());
        this.setIntegratedFlag(integrationUpdateDto.getIntegratedFlag());
        this.setComment(integrationUpdateDto.getComment());
        this.setDescription(integrationUpdateDto.getDescription());
    }




}
