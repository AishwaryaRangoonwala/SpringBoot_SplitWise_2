package com.aishwarya.SpringBoot_SplitWise_2;

import com.aishwarya.SpringBoot_SplitWise_2.Commands.CommandExecutor;
import com.aishwarya.SpringBoot_SplitWise_2.Commands.CreateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringBootSplitWise2Application implements CommandLineRunner {

	@Autowired
	private CommandExecutor commandExecutor;
	@Autowired
	private CreateUserCommand createUserCommand;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootSplitWise2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("********* SPLITWISE APPLICATION *********");
		Scanner sc = new Scanner(System.in);
		commandExecutor.register(createUserCommand);

		String inputCommand = "";
		while (!inputCommand.equalsIgnoreCase("quit")) {
			System.out.println("********** COMMAND DESCRIPTION **********");
			System.out.println("1. createuser name phonenumber");
			System.out.println("2. TBD");
			System.out.println("3. TBD");
			System.out.println("4. quit");
			System.out.print("Your command: ");
			inputCommand = sc.nextLine();
			commandExecutor.execute(inputCommand);
		}
	}
}
