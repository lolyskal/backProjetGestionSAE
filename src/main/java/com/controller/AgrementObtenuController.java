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

    private AgrementObtenuService agrementObtenuService;

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
    @PutMapping("/update/{id}")
    @ResponseBody
    public AgrementObtenuDto update(@PathVariable Long id, @RequestBody AgrementObtenuDto agrementObtenuDto){
        return agrementObtenuService.update(id, agrementObtenuDto);
    }
    @DeleteMapping("supprimerAgrementObtenu/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        agrementObtenuService.delete(id);
    }

}
