package com.controller;


import com.dto.CantonDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.CantonService;

import java.util.List;


@RestController
@RequestMapping(path = "/canton")
@AllArgsConstructor
public class CantonController {

    @Autowired
    private final CantonService cantonService;

    @GetMapping(value = "/cantons")
    @ResponseBody
    public List<CantonDto> findAll()
    {
        return cantonService.findAll();
    }
    @PostMapping("/cantonsave")
    @ResponseBody
    public CantonDto save(@RequestBody CantonDto cantonDto)
    {
        return cantonService.save(cantonDto);
    }
    @PutMapping("/update/{codecanton}")
    @ResponseBody
    public CantonDto update(@PathVariable String code, @RequestBody CantonDto cantonDto){

        return cantonService.update (code , cantonDto);
    }
    @DeleteMapping("supprimercanton/{code}")
    @ResponseBody
    public void delete(@PathVariable String code){
        cantonService.delete(code);
    }

}
