package com.siit.ioc;

public class AccountingService implements TransactionsService {
    private final int limit;

    public AccountingService(int limit) {
        this.limit = limit;
    }

    public boolean isTransactionValid(int value){
        return value <= limit;
    }


}
