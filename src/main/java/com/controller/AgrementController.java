package com.controller;

import com.dto.AgrementDto;
import com.services.AgrementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/agrement")
@AllArgsConstructor
public class AgrementController {

    @Autowired
    private final AgrementService agrementService;

    @GetMapping("/agrements")
    @ResponseBody
    public List<AgrementDto> findAll()

    {
        return agrementService.findAll();
    }
    @PostMapping("/agrementSave")
    @ResponseBody
    public AgrementDto save(@RequestBody AgrementDto agrementDto)
    {
        return agrementService.save(agrementDto);
    }
    @PutMapping("/update/{code}")
    @ResponseBody
    public AgrementDto update(@PathVariable String code, @RequestBody AgrementDto agrementDto){
        return agrementService.update(code, agrementDto);
    }
    @DeleteMapping("supprimeragrement")
    @ResponseBody
    public void delete(@PathVariable String code)
    {
        agrementService.delete(code);
    }

}
