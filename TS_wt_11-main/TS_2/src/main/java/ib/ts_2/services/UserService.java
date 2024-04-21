package ib.ts_2.services;

import ib.ts_2.entity.User;
import ib.ts_2.repository.UserRepository;
import ib.ts_2.services.error.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    /*
      Service class responsible for handling user-related operations.
     */

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        /*
          Retrieves all users from the database.
          @return A list of all users.
         */
        return (List<User>) userRepository.findAll();
    } //find me all users

    public User getOne(long id){
        /*
          Retrieves a single user by their ID.
          @param id The ID of the user to retrieve.
         * @return The user with the specified ID.
         * @throws RuntimeException if no user with the specified ID is found.
         */
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }


    public User create(User user){
        /*
          Creates a new user.
          @param user The user to create.
         * @return The created user.
         * @throws UserAlreadyExistsException if a user with the same username already exists.
         */
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()){
            throw UserAlreadyExistsException.create(user.getUsername());
        }
        return userRepository.save(user);
    }

    public User delete(long id) {
        /*
          Deletes a user by their ID.
          @param id The ID of the user to delete.
         * @return null.
         */
        userRepository.deleteById(id);
        return null;
    }

    public User update(User newUserDetails, long id) {
        /*
          Updates an existing user with new details.
          @param newUserDetails The updated details of the user.
         * @param id The ID of the user to update.
         * @return The updated user.
         * @throws RuntimeException if no user with the specified ID is found.
         */

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));


        existingUser.setFull_name(newUserDetails.getFull_name());
        existingUser.setSurname(newUserDetails.getSurname());

        return userRepository.save(existingUser);
    }

}
