package com.example.Pr22.controllers;

import com.example.Pr22.models.Card;
import com.example.Pr22.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAll() {
        return cardService.getAllCards();
    }

    @PostMapping
    public void save(@RequestBody Card card) {
        cardService.save(card);
    }

    @GetMapping("/filter/number/{number}")
    public List<Card> getByCardNumber(@PathVariable("number") int number) {
        return cardService.findCardsByCardNumber(number);
    }
    @GetMapping("/filter/id/{id}")
    public Card getById(@PathVariable("id") Long id) {
        return cardService.findCardById(id);
    }
    @GetMapping("/filter/code/{code}")
    public List<Card> getByCode(@PathVariable("code") int code) {
        return cardService.findCardsByCode(code);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        cardService.delete(id);
    }

}
