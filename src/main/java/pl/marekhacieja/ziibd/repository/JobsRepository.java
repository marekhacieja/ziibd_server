package pl.marekhacieja.ziibd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.marekhacieja.ziibd.model.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, String> {
    Jobs findByJobId(String id);

    @Modifying
    @Query("update Jobs j " +
            "set j.jobTitle = :#{#job.getJobTitle()}," +
            "j.minSalary = :#{#job.getMinSalary()}," +
            "j.maxSalary = :#{#job.getMaxSalary()} " +
            "where j.jobId = :#{#job.getJobId()}")
    void updateEmployee(@Param("job") Jobs job);

}
