package com.projects.bem_estar.service.serviceImpl;

import com.projects.bem_estar.models.AvaliarEntrega;
import com.projects.bem_estar.models.Cliente;
import com.projects.bem_estar.models.Mercado;
import com.projects.bem_estar.repository.AvaliarEntregaRepository;
import com.projects.bem_estar.repository.ClienteRepository;
import com.projects.bem_estar.repository.MercadoRepository;
import com.projects.bem_estar.service.AvaliarEntregaService;
import com.projects.bem_estar.service.ClienteService;
import com.projects.bem_estar.service.MercadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliarEntregaServiceImpl implements AvaliarEntregaService {
    private final ClienteService clienteService;
    private final MercadoService mercadoService;
    private final AvaliarEntregaRepository avaliarEntregaRepository;

    public AvaliarEntregaServiceImpl(ClienteRepository clienteRepository, MercadoRepository mercadoRepository, ClienteService clienteService, MercadoService mercadoService, AvaliarEntregaRepository avaliarEntregaRepository) {
        this.clienteService = clienteService;
        this.mercadoService = mercadoService;
        this.avaliarEntregaRepository = avaliarEntregaRepository;
    }

    @Override
    public AvaliarEntrega getAvaliarEntregaById(Long id) {
        Optional<AvaliarEntrega> optionalAvaliarEntrega = avaliarEntregaRepository.findById(id);
        return optionalAvaliarEntrega.orElse(null);
    }

    @Override
    public List<AvaliarEntrega> getAllAvaliarEntrega() {
         return avaliarEntregaRepository.findAll();
    }

    @Override
    public AvaliarEntrega createAvaliarEntrega(AvaliarEntrega avaliarEntrega) {
        Cliente clienteExistente = clienteService.getClienteById(avaliarEntrega.getCliente().getIdCliente());
        Mercado mercadoExistente = mercadoService.getMercadoById(avaliarEntrega.getMercado().getIdMercado());
        if(clienteExistente!=null && mercadoExistente!=null){
            return avaliarEntregaRepository.save(
                    new AvaliarEntrega(
                            avaliarEntrega.getAtendimento(),avaliarEntrega.getTempoDeEntrega(),avaliarEntrega.getQualidadeDeEntrega(),avaliarEntrega.getQualidadeDoProduto(), avaliarEntrega.getComentarios(),
                            clienteExistente,mercadoExistente
                    ));
        } else if (clienteExistente==null && mercadoExistente!=null) {
            clienteService.createCliente(avaliarEntrega.getCliente());
            return avaliarEntregaRepository.save(avaliarEntrega);
        } else if (mercadoExistente==null && clienteExistente!=null) {
            mercadoService.createMercado(avaliarEntrega.getMercado());
            return avaliarEntregaRepository.save(avaliarEntrega);
        }else{
            clienteService.createCliente(avaliarEntrega.getCliente());
            mercadoService.createMercado(avaliarEntrega.getMercado());
            return avaliarEntregaRepository.save(avaliarEntrega);
        }
    }

    @Override
    public AvaliarEntrega updateAvaliarEntrega(Long id, AvaliarEntrega avaliarEntrega) {
        AvaliarEntrega avaliarEntregaExistente = getAvaliarEntregaById(id);
        if(avaliarEntregaExistente!=null){
            avaliarEntregaExistente.setAtendimento(avaliarEntrega.getAtendimento());
            avaliarEntregaExistente.setTempoDeEntrega(avaliarEntrega.getTempoDeEntrega());
            avaliarEntregaExistente.setQualidadeDeEntrega(avaliarEntrega.getQualidadeDeEntrega());
            avaliarEntregaExistente.setQualidadeDoProduto(avaliarEntrega.getQualidadeDoProduto());
            avaliarEntregaExistente.setComentarios(avaliarEntrega.getComentarios());
            return avaliarEntregaRepository.save(avaliarEntregaExistente);
        }
        return null;
    }

    @Override
    public AvaliarEntrega deleteAvaliarEntrega(Long id) {
        avaliarEntregaRepository.deleteById(id);
        return null;
    }
}
