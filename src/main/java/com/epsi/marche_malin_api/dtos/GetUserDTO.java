package com.epsi.marche_malin_api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDTO {
    private String username;
    private String email;
    private String phoneNb;
}
