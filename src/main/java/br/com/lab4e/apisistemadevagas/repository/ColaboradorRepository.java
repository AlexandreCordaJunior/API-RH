package br.com.lab4e.apisistemadevagas.repository;

import br.com.lab4e.apisistemadevagas.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
