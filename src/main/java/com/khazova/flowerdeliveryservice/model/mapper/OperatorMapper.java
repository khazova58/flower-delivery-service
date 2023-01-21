package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.OperatorDTO;
import com.khazova.flowerdeliveryservice.model.entity.Operator;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OperatorMapper {

    Operator dtoMapToOperator(OperatorDTO operatorDTO);

    OperatorDTO operatorMapToDTO(Operator operator);

    List<OperatorDTO> convertListOperatorToListOperatorDTO(List<Operator> operatorList);

}