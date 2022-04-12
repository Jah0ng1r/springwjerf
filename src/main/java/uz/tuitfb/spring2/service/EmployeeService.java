package uz.tuitfb.spring2.service;

import org.springframework.stereotype.Service;
import uz.tuitfb.spring2.domain.Employee;
import uz.tuitfb.spring2.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);

    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();

    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();

    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByNameQueryNative(name);
    }

    public List<Employee> findAllParam(String name) {
        return employeeRepository.findByLikeNameQueryNative(name);

    }
    public  void delete(Long id){

        Employee employee=employeeRepository.getOne(id);
        employeeRepository.delete(employee);
    }

}
