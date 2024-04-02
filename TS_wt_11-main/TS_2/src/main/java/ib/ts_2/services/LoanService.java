package ib.ts_2.services;

import ib.ts_2.entity.Loan;
import ib.ts_2.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAll(){
        return (List<Loan>) loanRepository.findAll();
    }
    public Loan getOne(long id){
        return loanRepository.findById(id).orElseThrow(()-> new RuntimeException("Loan not found"));
    }

    public Loan create(Loan loan){
        return loanRepository.save(loan);
    }
}
