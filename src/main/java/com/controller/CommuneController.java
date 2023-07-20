package com.controller;



import com.dto.CommuneDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.CommuneService;

import java.util.List;


@RestController
@RequestMapping("/commune")
@AllArgsConstructor
public class CommuneController {

    @Autowired
    private final CommuneService communeService;

    @GetMapping("/communes")
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
    @PutMapping("/update/{id}")
    @ResponseBody
    public CommuneDto update(@PathVariable Long id, @RequestBody CommuneDto communeDto){
        return communeService.update(id, communeDto);
    }
    @DeleteMapping("supprimercommune/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        communeService.delete(id);
    }

}
