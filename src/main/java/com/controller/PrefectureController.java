package com.controller;


import com.dto.PrefectureDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.PrefectureService;

import java.util.List;


@RestController
@RequestMapping("/prefecture")
@AllArgsConstructor
public class PrefectureController {

    @Autowired
    private final PrefectureService prefectureService;

    @GetMapping("/prefectures")
    @ResponseBody
    public List<PrefectureDto> findAll()
    {
        return prefectureService.findAll();
    }
    @PostMapping("/prefectureSave")
    @ResponseBody
    public PrefectureDto save(@RequestBody PrefectureDto prefectureDto)
    {
        return prefectureService.save(prefectureDto);
    }
    @PutMapping("/updateprefecture/{id}")
    @ResponseBody
    public PrefectureDto update(@PathVariable Long id, @RequestBody PrefectureDto prefectureDto){
        return prefectureService.update( id, prefectureDto);
    }
    @DeleteMapping("supprimerprefecture/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id)
    {
        prefectureService.delete(id);
    }

}
