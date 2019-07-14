/*
 * Written by Wojciech Klupś
 * Copyright (c) 2019. All rights reserved
 */

package pl.sda.wsumiedrogo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class UserListDto {

    List<UserDto> userDtoList;
}
