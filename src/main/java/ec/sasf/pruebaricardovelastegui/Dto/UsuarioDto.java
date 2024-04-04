package ec.sasf.pruebaricardovelastegui.Dto;

import ec.sasf.pruebaricardovelastegui.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id;
    private String username;

    private String email;
    private String password;
    private UserRole role;

    @Override
    public String toString() {
        return "UsuarioDto{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", role='" + role + '\'' +
            '}';
    }
    
}
