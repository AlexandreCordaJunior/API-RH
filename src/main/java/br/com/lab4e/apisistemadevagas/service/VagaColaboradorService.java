package br.com.lab4e.apisistemadevagas.service;

import br.com.lab4e.apisistemadevagas.domain.Colaborador;
import br.com.lab4e.apisistemadevagas.domain.VCID;
import br.com.lab4e.apisistemadevagas.domain.Vaga;
import br.com.lab4e.apisistemadevagas.domain.VagaColaborador;
import br.com.lab4e.apisistemadevagas.repository.VagaColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaColaboradorService {
    @Autowired
    private VagaColaboradorRepository repository;

    public void add(VagaColaborador vagaColaborador){
        repository.save(vagaColaborador);
    }

    public void delete(Long vagaId, Long colaboradorId){
        VCID id = new VCID();
        id.setVagaId(vagaId);
        id.setColabId(colaboradorId);
        repository.deleteById(id);
    }

    public List<VagaColaborador> getVagaColaboradors(){
        return (List<VagaColaborador>) repository.findAll();
    }

    public VagaColaborador getVagaColaborador(Long vagaId, Long colaboradorId){
        VCID id = new VCID();
        id.setVagaId(vagaId);
        id.setColabId(colaboradorId);
        return (VagaColaborador) repository.findById(id).orElse(null);
    }

    public List<VagaColaborador> byVaga(Vaga vaga){
        return repository.byVaga(vaga);
    }

    public List<VagaColaborador> byColaborador(Colaborador colaborador){
        return repository.byColaborador(colaborador);
    }
}
