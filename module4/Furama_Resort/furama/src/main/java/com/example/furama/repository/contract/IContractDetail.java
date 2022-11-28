package com.example.furama.repository.contract;

import com.example.furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetail extends JpaRepository<ContractDetail,Integer> {
}
