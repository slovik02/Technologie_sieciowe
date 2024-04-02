package ib.ts_2.services;

import ib.ts_2.CommonTypes.UserRole;
import ib.ts_2.controller.Login;
import ib.ts_2.controller.LoginResponse;
import ib.ts_2.controller.Register;
import ib.ts_2.controller.RegisterResponse;
import ib.ts_2.entity.Auth;
import ib.ts_2.entity.User;
import ib.ts_2.repository.AuthRepository;
import ib.ts_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;



    @Autowired
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(Register dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        userRepository.save(user);

        Auth auth = new Auth();
        auth.setPassword(passwordEncoder.encode(dto.getPassword()));
        auth.setUsername(dto.getUsername());
        auth.setRole(dto.getRole());
        auth.setUser(user);

        authRepository.save(auth);

        return new RegisterResponse(user.getUser_id(), auth.getUsername(), auth.getRole());
    }

    public LoginResponse login(Login dto){
        Auth auth = authRepository.findByUsername(dto.getUsername()).orElseThrow(RuntimeException::new);

        if(!passwordEncoder.matches(dto.getPassword(), auth.getPassword())){
            throw new RuntimeException();
        }

        String token = jwtService.generateToken(auth);

        return new LoginResponse(token);

    }

}
