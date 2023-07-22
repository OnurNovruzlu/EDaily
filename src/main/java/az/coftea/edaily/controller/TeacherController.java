package az.coftea.edaily.controller;

import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get/{id}")
    public TeacherResponse getTeacherById(@PathVariable int id) {
        return teacherService.getTeacher(id);
    }

    @GetMapping("/all")
    public List<TeacherResponse> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/director")
    public TeacherResponse getDirector() {
        return teacherService.getDirector();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/insert")
    public String insert(@RequestBody NewTeacher newTeacher) {
        return teacherService.insert(newTeacher);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return teacherService.delete(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody NewTeacher newTeacher) {
        return teacherService.update(id, newTeacher);
    }

}
