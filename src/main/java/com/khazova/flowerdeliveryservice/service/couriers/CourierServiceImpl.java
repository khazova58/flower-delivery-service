package com.khazova.flowerdeliveryservice.service.couriers;

import com.khazova.flowerdeliveryservice.model.dto.CourierDto;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import com.khazova.flowerdeliveryservice.model.mapper.UserMapper;
import com.khazova.flowerdeliveryservice.repository.CourierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с курьером
 */
@Service
@Transactional(readOnly = true)
public class CourierServiceImpl implements CourierService {

    private final CourierRepository repository;
    private final UserMapper mapperCourier;

    public CourierServiceImpl(CourierRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapperCourier = mapper;
    }

    /**
     * Создать нового курьера
     * @param courierDTO курьер
     * @return ID нового курьера в строковом представлении
     */
    @Override
    @Transactional
    public String newCourier(CourierDto courierDTO) {
        Courier newCourier = mapperCourier.dtoMapToCourier(courierDTO);
        repository.save(newCourier);
        return String.valueOf(newCourier.getCourierId());
    }

    /**
     * Получить список всех курьеров
     * @return список найденных клиентов
     */
    @Override
    public List<CourierDto> findAll() {
        List<Courier> findCouriers = repository.findAll();
        List<CourierDto> dtoCourier = new ArrayList<>();
        for (Courier courier : findCouriers) {
            dtoCourier.add(mapperCourier.courierMapToDTO(courier));
        }
        return dtoCourier;
    }

    /**
     * Найти курьера по идентификатору
     * @param id курьера
     * @return найденный курьер
     */
    @Override
    public CourierDto findOneCourierByID(String id) {
        Courier findCourier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Курьер не найден"));//todo обработать ошибку
        return mapperCourier.courierMapToDTO(findCourier);
    }

    /**
     * Обновить существующую запись
     * @param id курьера
     * @param updateCourier новые данные
     * @return true
     */
    @Override
    @Transactional
    public boolean updateCourier(String id, CourierDto updateCourier) {
        Courier courier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Курьер не найден"));//todo обработать ошибку
        courier.setName(updateCourier.getName());
        courier.setLastName(updateCourier.getLastName());
        courier.setPhoneNumber(updateCourier.getPhoneNumber());
        repository.save(courier);
        return true;
    }

    /**
     * Удалить курьера из базы по идентификатору
     * @param id курьера
     * @return true
     */
    @Override
    @Transactional
    public boolean deleteCourier(String id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Курьер не найден"));//todo обработать ошибку
        repository.deleteById(id);
        return true;
    }
}
