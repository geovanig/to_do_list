package com.geovani.todolist.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import com.geovani.todolist.model.Login;
import com.geovani.todolist.model.Usuario;
import com.geovani.todolist.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			return Optional.empty();
		}
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		if (usuarioRepository.findById(usuario.getId()).isPresent()) {
			Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());
			if (buscaUsuario.isPresent()) {
				if (buscaUsuario.get().getId() != usuario.getId())
					return Optional.empty();
			}
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			return Optional.of(usuarioRepository.save(usuario));
		}
		return Optional.empty();
	}

	public Optional<Login> autenticarUsuario(Optional<Login> loginUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(loginUsuario.get().getEmail());
		if (usuario.isPresent()) {
			if (compararSenhas(loginUsuario.get().getSenha(), usuario.get().getSenha())) {
				loginUsuario.get().setId(usuario.get().getId());
				loginUsuario.get().setNome(usuario.get().getNome());
				loginUsuario.get().setSenha(usuario.get().getSenha());
				loginUsuario.get().setToken(gerarBasicToken(loginUsuario.get().getEmail(), loginUsuario.get().getSenha()));
				return loginUsuario;
			}
		}
		return Optional.empty();
	}

	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senhaDigitada, senhaBanco);
	}

	private String gerarBasicToken(String email, String senha) {
		String token = email + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}
	
}
