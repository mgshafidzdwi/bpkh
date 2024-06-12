package com.bpkh.model.dto.request.travel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
public class UpdateTravelRequestDto {
    private Long id;
    private String namaTravel;
    private String noTelp;
    private String alamat;
    private String noPolisi;
    private String jenisBus;
}