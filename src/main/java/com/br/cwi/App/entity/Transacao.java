package com.br.cwi.App.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transacao {
    @Id
    private String idTrans;
    private String cnpjRemetente;
    private String cnpjDestinatario;
    private String tipoConta;
    private Integer valor;
    private Date dataTrans;

}
