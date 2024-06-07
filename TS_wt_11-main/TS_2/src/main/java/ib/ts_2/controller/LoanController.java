package ib.ts_2.controller;

import ib.ts_2.entity.Loan;
import ib.ts_2.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @GetMapping("/getAll")
    public @ResponseBody List<Loan> getAllLoans(){
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public Loan getOne(@PathVariable long id){
        return loanService.getOne(id);
    }

    @PostMapping("/add")
    public Loan addLoan(@RequestBody LoanRequest loanRequest){
        return loanService.create(loanRequest);
    }

    @DeleteMapping("/delete/{id}")
    public Loan deleteLoan(@PathVariable long id){
        return loanService.deleteLoan(id);
    }

    @PatchMapping("update/{id}")
    public Loan updateLoan(@PathVariable long id, @RequestBody Loan loanUpdates) {
        return loanService.updateLoan(loanUpdates, id);
    }

    @GetMapping("/history/{username}")
    public List<Loan> loanHistory(@PathVariable String username) {
        return loanService.loanHistory(username);
    }
}
