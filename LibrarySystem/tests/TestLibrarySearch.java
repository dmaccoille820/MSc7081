import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLibrarySearch {
	public static final Object NullValue=null;
	public static final int RATING_LOW=1;
	public static final int RATING_HIGH=5;
	String validISBN, validISBN2, validAuthorLow, validAuthorHigh, 
		validTitleLow, validTitleHigh,invalidISBN, invalidAuthor, 
		invalidTitle1, invalidTitle2;
	
	int validLowRating, validHighRating, validMedRating,
		invalidLowRating, invalidHighRating;
	Book book1;
	Book book2;
	Book book3;
	Book book4;
	Book book5;
	ArrayList<Book> books;;
	@BeforeEach
	void setUp() throws Exception {
		validISBN = "I".repeat(10); //iSBN 10 or 13 chars
		validISBN2 = "I".repeat(13); //iSBN 10 or 13 chars
		validAuthorLow="Stephen King"; // >0
		validAuthorHigh = "S".repeat(256);
		validTitleLow="I"; // >0
		validTitleHigh="I".repeat(256); // >0
		invalidISBN="123456789";
		invalidAuthor="";
		invalidTitle1="";
		invalidTitle2=(String) NullValue;
		validLowRating=1;
		validHighRating =5;
		validMedRating =3;
		invalidLowRating =0;
		invalidHighRating =6;
		book1 = new Book(validISBN,validAuthorLow, validTitleHigh,validLowRating );
		book2 = new Book(validISBN,validAuthorHigh, validTitleLow,validMedRating );
		book3 = new Book(validISBN,validAuthorLow, validTitleLow,validHighRating );
		book4 = new Book(validISBN2,validAuthorHigh, validTitleLow,validLowRating );
		book5 = new Book(validISBN,validAuthorLow, validTitleHigh,validMedRating );
		books=new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
	}

	@Test
	void testSearchByTitle() {
		assertEquals(LibrarySearch.searchByTitle(books, validTitleHigh).size(),2);
		assertEquals(LibrarySearch.searchByTitle(books, validTitleLow).size(),3);
		Assertions.assertThrows(NullPointerException.class,()->{
			LibrarySearch.searchByTitle(books, null);
		});
		Assertions.assertThrows(NullPointerException.class,()->{
			LibrarySearch.searchByTitle(null, validTitleHigh);
		});
	}

	@Test
	void testSearchByAuthor() {
		assertEquals(3,LibrarySearch.searchByAuthor(books, validAuthorLow).size());
		assertEquals(2,LibrarySearch.searchByAuthor(books, validAuthorHigh).size());
		Assertions.assertThrows(NullPointerException.class,()->{
			LibrarySearch.searchByAuthor(books, null);
		});
		Assertions.assertThrows(NullPointerException.class,()->{
			LibrarySearch.searchByAuthor(null, validAuthorHigh);
		});
		
	}

	@Test
	void testSearchByISBN() {
		assertEquals((LibrarySearch.searchByISBN(books, validISBN)).size(),4);
		assertEquals((LibrarySearch.searchByISBN(books, validISBN2).size()),1);
		Assertions.assertThrows(NullPointerException.class,()->{
			LibrarySearch.searchByISBN(books, null);
		});
		Assertions.assertThrows(NullPointerException.class,()->{
			LibrarySearch.searchByISBN(null, validISBN2);
		});
	}

	@Test
	void testSearchByRating() {
		assertEquals(LibrarySearch.searchByRating(books, validLowRating).size(),2);
		assertEquals(LibrarySearch.searchByRating(books, validLowRating).size(),2);
		Assertions.assertThrows(NumberFormatException.class,()->{
			LibrarySearch.searchByRating(books, Integer.parseInt(null));
		});
		Assertions.assertThrows(NullPointerException.class,()->{
			LibrarySearch.searchByRating(null, validLowRating);
		});
	}

}
