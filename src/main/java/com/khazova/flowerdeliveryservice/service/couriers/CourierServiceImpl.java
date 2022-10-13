package com.khazova.flowerdeliveryservice.service.couriers;

import com.khazova.flowerdeliveryservice.model.DTO.CourierDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с курьером
 */
@Service
public class CourierServiceImpl implements CourierService {
    @Override
    public String newCourier(CourierDTO courier) {
        return null;
    }

    @Override
    public List<CourierDTO> getAllCourier() {
        return null;
    }

    @Override
    public String getCourierNameByID(int id) {
        return null;
    }

    @Override
    public String updateCourier(int id) {
        return null;
    }

    @Override
    public String deleteCourier(int id) {
        return null;
    }
}
