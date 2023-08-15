package com.controller;



import com.dto.FraisCycleDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.FraisCycleService;

import java.util.List;


@RestController
@RequestMapping("/fraisCycle")
@AllArgsConstructor
public class FraisCycleController {

    @Autowired
    private final FraisCycleService fraisCycleService;

    @GetMapping("/fraisCycles")
    @ResponseBody
    public List<FraisCycleDto> findAll()
    {
        return fraisCycleService.findAll();
    }
    @PostMapping("/fraisCycleSave")
    @ResponseBody
    public FraisCycleDto save(@RequestBody FraisCycleDto fraisCycleDto)
    {
        return fraisCycleService.save(fraisCycleDto);
    }
    @PutMapping("/updatefraisCycle/{id}")
    @ResponseBody
    public FraisCycleDto update(@PathVariable Long id, @RequestBody FraisCycleDto fraisCycleDto)
    {
        return fraisCycleService.update(id, fraisCycleDto);
    }
    @DeleteMapping("supprimerfraisCycle/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        fraisCycleService.delete(id);
    }

}
