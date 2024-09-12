//package fr.alpacha.webapp.controller;
//
//
//import fr.alpacha.webapp.services.AuthenticationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//@RequiredArgsConstructor
//public class AuthenticationController {
//
//    private final AuthenticationService authenticationService;
//
//    @PostMapping("/register")
//    public ResponseEntity<fr.alpacha.webapp.entity.auth.AuthenticationResponse> register(
//      @RequestBody fr.alpacha.webapp.entity.auth.RegisterRequest request
//    ) {
//        return ResponseEntity.ok(authenticationService.register(request));
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<fr.alpacha.webapp.entity.auth.AuthenticationResponse> authenticate(
//      @RequestBody fr.alpacha.webapp.entity.auth.AuthenticationRequest request
//    ) {
//        return ResponseEntity.ok(authenticationService.authenticate(request));
//    }
//}
