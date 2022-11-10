package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DaoCars.CarsDao;
import web.model.Car;

import java.util.List;
@Service
public class CarService implements CarServices {
    final CarsDao carsDao;

    @Autowired
    public CarService (CarsDao carsDao) {
        this.carsDao=carsDao;
    }

    @Override
    public List<Car> getCars(int count) {
        return carsDao.getCars(count);
    }
}
