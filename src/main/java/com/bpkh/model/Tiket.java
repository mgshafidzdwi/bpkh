package com.bpkh.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class Tiket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_penumpang")
    private Long idPenumpang;
    @Column(name = "id_travel")
    private Long idTravel;
    private LocalDateTime jadwal;
    // @Transient
    // private String namaPenumpang;
    // @Transient
    // private String noTelpPenumpang;
    // @Transient
    // private String namaTravel;
    // @Transient
    // private String noTelpTravel;
    // @Transient
    // private String alamatTravel;
    // @Transient
    // private String noPolisi;
    // @Transient
    // private String jenisBus;
}
