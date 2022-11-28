package com.example.furama.repository.facility;

import com.example.furama.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {

}
