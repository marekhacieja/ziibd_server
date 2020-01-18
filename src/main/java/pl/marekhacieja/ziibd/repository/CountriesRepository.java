package pl.marekhacieja.ziibd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.marekhacieja.ziibd.model.Countries;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, String> {
    Countries findByCountryId(String id);

    @Modifying
    @Query("update Countries c " +
            "set c.countryName = :#{#country.getCountryName()}," +
            "c.regionId = :#{#country.getRegionId()} " +
            "where c.countryId = :#{#country.getCountryId()}")
    void updateCountry(@Param("country") Countries country);
}
