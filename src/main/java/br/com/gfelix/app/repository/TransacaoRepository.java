package br.com.gfelix.app.repository;

import br.com.gfelix.app.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
