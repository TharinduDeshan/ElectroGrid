package com.group86.electrogrid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group86.electrogrid.models.MonthlyBill;

@Repository
public interface MonthlyBillRepository extends JpaRepository<MonthlyBill , Long>{

}
