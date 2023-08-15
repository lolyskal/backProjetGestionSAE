package com.controller;

import com.dto.SanctionDto;
import com.services.SanctionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path ="/sanction")
@AllArgsConstructor
public class SanctionController {

    @Autowired
    private final SanctionService sanctionService;

    @GetMapping("/sanctions")
    @ResponseBody
    public List<SanctionDto> findAll()
    {
        return sanctionService.findAll();
    }
    @PostMapping("/sanctionSave")
    @ResponseBody
    public SanctionDto save(@RequestBody SanctionDto sanctionDto)
    {
        return sanctionService.save(sanctionDto);
    }
    @PutMapping("/sanctionUpdate/{id}")
    @ResponseBody
    public SanctionDto update(@PathVariable Long id, @RequestBody SanctionDto sanctionDto){
        return sanctionService.update( id, sanctionDto);
    }
    @DeleteMapping("supprimerSanction/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        sanctionService.delete(id);
    }

}
