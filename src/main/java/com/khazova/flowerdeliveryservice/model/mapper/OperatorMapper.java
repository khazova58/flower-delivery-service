package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.OperatorDTO;
import com.khazova.flowerdeliveryservice.model.entity.Operator;

public class OperatorMapper {
    public OperatorDTO operatorMapToDTO(Operator operator){
        return new OperatorDTO(operator.getName(), operator.getLastName(), operator.getPhoneNumber(), operator.getEmail());
    }

    public Operator dtoMapToOperator(OperatorDTO operatorDTO){
        return new Operator("", operatorDTO.getName(), operatorDTO.getLastName(), operatorDTO.getPhoneNumber(), operatorDTO.getEmail());
    }

    public OperatorMapper(){
    }
}
