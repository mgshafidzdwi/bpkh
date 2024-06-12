package com.bpkh.model.dto.request.penumpang;

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
public class AddPenumpangRequestDto {
    private String nama;
    private String noTelp;
}
