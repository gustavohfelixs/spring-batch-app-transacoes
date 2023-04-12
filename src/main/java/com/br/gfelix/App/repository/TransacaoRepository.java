package com.br.gfelix.App.repository;

import com.br.gfelix.App.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
