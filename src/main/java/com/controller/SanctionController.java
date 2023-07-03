package com.controller;

import com.dto.SanctionDto;
import com.services.SanctionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Sanction")
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
    @PutMapping("/update/{codeSanction}")
    @ResponseBody
    public SanctionDto update(@PathVariable String code, @RequestBody SanctionDto sanctionDto){
        return sanctionService.update( code, sanctionDto);
    }
    @DeleteMapping("supprimercode/{codeSanction}")
    @ResponseBody
    public void delete(@PathVariable String code)
    {
        sanctionService.delete(code);
    }

}
