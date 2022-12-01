package com.khazova.flowerdeliveryservice.service.operators;

import com.khazova.flowerdeliveryservice.model.entity.Operator;
import com.khazova.flowerdeliveryservice.repository.OperatorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OperatorServiceImpl {
    private final OperatorRepository operatorRepository;

    public OperatorServiceImpl(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }

    @Transactional
    public void createNewOperator(Operator operator) {
        operatorRepository.save(operator);
    }

    @Transactional
    public void deleteOperatorByID(String id){
        operatorRepository.deleteById(id);
    }

    public Operator findOneOperatorByID(String id) {
        Optional<Operator> foundOperator = operatorRepository.findById(id);
        return foundOperator.orElse(null);
    }

    public List<Operator> findAll() {
        return operatorRepository.findAll();
    }

    @Transactional
    public void updateOperatorByID(String id, Operator updateOperator) {
        updateOperator.setOperatorID(id);
        operatorRepository.save(updateOperator);
    }
}