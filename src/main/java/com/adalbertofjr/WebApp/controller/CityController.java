package com.adalbertofjr.WebApp.controller;

import com.adalbertofjr.WebApp.model.City;
import com.adalbertofjr.WebApp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public String index(Model model){
        List<City> cities = this.cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "cities/index";
    }

    @GetMapping("/new")
    public String newCity(Model model){
        model.addAttribute("city", new City());
        return "cities/new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("city") City city, Model model){
        this.cityRepository.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/{id}")
    public String editCity(@PathVariable("id") Long id, Model model){
        model.addAttribute("city", this.cityRepository.findById(id).get());
        return "cities/edit";
    }

    @PutMapping("{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("city") City city, Model model) {
        City findCity = this.cityRepository.findById(id).get();

        if (findCity != null) {
            findCity.setId(city.getId());
            findCity.setName(city.getName());

            this.cityRepository.save(findCity);
        }

        return "redirect:/cities";
    }

    @DeleteMapping("{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        City city = this.cityRepository.findById(id).get();

        if (city != null) {
            this.cityRepository.delete(city);
        }
        return "redirect:/cities";
    }
}
