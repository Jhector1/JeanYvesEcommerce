package art.jeanyvehector.service;

import art.jeanyvehector.dto.CustomerDto;
import art.jeanyvehector.exceptionHandler.UserAlreadyExistException;
import art.jeanyvehector.model.MyCustomer;

public interface IUserService<E> {
    E registerNewCustomerAccount(CustomerDto userDto) throws UserAlreadyExistException;
}