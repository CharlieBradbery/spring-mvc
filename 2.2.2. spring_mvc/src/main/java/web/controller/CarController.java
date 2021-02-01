package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    private static final List<Car> cars = Arrays.asList(
            new Car("BMW", 1, "black"),
            new Car("Mersedes", 2, "white"),
            new Car("Reno", 3, "yellow"),
            new Car("Audi", 4, "red"),
            new Car("Ford", 5, "green"));


    public List<Car> getSomeCars(Integer count) {
        if (count == null || count >= 5) {
            return cars;
        }

        return cars.subList(0, count);
    }

    @GetMapping("/cars")
    public String showSomeCars(@RequestParam(value = "count", required = false) Integer count, Model model) {

        model.addAttribute("cars", getSomeCars(count));
        return "cars";
    }

}