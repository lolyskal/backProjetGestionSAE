package com.controller;

import com.dto.EtablissementDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.EtablissementService;

import java.util.List;


@RestController
@RequestMapping("/etablissement")
@AllArgsConstructor
public class EtablissementController {

@Autowired
    private final EtablissementService etablissementService;

    @GetMapping("/etablissements")
    @ResponseBody
    public List<EtablissementDto> findAll()
    {
        return etablissementService.findAll();
    }
    @PostMapping("/etablissementSave")
    @ResponseBody
    public EtablissementDto save(@RequestBody EtablissementDto etablissementDto)
    {
        return etablissementService.save(etablissementDto);
    }
    @PutMapping("/update/{codeEtablissement}")
    @ResponseBody
    public EtablissementDto update(@PathVariable String nom_Etablissement, @RequestBody EtablissementDto etablissementDto){
        return etablissementService.update(nom_Etablissement , etablissementDto);
    }
    @DeleteMapping("supprimerEtablissement/{codeEtablissement}")
    @ResponseBody
    public void delete(@PathVariable String nom_Etablissement)
    {
        etablissementService.delete(nom_Etablissement);
    }

}
