package com.controller;

import com.dto.CycleEnseignementDto;
import com.services.CycleEnseignementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cycleEnseignement")
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
    @PostMapping("/cycleEnseignementSave")
    @ResponseBody
    public CycleEnseignementDto save(@RequestBody CycleEnseignementDto cycleEnseignementDto)
    {
        return cycleEnseignementService.save(cycleEnseignementDto);
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public CycleEnseignementDto update(@PathVariable Long id, @RequestBody CycleEnseignementDto cycleEnseignementDto){
        return cycleEnseignementService.update(id, cycleEnseignementDto);
    }
    @DeleteMapping("supprimerCommune/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        cycleEnseignementService.delete(id);
    }

}
