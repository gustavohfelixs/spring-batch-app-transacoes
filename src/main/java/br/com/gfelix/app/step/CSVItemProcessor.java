package br.com.gfelix.app.step;

import br.com.gfelix.app.entity.Transacao;
import org.springframework.batch.item.ItemProcessor;
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
