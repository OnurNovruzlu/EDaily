package az.coftea.edaily.controller;

import az.coftea.edaily.dto.NewPoint;
import az.coftea.edaily.dto.PointResponse;
import az.coftea.edaily.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("point")
public class PointController {
    private final PointService service;

    @GetMapping("/all")
    public List<PointResponse> getAll(){
        return service.getAll();
    }
    @PostMapping("/insert")
    public String insert(@RequestBody NewPoint newPoint){
        return service.insert(newPoint);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        return service.delete(id);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable("id")int id, @RequestParam Integer point){
        return service.update(id,point);
    }
}
