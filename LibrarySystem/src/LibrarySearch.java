import java.util.ArrayList;

public class LibrarySearch {

	
		/**
		* Search by title
		* @param title - String
		* @return ArrayList of found books matching search criteria
		*/
		public static ArrayList<Book> searchByTitle(ArrayList<Book> allBooks, String
		title) {
		ArrayList<Book> results = new ArrayList<Book>();
		for (int loop = 0; loop < allBooks.size(); loop++) {
		if (allBooks.get(loop).getTitle().equals(title)) {
		// add book to search
		results.add(allBooks.get(loop));
		}
		else {
			if (title.equals(null)) {
				
				throw new NullPointerException("Nothing was passed in as title string");
			}
		}
		}
		return results;
		}
		/**
		 * 
		 * @param allBooks
		 * @param author
		 * @return
		 * @throws NullPointerException
		 */
		public static ArrayList<Book> searchByAuthor(ArrayList<Book> allBooks, String
		author) throws IllegalArgumentException {
			if (author.equals(null)) {
				throw new NullPointerException("Problem with the author, null");
			}
		ArrayList<Book> results = new ArrayList<Book>();
		for (int loop = 0; loop < allBooks.size(); loop++) {
		if (allBooks.get(loop).getAuthor().equals(author)) {
		// add book to search
		results.add(allBooks.get(loop));
		}
		}
		return results;
		}
		/**
		 * Search by ISBN
		 * @param allBooks
		 * @param iSBN
		 * @return
		 */
		public static ArrayList<Book> searchByISBN(ArrayList<Book> allBooks, String
				iSBN) throws NullPointerException{
				ArrayList<Book> results = new ArrayList<Book>();
				if (iSBN.equals(null)) {
					throw new NullPointerException("Problem with thw ISBN length null?");
				}
				for (int loop = 0; loop < allBooks.size(); loop++) {
				if (allBooks.get(loop).getISBN().equals(iSBN)) {
				// add book to search
				results.add(allBooks.get(loop));
				}
				}
				return results;
				}
		/**
		 * Search by Rating
		 * @param allBooks
		 * @param iSBN
		 * @return
		 */
		public static ArrayList<Book> searchByRating(ArrayList<Book> allBooks, int
				rating) {
				ArrayList<Book> results = new ArrayList<Book>();
				for (int loop = 0; loop < allBooks.size(); loop++) {
				if (allBooks.get(loop).getRating()==rating) {
				// add book to search
				results.add(allBooks.get(loop));
				}
				}
				return results;
				}

	}


