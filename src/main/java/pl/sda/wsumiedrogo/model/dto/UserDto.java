/*
 * Written by Wojciech Klupś
 * Copyright (c) 2019. All rights reserved
 */

package pl.sda.wsumiedrogo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private Long phoneNumber;
    private String email;
    private boolean activated;
}
