package com.aishwarya.SpringBoot_SplitWise_2;

import com.aishwarya.SpringBoot_SplitWise_2.Commands.*;
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
	@Autowired
	private CreateGroupCommand createGroupCommand;
	@Autowired
	private AddMemberToGroupCommand addMemberToGroupCommand;
	@Autowired
	private DeleteGroupCommand deleteGroupCommand;
	@Autowired
	private RemoveMemberFromGroupCommand removeMemberFromGroupCommand;
	@Autowired
	private FetchMembersCommand fetchMembersCommand;
	@Autowired
	private AddMemberToGroupCommandV2 addMemberToGroupCommandV2;
	@Autowired
	private AddAdminToGroupCommandV2 addAdminToGroupCommandV2;
	@Autowired
	private AddExpenseCommand addExpenseCommand;
	@Autowired
	private SettleUpGroupCommand settleUpGroupCommand;
	@Autowired
	private SettleUpUserCommand settleUpUserCommand;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootSplitWise2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("********* SPLITWISE APPLICATION *********");
		Scanner sc = new Scanner(System.in);
		commandExecutor.register(createUserCommand);
		commandExecutor.register(createGroupCommand);
		commandExecutor.register(addMemberToGroupCommand);
		commandExecutor.register(deleteGroupCommand);
		commandExecutor.register(removeMemberFromGroupCommand);
		commandExecutor.register(fetchMembersCommand);
		commandExecutor.register(addMemberToGroupCommandV2);
		commandExecutor.register(addAdminToGroupCommandV2);
		commandExecutor.register(addExpenseCommand);
		commandExecutor.register(settleUpGroupCommand);
		commandExecutor.register(settleUpUserCommand);

		String inputCommand = "";
		while (!inputCommand.equalsIgnoreCase("quit")) {
			System.out.println("********** COMMAND DESCRIPTION **********");
			System.out.println("1. createUser name phoneNumber");
			System.out.println("2. createGroup name description creatorUserid");
			System.out.println("3. addMemberToGroup groupId adminId memberId");
			System.out.println("4. deleteGroup groupId userId");
			System.out.println("5. removeMemberFromGroup groupId adminId memberId");
			System.out.println("6. fetchMembersOfAGroup groupId memberId");
			System.out.println("7. settleUpGroup groupId");
			System.out.println("8. settleUpUser userId");
			System.out.println("9. addMemberToGroupV2 groupId memberId");
			System.out.println("9. addAdminToGroupV2 groupId adminId");
			System.out.println("10. addExpense expenseAmount groupId expenseUser1_userId expenseUser1_amount expenseUser1_type expenseUser2_userId expenseUser2_amount expenseUser2_type ... expenseUser1_userId expenseUserN_amount expenseUserN_type");
			System.out.println("11. quit");
			System.out.print("Your command: ");
			inputCommand = sc.nextLine();
			commandExecutor.execute(inputCommand);
		}
	}
}
