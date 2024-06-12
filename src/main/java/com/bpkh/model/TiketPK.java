package com.bpkh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class TiketPK implements Serializable {
    @Column(name = "id_travel", insertable = false, updatable = false)
    private Long idTravel;

    @Column(name = "id_penumpang", insertable = false, updatable = false)
    private Long idPenumpang;
}
