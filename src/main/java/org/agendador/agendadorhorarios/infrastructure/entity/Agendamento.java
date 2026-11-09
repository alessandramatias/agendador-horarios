package org.agendador.agendadorhorarios.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamento")

public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;
    private String profissionalResponsavel;
    private LocalDateTime dataHoraAgendamento;
    private String cliente;
    private String telefoneCliente;
    private LocalDateTime dataInsercao = LocalDateTime.now();

}
