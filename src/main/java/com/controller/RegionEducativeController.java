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
    @PutMapping("/update/{libelleRegionEducative}")
    @ResponseBody
    public RegionEducativeDto update(@PathVariable String libelle, @RequestBody RegionEducativeDto regionEducativeDto){
        return regionEducativeService.update( libelle, regionEducativeDto);
    }
    @DeleteMapping("supprimer/{libelle}")
    @ResponseBody
    public void delete(@PathVariable String libelle)
    {
        regionEducativeService.delete(libelle);
    }

}
