package com.controller;


import com.dto.PenaliteDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.PenaliteService;

import java.util.List;


@RestController
@RequestMapping("/Penalite")
@AllArgsConstructor
public class PenaliteController {

    @Autowired
    private final PenaliteService penaliteService;

    @GetMapping("/penalites")
    @ResponseBody
    public List<PenaliteDto> findAll()
    {
        return penaliteService.findAll();
    }
    @PostMapping("/penaliteSave")
    @ResponseBody
    public PenaliteDto save(@RequestBody PenaliteDto penaliteDto)
    {
        return penaliteService.save(penaliteDto);
    }
    @PutMapping("/update/{typePenalite}")
    @ResponseBody
    public PenaliteDto update(@PathVariable String typePenalite, @RequestBody PenaliteDto penaliteDto){
        return penaliteService.update( typePenalite, penaliteDto);
    }
    @DeleteMapping("supprimertypePenalite/{typePenalite}")
    @ResponseBody
    public void delete(@PathVariable String typePenalite)
    {
        penaliteService.delete(typePenalite);
    }

}
