package com.bpkh.model.dao.penumpang;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bpkh.model.Penumpang;

public interface PenumpangDao extends CrudRepository<Penumpang, Long> {
    @Query(value = "SELECT no_telp FROM penumpang where no_telp = ?1", nativeQuery = true)
    String findNoTelp(String noTelp);
}
