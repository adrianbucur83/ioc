package com.siit.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountingServiceConfiguration {
    @Value("${limits.smallAccountLimit}")
    private int smallAccountLimit;
    @Value("${limits.largeAccountsLimit}")
    private int largeAccountsLimit;

    @Bean("accountingService")
//    @Primary
    public TransactionsService accountingService() {
        return new AccountingService(smallAccountLimit);
    }

    @Bean("accountingServiceLargeCustomers")
    public TransactionsService accountingServiceLargeCustomers() {
        return new AccountingService(largeAccountsLimit);
    }


}
