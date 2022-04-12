package uz.tuitfb.spring2.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tuitfb.spring2.domain.StudentModel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {




    @GetMapping("/students/all")
    public ResponseEntity getAll() {
        StudentModel studentModel = new StudentModel(1L, "James", "Cameron", "3-kurs");
        StudentModel studentModel2 = new StudentModel(2L, "James2", "Cameron2", "3-kurs");
        StudentModel studentModel3 = new StudentModel(3L, "James3", "Cameron3", "3-kurs");
        StudentModel studentModel4 = new StudentModel(4L, "James4", "Cameron4", "3-kurs");

        List<StudentModel> studentModelList = new ArrayList<>();
        studentModelList.add(studentModel);
        studentModelList.add(studentModel2);
        studentModelList.add(studentModel3);
        studentModelList.add(studentModel4);
        return ResponseEntity.ok(studentModelList);
    }

    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastname,
                                 @RequestParam String course) {
        StudentModel studentModel = new StudentModel(id,name, lastname, course);
        return ResponseEntity.ok(studentModel);


    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Malumot o`chirildi");
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody StudentModel studentModel) {
        return ResponseEntity.ok(studentModel);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody StudentModel studentModelnew) {
        StudentModel studentModel = new StudentModel(5L, "James4", "Cameron4", "3-kurs");
        studentModel.setId(id);
        studentModel.setName(studentModelnew.getName());
        studentModel.setLastname(studentModelnew.getLastname());

        return ResponseEntity.ok(studentModel);

    }


    @GetMapping("/students/")
    public ResponseEntity getOne(@PathVariable Long id) {
        StudentModel studentModel = new StudentModel(id, "James", "Cameron", "3-kurs");
        return ResponseEntity.ok(studentModel);


    }


//    @RequestMapping(value = "/students" ,method = RequestMethod.GET)
//    public String hello2(){
//        return "salom";
//    }   StudentModel studentModel4 = new StudentModel(4L, "James4", "Cameron4", "3-kurs");

}
