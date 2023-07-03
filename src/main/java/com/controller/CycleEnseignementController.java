package com.controller;

import com.dto.CycleEnseignementDto;
import com.services.CycleEnseignementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Commune")
@AllArgsConstructor
public class CycleEnseignementController {

    @Autowired
    private final CycleEnseignementService cycleEnseignementService;

    @GetMapping("/cycleEnseignements")
    @ResponseBody
    public List<CycleEnseignementDto> findAll()
    {
        return cycleEnseignementService.findAll();
    }
    @PostMapping("/CycleEnseignementSave")
    @ResponseBody
    public CycleEnseignementDto save(CycleEnseignementDto cycleEnseignementDto)
    {
        return cycleEnseignementService.save(cycleEnseignementDto);
    }
    @PutMapping("/update/{codecycle}")
    @ResponseBody
    public CycleEnseignementDto update(@PathVariable String code, @RequestBody CycleEnseignementDto cycleEnseignementDto){
        return cycleEnseignementService.update(code, cycleEnseignementDto);
    }
    @DeleteMapping("supprimerCommune/{codeCycleEnseignement}")
    @ResponseBody
    public void delete(@PathVariable String code)
    {
        cycleEnseignementService.delete(code);
    }

}
