package com.controller;


import com.dto.PenaliteObtenuDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.PenaliteObtenuService;

import java.util.List;


@RestController
@RequestMapping("/PenaliteObtenu")
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
    @PutMapping("/update/{penaliteObtenu}")
    @ResponseBody
    public PenaliteObtenuDto update(@PathVariable String date, @RequestBody PenaliteObtenuDto penaliteObtenuDto){
        return penaliteObtenuService.update( date, penaliteObtenuDto);
    }
    @DeleteMapping("supprimerdate/{date}")
    @ResponseBody
    public void delete(@PathVariable String date)
    {
        penaliteObtenuService.delete(date);
    }

}
