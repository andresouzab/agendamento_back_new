package com.agenda_service_back.service;

import com.agenda_service_back.entity.Pessoa;
import com.agenda_service_back.repository.PessoaRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private static final String SECRET_KEY = "yourSecretKey";
    private static final long EXPIRATION_TIME = 3600000;

    public String authenticate(String email, String senha) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        System.out.println("pessoa:" + pessoa);
        if (pessoa != null && pessoa.getSenha().equals(senha)) {
            return Jwts.builder()
                    .setSubject(pessoa.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
                    .compact();
        }
        return null;
    }
}
