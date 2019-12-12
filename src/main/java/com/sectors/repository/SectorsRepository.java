package com.sectors.repository;

import com.sectors.domain.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SectorsRepository extends JpaRepository<Sectors,Long> {
    public Sectors findById(long id);

    public Sectors findSectorsBySectorName(String sectorName);

    @Query(value = "select * from Users u where u.user_name like %?1% " , nativeQuery = true)
    public List<Sectors> findByUserNameLike(String userName);
}
