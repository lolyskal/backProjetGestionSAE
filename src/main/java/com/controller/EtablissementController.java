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
    @PutMapping("/update/{id}")
    @ResponseBody
    public EtablissementDto update(@PathVariable Long id, @RequestBody EtablissementDto etablissementDto){
        return etablissementService.update(id , etablissementDto);
    }
    @DeleteMapping("supprimerEtablissement/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        etablissementService.delete(id);
    }

}
