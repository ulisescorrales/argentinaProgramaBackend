/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.security.Controller;

import com.example.backend.argentinaPrograma.Security.Dto.JwtDto;
import com.example.backend.argentinaPrograma.Security.Enums.RolNombre;
import com.example.backend.argentinaPrograma.security.Dto.LoginUsuario;
import com.example.backend.argentinaPrograma.security.Service.UsuarioService;
import com.example.backend.argentinaPrograma.security.Dto.NuevoUsuario;
import com.example.backend.argentinaPrograma.security.Entity.Rol;
import com.example.backend.argentinaPrograma.security.Entity.Usuario;
import com.example.backend.argentinaPrograma.security.Service.RolService;
import com.example.backend.argentinaPrograma.security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    
    //Solo un usuario administrador puede crear otro usuario
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("El email ya existe"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    //JwDto sería el token
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt=jwtProvider.generateToken(authentication);
        
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto= new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> eliminarUsuario(@RequestParam String nombreUsuario){
        ResponseEntity respuesta;
        if(usuarioService.existByNombreUsuario(nombreUsuario)){
            usuarioService.delete(nombreUsuario);
            respuesta=new ResponseEntity(new Mensaje("Usuario Eliminado"),HttpStatus.OK);
        }else{
            respuesta=new ResponseEntity(new Mensaje("Usuario no existe"),HttpStatus.NOT_FOUND);
        }
        return respuesta;
    }
    //Prueba
    @GetMapping("/user")
    public ResponseEntity existeUsuarioNombre(@RequestParam String nombreUsuario){
        ResponseEntity respuesta;        
        if(usuarioService.existByNombreUsuario(nombreUsuario)){
            respuesta=new ResponseEntity(new Mensaje("Usuario existe"),HttpStatus.OK);
        }else{
            respuesta=new ResponseEntity(new Mensaje("Usuario no existe: "+nombreUsuario),HttpStatus.NOT_FOUND);            
        }
        return respuesta;
    }
}
