package br.com.lab4e.apisistemadevagas.repository;

import br.com.lab4e.apisistemadevagas.domain.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    @Query("SELECT v FROM  vaga v WHERE v.tipo = 'Interna' AND v.situacao = 'Aberta'")
    List<Vaga> disp();
}
