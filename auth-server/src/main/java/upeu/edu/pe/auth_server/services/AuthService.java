package upeu.edu.pe.auth_server.services;

import upeu.edu.pe.auth_server.dtos.TokenDto;
import upeu.edu.pe.auth_server.dtos.UserDto;

public interface AuthService {
    TokenDto login(UserDto user);
    TokenDto validateToken(TokenDto token);



}
