package az.coftea.edaily.controller;

import az.coftea.edaily.dto.DailyResponse;
import az.coftea.edaily.dto.NewDaily;
import az.coftea.edaily.service.DailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("daily")
@RequiredArgsConstructor
public class DailyController {
    private final DailyService service;

    @GetMapping("/all")
    public List<DailyResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/get/{id}")
    public DailyResponse getById(@PathVariable("id")int id){
        return service.getDaily(id);
    }
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public String insert(@RequestBody NewDaily newDaily){
        return service.insert(newDaily);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        return service.delete(id);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable("id")int id,@RequestBody NewDaily newDaily){
        return service.update(id,newDaily);
    }

}