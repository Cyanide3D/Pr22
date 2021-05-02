package com.example.Pr22.service;

import com.example.Pr22.models.Card;
import com.example.Pr22.repository.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@Transactional
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MailService mailService;

    public void save(Card card) {
        log.info("Method save has been started...");
        mailService.sendMessage("Save");
        cardRepository.save(card);
    }

    public void delete(Long id) {
        log.info("Method delete has been started...");
        cardRepository.delete(findCardById(id));
    }

    public Card findCardById(Long id) {
        log.info("Method findCardById has been started...");
        return cardRepository.findOneById(id);
    }

    public List<Card> findCardsByCardNumber(int cardNumber) {
        log.info("Method findCardsByCardNumber has been started...");
        return cardRepository.findAllByCardNumber(cardNumber);
    }

    public List<Card> findCardsByCode(int code) {
        log.info("Method findCardsByCode has been started...");
        return cardRepository.findAllByCode(code);
    }

    public List<Card> getAllCards() {
        log.info("Method getAllCards has been started...");
        return cardRepository.findAll();
    }

}
