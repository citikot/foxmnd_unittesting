package domain;

import exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BankAccountTest {

    @Test
    void testFailedWilthdrawalWithAmountHigherThanBalance() {
        // given
        double initialDeposit = 1000;
        double withdrawalAmount = 1200;
        BankAccount bankAccount = new BankAccount(initialDeposit);

        //when
        Exception ex = assertThrows(InsufficientFundsException.class, () -> {
            bankAccount.withdraw(withdrawalAmount);
        });

        // then
        assertEquals("Insufficient funds for withdrawal", ex.getMessage());

    };

}
