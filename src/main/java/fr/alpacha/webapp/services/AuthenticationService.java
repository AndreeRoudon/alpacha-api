//package fr.alpacha.webapp.services;
//
//import fr.alpacha.webapp.dao.UserDao;
//
//import fr.alpacha.webapp.entity.User;
//import fr.alpacha.webapp.entity.auth.AuthenticationRequest;
//import fr.alpacha.webapp.entity.auth.AuthenticationResponse;
//import fr.alpacha.webapp.entity.auth.RegisterRequest;
//import fr.alpacha.webapp.enumeration.Role;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationService {
//
//    private final UserDao userDao;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final JwtService jwtService;
//
//    private final AuthenticationManager authenticationManager;
//
//    public fr.alpacha.webapp.entity.auth.AuthenticationResponse register(RegisterRequest request) {
//        var user = User.builder()
//            .firstName(request.getFirstName())
//            .lastName(request.getLastName())
//            .email(request.getEmail())
//            .password(passwordEncoder.encode(request.getPassword()))
//            .role(Role.USER)
//            .build();
//        userDao.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//            .token(jwtToken)
//            .build();
//    }
//
//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                request.getEmail(),
//                request.getPassword()
//            )
//        );
//        var user = userDao.findByEmail(request.getEmail())
//            .orElseThrow();
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//            .token(jwtToken)
//            .build();
//    }
//}
