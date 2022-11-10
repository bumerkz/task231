package web.services;

import web.model.Car;

import java.util.List;

public interface CarServices {
    public List<Car> getCars (int count);
}
