package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.OperatorDTO;
import com.khazova.flowerdeliveryservice.model.entity.Operator;

import java.util.ArrayList;
import java.util.List;

public class OperatorMapper {
    public OperatorDTO operatorMapToDTO(Operator operator){
        return new OperatorDTO(operator.getName(), operator.getLastName(), operator.getPhoneNumber(), operator.getEmail());
    }

    public Operator dtoMapToOperator(OperatorDTO operatorDTO){
        return new Operator(operatorDTO.getName(), operatorDTO.getLastName(), operatorDTO.getPhoneNumber(), operatorDTO.getEmail());
    }

    public List<OperatorDTO> convertListOperatorToListOperatorDTO(List<Operator> operatorList) {
        List<OperatorDTO> operatorDTOList = new ArrayList<>();
        for (Operator temp : operatorList) {
            operatorDTOList.add(operatorMapToDTO(temp));
        }
        return operatorDTOList;
    }

    public OperatorMapper() {
        }
    }