package com.merveadler.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterModel implements Serializable {
    private Long authId;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
}
