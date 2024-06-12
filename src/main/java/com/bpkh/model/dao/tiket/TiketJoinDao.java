package com.bpkh.model.dao.tiket;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bpkh.model.TiketJoin;

public interface TiketJoinDao extends CrudRepository<TiketJoin, Long> {
    @Query(value = "SELECT t.id, t.id_penumpang, t.id_travel, t.jadwal as jadwal,p.nama AS nama_penumpang, p.no_telp AS no_telp_penumpang, t2.nama_travel, t2.no_telp AS no_telp_travel, "
            +
            "t2.alamat AS alamat_travel, t2.no_polisi, t2.jenis_bus FROM tiket t LEFT JOIN penumpang p ON t.id_penumpang = p.id_penumpang "
            +
            "LEFT JOIN travel t2 ON t.id_travel = t2.id WHERE LOWER(t2.alamat) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "LOWER(p.nama) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(t2.nama_travel) LIKE LOWER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<TiketJoin> findByKeywordTiket(String keyword);
}
