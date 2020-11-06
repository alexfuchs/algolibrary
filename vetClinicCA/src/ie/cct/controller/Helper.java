package ie.cct.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ConcurrentModifibookclass1ionException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ie.cct.cli.CLI;
import ie.cct.model.Book;
import ie.cct.model.Bird;
import ie.cct.model.BookClass1;
import ie.cct.model.BookClass2;
import ie.cct.model.Employee;
import ie.cct.model.Horse;
import ie.cct.model.ITSpecialist;
import ie.cct.model.Nurse;
import ie.cct.model.Rabbit;
import ie.cct.model.Receptionist;
import ie.cct.model.Task;
import ie.cct.model.TraineeVet;
import ie.cct.model.Treatment;
import ie.cct.model.Reader;

/**
 * @author Manoel Vitor Nascimento Lopes
 * @college CCT - College
 * @studentNumber 2019286
 * @gitHub https://github.com/manoellvitor/vetClinicCA
 *
 */
public class Helper {
	// List of Book to hold the objects of each kind of books
	List<Book> books = new LinkedList<Book>();
	// List of Employee to hold the objects of each kind of staff
	List<Employee> employees = new LinkedList<Employee>();
	// List of Tasks
	List<Task> tasks = new LinkedList<Task>();
	// List of Books for treatment and the respective veterinarian
	List<Treatment> borrows = new LinkedList<Treatment>();
	// List of Readers
	List<Employee> vets = new LinkedList<Employee>();

	public Helper() {
		// Calling the CLI passing the instance of this Helper class
		new CLI(this);
	}

	// Function to Generate Books Names
	public static String petNameGenerator() {

		// Array of Names (1000 names)
		// Names got from :
		// https://www.petplace.com/article/dogs/pet-care/top-1200-pet-names/
		String[] petName = { "ABBEY", "ABBIE", "ABBY", "ABEL", "ABIGAIL", "ACE", "ADAM", "ADDIE", "ADMIRAL", "AGGIE",
				"AIRES", "AJ", "AJAX", "ALDO", "ALEX", "ALEXUS", "ALF", "ALFIE", "ALLIE", "ALLY", "AMBER", "AMIE",
				"AMIGO", "AMOS", "AMY", "ANDY", "ANGEL", "ANGUS", "ANNIE", "APOLLO", "APRIL", "ARCHIE", "ARGUS",
				"ARIES", "ARMANTI", "ARNIE", "ARROW", "ASHES", "ASHLEY", "ASTRO", "ATHENA", "ATLAS", "AUDI", "AUGIE",
				"AUSSIE", "AUSTIN", "AUTUMN", "AXEL", "AXLE", "BABBLES", "BABE", "BABY", "BABY-DOLL", "BABYKINS",
				"BACCHUS", "BAILEY", "BAM-BAM", "BAMBI", "BANDIT", "BANJO", "BARBIE", "BARCLAY", "BARKER", "BARKLEY",
				"BARLEY", "BARNABY", "BARNEY", "BARON", "BART", "BASIL", "BAXTER", "BB", "BEAMER", "BEANIE", "BEANS",
				"BEAR", "BEAU", "BEAUTY", "BEAUX", "BEBE", "BEETLE", "BELLA", "BELLE", "BEN", "BENJI", "BENNY",
				"BENSON", "BENTLEY", "BERNIE", "BESSIE", "BIABLO", "BIBBLES", "BIG BOY", "BIG FOOT", "BIGGIE", "BILLIE",
				"BILLY", "BINGO", "BINKY", "BIRDIE", "BIRDY", "BISCUIT", "BISHOP", "BITS", "BITSY", "BIZZY", "BJ",
				"BLACKIE", "BLACK-JACK", "BLANCHE", "BLAST", "BLAZE", "BLONDIE", "BLOSSOM", "BLUE", "BO", "BO", "BOB",
				"BOBBIE", "BOBBY", "BOBO", "BODIE", "BOGEY", "BONES", "BONGO", "BONNIE", "BOO", "BOO-BOO", "BOOKER",
				"BOOMER", "BOONE", "BOOSTER", "BOOTIE", "BOOTS", "BOOZER", "BORIS", "BOSCO", "BOSLEY", "BOSS", "BOY",
				"BOZLEY", "BRADLEY", "BRADY", "BRAGGS", "BRANDI", "BRANDO", "BRANDY", "BRIDGETT", "BRIDGETTE", "BRIE",
				"BRINDLE", "BRIT", "BRITTANY", "BRODIE", "BROOK", "BROOKE", "BROWNIE", "BRUISER", "BRUNO", "BRUTUS",
				"BUBBA", "BUBBLES", "BUCK", "BUCKEYE", "BUCKO", "BUCKY", "BUD", "BUDDA", "BUDDIE", "BUDDY", "BUDDY BOY",
				"BUFFIE", "BUFFY", "BUG", "BUGSEY", "BUGSY", "BULLET", "BULLWINKLE", "BULLY", "BUMPER", "BUNKY",
				"BUSTER", "BUSTER-BROWN", "BUTCH", "BUTCHY", "BUTTER", "BUTTERBALL", "BUTTERCUP", "BUTTERSCOTCH",
				"BUTTONS", "BUZZY", "CAESAR", "CALI", "CALLIE", "CALVIN", "CAMEO", "CAMILLE", "CANDY", "CAPONE",
				"CAPTAIN", "CARLEY", "CASEY", "CASPER", "CASSIE", "CASSIS", "CHA CHA", "CHAD", "CHAMBERLAIN", "CHAMP",
				"CHANCE", "CHANEL", "CHAOS", "CHARISMA", "CHARLES", "CHARLIE", "CHARLIE BROWN", "CHARMER", "CHASE",
				"CHAUNCEY", "CHAZ", "CHECKERS", "CHELSEA", "CHEROKEE", "CHESSIE", "CHESTER", "CHEVY", "CHEWIE", "CHEWY",
				"CHEYENNE", "CHI CHI", "CHIC", "CHICO", "CHIEF", "CHILI", "CHINA", "CHIP", "CHIPPER", "CHIPPY", "CHIPS",
				"CHIQUITA", "CHIVAS", "CHLOE", "CHOCOLATE", "CHRISSY", "CHUBBS", "CHUCKY", "CHYNA", "CINDER", "CINDY",
				"CINNAMON", "CISCO", "CLAIRE", "CLANCY", "CLEO", "CLEOPATRA", "CLICKER", "CLIFFORD", "CLOVER", "CLYDE",
				"COAL", "COBWEB", "COCO", "COCOA", "COCONUT", "CODI", "CODY", "COLE", "COMET", "COMMANDO", "CONAN",
				"CONNOR", "COOKIE", "COOPER", "COPPER", "CORKY", "COSMO", "COTTON", "COZMO", "CRACKERS", "CRICKET",
				"CRYSTAL", "CUBBY", "CUBS", "CUJO", "CUPCAKE", "CURLY", "CURRY", "CUTIE", "CUTIE-PIE", "CYRUS", "DAFFY",
				"DAISEY-MAE", "DAISY", "DAKOTA", "DALLAS", "DANDY", "DANTE", "DAPHNE", "DARBY", "DARCY", "DARWIN",
				"DASH", "DAVE", "DEACON", "DEE", "DEE DEE", "DEMPSEY", "DESTINI", "DEWEY", "DEXTER", "DHARMA",
				"DIAMOND", "DICKENS", "DIEGO", "DIESEL", "DIGGER", "DILLON", "DINKY", "DINO", "DIVA", "DIXIE", "DOBIE",
				"DOC", "DODGER", "DOGGON’", "DOLLY", "DOMINO", "DOODLES", "DOOGIE", "DOTS", "DOTTIE", "DOZER",
				"DRAGSTER", "DREAMER", "DUCHESS", "DUDE", "DUDLEY", "DUFFY", "DUKE", "DUNCAN", "DUNN", "DUSTY",
				"DUTCHES", "DUTCHESS", "DYLAN", "EARL", "EBONY", "ECHO", "EDDIE", "EDDY", "EDGAR", "EDSEL", "EIFEL",
				"EINSTEIN", "ELLIE", "ELLIOT", "ELMO", "ELVIS", "ELWOOD", "EMBER", "EMILY", "EMMA", "EMMY", "ERIN",
				"ERNIE", "EVA", "FAITH", "FANCY", "FELIX", "FERGIE", "FERRIS", "FIDO", "FIFI", "FIGARO", "FINNEGAN",
				"FIONA", "FLAKE", "FLAKEY", "FLASH", "FLINT", "FLOPSY", "FLOWER", "FLOYD", "FLUFFY", "FONZIE", "FOXY",
				"FRANCAIS", "FRANKIE", "FRANKY", "FRECKLES", "FRED", "FREDDIE", "FREDDY", "FREEDOM", "FREEWAY",
				"FRESIER", "FRIDAY", "FRISCO", "FRISKY", "FRITZ", "FRODO", "FROSTY", "FURBALL", "FUZZY", "GABBY",
				"GABRIELLA", "GARFIELD", "GASBY", "GATOR", "GAVIN", "GENIE", "GEORGE", "GEORGIA", "GEORGIE", "GIANT",
				"GIBSON", "GIDGET", "GIGI", "GILBERT", "GILDA", "GINGER", "GINNY", "GIRL", "GIZMO", "GODIVA", "GOLDIE",
				"GOOBER", "GOOSE", "GORDON", "GRACE", "GRACE", "GRACIE", "GRACIE", "GRADY", "GREENIE", "GRETA",
				"GRETCHEN", "GRETEL", "GRETTA", "GRIFFEN", "GRINGO", "GRIZZLY", "GROMIT", "GROVER", "GUCCI", "GUIDO",
				"GUINNESS", "GUNNER", "GUNTHER", "GUS", "GUY", "GYPSY", "HAILEY", "HALEY", "HALLIE", "HAMLET", "HAMMER",
				"HANK", "HANNA", "HANNAH", "HANS", "HAPPYT", "HARDY", "HARLEY", "HARPO", "HARRISON", "HARRY", "HARVEY",
				"HEATHER", "HEIDI", "HENRY", "HERCULES", "HERSHEY", "HIGGINS", "HOBBES", "HOLLY", "HOMER", "HONEY",
				"HONEY-BEAR", "HOOCH", "HOOVER", "HOPE", "HOUDINI", "HOWIE", "HUDSON", "HUEY", "HUGH", "HUGO",
				"HUMPHREY", "HUNTER", "INDIA", "INDY", "IRIS", "ISABELLA", "ISABELLE", "ITSY", "ITSY-BITSY", "IVORY",
				"IVY", "IZZY", "JACK", "JACKIE", "JACKPOT", "JACKSON", "JADE", "JAGGER", "JAGS", "JAGUAR", "JAKE",
				"JAMIE", "JASMINE", "JASPER", "JAXSON", "JAZMIE", "JAZZ", "JELLY", "JELLY-BEAN", "JENNA", "JENNY",
				"JERRY", "JERSEY", "JESS", "JESSE", "JESSE JAMES", "JESSIE", "JESTER", "JET", "JETHRO", "JETT", "JETTA",
				"JEWEL", "JEWELS", "JIMMUY", "JINGLES", "JJ", "JOE", "JOEY", "JOHNNY", "JOJO", "JOKER", "JOLIE",
				"JOLLY", "JORDAN", "JOSIE", "JOY", "JR", "JUDY", "JULIUS", "JUNE", "JUNIOR", "JUSTICE", "KALI",
				"KALLIE", "KANE", "KARMA", "KASEY", "KATIE", "KATO", "KATZ", "KAYLA", "KC", "KEESHA", "KELLIE", "KELLY",
				"KELSEY", "KENYA", "KERRY", "KIBBLES", "KID", "KIKI", "KILLIAN", "KING", "KIPPER", "KIRA", "KIRBY",
				"KISMET", "KISSY", "KITTY", "KIWI", "KLAUS", "KOBA", "KOBE", "KODA", "KOKO", "KONA", "KOSMO", "KOTY",
				"KRAMER", "KUJO", "KURLY", "KYRA", "LACEY", "LADDIE", "LADY", "LADYBUG", "LANEY", "LASSIE", "LATTE",
				"LAYLA", "LAZARUS", "LEFTY", "LEO", "LEVI", "LEXI", "LEXIE", "LEXUS", "LIBBY", "LIGHTNING", "LILI",
				"LILLY", "LILY", "LINCOLN", "LINUS", "LITTLE BIT", "LITTLE-GUY", "LITTLE-ONE", "LITTLE-RASCAL", "LIZZY",
				"LOGAN", "LOKI", "LOLA", "LOU", "LOUIE", "LOUIS", "LOVEY", "LUCAS", "LUCI", "LUCIFER", "LUCKY", "LUCY",
				"LUKE", "LULU", "LUNA", "LYNX", "MAC", "MACHO", "MACINTOSH", "MACK", "MACKENZIE", "MACY", "MADDIE",
				"MADDY", "MADISON", "MAGGIE", "MAGGIE-MAE", "MAGGIE-MOO", "MAGGY", "MAGIC", "MAGNOLIA", "MAJOR",
				"MANDI", "MANDY", "MANGO", "MARBLE", "MARIAH", "MARLEY", "MARY", "MARY JANE", "MASON", "MATTIE",
				"MAVERICK", "MAX", "MAXIMUS", "MAXINE", "MAXWELL", "MAY", "MAYA", "MCDUFF", "MCKENZIE", "MEADOW",
				"MEGAN", "MEGGIE", "MERCEDES", "MERCLE", "MERLIN", "MIA", "MIASY", "MICHAEL", "MICKEY", "MIDNIGHT",
				"MIKEY", "MIKO", "MILES", "MILLER", "MILLIE", "MILO", "MIMI", "MINDY", "MING", "MINI", "MINNIE",
				"MISCHIEF", "MISHA", "MISS KITTY", "MISS PRISS", "MISSIE", "MISSY", "MISTER", "MISTY", "MITCH",
				"MITTENS", "MITZI", "MITZY", "MO", "MOCHA", "MOJO", "MOLLIE", "MOLLY", "MONA", "MONKEY", "MONSTER",
				"MONTANA", "MONTGOMERY", "MONTY", "MOOCHER", "MOOCHIE", "MOOKIE", "MOONSHINE", "MOOSE", "MORGAN",
				"MOSES", "MOUSE", "MR KITTY", "MUFFIN", "MUFFY", "MUGSY", "MULLIGAN", "MUNCHKIN", "MURPHY", "NAKITA",
				"NALA", "NANA", "NAPOLEON", "NATASHA", "NATHAN", "NELLIE", "NEMO", "NENA", "NERO", "NESTLE", "NEWT",
				"NEWTON", "NIBBLES", "NIBBY", "NIBBY-NOSE", "NICK", "NICKERS", "NICKIE", "NICKY", "NICO", "NIKE",
				"NIKI", "NIKITA", "NIKKI", "NIKO", "NINA", "NITRO", "NOBEL", "NOEL", "NONA", "NOODLES", "NORTON",
				"NOSEY", "NUGGET", "NUTMEG", "OAKLEY", "OBIE", "ODIE", "OLD GLORY", "OLIVE", "OLIVER", "OLIVIA",
				"OLLIE", "ONIE", "ONYX", "OPIE", "OREO", "OSCAR", "OTIS", "OTTO", "OZ", "OZZIE", "OZZY", "PABLO",
				"PACO", "PADDINGTON", "PADDY", "PANDA", "PANDORA", "PANTHER", "PAPA", "PARIS", "PARKER", "PASHA",
				"PATCH", "PATCHES", "PATRICKY", "PATSY", "PATTY", "PEACHES", "PEANUT", "PEANUTS", "PEARL", "PEBBLES",
				"PEDRO", "PENNY", "PEPE", "PEPPER", "PEPPY", "PEPSI", "PERSY", "PETE", "PETER", "PETEY", "PETIE",
				"PHANTOM", "PHOEBE", "PHOENIX", "PICASSO", "PICKLES", "PIERRE", "PIGGY", "PIGLET", "PINK PANTHER",
				"PINKY", "PINTO", "PIPER", "PIPPIN", "PIPPY", "PIP-SQUEEK", "PIRATE", "PIXIE", "PLATO", "PLUTO",
				"POCKETS", "POGO", "POKEY", "POLLY", "PONCHO", "PONGO", "POOCH", "POOCHIE", "POOH", "POOH-BEAR",
				"POOKIE", "POOKY", "POPCORN", "POPPY", "PORCHE", "PORKCHOP", "PORKY", "PORTER", "POWDER", "PRANCER",
				"PRECIOUS", "PRESLEY", "PRETTY", "PRETTY-GIRL", "PRINCE", "PRINCESS", "PRISSY", "PUCK", "PUDDLES",
				"PUDGE", "PUFFY", "PUGSLEY", "PUMPKIN", "PUNKIN", "PUPPY", "PURDY", "QUEEN", "QUEENIE", "QUINCY",
				"QUINN", "RAGS", "RAISON", "RALPH", "RALPHIE", "RAMBLER", "RAMBO", "RANGER", "RASCAL", "RAVEN", "REBEL",
				"RED", "REGGIE", "REILLY", "REMY", "REX", "REXY", "RHETT", "RICKY", "RICO", "RIGGS", "RILEY",
				"RIN TIN TIN", "RINGO", "RIPLEY", "ROCCO", "ROCK", "ROCKET", "ROCKO", "ROCKY", "ROLAND", "ROLEX",
				"ROLLIE", "ROMAN", "ROMEO", "ROSA", "ROSCOE", "ROSEBUD", "ROSIE", "ROSY", "ROVER", "ROWDY", "ROXANNE",
				"ROXIE", "ROXY", "RUBY", "RUCHUS", "RUDY", "RUFFE", "RUFFER", "RUFFLES", "RUFUS", "RUGER", "RUSTY",
				"RUTHIE", "RYDER", "SABINE", "SABLE", "SABRINA", "SADIE", "SAGE", "SAILOR", "SALEM", "SALLY", "SALTY",
				"SAM", "SAMANTHA", "SAMMY", "SAMPSON", "SAMSON", "SANDY", "SARA", "SARAH", "SARGE", "SASHA", "SASSIE",
				"SASSY", "SAVANNAH", "SAWYER", "SCARLETT", "SCHOTZIE", "SCHULTZ", "SCOOBIE", "SCOOBY", "SCOOBY-DOO",
				"SCOOTER", "SCOTTIE", "SCOUT", "SCRAPPY", "SCRUFFY", "SEBASTIAN", "SHADOW", "SHADY", "SHAGGY", "SHASTA",
				"SHEBA", "SHEENA", "SHELBY", "SHELLY", "SHERMAN", "SHILOH", "SHINER", "SHORTY", "SIENNA", "SIERRA",
				"SILKY", "SILVER", "SILVESTER", "SIMBA", "SIMON", "SIMONE", "SISSY", "SKEETER", "SKINNY", "SKIP",
				"SKIPPER", "SKIPPY", "SKITTLES", "SKY", "SKYE", "SKYLER", "SLICK", "SLINKY", "SLY", "SMARTY", "SMOKE",
				"SMOKEY", };

		Random ran = new Random();

		// pick a Pet Name based on length of array
		String name = petName[ran.nextInt(petName.length)];

		// Return the Name, and Fix the name to left just the First Letter in Capital
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

	}

	// Function to Generate Author Names
	public static String medicalCondition() {

		// Array of Author
		// Names got from :
		// https://www.petmd.com/dog/conditions
		String[] author = { "J. K. Rowling", "Oscar Wilde",
				"William Shakespeare ", "Clarice Lispector", "Philip Roth",
				 };

		Random ran = new Random();

		// pick a author based on length of array
		String name = author[ran.nextInt(author.length)];

		// Return the name of the author
		return name;

	}

	// Function to Generate Age and do not give a age == 0
	public static int generateAge() {
		int age = 0;
		while (age == 0) {
			age = (int) (Math.random() * Math.pow(10, 1));
		}
		return age;

	}

	// Function to Generate Staff Names based on the 2 arrays of First name and
	// Second name
	public static String staffNameGenerator() {

		// Array of Names (30 names)
		// Names got from :
		// http://listofrandomnames.com/
		String[] firstName = { "Marylee", "Maryanne", "Annamaria", "Manie", "Ismael", "Cleveland", "Vallie", "Jayne",
				"Adam", "Venice", "Lissette", "Loria", "Gussie", "Betsy", "Rikki", "Karyn", "Richelle", "Melodee",
				"Trudie", "Jacqualine", "Mae", "Tomeka", "Casie", "Desire", "Aurore", "Santana", "Johnie", "Jame",
				"Agustin", "Bernardo", };
		String[] secondName = { "Trudie", "Marica", "Laurice", "Caron", "Criselda", "Deonna", "Susie", "Cortez",
				"Tempie", "Milissa", "Newton", "Malvina", "Chiquita", "Edward", "Patsy", "Goldie", "Earline", "Vernice",
				"Lauretta", "Charlott", "Evelyne", "Elizebeth", "Lela", "Caprice", "Nilda", "Yesenia", "Nydia", "Bruce",
				"Estrella", "Ellena", };

		Random ran = new Random();

		// pick a Name based on length of array
		String fName = firstName[ran.nextInt(firstName.length)];
		String sName = secondName[ran.nextInt(secondName.length)];
		String name = fName + " " + sName;

		// Return the Name
		return name;

	}

	// Function to Generate Task Names
	public static String generateTask() {

		// Array of Tasks
		String[] taskList = { "Making Phone Calls", "On Hollidays", "Filling Pappers", "Making Coffe",
				"Making Appoitments", "Fixing Computters", "Helping Others", "Searching for News" };

		Random ran = new Random();

		// pick a Name based on length of array
		String task = taskList[ran.nextInt(taskList.length)];

		// Return the Name
		return task;

	}

	// Function to generate 1000 books, 200 of each type
	public void startBooks() {
		// For loop to generate 200 books of each type
		for (int i = 0; i < 200; i++) {
			books.add(new BookClass2(petNameGenerator(), generateAge(), medicalCondition()));
		}

		for (int i = 0; i < 200; i++) {
			books.add(new BookClass1(petNameGenerator(), generateAge(), medicalCondition()));
		}

	}

	// Function to generate the staff members
	public void startStaffMembers() {
		// For loop to generate specific number of each type of Staff
		// If more staff needed just have to increase the value
		for (int i = 0; i < 5; i++) {
			employees.add(new ITSpecialist(staffNameGenerator(), 100));
		}

		for (int i = 0; i < 5; i++) {
			employees.add(new Receptionist(staffNameGenerator(), 5));
		}

		for (int i = 0; i < 10; i++) {
			employees.add(new Reader(staffNameGenerator(), 50));
		}

		for (int i = 0; i < 10; i++) {
			employees.add(new Nurse(staffNameGenerator(), 30));
		}

		for (int i = 0; i < 10; i++) {
			employees.add(new TraineeVet(staffNameGenerator(), 10));
		}
	}

	// Function to give some random tasks
	public void giveTask() {
		// For each going into the employees list and checking by the object name
		// if its matches one of the Admin Staff it add to a task list passing the
		// member and the task
		for (Employee admStaff : employees) {
			if (admStaff.getClass().getSimpleName().equals("ITSpecialist")
					|| admStaff.getClass().getSimpleName().equals("Receptionist")) {
				tasks.add(new Task(admStaff, generateTask()));
			}
		}
	}

	// Function to List all Staff Members
	public void listAllStaffMembers() {
		// Simple go into the employees array , and print all staff members
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~STAFF-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + staff.getName() + " - " + staff.getClass().getSimpleName());
			System.out.println("|> Staff-Number: " + staff.getStaffNumber());
			System.out.println("|> Salary Level: " + staff.getSalaryLevel());
		}

	}

	// Function to List staff by specific BookClass1egory
	public void listStaffByBookClass1egory(int option, String staff) {
		// Go into the employees list and if it matches the selected bookclass1egory it prints
		// it
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~STAFF-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee bookclass1egorie : employees) {
			if (bookclass1egorie.getClass().getSimpleName().equals(staff)) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + bookclass1egorie.getName() + " - " + bookclass1egorie.getClass().getSimpleName());
				System.out.println("|> Staff-Number: " + bookclass1egorie.getStaffNumber());
				System.out.println("|> Salary Level: " + bookclass1egorie.getSalaryLevel());
			}
		}
	}

	// Function to List all Books
	public void listAllBooks() {
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~ANIMAL-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Book book : books) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + book.getName() + " - " + book.getClass().getSimpleName());
			System.out.println("|> PET Age: " + book.getAge());
			System.out.println("|> Author: " + book.getMedicalCondition());
		}
	}

	// Function to List book by specific Kind
	public void listBookByKind(int option, String kind) {
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~ANIMAL-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Book book : books) {
			if (book.getClass().getSimpleName().equals(kind)) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + book.getName() + " - " + book.getClass().getSimpleName());
				System.out.println("|> PET Age: " + book.getAge());
				System.out.println("|> Author: " + book.getMedicalCondition());
			}
		}
	}

	// Function to List Staff by specific Name
	public void listStaffByName() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String staffName = null;

		// Output, list all the staff and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~NAMES-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + staff.getName());
		}

		// try bookclass1ch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Staff Name:_ ");
			staffName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated bookclass1ch block
			e.printStackTrace();
		}
		System.out.println("#~~~~~~~~~~~~~~~~~~~FOUNDED-STAFF~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)
			if (staffName.equals(staff.getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + staff.getName() + " - " + staff.getClass().getSimpleName());
				System.out.println("|> Staff-Number: " + staff.getStaffNumber());
				System.out.println("|> Salary Level: " + staff.getSalaryLevel());
			}

		}
	}

	// Function to List Book by specific Name
	public void listBookByName() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String bookName = null;

		// Output, list all the staff and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~PET-NAMES~~~~~~~~~~~~~~~~~~~~~~#");
		for (Book book : books) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + book.getName());
		}

		// try bookclass1ch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the PET Name:_ ");
			bookName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated bookclass1ch block
			e.printStackTrace();
		}
		System.out.println("#~~~~~~~~~~~~~~~~~~~FOUNDED-PET~~~~~~~~~~~~~~~~~~~~~~#");
		for (Book book : books) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)
			if (bookName.equals(book.getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + book.getName() + " - " + book.getClass().getSimpleName());
				System.out.println("|> PET Age: " + book.getAge());
				System.out.println("|> Author: " + book.getMedicalCondition());
			}

		}

	}

	// Function to list Staff performing certain task
	public void listByTask() {
		String option = null;
		;
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("#~~~~~~~~~~~~~~~~~~~~~TASK-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Task task : tasks) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + task.getTask());
		}

		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Task name:_ ");
			option = reader.readLine();
		} bookclass1ch (IOException e) {
			// TODO Auto-generated bookclass1ch block
			e.printStackTrace();
		}
		System.out.println("#~~~~~~~~~~~~~~~~~~~FOUNDED-TASK~~~~~~~~~~~~~~~~~~~~~#");
		for (Task taskName : tasks) {
			if (taskName.getTask().equals(option)) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> Staff Name: " + taskName.getStaff().getName());
				System.out.println("|> Staff Position: " + taskName.getStaff().getClass().getSimpleName());
				System.out.println("|> Task: " + taskName.getTask());
			}

		}
	}

	// Function to assign an book to a veterinarian
	public void assignTreatment() {
		int countBooks = 0;

		for (Employee vet : employees) {
			if (vet.getClass().getSimpleName().equals("Reader")) {
				vets.add(vet);
			}
		}

		// For each to give 100 books for each veterinarian
		// TO IMPLEMENT! - > Find a way to give the books randomly
		for (Book ani : books) {
			if (countBooks < 100) {
				if (ani.getClass().getSimpleName().equals("BookClass2")) {
					borrows.add(new Treatment(vets.get(0), ani));
				}
			} else if (countBooks > 100 && countBooks < 200) {
				if (ani.getClass().getSimpleName().equals("BookClass2")) {
					borrows.add(new Treatment(vets.get(1), ani));
				}
			} else if (countBooks > 200 && countBooks < 300) {
				if (ani.getClass().getSimpleName().equals("BookClass1")) {
					borrows.add(new Treatment(vets.get(2), ani));
				}
			} else if (countBooks > 300 && countBooks < 400) {
				if (ani.getClass().getSimpleName().equals("BookClass1")) {
					borrows.add(new Treatment(vets.get(3), ani));
				}
			}
			countBooks++;
		}

	}

	// Function to List Book to be treated by specific Vet
	public void listBooksFromVet() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String vetName = null;
		int positionQueue = 0;

		// Output, list all the VET and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~VET-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			if (staff.getClass().getSimpleName().equals("Reader")) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + staff.getName());
			}
		}

		// try bookclass1ch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Reader Name:_ ");
			vetName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated bookclass1ch block
			e.printStackTrace();
		}

		System.out.println("#~~~~~~~~~~~~~~~~~~FOUNDED-ANIMALS~~~~~~~~~~~~~~~~~~~~#");
		for (Treatment bookToTreat : borrows) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)

			if (vetName.equals(bookToTreat.getVet().getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> PET Name: " + bookToTreat.getBookToHeal().getName());
				System.out.println("|> PET Age: " + bookToTreat.getBookToHeal().getAge());
				System.out.println("|> PET Condition: " + bookToTreat.getBookToHeal().getMedicalCondition());
				System.out.println("|> PET Position in the QUEUE: " + positionQueue);
			}
			positionQueue++;
		}
	}

	// Function to Treat Books and remove them from the List
	public void treatBook() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String vetName = null;
		String petName = null;

		// Output, list all the VET and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~VET-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			if (staff.getClass().getSimpleName().equals("Reader")) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + staff.getName());
			}
		}

		// try bookclass1ch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Reader Name:_ ");
			vetName = reader.readLine();
		} bookclass1ch (IOException e) {
			// TODO Auto-generated bookclass1ch block
			e.printStackTrace();
		}

		System.out.println("#~~~~~~~~~~~~~~~~~~FOUNDED-ANIMALS~~~~~~~~~~~~~~~~~~~~#");
		for (Treatment bookToTreat : borrows) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)

			if (vetName.equals(bookToTreat.getVet().getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> PET Name: " + bookToTreat.getBookToHeal().getName());
				System.out.println("|> PET Age: " + bookToTreat.getBookToHeal().getAge());
				System.out.println("|> PET Condition: " + bookToTreat.getBookToHeal().getMedicalCondition());
			}
		}

		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Book Name:_ ");
			petName = reader.readLine();
		} catch (IOException | ConcurrentModifibookclass1ionException e) {
			// TODO Auto-generated bookclass1ch block
			e.printStackTrace();
		}

		for (Treatment bookToTreat : borrows) {
			// for each reading all the array again , and if the name matches it remove the
			// book from the list

			if (petName.equals(bookToTreat.getBookToHeal().getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> PET Name: " + bookToTreat.getBookToHeal().getName());
				System.out.println("|> Sucessfully Treated!");
				// where i remove the related book
				//borrows.remove(bookToTreat);
			}
		}

	}
}
