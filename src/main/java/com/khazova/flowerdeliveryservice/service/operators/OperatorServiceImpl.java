package com.khazova.flowerdeliveryservice.service.operators;

import com.khazova.flowerdeliveryservice.exception.Error;
import com.khazova.flowerdeliveryservice.exception.ServiceException;
import com.khazova.flowerdeliveryservice.model.dto.CreateOperatorResponse;
import com.khazova.flowerdeliveryservice.model.dto.OperatorDTO;
import com.khazova.flowerdeliveryservice.model.dto.UpdateOperatorResponse;
import com.khazova.flowerdeliveryservice.model.entity.Operator;
import com.khazova.flowerdeliveryservice.model.mapper.OperatorMapper;
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
    private final OperatorMapper operatorMapper = new OperatorMapper();

    public OperatorServiceImpl(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }

    /**
     * Создать нового оператора
     * @param operatorDTO оператор
     * @return ID нового оператора в строковом представлении
     */
    @Transactional
    public CreateOperatorResponse createNewOperator(OperatorDTO operatorDTO) {
        Operator operator = operatorMapper.dtoMapToOperator(operatorDTO);
        String id = operatorRepository.saveAndFlush(operator).getOperatorID();
        return new CreateOperatorResponse(id);
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
    public OperatorDTO findOneOperatorByID(String id) {
        return operatorMapper.operatorMapToDTO(operatorRepository.findById(id)
                .orElseThrow(() -> new ServiceException(Error.OPERATOR_NOT_FOUND, id)));
    }

    /**
     * Получить список всех операторов
     * @return список найденных операторов
     */
    public List<OperatorDTO> findAllOperators() {
        return operatorMapper.convertListOperatorToListOperatorDTO(operatorRepository.findAll());

    }

    /**
     * Обновить существующую запись оператора
     * @param id оператора
     * @param updateOperatorDTO новые данные
     */
    @Transactional
    public UpdateOperatorResponse updateOperatorByID(String id, OperatorDTO updateOperatorDTO) {
        findOneOperatorByID(id);
        Operator updateOperator = operatorMapper.dtoMapToOperator(updateOperatorDTO);
        updateOperator.setOperatorID(id);
        operatorRepository.save(updateOperator);
        return new UpdateOperatorResponse(true);
    }
}