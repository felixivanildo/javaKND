package com.eventotec.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventotec.api.domain.imov.Imovel;
import com.eventotec.api.domain.imov.ImovelFindDTO;
import com.eventotec.api.domain.imov.ImovelRequestDTO;
import com.eventotec.api.domain.imov.ImovelUpdateDTO;
import com.eventotec.api.services.ImovelService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;


    @PostMapping("/inserir")
    public ResponseEntity postImovel(@RequestBody ImovelRequestDTO data) {
        Imovel newImovel = imovelService.creatImovel(data);
        
        return ResponseEntity.ok(newImovel);
    }


    @GetMapping("/consultar")
    public ResponseEntity<List<Imovel>> getallImovels() {
        List<Imovel> imoveis = imovelService.getallImovels();
       
        return ResponseEntity.ok(imoveis);
    }
    

    @PostMapping("/consultar/id")
    public ResponseEntity<Imovel> getallImovelsId(@RequestBody ImovelFindDTO  data) {
        Imovel imoveis = imovelService.getallImovelByid(data.id());
       
        return ResponseEntity.ok(imoveis);
    }

    @PostMapping("/deletar")
    public ResponseEntity deleteImovelsId(@RequestBody ImovelFindDTO  data) {
        Integer id = data.id();
       
        imovelService.deleteImovel(id);
         Map<String, String> response = new HashMap<>();
        response.put("MESSAGE", "DELETED");

        return ResponseEntity.ok(response);
    }



    @PostMapping("/atualizar")
    public ResponseEntity updateImovel(@RequestBody ImovelUpdateDTO data) {
        Integer id = data.id();

        Imovel imovel = imovelService.updatImovel(id, data);
        
        return ResponseEntity.ok(imovel);
    }
    
    
}
