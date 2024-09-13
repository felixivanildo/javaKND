package com.eventotec.api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventotec.api.domain.imov.Imovel;
import com.eventotec.api.domain.imov.ImovelRequestDTO;
import com.eventotec.api.domain.imov.ImovelUpdateDTO;
import com.eventotec.api.repositories.HousesRepository;

@Service
public class ImovelService {
    
    @Autowired
    private HousesRepository housesRepository;


    public Imovel creatImovel (ImovelRequestDTO data){

        Imovel newImv = new Imovel();

        newImv.setAndar(data.andar());
        newImv.setBloco(data.bloco());
        newImv.setCreatedAt(LocalDate.now());
        newImv.setDescricao(data.descricao());
        newImv.setNumeroCasa(data.numero_casa());
        newImv.setRua(data.rua());
        newImv.setExclusao(data.ic_exclusao());

        return housesRepository.save(newImv);
    }



    public Imovel updatImovel (Integer id, ImovelUpdateDTO data){
        
        Optional<Imovel> existImovel =  housesRepository.findById(id);

        

       if(existImovel.isPresent()){
            Imovel existingImovel = existImovel.get();

            existingImovel.setAndar(data.andar());
            existingImovel.setBloco(data.bloco());
            existingImovel.setDescricao(data.descricao());
            existingImovel.setExclusao(data.ic_exclusao());
            existingImovel.setRua(data.rua());
            existingImovel.setNumeroCasa(data.numero_casa());

            return housesRepository.save(existingImovel);

       }else {

           
         return null;
       }
    
           
        
      

        

        
    }




    public List<Imovel> getallImovels() {
        return housesRepository.findAll();
    }

    public Optional<Imovel> getallImovelByid(Integer id) {
        return housesRepository.findById(id);
    }

    public void deleteImovel (Integer id){
        housesRepository.deleteById(id);
    }
}
