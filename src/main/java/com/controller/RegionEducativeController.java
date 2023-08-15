package com.controller;


import com.dto.RegionEducativeDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.RegionEducativeService;

import java.util.List;

@RestController
@RequestMapping(path = "/regionEducative")
@AllArgsConstructor
public class RegionEducativeController {

    @Autowired
    private final RegionEducativeService regionEducativeService;

    @GetMapping("/regionEducatives")
    @ResponseBody
    public List<RegionEducativeDto> findAll()
    {
        return regionEducativeService.findAll();
    }
    @PostMapping("/regionEducativeSave")
    @ResponseBody
    public RegionEducativeDto save(@RequestBody RegionEducativeDto regionEducativeDto)
    {
        return regionEducativeService.save(regionEducativeDto);
    }
    @PutMapping("/regionEducativeUpdate/{id}")
    @ResponseBody
    public RegionEducativeDto update(@PathVariable Long id, @RequestBody RegionEducativeDto regionEducativeDto){
        return regionEducativeService.update( id, regionEducativeDto);
    }
    @DeleteMapping("supprimerRegionEducative/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        regionEducativeService.delete(id);
    }


}
