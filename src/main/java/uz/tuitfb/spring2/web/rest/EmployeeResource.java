package uz.tuitfb.spring2.web.rest;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tuitfb.spring2.domain.Employee;
import uz.tuitfb.spring2.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/employees")
    private ResponseEntity create(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @PutMapping("/employees")
    private ResponseEntity update(@RequestBody Employee employee) {

//        if(employee.getId() == null){
//            return ResponseEntity.badRequest().build();
//        }

        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @DeleteMapping("/employees/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("qator o`chirildi");
    }


    @GetMapping("/employees")
    private ResponseEntity getAll() {
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }


    @GetMapping("/employees/search")
    private ResponseEntity getAllSearch(@RequestParam String name) {
        List<Employee> employeeList = employeeService.findAllParam(name);

        if (employeeList.isEmpty()) {
            return ResponseEntity.ok("000000");
        } else {
            return ResponseEntity.ok(employeeList);
        }
    }


    @GetMapping("/employees/{name}")
    private ResponseEntity findByName(@PathVariable String name) {

        List<Employee> employeeList = employeeService.findByName(name);
        if (employeeList.isEmpty()) {
            return ResponseEntity.ok("Bunday nom yo`q");
        } else {
            return ResponseEntity.ok(employeeList);
        }
    }


}
