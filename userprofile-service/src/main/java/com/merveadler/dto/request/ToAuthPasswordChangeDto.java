package com.merveadler.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToAuthPasswordChangeDto {
    Long authId; //= auth entitiysindeki id
    String password;

}
