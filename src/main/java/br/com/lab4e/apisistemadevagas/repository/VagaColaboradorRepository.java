package br.com.lab4e.apisistemadevagas.repository;

import br.com.lab4e.apisistemadevagas.domain.Colaborador;
import br.com.lab4e.apisistemadevagas.domain.VCID;
import br.com.lab4e.apisistemadevagas.domain.Vaga;
import br.com.lab4e.apisistemadevagas.domain.VagaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaColaboradorRepository extends JpaRepository<VagaColaborador, VCID> {
    @Query("SELECT vc FROM  vaga_colaborador vc WHERE vc.vaga = ?1")
    List<VagaColaborador> byVaga(Vaga vaga);

    @Query("SELECT vc FROM  vaga_colaborador vc WHERE vc.colaborador = ?1")
    List<VagaColaborador> byColaborador(Colaborador colaborador);
}
