package com.controller;


import com.dto.InspectionDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.InspectionService;

import java.util.List;


@RestController
@RequestMapping("/Inspection")
@AllArgsConstructor
public class InspectionController {

    @Autowired
    private final InspectionService inspectionService;

    @GetMapping("/inspections")
    @ResponseBody
    public List<InspectionDto> findAll()
    {
        return inspectionService.findAll();
    }
    @PostMapping("/inspectionSave")
    @ResponseBody
    public InspectionDto save(InspectionDto inspectionDto)
    {
        return inspectionService.save(inspectionDto);
    }
    @PutMapping("/update/{libelle}")
    @ResponseBody
    public InspectionDto update(@PathVariable Integer numero, @RequestBody InspectionDto inspectionDto){
        return inspectionService.update( numero, inspectionDto);
    }
    @DeleteMapping("supprimerinspection/{libelle}")
    @ResponseBody
    public void delete(@PathVariable Integer numero)
    {
        inspectionService.delete(numero);
    }

}
