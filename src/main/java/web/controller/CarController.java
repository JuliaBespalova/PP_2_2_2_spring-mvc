package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public String getCars(
            @RequestParam(value = "count", required = false, defaultValue = "0")
            int count,
            Model model
    ){
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}
