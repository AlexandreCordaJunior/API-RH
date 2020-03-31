package br.com.lab4e.apisistemadevagas.service;

import br.com.lab4e.apisistemadevagas.domain.Colaborador;
import br.com.lab4e.apisistemadevagas.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository repository;

    public void add(Colaborador colaborador){
        repository.save(colaborador);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Colaborador> getColaboradores(){
        return (List<Colaborador>) repository.findAll();
    }

    public Colaborador getColaborador(Long id){
        return (Colaborador) repository.findById(id).orElse(null);
    }
}
