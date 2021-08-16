package br.goc.ac.sefaz.calendario.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.goc.ac.sefaz.calendario.model.Eventos;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, String>{

}
