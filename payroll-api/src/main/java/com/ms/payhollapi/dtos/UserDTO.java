package com.ms.payhollapi.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourPrice;
}
