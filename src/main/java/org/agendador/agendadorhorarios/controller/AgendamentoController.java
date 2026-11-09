package org.agendador.agendadorhorarios.controller;

import lombok.RequiredArgsConstructor;
import org.agendador.agendadorhorarios.infrastructure.entity.Agendamento;
import org.agendador.agendadorhorarios.services.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento) {
        return ResponseEntity.ok().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente, @RequestParam LocalDateTime dataHoraAgendamento) {
        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarAgendamentosDoDia(@RequestParam LocalDate date) {
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDoDia(date));
    }

    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamentos(@RequestBody Agendamento agendamento, @RequestParam String cliente, @RequestParam LocalDateTime dataHoraAgendamento) {
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento));
    }


}
