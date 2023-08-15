package com.controller;


import com.dto.PenaliteObtenuDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.PenaliteObtenuService;

import java.util.List;


@RestController
@RequestMapping("/penaliteObtenu")
@AllArgsConstructor
public class PenaliteObtenuController {

    @Autowired
    private final PenaliteObtenuService penaliteObtenuService;

    @GetMapping("/penaliteObtenus")
    @ResponseBody
    public List<PenaliteObtenuDto> findAll()
    {
        return penaliteObtenuService.findAll();
    }
    @PostMapping("/penaliteObtenuSave")
    @ResponseBody
    public PenaliteObtenuDto save(@RequestBody PenaliteObtenuDto penaliteObtenuDto)
    {
        return penaliteObtenuService.save(penaliteObtenuDto);
    }
    @PutMapping("/updatepenaliteObtenu/{id}")
    @ResponseBody
    public PenaliteObtenuDto update(@PathVariable Long id, @RequestBody PenaliteObtenuDto penaliteObtenuDto){
        return penaliteObtenuService.update( id, penaliteObtenuDto);
    }
    @DeleteMapping("supprimerdate/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        penaliteObtenuService.delete(id);
    }

}
