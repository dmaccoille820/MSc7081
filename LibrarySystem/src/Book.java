/**
 * 
 */

/**
 * @author dmaccoille820
 *
 */
public class Book {
public static final int RATING_LOW=1;
public static final int RATING_HIGH=5;

	/**
	 * This is the book class
	 */

	/**
	 * The book's ISBN
	 */
	private String ISBN;
	/**
	 * The autor of the book
	 */
	private String author;
	/**
	 * The title of the book
	 */
	private String title;
	/**
	 * The rating of the book
	 */
	private int rating;

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) throws IllegalArgumentException {
		if (validRating(rating)) {
			this.rating = rating;
		}
		else {
			throw new IllegalArgumentException("Problem setting the rating 1-5 inclusive");
		}
	}

	public boolean validRating(int rating2) {
		if (rating2>=RATING_LOW && rating2<=RATING_HIGH) {
			return true;
		}
		else{return false;}
	}

	/**
	 * Gets the ISBN number
	 *
	 * @return
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * Sets the ISBN number
	 *
	 * @param iSBN 10 or 13 chars
	 * @throws Exception
	 */
	public void setISBN(String iSBN) throws IllegalArgumentException{
		if (validISBN(iSBN)) {
			this.ISBN = iSBN;
		}
		else {
			throw new IllegalArgumentException("Problem setting the ISBN - either 10 or 13 characters");
		}
	}

	public boolean validISBN(String iSBN2) {
		if (iSBN2.length()==10 || iSBN2.length()==13 ) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Get the book's author
	 *
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the book's author
	 * @param author
	 */
	public void setAuthor(String author) {
		if (author.length()>0) {
			this.author = author;
		}
		else {
			throw new IllegalArgumentException("Problem setting the author - 1 or more characters");
		}
	}

	/**
	 * Gets the book's title
	 *
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the books title
	 * @param title
	 * @throws IllegalArgumentException
	 */
	public void setTitle(String title) throws IllegalArgumentException {
		if (title.length()>0) {
			this.title = title;
		}
		else {
			throw new IllegalArgumentException("Problem setting the author - 1 or more characters");
		}
		
	}

	/**
	 * Default constructor
	 */
	public Book() {
	}
	/**
	 * 
	 */

	/**
	 * Argument based Constructor
	 * @param iSBN
	 * @param author
	 * @param title
	 * @param rating
	 */
	public Book(String iSBN, String author, String title, int rating) {
		
		setISBN(iSBN);
		setAuthor(author);
		setTitle(title);
		setRating(rating);
	}
	
}
