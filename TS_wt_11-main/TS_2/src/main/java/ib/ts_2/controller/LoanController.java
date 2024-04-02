package ib.ts_2.controller;

import ib.ts_2.entity.Book;
import ib.ts_2.entity.Loan;
import ib.ts_2.repository.LoanRepository;
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
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.create(loan);
    }
}
