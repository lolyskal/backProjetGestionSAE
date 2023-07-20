package com.controller;


import com.dto.SanctionObtenuDto;
import com.services.SanctionObtenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path="/sanctionObtenu")
@AllArgsConstructor
public class SanctionObtenuController {

    @Autowired
    private final SanctionObtenuService sanctionObtenuService;

    @GetMapping("/sanction0btenus")
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
    @PutMapping("/updateSanctionObtenu/{id}")
    @ResponseBody
    public SanctionObtenuDto update(@PathVariable Long id, @RequestBody SanctionObtenuDto sanctionObtenuDto){
        return sanctionObtenuService.update(id, sanctionObtenuDto);
    }
    @DeleteMapping("supprimerSanctionObtenu/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        sanctionObtenuService.delete(id);
    }

}
