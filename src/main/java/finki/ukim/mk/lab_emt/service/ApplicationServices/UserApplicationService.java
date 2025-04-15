package finki.ukim.mk.lab_emt.service.ApplicationServices;


import finki.ukim.mk.lab_emt.dto.CreateUserDto;
import finki.ukim.mk.lab_emt.dto.DisplayUserDto;
import finki.ukim.mk.lab_emt.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}

