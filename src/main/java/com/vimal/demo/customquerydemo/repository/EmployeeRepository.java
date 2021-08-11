package com.vimal.demo.customquerydemo.repository;

import com.vimal.demo.customquerydemo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email = :email and e.password = :password")
    Optional<Employee> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT * FROM employee WHERE salary between :s and :e", nativeQuery=true)
    public List<Employee> findBySalaryBetween(Long s, Long e);
}
