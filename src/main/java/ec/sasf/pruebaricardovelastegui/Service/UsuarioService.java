package ec.sasf.pruebaricardovelastegui.Service;

import ec.sasf.pruebaricardovelastegui.Dto.LoginDto;
import ec.sasf.pruebaricardovelastegui.Dto.UsuarioDto;
import ec.sasf.pruebaricardovelastegui.response.LoginResponse;

public interface UsuarioService {
    
    String addUsuario(UsuarioDto usuarioDto);

    LoginResponse loginUsuario(LoginDto loginDto);
}
