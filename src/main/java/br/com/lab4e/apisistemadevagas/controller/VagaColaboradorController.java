package br.com.lab4e.apisistemadevagas.controller;

import br.com.lab4e.apisistemadevagas.domain.Colaborador;
import br.com.lab4e.apisistemadevagas.domain.VCID;
import br.com.lab4e.apisistemadevagas.domain.Vaga;
import br.com.lab4e.apisistemadevagas.domain.VagaColaborador;
import br.com.lab4e.apisistemadevagas.service.ColaboradorService;
import br.com.lab4e.apisistemadevagas.service.VagaColaboradorService;
import br.com.lab4e.apisistemadevagas.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vaga_colaborador")
public class VagaColaboradorController {
    @Autowired
    private VagaColaboradorService service;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private VagaService vagaService;

    @GetMapping(produces = "application/json")
    public ResponseEntity getVagaColaboradors(){
        List<VagaColaborador> lista = service.getVagaColaboradors();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Helper helper){
        Vaga vaga = vagaService.getVaga(helper.getVaga());
        if(vaga == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
        }

        Colaborador colaborador = colaboradorService.getColaborador(helper.getColaborador());
        if(colaborador == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrada");
        }

        VagaColaborador vc = new VagaColaborador();
        vc.setColaborador(colaborador);
        vc.setVaga(vaga);
        vc.setDataDeCadastro(helper.getTempo());

        VCID id = new VCID();
        id.setVagaId(vaga.getCodigo());
        id.setColabId(colaborador.getCodigo());
        vc.setId(id);

        service.add(vc);
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso");
    }

    @GetMapping(value = "/{idVaga}/{idColab}", produces = "application/json")
    public ResponseEntity getColaborador(@PathVariable String idVaga, @PathVariable String idColab){
        VagaColaborador vc = service.getVagaColaborador(Long.parseLong(idVaga), Long.parseLong(idColab));
        if(vc == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(vc);
    }

    @DeleteMapping(value = "/{idVaga}/{idColab}", produces = "application/json")
    public ResponseEntity deleteColaborador(@PathVariable String idVaga, @PathVariable String idColab){
        VagaColaborador vc = service.getVagaColaborador(Long.parseLong(idVaga), Long.parseLong(idColab));
        if(vc == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        service.delete(Long.parseLong(idVaga), Long.parseLong(idColab));
        return ResponseEntity.ok("Deletado com sucesso");
    }

    @GetMapping(value = "/vaga/{id}", produces = "application/json")
    public ResponseEntity byVaga(@PathVariable String id){
        Vaga vaga = vagaService.getVaga(Long.parseLong(id));
        List<VagaColaborador> lista = service.byVaga(vaga);
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(lista);
    }
}

class Helper{
    private Long vaga;
    private Long colaborador;
    private Date tempo;

    public Long getVaga() {
        return vaga;
    }

    public void setVaga(Long vaga) {
        this.vaga = vaga;
    }

    public Long getColaborador() {
        return colaborador;
    }

    public void setColaborador(Long colaborador) {
        this.colaborador = colaborador;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }
}