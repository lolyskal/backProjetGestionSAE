package com.controller;


import com.dto.OrdreEnseignementDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.OrdreEnseignementService;

import java.util.List;


@RestController
@RequestMapping("/ordreEnseignement")
@AllArgsConstructor
public class OrdreEnseignementController {

    @Autowired
    private final OrdreEnseignementService ordreEnseignementService;

    @GetMapping("/ordreEnseignements")
    @ResponseBody
    public List<OrdreEnseignementDto> findAll()
    {
        return ordreEnseignementService.findAll();
    }
    @PostMapping("/ordreEnseignementSave")
    @ResponseBody
    public OrdreEnseignementDto save(@RequestBody OrdreEnseignementDto ordreEnseignementDto)
    {
        return ordreEnseignementService.save(ordreEnseignementDto);
    }
    @PutMapping("/update/{codeOrdreEnseignement}")
    @ResponseBody
    public OrdreEnseignementDto update(@PathVariable String code, @RequestBody OrdreEnseignementDto ordreEnseignementDto){
        return ordreEnseignementService.update( code, ordreEnseignementDto);
    }
    @DeleteMapping("supprimerOrdreEnseignement/{code}")
    @ResponseBody
    public void delete(@PathVariable  String code)
    {
        ordreEnseignementService.delete(code);
    }

}
