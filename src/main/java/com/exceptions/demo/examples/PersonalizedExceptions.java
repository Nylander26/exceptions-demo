package com.exceptions.demo.examples;

import java.math.BigDecimal;

public class PersonalizedExceptions {
    
    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }
    
    public static class BankAccount {
        private BigDecimal balance;
        
        public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
            if (amount.compareTo(balance) < 0) {
                throw new InsufficientBalanceException("Not enough balance");
            }
            this.balance = balance.subtract(amount);
        }
    }
}
