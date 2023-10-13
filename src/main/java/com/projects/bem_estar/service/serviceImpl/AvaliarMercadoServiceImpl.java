package com.projects.bem_estar.service.serviceImpl;

import com.projects.bem_estar.models.AvaliarMercado;
import com.projects.bem_estar.models.Cliente;
import com.projects.bem_estar.models.Mercado;
import com.projects.bem_estar.repository.AvaliarMercadoRepository;
import com.projects.bem_estar.repository.ClienteRepository;
import com.projects.bem_estar.repository.MercadoRepository;
import com.projects.bem_estar.service.AvaliarMercadoService;
import com.projects.bem_estar.service.ClienteService;
import com.projects.bem_estar.service.MercadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliarMercadoServiceImpl implements AvaliarMercadoService {
    private final ClienteService clienteService;
    private final MercadoService mercadoService;
    private final AvaliarMercadoRepository avaliarMercadoRepository;

    public AvaliarMercadoServiceImpl(ClienteRepository clienteRepository, MercadoRepository mercadoRepository, ClienteService clienteService, MercadoService mercadoService, AvaliarMercadoRepository avaliarMercadoRepository) {
        this.clienteService = clienteService;
        this.mercadoService = mercadoService;
        this.avaliarMercadoRepository = avaliarMercadoRepository;
    }

    @Override
    public AvaliarMercado getAvaliarEntregaById(Long id) {
        Optional<AvaliarMercado> optionalAvaliarEntrega = avaliarMercadoRepository.findById(id);
        return optionalAvaliarEntrega.orElse(null);
    }

    @Override
    public List<AvaliarMercado> getAllAvaliarEntrega() {
         return avaliarMercadoRepository.findAll();
    }

    @Override
    public AvaliarMercado createAvaliarEntrega(AvaliarMercado avaliarEntrega) {
        Cliente clienteExistente = clienteService.getClienteById(avaliarEntrega.getCliente().getIdCliente());
        Mercado mercadoExistente = mercadoService.getMercadoById(avaliarEntrega.getMercado().getIdMercado());
        if(clienteExistente!=null && mercadoExistente!=null){
            return avaliarMercadoRepository.save(
                    new AvaliarMercado(
                            avaliarEntrega.getAtendimento(),avaliarEntrega.getComentarios(),
                            clienteExistente,mercadoExistente
                    ));
        } else if (clienteExistente==null && mercadoExistente!=null) {
            clienteService.createCliente(avaliarEntrega.getCliente());
            return avaliarMercadoRepository.save(avaliarEntrega);
        } else if (mercadoExistente==null && clienteExistente!=null) {
            mercadoService.createMercado(avaliarEntrega.getMercado());
            return avaliarMercadoRepository.save(avaliarEntrega);
        }else{
            clienteService.createCliente(avaliarEntrega.getCliente());
            mercadoService.createMercado(avaliarEntrega.getMercado());
            return avaliarMercadoRepository.save(avaliarEntrega);
        }
    }

    @Override
    public AvaliarMercado updateAvaliarEntrega(Long id, AvaliarMercado avaliarEntrega) {
        AvaliarMercado avaliarEntregaExistente = getAvaliarEntregaById(id);
        if(avaliarEntregaExistente!=null){
            avaliarEntregaExistente.setAtendimento(avaliarEntrega.getAtendimento());
            avaliarEntregaExistente.setComentarios(avaliarEntrega.getComentarios());
            return avaliarMercadoRepository.save(avaliarEntregaExistente);
        }
        return null;
    }

    @Override
    public AvaliarMercado deleteAvaliarEntrega(Long id) {
        avaliarMercadoRepository.deleteById(id);
        return null;
    }
}
