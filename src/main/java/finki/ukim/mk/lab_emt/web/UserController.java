package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.CreateUserDto;
import finki.ukim.mk.lab_emt.dto.DisplayUserDto;
import finki.ukim.mk.lab_emt.dto.LoginResponseDto;
import finki.ukim.mk.lab_emt.dto.LoginUserDto;
import finki.ukim.mk.lab_emt.model.exceptions.InvalidArgumentsException;
import finki.ukim.mk.lab_emt.model.exceptions.InvalidUserCredentialsException;
import finki.ukim.mk.lab_emt.model.exceptions.PasswordsDoNotMatchException;
import finki.ukim.mk.lab_emt.service.ApplicationServices.UserApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Endpoints for user authentication and registration") // Swagger tag
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<DisplayUserDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and generates a JWT")
//    @ApiResponses(
//            value = {@ApiResponse(
//                    responseCode = "200",
//                    description = "User authenticated successfully"
//            ), @ApiResponse(responseCode = "404", description = "Invalid username or password")}
//    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {
        System.out.println("login pravi do tuka ");

        try {
            return userApplicationService.login(loginUserDto)
                    .map(ResponseEntity::ok)
                    .orElseThrow(InvalidUserCredentialsException::new);
        } catch (InvalidUserCredentialsException e) {
            System.out.println("login pravi do tuka frla exeption ");

            return ResponseEntity.notFound().build();
        }
    }


}