package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImp implements CarService {


    @Override
    public List<Car> getCars(List<Car> cars, int count) {
        if (count <= 0 || count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }

    @Override
    public List<Car> getCars(int count) {
        List<Car> cars = Arrays.asList(
                new Car(1999, "Toyota Camry", "White"),
                new Car(2024, "BMW", "Black"),
                new Car(2025, "Porsche", "Red"),
                new Car(2000, "Toyota Supra", "Purple"),
                new Car(1994, "Mustang", "Yellow")
        );
        return count <= 0 || count>=cars.size() ? cars:cars.subList(0, count);
    }
}
