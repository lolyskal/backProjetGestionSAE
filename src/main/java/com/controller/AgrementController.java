package com.controller;

import com.dto.AgrementDto;
import com.services.AgrementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/agrement")
@CrossOrigin(origins = "*")
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
    @PutMapping("/update/{id}")
    @ResponseBody
    public AgrementDto update(@PathVariable Long id, @RequestBody AgrementDto agrementDto){
        return agrementService.update(id, agrementDto);
    }
    @DeleteMapping("supprimeragrement/{id}")
    @ResponseBody
    public void delete(@PathVariable long id)
    {
        agrementService.delete(id);
    }

    @GetMapping("/{id}")
    public AgrementDto findById(@PathVariable Long id) {
        return agrementService.findById(id);
    }

}
