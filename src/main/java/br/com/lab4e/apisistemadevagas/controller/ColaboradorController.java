package br.com.lab4e.apisistemadevagas.controller;

import br.com.lab4e.apisistemadevagas.domain.Colaborador;
import br.com.lab4e.apisistemadevagas.domain.VagaColaborador;
import br.com.lab4e.apisistemadevagas.service.ColaboradorService;
import br.com.lab4e.apisistemadevagas.service.VagaColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    @Autowired
    ColaboradorService service;

    @Autowired
    private VagaColaboradorService vcService;

    @GetMapping(produces = "application/json")
    public ResponseEntity getColaboradores(){
        List<Colaborador> lista = service.getColaboradores();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Colaborador colaborador){
        service.add(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso");
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getColaborador(@PathVariable String id){
        Colaborador colaborador = service.getColaborador(Long.parseLong(id));
        if(colaborador == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(colaborador);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity deleteColaborador(@PathVariable String id){
        Colaborador colaborador = service.getColaborador(Long.parseLong(id));
        if(colaborador == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        List<VagaColaborador> lista = vcService.byColaborador(colaborador);
        for(VagaColaborador vc: lista){
            vcService.delete(vc.getVaga().getCodigo(), vc.getColaborador().getCodigo());
        }
        service.delete(Long.parseLong(id));
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
