package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepo extends JpaRepository<Client , Long> {



}
