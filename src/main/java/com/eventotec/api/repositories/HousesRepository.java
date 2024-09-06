package com.eventotec.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventotec.api.domain.imov.Imovel;

public interface HousesRepository extends JpaRepository <Imovel, Integer>{

    

    
}