package com.capgemini.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.exception.LowBalanceException;

public class Application {
	public static void main(String[] args) throws LowBalanceException {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController=
		context.getBean("bankAccountController",BankAccountController.class);
		
		System.out.println(bankAccountController.getBalance(123));
		System.out.println(bankAccountController.withdraw(123,500 ));
		System.out.println(bankAccountController.deposit(124, 1000));
		System.out.println(bankAccountController.fundTransfer(123, 124, 1000));
		System.out.println(bankAccountController.getBalance(124));
	}

}
