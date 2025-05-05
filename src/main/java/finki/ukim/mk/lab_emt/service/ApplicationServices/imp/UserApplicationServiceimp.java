package finki.ukim.mk.lab_emt.service.ApplicationServices.imp;

import finki.ukim.mk.lab_emt.dto.CreateUserDto;
import finki.ukim.mk.lab_emt.dto.DisplayUserDto;
import finki.ukim.mk.lab_emt.dto.LoginResponseDto;
import finki.ukim.mk.lab_emt.dto.LoginUserDto;
import finki.ukim.mk.lab_emt.helpers.JwtHelper;
import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.repository.UserRepository;
import finki.ukim.mk.lab_emt.service.ApplicationServices.UserApplicationService;
import finki.ukim.mk.lab_emt.service.DomainServices.UserDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceimp implements UserApplicationService {
    private final UserDomainService userDomainService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceimp(UserDomainService userDomainService, JwtHelper jwtHelper) {
        this.userDomainService = userDomainService;
        this.jwtHelper = jwtHelper;
    }


    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userDomainService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));

    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userDomainService.login(
                loginUserDto.username(),
                loginUserDto.password()
        );

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDto(token));
    }

//    @Override
//    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
//        return Optional.of(DisplayUserDto.from(userDomainService.login(
//                loginUserDto.username(),
//                loginUserDto.password()
//        )));
//
//    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userDomainService.findByUsername(username)));


    }
}
