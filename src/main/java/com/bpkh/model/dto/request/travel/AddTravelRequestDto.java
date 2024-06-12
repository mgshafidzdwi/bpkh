package com.bpkh.model.dto.request.travel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE
)

@Setter
@Getter
@ToString
public class AddTravelRequestDto {
    private String namaTravel;
    private String noTelp;
    private String alamat;
    private String noPolisi;
    private String jenisBus;
}