package com.br.cwi.App.step;

import com.br.cwi.App.entity.Transacao;
import com.br.cwi.App.repository.TransacaoRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CSVItemProcessor implements ItemProcessor<Transacao, Transacao> {

    @Override
    public Transacao process(Transacao transacao) throws Exception {
        String idTrans = transacao.getIdTrans();
        System.out.printf("Processando transação [%s]....\n", idTrans);

        return transacao;
    }
}
