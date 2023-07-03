package com.controller;

import com.dto.RegionAdministrativeDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.RegionAdministrativeService;

import java.util.List;


@RestController
@RequestMapping("/regionAdministrative")
@AllArgsConstructor
public class RegionAdministrativeController {

    @Autowired
    private final RegionAdministrativeService regionAdministrativeService;

    @GetMapping("/regionAdministratives")
    @ResponseBody
    public List<RegionAdministrativeDto> findAll()
    {
        return regionAdministrativeService.findAll();
    }
    @PostMapping("/regionAdministrativeSave")
    @ResponseBody
    public RegionAdministrativeDto save(@RequestBody RegionAdministrativeDto regionAdministrativeDto)
    {
        return regionAdministrativeService.save(regionAdministrativeDto);
    }
    @PutMapping("/update/{code}")
    @ResponseBody
    public RegionAdministrativeDto update(@PathVariable String code, @RequestBody RegionAdministrativeDto regionAdministrativeDto){
        return regionAdministrativeService.update( code, regionAdministrativeDto);
    }
    @DeleteMapping("supprimerRegionAdministrative/{code}")
    @ResponseBody
    public void delete(@PathVariable String code)

    {
        regionAdministrativeService.delete(code);
    }

}
