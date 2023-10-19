package com.projects.bem_estar.controllers;

import com.projects.bem_estar.models.Cliente;
import com.projects.bem_estar.models.Orcamento;
import com.projects.bem_estar.models.PlanoAlimentar;
import com.projects.bem_estar.service.ClienteService;
import com.projects.bem_estar.service.OrcamentoService;
import com.projects.bem_estar.service.PlanoAlimentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orcamentos")
@CrossOrigin(origins = "*")
public class OrcamentoController {
    private final OrcamentoService orcamentoService;
    private final PlanoAlimentarService planoAlimentarService;
    private final ClienteService clienteService;

    @Autowired
    public OrcamentoController(OrcamentoService orcamentoService, PlanoAlimentarService planoAlimentarService, ClienteService clienteService) {
        this.orcamentoService = orcamentoService;
        this.planoAlimentarService = planoAlimentarService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Orcamento>> getAllOrcamentos() {
        List<Orcamento> orcamentos = orcamentoService.getAllOrcamentos();
        return new ResponseEntity<>(orcamentos, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Orcamento> getOrcamentoById(@RequestParam("idMercado") Long idMercado, @RequestParam("idPlanoAlimentar") Long idPlanoAlimentar) {
        Orcamento orcamento = orcamentoService.getOrcamentoById(idMercado, idPlanoAlimentar);
        if (orcamento != null) {
            return new ResponseEntity<>(orcamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/plano-alimentar")
    public ResponseEntity<List<Orcamento>> getOrcamentosByPlanoAlimentar(@RequestParam("idPlanoAlimentar") Long idPlanoAlimentar) {
        List<Orcamento> orcamentos = orcamentoService.getOrcamentosByPlanoAlimentar(idPlanoAlimentar);
        if (!orcamentos.isEmpty()) {
            return new ResponseEntity<>(orcamentos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/mercado")
    public ResponseEntity<List<Orcamento>> getOrcamentosByMercado(@RequestParam("idMercado") Long idMercado) {
        List<Orcamento> orcamentos = orcamentoService.getOrcamentosByMercado(idMercado);
        if (!orcamentos.isEmpty()) {
            return new ResponseEntity<>(orcamentos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Orcamento>> getOrcamentosByStatus(@PathVariable String status) {
        List<Orcamento> orcamentos = orcamentoService.getOrcamentosByStatus(status);
        return new ResponseEntity<>(orcamentos, HttpStatus.OK);
    }

    @GetMapping("/status/pendentes-planos")
    public ResponseEntity<List<Orcamento>> getOrcamentosPendentesPlanos() {
        // Primeiro, obtenha todos os orçamentos com status "pendente"
        List<Orcamento> orcamentosPendentes = orcamentoService.getOrcamentosByStatus("PEND");

        // Agora, filtre os orçamentos para encontrar aqueles cujos planos alimentares têm status "pendente de orçamento"
        List<Orcamento> orcamentosPendentesPlanos = orcamentosPendentes.stream()
                .filter(orcamento -> orcamento.getPlanoAlimentar().getStatus().equals("PENDO"))
                .collect(Collectors.toList());

        if (!orcamentosPendentesPlanos.isEmpty()) {
            return new ResponseEntity<>(orcamentosPendentesPlanos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/status/pendentes-orcamentos")
    public ResponseEntity<List<PlanoAlimentar>> getPlanosPendenteOrcamento() {
        // Primeiro, obtenha todos os planos alimentares com status pendente orçamento
        List<PlanoAlimentar> orcamentosPendentes = planoAlimentarService.getAllPlanosAlimentaresByStatus("PENDO");
        if (!orcamentosPendentes.isEmpty()) {
            return new ResponseEntity<>(orcamentosPendentes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Orcamento> createOrcamento(@RequestBody Orcamento orcamento) {
        Orcamento newOrcamento = orcamentoService.createOrcamento(orcamento);
        if (newOrcamento != null) {
            return new ResponseEntity<>(newOrcamento, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/")
    public ResponseEntity<Orcamento> updateOrcamento(@RequestParam("idMercado") Long idMercado, @RequestParam("idPlanoAlimentar") Long idPlanoAlimentar, @RequestBody Orcamento orcamento) {
        Orcamento updatedOrcamento = orcamentoService.updateOrcamento(idMercado, idPlanoAlimentar, orcamento);
        if (updatedOrcamento != null) {
            return new ResponseEntity<>(updatedOrcamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/orcamentos/aceitar")
    public ResponseEntity<Orcamento> aceitarOrcamento(@RequestBody Orcamento orcamentoAceito) {
        // Verifica se o orçamento enviado contém os IDs do Mercado e PlanoAlimentar.
        if (orcamentoAceito.getMercado() == null || orcamentoAceito.getPlanoAlimentar() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // Obtenha o orçamento a ser aceito
        Orcamento orcamentoExistente = orcamentoService.getOrcamentoById(orcamentoAceito.getMercado().getIdMercado(), orcamentoAceito.getPlanoAlimentar().getIdPlanoAlimentar());

        if (orcamentoExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Atualize o status do orçamento para "aceito"
        orcamentoExistente.setStatus("ACEITO");
        orcamentoService.updateOrcamento(orcamentoExistente.getMercado().getIdMercado(), orcamentoExistente.getPlanoAlimentar().getIdPlanoAlimentar(), orcamentoExistente);

        // Obtenha o plano alimentar associado a este orçamento
        PlanoAlimentar planoAlimentar = orcamentoExistente.getPlanoAlimentar();

        if (planoAlimentar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Atualize o status do plano alimentar para "pendente frequência"
        planoAlimentar.setStatus("PENDF");
        planoAlimentarService.updatePlanoAlimentarStatus(planoAlimentar.getIdPlanoAlimentar(), planoAlimentar.getStatus());

        // Obtenha todos os outros orçamentos do mesmo plano que não sejam o orçamento aceito
        List<Orcamento> outrosOrcamentos = orcamentoService.getOrcamentosByPlanoAlimentarId(planoAlimentar.getIdPlanoAlimentar());
        for (Orcamento orcamento : outrosOrcamentos) {
            if (!orcamento.getMercado().equals(orcamentoAceito.getMercado())) {
                // Atualize o status de outros orçamentos do mesmo plano para "negado"
                orcamento.setStatus("NEGADO");
                orcamentoService.updateOrcamento(orcamento.getMercado().getIdMercado(), orcamento.getPlanoAlimentar().getIdPlanoAlimentar(), orcamento);
            }
        }
        return new ResponseEntity<>(orcamentoExistente, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrcamento(@PathVariable Long id) {
        orcamentoService.deleteOrcamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/cliente/{clienteId}/orcamentos-pendentes-planos")
    public ResponseEntity<List<Orcamento>> getOrcamentosPendentesPlanos(@PathVariable Long clienteId) {
        // Primeiro, você pode obter o cliente pelo ID
        Cliente cliente = clienteService.getClienteById(clienteId);

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Em seguida, obtenha todos os orçamentos pendentes para esse cliente
        List<Orcamento> orcamentosPendentes = orcamentoService.getOrcamentosByStatus("PEND");

        // Filtre os orçamentos para obter aqueles com plano alimentar "pendente de orçamento" e depois filtre para onde o plano alimenter tem o cliente em questão
        List<Orcamento> orcamentosPendentesPlanos = orcamentosPendentes.stream()
                .filter(orcamento -> orcamento.getPlanoAlimentar().getStatus().equals("PENDO"))
                .filter(orcamento -> orcamento.getPlanoAlimentar().getCliente().equals(cliente))
                .collect(Collectors.toList());
        return new ResponseEntity<>(orcamentosPendentesPlanos, HttpStatus.OK);
    }
    /*@GetMapping("/cliente/{clienteId}/orcamentos-pendentes-planos")
    public ResponseEntity<List<Orcamento>> getOrcamentosPendentesPlanos(@PathVariable Long clienteId) {
        // Primeiro, obtenha o cliente pelo ID
        Cliente cliente = clienteService.getClienteById(clienteId);

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Em seguida, obtenha os planos alimentares do cliente com status "pendente de orçamento"
        List<PlanoAlimentar> planosPendentes = planoAlimentarService.getPlanosAlimentaresByClienteId(clienteId).stream()
                .filter(plano -> plano.getStatus().equals("PENDO"))
                .toList();

        // Agora, você pode obter os orçamentos associados a esses planos alimentares
        List<Orcamento> orcamentosPendentesPlanos = new ArrayList<>();

        for (PlanoAlimentar plano : planosPendentes) {
            List<Orcamento> orcamentos = orcamentoService.getOrcamentosByPlanoAlimentarId(plano.getIdPlanoAlimentar());
            orcamentosPendentesPlanos.addAll(orcamentos);
        }

        return new ResponseEntity<>(orcamentosPendentesPlanos, HttpStatus.OK);
    }*/
}
