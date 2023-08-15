package com.controller;


import com.dto.PenaliteDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.PenaliteService;

import java.util.List;


@RestController
@RequestMapping("/penalite")
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
    @PutMapping("/updatePenalite/{id}")
    @ResponseBody
    public PenaliteDto update(@PathVariable Long id, @RequestBody PenaliteDto penaliteDto){
        return penaliteService.update(id , penaliteDto);
    }
    @DeleteMapping("supprimePenalite/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        penaliteService.delete(id);
    }

}
