package br.com.vivaperifa.vivaperifa_api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivaperifa.vivaperifa_api.models.OrganizadorModel;
import br.com.vivaperifa.vivaperifa_api.repositories.OrganizadorRepository;

@RestController
@CrossOrigin(origins = "localhost:3000")
public class OrganizadorController {
    @Autowired
    OrganizadorRepository repository;

    @GetMapping("/organizador/{codigo}")
    public ResponseEntity<OrganizadorModel> carregar(@PathVariable int codigo){
        Optional<OrganizadorModel> obj = repository.findById(codigo);
        return ResponseEntity.ok(obj.get());
    }

    @GetMapping("/organizadores")
    public ResponseEntity<List<OrganizadorModel>> listar(){
        List<OrganizadorModel> listagem = repository.findAll();
        return ResponseEntity.ok(listagem);
    }

    @PostMapping("/organizador")
    public ResponseEntity<String> cadastrar(@RequestBody OrganizadorModel obj){
        repository.save(obj);
        String msg = "Registro salvo com sucesso";
        return ResponseEntity.ok(msg);
    }
}