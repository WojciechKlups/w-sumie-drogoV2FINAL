/*
 * Copyright (c) 2019. Mateusz Haberla all rights reserved.
 */

package pl.sda.wsumiedrogo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;


@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
