package com.controller;


import com.dto.SanctionObtenuDto;
import com.services.SanctionObtenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/SanctionObtenu")
@AllArgsConstructor
public class SanctionObtenuController {

    @Autowired
    private final SanctionObtenuService sanctionObtenuService;

    @GetMapping("/sanctionobtenus")
    @ResponseBody
    public List<SanctionObtenuDto> findAll()
    {
        return sanctionObtenuService.findAll();
    }
    @PostMapping("/sanctionObtenuSave")
    @ResponseBody
    public SanctionObtenuDto save(@RequestBody SanctionObtenuDto sanctionObtenuDto)
    {
        return sanctionObtenuService.save(sanctionObtenuDto);
    }
    @PutMapping("/update/{sanctionobtenu}")
    @ResponseBody
    public SanctionObtenuDto update(@PathVariable String date, @RequestBody SanctionObtenuDto sanctionObtenuDto){
        return sanctionObtenuService.update( date, sanctionObtenuDto);
    }
    @DeleteMapping("supprimer/{sanctionobtenu}")
    @ResponseBody
    public void delete(@PathVariable String sanctionobtenu)
    {
        sanctionObtenuService.delete(sanctionobtenu);
    }

}
