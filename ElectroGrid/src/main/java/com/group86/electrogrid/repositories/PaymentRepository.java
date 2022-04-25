package com.group86.electrogrid.repositories;

import com.group86.electrogrid.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment , Long>{

}
