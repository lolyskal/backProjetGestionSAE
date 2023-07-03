package com.controller;



import com.dto.FraisCycleDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.FraisCycleService;

import java.util.List;


@RestController
@RequestMapping("/FraisCycle")
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
    @PostMapping("/FraisCycleSave")
    @ResponseBody
    public FraisCycleDto save(@RequestBody FraisCycleDto fraisCycleDto)
    {
        return fraisCycleService.save(fraisCycleDto);
    }
    @PutMapping("/update/{codefraisCycle}")
    @ResponseBody
    public FraisCycleDto update(@PathVariable Integer code, @RequestBody FraisCycleDto fraisCycleDto){
        return fraisCycleService.update(code, fraisCycleDto);
    }
    @DeleteMapping("supprimerfraisCycle/{codefraisCycle}")
    @ResponseBody
    public void delete(@PathVariable Integer code)
    {
        fraisCycleService.delete(code);
    }

}
