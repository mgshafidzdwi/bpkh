package com.bpkh.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)

@Setter
@Getter
@Entity
@Table(name = "tiket")
public class TiketJoin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_penumpang")
    private Long idPenumpang;
    @Column(name = "id_travel")
    private Long idTravel;
    private LocalDateTime jadwal;

    @Nullable
    @Column(name = "nama_penumpang")
    private String namaPenumpang;
    @Nullable
    @Column(name = "no_telp_penumpang")
    private String noTelpPenumpang;
    @Nullable
    @Column(name = "nama_travel")
    private String namaTravel;
    @Nullable
    @Column(name = "no_telp_travel")
    private String noTelpTravel;
    @Nullable
    @Column(name = "alamat_travel")
    private String alamatTravel;
    @Nullable
    @Column(name = "no_polisi")
    private String noPolisi;
    @Nullable
    @Column(name = "jenis_bus")
    private String jenisBus;
}
