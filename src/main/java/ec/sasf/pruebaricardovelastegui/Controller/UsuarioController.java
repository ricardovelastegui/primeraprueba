package ec.sasf.pruebaricardovelastegui.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.pruebaricardovelastegui.Dto.LoginDto;
import ec.sasf.pruebaricardovelastegui.Dto.UsuarioDto;
import ec.sasf.pruebaricardovelastegui.Service.UsuarioService;
import ec.sasf.pruebaricardovelastegui.response.LoginResponse;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api/v1")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/save")
    public String saveUsuario(@RequestBody UsuarioDto usuarioDto){

        String id = usuarioService.addUsuario(usuarioDto);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = usuarioService.loginUsuario(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

    
}
