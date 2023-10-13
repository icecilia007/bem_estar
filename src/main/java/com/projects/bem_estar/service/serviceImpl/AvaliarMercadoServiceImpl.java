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
    public AvaliarMercado getAvaliarMercadoById(Long id) {
        Optional<AvaliarMercado> optionalAvaliarMercado = avaliarMercadoRepository.findById(id);
        return optionalAvaliarMercado.orElse(null);
    }

    @Override
    public List<AvaliarMercado> getAllAvaliarMercado() {
         return avaliarMercadoRepository.findAll();
    }

    @Override
    public AvaliarMercado createAvaliarMercado(AvaliarMercado AvaliarMercado) {
        Cliente clienteExistente = clienteService.getClienteById(AvaliarMercado.getCliente().getIdCliente());
        Mercado mercadoExistente = mercadoService.getMercadoById(AvaliarMercado.getMercado().getIdMercado());
        if(clienteExistente!=null && mercadoExistente!=null){
            return avaliarMercadoRepository.save(
                    new AvaliarMercado(
                            AvaliarMercado.getAtendimento(),AvaliarMercado.getComentarios(),
                            clienteExistente,mercadoExistente
                    ));
        } else if (clienteExistente==null && mercadoExistente!=null) {
            clienteService.createCliente(AvaliarMercado.getCliente());
            return avaliarMercadoRepository.save(AvaliarMercado);
        } else if (mercadoExistente==null && clienteExistente!=null) {
            mercadoService.createMercado(AvaliarMercado.getMercado());
            return avaliarMercadoRepository.save(AvaliarMercado);
        }else{
            clienteService.createCliente(AvaliarMercado.getCliente());
            mercadoService.createMercado(AvaliarMercado.getMercado());
            return avaliarMercadoRepository.save(AvaliarMercado);
        }
    }

    @Override
    public AvaliarMercado updateAvaliarMercado(Long id, AvaliarMercado AvaliarMercado) {
        AvaliarMercado AvaliarMercadoExistente = getAvaliarMercadoById(id);
        if(AvaliarMercadoExistente!=null){
            AvaliarMercadoExistente.setAtendimento(AvaliarMercado.getAtendimento());
            AvaliarMercadoExistente.setComentarios(AvaliarMercado.getComentarios());
            return avaliarMercadoRepository.save(AvaliarMercadoExistente);
        }
        return null;
    }

    @Override
    public AvaliarMercado deleteAvaliarMercado(Long id) {
        avaliarMercadoRepository.deleteById(id);
        return null;
    }
}
