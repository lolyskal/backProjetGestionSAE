package com.controller;




import com.dto.AgrementObtenuDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.AgrementObtenuService;

import java.util.List;


@RestController
@RequestMapping("/agrementObtenu")
@AllArgsConstructor
public class AgrementObtenuController {

    @Autowired
    private final AgrementObtenuService agrementObtenuService;

    @GetMapping("/agrementObtenus")
    @ResponseBody
    public List<AgrementObtenuDto> findAll(){
        return agrementObtenuService.findAll();
    }
    @PostMapping("/agrementObtenuSave")
    @ResponseBody
    public AgrementObtenuDto save(@RequestBody AgrementObtenuDto agrementObtenuDto){
        return agrementObtenuService.save(agrementObtenuDto);
    }
    @PutMapping("/update/{numero}")
    @ResponseBody
    public AgrementObtenuDto update(@PathVariable Long numero, @RequestBody AgrementObtenuDto agrementObtenuDto){
        return agrementObtenuService.update(numero, agrementObtenuDto);
    }
    @DeleteMapping("supprimerAgrementObtenu/{numero}")
    @ResponseBody
    public void delete(@PathVariable Long numero){
        agrementObtenuService.delete(numero);
    }

}
