package com.siit.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IocApplication {

    @Qualifier("accountingService")
    @Autowired
    private TransactionsService accountService;
    @Qualifier("accountingServiceLargeCustomers")
    @Autowired
    private TransactionsService accountServiceLargeAccounts;


    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        System.out.println("Output");
//		ApplicationContext context = new AnnotationConfigApplicationContext(AccountingServiceConfiguration.class);
//		TransactionVerifier normalAccountingService =context.getBean(AccountingService.class);

    }

    @PostConstruct
    void doVerifications() {

        System.out.println("Verifying a small client transaction: " + accountService.isTransactionValid(40000));
        System.out.println("Verifying a LARGE client transaction: " + accountServiceLargeAccounts.isTransactionValid(500000));

    }

}
