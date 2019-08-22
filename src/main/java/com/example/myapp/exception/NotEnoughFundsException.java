package com.example.myapp.exception;

import com.example.myapp.model.User;

public class NotEnoughFundsException extends Exception {


        private static final String message = "Not enough in funds ! ";

        public NotEnoughFundsException(){
            super(message);
        }

        public NotEnoughFundsException(User user) {
            super(String.format("Not enough funds. Current balance : %s .",user.getBalance()));
        }
}
