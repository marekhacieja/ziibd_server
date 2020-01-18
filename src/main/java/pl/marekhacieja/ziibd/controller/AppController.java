package pl.marekhacieja.ziibd.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.marekhacieja.ziibd.model.Countries;
import pl.marekhacieja.ziibd.model.Departments;
import pl.marekhacieja.ziibd.model.Employees;
import pl.marekhacieja.ziibd.model.Jobs;
import pl.marekhacieja.ziibd.repository.CountriesRepository;
import pl.marekhacieja.ziibd.repository.DepartmentsRepository;
import pl.marekhacieja.ziibd.repository.EmployeesRepository;
import pl.marekhacieja.ziibd.repository.JobsRepository;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class AppController {
    final EmployeesRepository employeesRepository;
    final JobsRepository jobsRepository;
    final DepartmentsRepository departmentsRepository;
    final CountriesRepository countriesRepository;

    public AppController(EmployeesRepository employeesRepository, JobsRepository jobsRepository, DepartmentsRepository departmentsRepository, CountriesRepository countriesRepository) {
        this.employeesRepository = employeesRepository;
        this.jobsRepository = jobsRepository;
        this.departmentsRepository = departmentsRepository;
        this.countriesRepository = countriesRepository;
    }

    @GetMapping("/employees")
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employees getEmployee(@PathVariable("id") Long id) {
        return employeesRepository.findByEmployeeId(id);
    }

    @GetMapping("/jobs")
    public List<Jobs> getJobs() {
        return jobsRepository.findAll();
    }

    @GetMapping("/job/{id}")
    public Jobs getJob(@PathVariable("id") String id) {
        return jobsRepository.findByJobId(id);
    }

    @GetMapping("/departments")
    public List<Departments> getDepartments() {
        return departmentsRepository.findAll();
    }

    @GetMapping("/department/{id}")
    public Departments getDepartment(@PathVariable("id") String id) {
        return departmentsRepository.findByDepartmentId(id);
    }

    @GetMapping("/countries")
    public List<Countries> getCountries() {
        return countriesRepository.findAll();
    }

    @GetMapping("/country/{id}")
    public Countries getCountry(@PathVariable("id") String id) {
        return countriesRepository.findByCountryId(id);
    }

    @Transactional
    @PostMapping("/employee")
    public void updateEmployee(@RequestBody Employees data) {
        employeesRepository.updateEmployee(data);
    }

    @Transactional
    @PostMapping("/job")
    public void updateJob(@RequestBody Jobs data) {
        jobsRepository.updateEmployee(data);
    }

    @Transactional
    @PostMapping("/department")
    public void updateDepartment(@RequestBody Departments data) {
        departmentsRepository.updateDepartment(data);
    }

    @Transactional
    @PostMapping("/country")
    public void updateCountry(@RequestBody Countries data) {
        countriesRepository.updateCountry(data);
    }

}
