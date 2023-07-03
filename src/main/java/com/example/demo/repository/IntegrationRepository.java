package com.example.demo.repository;

import com.example.demo.entity.Integration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IntegrationRepository extends JpaRepository<Integration, Long> {

    //List<Integration> findByIntegrationName(String integrationName);

    @Query(value = "select i from Integration i where i.integrationName like %:integrationName% order by i.id")
    List<Integration> findByIntegrationName(@Param("integrationName") String integrationName);

    Integration findByIntegrationNameAndSenderAndReceiver(String integrationName, String sender, String receiver);

}
