package com.bpkh.model.dao.travel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bpkh.model.Travel;

public interface TravelDao extends CrudRepository<Travel, Long> {

    @Query(value = "SELECT * FROM travel WHERE (LOWER(alamat) " +
            "LIKE LOWER(concat('%', ?1 ,'%')) " +
            "OR (LOWER(nama_travel) " +
            "LIKE LOWER(concat('%', ?1 ,'%')))) ", nativeQuery = true)
    List<Travel> findTravelByKeyword(String keyword);

    @Query(value = "SELECT no_telp FROM travel where no_telp = ?1", nativeQuery = true)
    String findNoTelp(String noTelp);
}
