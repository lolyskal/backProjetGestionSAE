package com.controller;


import com.dto.PrefectureDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.PrefectureService;

import java.util.List;


@RestController
@RequestMapping("/Prefecture")
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
    @PutMapping("/update/{codeprefecture}")
    @ResponseBody
    public PrefectureDto update(@PathVariable String code, @RequestBody PrefectureDto prefectureDto){
        return prefectureService.update( code, prefectureDto);
    }
    @DeleteMapping("supprimercode/{code}")
    @ResponseBody
    public void delete(@PathVariable String code)
    {
        prefectureService.delete(code);
    }

}
