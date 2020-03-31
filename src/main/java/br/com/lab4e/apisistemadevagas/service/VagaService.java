package br.com.lab4e.apisistemadevagas.service;

import br.com.lab4e.apisistemadevagas.domain.Vaga;
import br.com.lab4e.apisistemadevagas.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {
    @Autowired
    private VagaRepository repository;

    public void add(Vaga vaga){
        repository.save(vaga);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Vaga> getVagas(){
        return (List<Vaga>) repository.findAll();
    }

    public Vaga getVaga(Long id){
        return (Vaga) repository.findById(id).orElse(null);
    }

    public List<Vaga> disp(){
        return repository.disp();
    }

}
