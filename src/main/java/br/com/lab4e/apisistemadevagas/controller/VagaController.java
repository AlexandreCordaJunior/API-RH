package br.com.lab4e.apisistemadevagas.controller;

import br.com.lab4e.apisistemadevagas.domain.Vaga;
import br.com.lab4e.apisistemadevagas.domain.VagaColaborador;
import br.com.lab4e.apisistemadevagas.service.VagaColaboradorService;
import br.com.lab4e.apisistemadevagas.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vaga")
public class VagaController {
    @Autowired
    private VagaService service;

    @Autowired
    private VagaColaboradorService vcService;

    @GetMapping(value = "/disp", produces = "application/json")
    public ResponseEntity vagaDisp(){
        List<Vaga> lista = service.disp();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity getColaboradores(){
        List<Vaga> lista = service.getVagas();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Vaga vaga){
        service.add(vaga);
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso");
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getColaborador(@PathVariable String id){
        Vaga vaga = service.getVaga(Long.parseLong(id));
        if(vaga == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(vaga);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity deleteColaborador(@PathVariable String id){
        Vaga vaga = service.getVaga(Long.parseLong(id));
        if(vaga == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        List<VagaColaborador> lista = vcService.byVaga(vaga);
        for(VagaColaborador vc: lista){
            vcService.delete(vc.getVaga().getCodigo(), vc.getColaborador().getCodigo());
        }
        service.delete(Long.parseLong(id));
        return ResponseEntity.ok("Deletado com sucesso");
    }


}
