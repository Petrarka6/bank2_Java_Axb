package com.example.bank2.Controllers;


import java.math.BigDecimal;

import com.example.bank2.Servises.BankService;
import com.example.bank2.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/balance")
@AllArgsConstructor
public class BalanceController {
    private static final Logger log = LoggerFactory.getLogger(BalanceController.class);
    private BankService bankService;

    @GetMapping({"/GetBalance/{accountId}"})
    public BigDecimal GetBalance(@PathVariable Long accountId) throws IllegalAccessException {
      //  return bankService.Getbalance(accountId);
        return bankService.Getbalance(accountId);
    }
//
//    @GetMapping({"/aaaa/{accountIdsa}"})
//    public BigDecimal GetBalancsss(@PathVariable Long accountIdsa) {
//        return new BigDecimal(1433);
//    }
//
    @PostMapping({"/Add"})
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }
//
    @PostMapping({"/Transfer"})
    public void TransBalance(@RequestBody TransferBalance transferBalance) {
        bankService.MakeTransfer(transferBalance);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String handle1(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "Не хочу работать((";
    }


}
