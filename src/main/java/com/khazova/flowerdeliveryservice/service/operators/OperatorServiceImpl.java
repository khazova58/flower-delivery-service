package com.khazova.flowerdeliveryservice.service.operators;

import com.khazova.flowerdeliveryservice.exception.part2.Error;
import com.khazova.flowerdeliveryservice.exception.part2.ServiceException;
import com.khazova.flowerdeliveryservice.model.dto.UpdateOperatorResponse;
import com.khazova.flowerdeliveryservice.model.entity.Operator;
import com.khazova.flowerdeliveryservice.repository.OperatorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис для работы с оператором
 */
@Service
@Transactional(readOnly = true)
public class OperatorServiceImpl {
    private final OperatorRepository operatorRepository;

    public OperatorServiceImpl(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }

    /**
     * Создать нового оператора
     * @param operator оператор
     * @return ID нового оператора в строковом представлении
     */
    @Transactional
    public String createNewOperator(Operator operator) {
        operatorRepository.save(operator);
        return operator.getOperatorID();
    }

    /**
     * Удалить оператора из базы по идентификатору
     * @param id оператора
     */
    @Transactional
    public boolean deleteOperatorByID(String id){
        findOneOperatorByID(id);
        operatorRepository.deleteById(id);
        return true;
    }

    /**
     * Найти оператора по идентификатору
     * @param id оператора
     * @return найденный оператор или exception
     */
    public Operator findOneOperatorByID(String id) {
        return operatorRepository.findById(id)
                .orElseThrow(() -> new ServiceException(Error.COURIER_NOT_FOUND));
    }

    /**
     * Получить список всех операторов
     * @return список найденных операторов
     */
    public List<Operator> findAllOperators() {
        return operatorRepository.findAll();
    }

    /**
     * Обновить существующую запись оператора
     * @param id оператора
     * @param updateOperator новые данные
     */
    @Transactional
    public UpdateOperatorResponse updateOperatorByID(String id, Operator updateOperator) {
        findOneOperatorByID(id);
        updateOperator.setOperatorID(id);
        operatorRepository.save(updateOperator);
        return new UpdateOperatorResponse(true);
    }
}