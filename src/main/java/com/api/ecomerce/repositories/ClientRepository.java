package com.api.ecomerce.repositories;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<IntegrationProperties.RSocket.Client,UUID> {
}
