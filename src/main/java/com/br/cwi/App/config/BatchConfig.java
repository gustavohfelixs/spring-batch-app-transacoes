package com.br.cwi.App.config;


import com.br.cwi.App.entity.Transacao;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.sound.sampled.Line;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Job job (JobBuilderFactory jobBuilderFactory,
                    StepBuilderFactory stepBuilderFactory,
                    ItemReader<Transacao> itemReader,
                    ItemProcessor<Transacao, Transacao> itemProcessor,
                    ItemWriter<Transacao> itemWriter
     ) {
        Step step = stepBuilderFactory.get("Step Carrega Dados")
                .<Transacao, Transacao> chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        return jobBuilderFactory.get("Job Carrega Step")
                .start(step)
                .build();
        }
    @Bean
    public FlatFileItemReader<Transacao> temReader() {
        FlatFileItemReader<Transacao> reader = new FlatFileItemReader<Transacao>();
        reader.setResource(new FileSystemResource("src/main/resources/transacoes.csv"));
        reader.setName("Leitor CSV");
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());

        return reader;
    }

    @Bean
    public LineMapper<Transacao> lineMapper() {
        DefaultLineMapper<Transacao> defaultLineMapper = new DefaultLineMapper<Transacao>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("idTrans","cnpjRemetente","cnpjDestinatario","tipoConta","valor","dataCriacao");

        BeanWrapperFieldSetMapper<Transacao> fieldSetMapper = new BeanWrapperFieldSetMapper<Transacao>();
        fieldSetMapper.setTargetType(Transacao.class);

        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        defaultLineMapper.setLineTokenizer(lineTokenizer);

        return  defaultLineMapper;
    }
}


