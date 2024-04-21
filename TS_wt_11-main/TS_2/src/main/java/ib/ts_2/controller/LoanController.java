package ib.ts_2.controller;

import ib.ts_2.entity.Loan;
import ib.ts_2.entity.User;
import ib.ts_2.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAll")
    public @ResponseBody List<Loan> getAllLoans(){
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public Loan getOne(@PathVariable long id){
        return loanService.getOne(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.create(loan);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public Loan deleteLoan(@PathVariable long id){return loanService.deleteLoan(id);}

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("update/{id}")
    public Loan updateLoan(@PathVariable long id, @RequestBody Loan loanUpdates) {
        return loanService.updateLoan(loanUpdates, id);
    }

    @GetMapping("/history/{username}")
    public List<Loan> loanHistory(@PathVariable String username) {
        return loanService.loanHistory(username);
    }
}
