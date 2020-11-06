package ie.cct.model;

public class Borrowings {
	// Attributes
	protected Employee vet;
	protected Book bookToHeal;

	// Constructor
	public Borrowings(Employee vet, Book bookToHeal) {
		super();
		this.vet = vet;
		this.bookToHeal = bookToHeal;
	}

	// Getters and Setters
	public Employee getVet() {
		return vet;
	}

	public void setVet(Employee vet) {
		this.vet = vet;
	}

	public Book getBookToHeal() {
		return bookToHeal;
	}

	public void setBookToHeal(Book bookToHeal) {
		this.bookToHeal = bookToHeal;
	}

}
