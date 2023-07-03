package com.controller;



import com.dto.CommuneDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.CommuneService;

import java.util.List;


@RestController
@RequestMapping("/Commune")
@AllArgsConstructor
public class CommuneController {

    @Autowired
    private final CommuneService communeService;

    @GetMapping("/Communes")
    @ResponseBody
    public List<CommuneDto> findAll()
    {
        return communeService.findAll();
    }
    @PostMapping("/communeSave")
    @ResponseBody
    public CommuneDto save(@RequestBody CommuneDto communeDto)
    {
        return communeService.save(communeDto);
    }
    @PutMapping("/update/{codecommune}")
    @ResponseBody
    public CommuneDto update(@PathVariable String code, @RequestBody CommuneDto communeDto){
        return communeService.update(code, communeDto);
    }
    @DeleteMapping("supprimercommune/{codecommune}")
    @ResponseBody
    public void delete(@PathVariable String code)
    {
        communeService.delete(code);
    }

}
