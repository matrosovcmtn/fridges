package ru.matrosov.fridges.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.matrosov.fridges.security.AuthenticationRequest;
import ru.matrosov.fridges.security.AuthenticationResponse;
import ru.matrosov.fridges.security.AuthenticationService;
import ru.matrosov.fridges.security.RegisterRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    /**
     * @param request - запрос вида {
     *                "username": имя пользователя,
     *                "email": маил пользователя,
     *                "password": пароль пользователя,
     *                }
     * @return JW token вида - {
     * "token": токен
     * }
     */

    @PostMapping("/registration")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    /**
     * @param request - запрос вида {
     *                "email": маил пользователя,
     *                "password": пароль пользователя,
     *                }
     * @return JW token вида - {
     * "token": токен
     * }
     */

    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) {
        return service.authenticate(request);
    }


}
