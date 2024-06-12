package com.bpkh.model.dto.response.common;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BpkhResponseDto<T> implements Serializable {
    private Integer httpCode;
    private String responseCode;
    private String responseDesc;
    private List<T> responseData;
}
