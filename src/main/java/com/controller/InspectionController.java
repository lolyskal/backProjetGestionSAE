package com.controller;


import com.dto.InspectionDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.InspectionService;

import java.util.List;


@RestController
@RequestMapping(path="/inspection")
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
    @PutMapping("/updateinspection/{id}")
    @ResponseBody
    public InspectionDto update(@PathVariable Long id, @RequestBody InspectionDto inspectionDto)
    {
        return inspectionService.update( id, inspectionDto);
    }
    @DeleteMapping("supprimerinspection/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        inspectionService.delete(id);
    }

}
