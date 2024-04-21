package ib.ts_2.services;

import ib.ts_2.entity.Book;
import ib.ts_2.entity.Loan;
import ib.ts_2.entity.User;
import ib.ts_2.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    /*
      Service class responsible for handling loan-related operations.
     */

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAll(){
       /*
        Retrieves all loans from the database.
        @return A list of all loans.
       */
        return (List<Loan>) loanRepository.findAll();
    }
    public Loan getOne(long id){
          /*
          Retrieves a single loan by its ID.
          @param id The ID of the loan to retrieve.
         * @return The loan with the specified ID.
         * @throws RuntimeException if no loan with the specified ID is found.
         */
        return loanRepository.findById(id).orElseThrow(()-> new RuntimeException("Loan not found"));
    }

    public Loan create(Loan loan){
        /*
          Creates a new loan.
          @param loan The loan to create.
         * @return The created loan.
         */
        return loanRepository.save(loan);
    }

    public Loan deleteLoan(long id) {
        /*
          Deletes a loan by its ID.
          @param id The ID of the loan to delete.
         * @return null.
         */
        loanRepository.deleteById(id);
        return null;
    }

    public Loan updateLoan(Loan newLoan, long id) {
        /*
          Updates an existing loan with new details.
          @param newLoan The updated details of the loan.
         * @param id The ID of the loan to update.
         * @return The updated loan.
         * @throws RuntimeException if no loan with the specified ID is found.
         */
        Loan existingLoan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));


        existingLoan.setReturnDate(newLoan.getReturnDate());

        return loanRepository.save(existingLoan);
    }


    public List<Loan> loanHistory(String username) {
        /*
          Retrieves the loan history for a specific user.
          @param username The username of the user to retrieve the loan history for.
         * @return A list of loans associated with the specified user.
         */
        return loanRepository.findByUserUsername(username);
    }
}
