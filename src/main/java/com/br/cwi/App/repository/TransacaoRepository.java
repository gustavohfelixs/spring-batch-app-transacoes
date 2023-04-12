package com.br.cwi.App.repository;

import com.br.cwi.App.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
