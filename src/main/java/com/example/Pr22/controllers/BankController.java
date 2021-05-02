package com.example.Pr22.controllers;

import com.example.Pr22.models.Bank;
import com.example.Pr22.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public List<Bank> getAll() {
        return bankService.getAllBanks();
    }

    @GetMapping("/filter/address/{address}")
    public List<Bank> getByAddress(@PathVariable("address") String address) {
        return bankService.findBanksByAddress(address);
    }
    @GetMapping("/filter/id/{id}")
    public Bank getById(@PathVariable("id") Long id) {
        return bankService.findBankById(id);
    }
    @GetMapping("/filter/name/{name}")
    public List<Bank> getByName(@PathVariable("name") String name) {
        return bankService.findBanksByName(name);
    }

    @PostMapping
    public void save(@RequestBody Bank bank) {
        bankService.save(bank);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        bankService.delete(id);
    }

}
