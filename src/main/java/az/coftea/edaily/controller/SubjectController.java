package az.coftea.edaily.controller;

import az.coftea.edaily.dto.NewSubject;
import az.coftea.edaily.dto.SubjectResponse;
import az.coftea.edaily.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;

    @GetMapping("/all")
    public List<SubjectResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/get/{id}")
    public SubjectResponse getById(@PathVariable("id")int id){
        return service.getSubject(id);
    }
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public String insert(@RequestBody NewSubject newSubject){
        return service.insert(newSubject);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable("id")int id,@RequestBody NewSubject newSubject){
        return service.update(id,newSubject);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        return service.delete(id);
    }
}
