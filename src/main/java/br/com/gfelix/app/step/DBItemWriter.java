package br.com.gfelix.app.step;

import br.com.gfelix.app.entity.Transacao;
import br.com.gfelix.app.repository.TransacaoRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DBItemWriter implements ItemWriter<Transacao> {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Override
    public void write(List<? extends Transacao> listTransacoes) throws Exception {
        System.out.println("Data Saved for Employees: " + listTransacoes);
        transacaoRepository.saveAll(listTransacoes);
    }
}
