package com.bpkh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "travel")
public class Travel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nama_travel")
    private String namaTravel;
    @Column(name = "no_telp")
    private String noTelp;
    private String alamat;
    @Column(name = "no_polisi")
    private String noPolisi;
    @Column(name = "jenis_bus")
    private String jenisBus;
}
