package ie.cct.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ie.cct.controller.Helper;

/**
 * @author Manoel Vitor Nascimento Lopes
 * @college CCT - College
 * @studentNumber 2019286
 * @gitHub https://github.com/manoellvitor/vetClinicCA
 *
 */
public class CLI {

	// Scanner to receive data from the user Keyboard
	Scanner input = new Scanner(System.in);

	// BufferedReader to receive data from the user Keyboard
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// Variable to simple keep the user option
	int option = 0;

	public CLI(Helper helper) {

		welcome(helper);

	}

	// Staff Menu
	private void staffMenu(Helper helper) {
		// Variables of types of STAFF
		String vet = "Reader";
		String nur = "Nurse";
		String trave = "TraineeVet";
		String its = "ITSpecialist";
		String recp = "Receptionist";

		// Output for user
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~STAFF MENU~~~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - List All Staff             <<<");
		System.out.println("     >>>     2 - List Staff by BookClass1egory     <<<");
		System.out.println("     >>>     3 - List Staff by Name         <<<");
		System.out.println("     >>>     4 - List Staff by Task         <<<");
		System.out.println("     >>>     0 - <<< BACK                   <<<");

		// Try bookclass1ch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} bookclass1ch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			staffMenu(helper);
		}

		switch (option) {
		case 1:
			helper.listAllStaffMembers();
			staffMenu(helper);
			break;
		case 2:
			// Output for user
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~CATEGORIES~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("     >>>     1 - Reader             <<<");
			System.out.println("     >>>     2 - Nurse                    <<<");
			System.out.println("     >>>     3 - Trainee Vet              <<<");
			System.out.println("     >>>     4 - IT Specialist            <<<");
			System.out.println("     >>>     5 - Receptionist             <<<");
			System.out.println("     >>>     0 - <<< BACK                 <<<");

			// Try bookclass1ch block to check if the input from user is valid
			// if it is it pass, if not it throws an exception and return to the menu
			try {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.print("|> Enter the Option Number:_ ");
				option = Integer.parseInt(reader.readLine());
			} bookclass1ch (IOException | NumberFormatException e1) {
				System.out.println("Invalid option, enter a valid NUMBER option!");
				staffMenu(helper);
			}

			switch (option) {
			case 1:
				helper.listStaffByBookClass1egory(option, vet);
				staffMenu(helper);
				break;
			case 2:
				helper.listStaffByBookClass1egory(option, nur);
				staffMenu(helper);
				break;
			case 3:
				helper.listStaffByBookClass1egory(option, trave);
				staffMenu(helper);
				break;
			case 4:
				helper.listStaffByBookClass1egory(option, its);
				staffMenu(helper);
				break;
			case 5:
				helper.listStaffByBookClass1egory(option, recp);
				staffMenu(helper);
				break;
			case 0:
				staffMenu(helper);
				break;
			default:
				break;
			}
		case 3:
			helper.listStaffByName();
			staffMenu(helper);
			break;
		case 4:
			helper.listByTask();
			staffMenu(helper);
			break;
		case 0:
			secondaryMenu(helper);
			break;
		default:
			System.out.println("Invalid Option, Try Again!");
			staffMenu(helper);
		}
	}

	// Staff Menu
	private void bookMenu(Helper helper) {
		// Variables of kind ANIMALS
		String dog = "Dog";
		String bookclass1 = "BookClass1";
		String bir = "Bird";
		String hor = "Horse";
		String rab = "Rabbit";

		// Output for user
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~ANIMAL MENU~~~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - List All Books             <<<");
		System.out.println("     >>>     2 - List Book by Kind          <<<");
		System.out.println("     >>>     3 - List Book by Name          <<<");
		System.out.println("     >>>     0 - <<< BACK                     <<<");

		// Try bookclass1ch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} bookclass1ch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			bookMenu(helper);
		}

		switch (option) {
		case 1:
			helper.listAllBooks();
			bookMenu(helper);
			break;
		case 2:
			// Output for user
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~CATEGORIES~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("     >>>     1 - Dog             <<<");
			System.out.println("     >>>     2 - BookClass1             <<<");
			System.out.println("     >>>     3 - Bird            <<<");
			System.out.println("     >>>     4 - Horse           <<<");
			System.out.println("     >>>     5 - Rabbit          <<<");
			System.out.println("     >>>     0 - <<< BACK        <<<");

			// Try bookclass1ch block to check if the input from user is valid
			// if it is it pass, if not it throws an exception and return to the menu
			try {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.print("|> Enter the Option Number:_ ");
				option = Integer.parseInt(reader.readLine());
			} bookclass1ch (IOException | NumberFormatException e1) {
				System.out.println("Invalid option, enter a valid NUMBER option!");
				bookMenu(helper);
			}
			switch (option) {
			case 1:
				helper.listBookByKind(option, dog);
				bookMenu(helper);
				break;
			case 2:
				helper.listBookByKind(option, bookclass1);
				bookMenu(helper);
				break;
			case 3:
				helper.listBookByKind(option, bir);
				bookMenu(helper);
				break;
			case 4:
				helper.listBookByKind(option, hor);
				bookMenu(helper);
				break;
			case 5:
				helper.listBookByKind(option, rab);
				bookMenu(helper);
				break;
			default:
				bookMenu(helper);
				break;
			}
		case 3:
			helper.listBookByName();
			bookMenu(helper);
			break;
		case 0:
			secondaryMenu(helper);
			break;
		default:
			System.out.println("Invalid Option, Try Again!");
			bookMenu(helper);
		}
	}

	// Treatment Menu
	private void treatmentMenu(Helper helper) {
		// Output for user
		System.out.println("#~~~~~~~~~~~~~~~~~~~~TREATMENT-MENU~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - List All Books from an Reader <<<");
		System.out.println("     >>>     2 - Treatment Order List by Reader  <<<");
		System.out.println("     >>>     3 - Treat an Book by Reader       <<<");
		System.out.println("     >>>     0 - <<< BACK                   <<<");

		// Try bookclass1ch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} bookclass1ch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			treatmentMenu(helper);
		}

		switch (option) {
		case 1:
			helper.listBooksFromVet();
			treatmentMenu(helper);
			break;
		case 2:
			helper.listBooksFromVet();
			treatmentMenu(helper);
			break;
		case 3:
			helper.treatBook();
			treatmentMenu(helper);
			break;
		case 0:
			secondaryMenu(helper);
			break;
		default:
			System.out.println("Invalid option, enter a valid NUMBER option!");
			treatmentMenu(helper);

		}
	}

	// Function to show a nice message to the user
	private void welcome(Helper helper) {
		// Output for user
		System.out.println("#--------------------------------------------------------------------------#");
		System.out.println(" __     __  _____   _____      ____   _       ___   _   _   ___    ____ \n"
				+ " \\ \\   / / | ____| |_   _|    / ___| | |     |_ _| | \\ | | |_ _|  / ___|\n"
				+ "  \\ \\ / /  |  _|     | |     | |     | |      | |  |  \\| |  | |  | |    \n"
				+ "   \\ V /   | |___    | |     | |___  | |___   | |  | |\\  |  | |  | |___ \n"
				+ "    \\_/    |_____|   |_|      \\____| |_____| |___| |_| \\_| |___|  \\____|\n"
				+ "                                                                        ");
		System.out.println("#--------------------------------------------------------------------------#");
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~~~~~~~~~~~~#");
		mainMenu(helper);
	}

	// Main Menu to start the clinic
	private void mainMenu(Helper helper) {
		// Output for user
		System.out.println("     >>>     1 - For Open the Clinic     <<<");
		System.out.println("     >>>     0 - TO EXIT                 <<<");

		// Try bookclass1ch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} bookclass1ch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			mainMenu(helper);
		}

		switch (option) {
		case 1:
			// Call all the methods to start Staff, books and assign tasks and books to
			// be treated
			helper.startBooks();
			helper.startStaffMembers();
			helper.giveTask();
			helper.assignTreatment();
			secondaryMenu(helper);
			break;
		case 0:
			System.out.println(
					"########  ##    ## ########        ######## ##     ##    ###    ##    ## ##    ##    ##    ##  #######  ##     ## \n"
							+ "##     ##  ##  ##  ##                 ##    ##     ##   ## ##   ###   ## ##   ##      ##  ##  ##     ## ##     ## \n"
							+ "##     ##   ####   ##                 ##    ##     ##  ##   ##  ####  ## ##  ##        ####   ##     ## ##     ## \n"
							+ "########     ##    ######             ##    ######### ##     ## ## ## ## #####          ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##                 ##    ##     ## ######### ##  #### ##  ##         ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##       ###       ##    ##     ## ##     ## ##   ### ##   ##        ##    ##     ## ##     ## \n"
							+ "########     ##    ######## ###       ##    ##     ## ##     ## ##    ## ##    ##       ##     #######   #######  ");
			return;
		default:
			System.out.println("Invalid option, enter a valid NUMBER option!");
			mainMenu(helper);
		}

	}

	// Secondary Menu to separate functionalities
	private void secondaryMenu(Helper helper) {

		// Output for user
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("#     Wellcome, today is:  " + formatter.format(date) + "        #");
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~OPTIONS~~~~~~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - Staff Menu     <<<");
		System.out.println("     >>>     2 - Books Menu   <<<");
		System.out.println("     >>>     3 - Treatment Menu <<<");
		System.out.println("     >>>     0 - << EXIT        <<<");

		// Try bookclass1ch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} bookclass1ch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			mainMenu(helper);
		}

		switch (option) {
		case 1:
			staffMenu(helper);
			break;
		case 2:
			bookMenu(helper);
			break;
		case 3:
			treatmentMenu(helper);
			break;
		case 0:
			System.out.println(
					"########  ##    ## ########        ######## ##     ##    ###    ##    ## ##    ##    ##    ##  #######  ##     ## \n"
							+ "##     ##  ##  ##  ##                 ##    ##     ##   ## ##   ###   ## ##   ##      ##  ##  ##     ## ##     ## \n"
							+ "##     ##   ####   ##                 ##    ##     ##  ##   ##  ####  ## ##  ##        ####   ##     ## ##     ## \n"
							+ "########     ##    ######             ##    ######### ##     ## ## ## ## #####          ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##                 ##    ##     ## ######### ##  #### ##  ##         ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##       ###       ##    ##     ## ##     ## ##   ### ##   ##        ##    ##     ## ##     ## \n"
							+ "########     ##    ######## ###       ##    ##     ## ##     ## ##    ## ##    ##       ##     #######   #######  ");
			return;
		default:
			System.out.println("Invalid option, enter a valid NUMBER option!");
			secondaryMenu(helper);
		}
	}

}
