package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(
            @RequestParam(value = "count", required = false, defaultValue = "0")
            int count,
            Model model
    ) {
        List<Car> cars = Arrays.asList(
                new Car(1999, "Toyota Camry", "White"),
                new Car(2024, "BMW", "Black"),
                new Car(2025, "Porsche", "Red"),
                new Car(2000, "Toyota Supra", "Purple"),
                new Car(1994, "Mustang", "Yellow")
        );
        model.addAttribute("cars", carService.getCars(cars, count));
        return "cars";
    }
}
