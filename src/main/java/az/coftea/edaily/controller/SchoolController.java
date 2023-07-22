package az.coftea.edaily.controller;

import az.coftea.edaily.dto.NewSchool;
import az.coftea.edaily.dto.SchoolResponse;
import az.coftea.edaily.dto.SchoolResponseS;
import az.coftea.edaily.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    @GetMapping("/all")
    public List<SchoolResponseS> getAll(){
        return service.getAll();
    }
    @GetMapping("/get/{id}")
    public SchoolResponseS getById(@PathVariable("id")int id){
        return service.getById(id);
    }
    @GetMapping("/alldata/{id}")
    public SchoolResponse getAllDataById(@PathVariable("id")int id){
        return service.getSchoolWithAllData(id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        return service.delete(id);
    }
    @PostMapping("/insert")
    public String insert(@RequestBody NewSchool newSchool){
        return service.insert(newSchool);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable("id")int id,@RequestBody NewSchool newSchool){
        return service.update(id,newSchool);
    }
}
