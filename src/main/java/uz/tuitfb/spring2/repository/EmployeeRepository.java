package uz.tuitfb.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.tuitfb.spring2.domain.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("select e from Employee  e where e.name=:name")
    List<Employee> findByNameQuery(@Param("name") String name);

    @Query(value = "select * from employee  e where e.name= :name ", nativeQuery = true)
    List<Employee> findByNameQueryNative(@Param("name") String name);

    List<Employee> findByNameLike(String name);

    List<Employee> findByNameStartingWith(String name);

    List<Employee> findByNameEndingWith(String name);


    @Query("select  e from Employee  e where upper(e.name) like  upper( concat ( '%', :name ,'%')) ")
    List<Employee> findByLikeNameQuery(@Param("name") String name);


    @Query(value = "select  * from employee  e where e.name like  %:name% ", nativeQuery = true)
    List<Employee> findByLikeNameQueryNative(@Param("name") String name);

}
