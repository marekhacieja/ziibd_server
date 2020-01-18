package pl.marekhacieja.ziibd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.marekhacieja.ziibd.model.Countries;
import pl.marekhacieja.ziibd.model.Departments;
import pl.marekhacieja.ziibd.model.Jobs;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, String> {
    Departments findByDepartmentId(String id);

    @Modifying
    @Query("update Departments d " +
            "set d.managerId = :#{#department.getManagerId()}," +
            "d.departmentName = :#{#department.getDepartmentName()}, " +
            "d.locationId = :#{#department.getLocationId()} " +
            "where d.departmentId = :#{#department.getDepartmentId()}")
    void updateDepartment(@Param("department") Departments department);

}
