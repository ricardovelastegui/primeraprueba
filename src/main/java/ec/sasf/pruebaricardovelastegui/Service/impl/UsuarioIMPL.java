package ec.sasf.pruebaricardovelastegui.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ec.sasf.pruebaricardovelastegui.Dto.LoginDto;
import ec.sasf.pruebaricardovelastegui.Dto.UsuarioDto;
import ec.sasf.pruebaricardovelastegui.Entity.Usuario;
import ec.sasf.pruebaricardovelastegui.Repository.UsuarioRepo;
import ec.sasf.pruebaricardovelastegui.Service.UsuarioService;
import ec.sasf.pruebaricardovelastegui.response.LoginResponse;


@Service
public class UsuarioIMPL  implements UsuarioService{


    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(
            usuarioDto.getId(),
            usuarioDto.getUsername(),
            usuarioDto.getEmail(),
            usuarioDto.getRole(),
            this.passwordEncoder.encode(usuarioDto.getPassword())
        );

        usuarioRepo.save(usuario);
        return usuario.getUsername();
            
        
    }

    @Override
    public LoginResponse loginUsuario(LoginDto loginDto){

        String msg = "";
        Usuario usuario1 = usuarioRepo.findByEmail(loginDto.getEmail());
        if (usuario1 != null){
            String password = loginDto.getPassword();
            String encodedPassword = usuario1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight){
                Optional<Usuario> usuario = usuarioRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword );
                if (usuario.isPresent()){
                    return new LoginResponse( "Login Success", true );
                } else {
                    return new LoginResponse( "Login Failed", false );
                }
            } else {
                return new LoginResponse("password Not match ", false);
            }
            
        } else {
            return new LoginResponse("Email not exits", false);
        }
    }
    
}
