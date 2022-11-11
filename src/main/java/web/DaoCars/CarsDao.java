package web.DaoCars;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CarsDao {
    private List<Car> cars = Arrays.asList(
            new Car("VAZ","2106",1995),
            new Car("BMW","320",1994),
            new Car("TOYOTA","CAMRY",2006),
            new Car("BMW","X5",2003),
            new Car("NISSAN","TEANA",2006));

    public List<Car> getCars(int count) {
        if(count < 5) {
            return cars.stream()
                    .limit(count)
                    .collect(Collectors.toList());
        } else {
            return cars;
        }
    }
    public void addCar(Car car) {
        cars.add(car);
    }

}
