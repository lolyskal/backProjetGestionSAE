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
    @PutMapping("/update/{id}")
    @ResponseBody
    public CantonDto update(@PathVariable Long id, @RequestBody CantonDto cantonDto){

        return cantonService.update (id , cantonDto);
    }
    @DeleteMapping("supprimercanton/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        cantonService.delete(id);
    }

}
