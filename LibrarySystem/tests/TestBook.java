

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestBook {
	public static final Object NullValue=null;
	public static final int RATING_LOW=1;
	public static final int RATING_HIGH=5;
	String validISBN, validISBN2, validAuthorLow, validAuthorHigh, 
		validTitleLow, validTitleHigh,invalidISBN, invalidAuthor, 
		invalidTitle1, invalidTitle2;
	
	int validLowRating, validHighRating, validMedRating,
		invalidLowRating, invalidHighRating;
	Book book;
	
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
		book = new Book(validISBN,validAuthorLow, validTitleLow,validMedRating );
	}

	@Test
	void testSetRatingValid() { // test SetRating method for valid integer
		book.setRating(validLowRating);
		assertEquals(book.getRating(),validLowRating);
		book.setRating(validHighRating);
		assertEquals(book.getRating(),validHighRating);
	}
	@Test
	void testSetRatingInvalid() { // test SetRating method for valid integer
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			book.setRating(invalidHighRating);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			book.setRating(invalidLowRating);
		});
	
	}

	@Test
	void testValidRating() { // test the validRating method for true
		assertTrue(book.validRating(validLowRating));
		assertTrue(book.validRating(validMedRating));
		assertTrue(book.validRating(validHighRating));
	}
	@Test
	void testValidRatingInvalid() { // test the validRating method for false
		assertFalse(book.validRating(invalidLowRating));
		assertFalse(book.validRating(invalidHighRating));
	}

	@Test
	void testSetISBN() { // test setISBN for valid length
		book.setISBN(validISBN);
		assertEquals(book.getISBN(),validISBN); // length 10
		book.setISBN(validISBN2);
		assertEquals(book.getISBN(),validISBN2); // length 13
	}
	@Test
	void testSetISBNInvalid() { // test setISBN for valid length
	;
		assertFalse(book.validISBN(invalidISBN)); // invalid length 
		
	}

	@Test
	void testSetAuthor() { // test setAuthor for valid length, 
		book.setAuthor(validAuthorHigh);
		assertEquals(book.getAuthor(),"S".repeat(256));
		book.setAuthor(validAuthorLow);
		assertEquals(book.getAuthor(),"Stephen King");
	}
	@Test
	void testSetAuthorInvalid() { // test setAuthor for invalid length, 
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			book.setAuthor(invalidAuthor);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			book.setAuthor(invalidAuthor);
		});
	}

	@Test
	void testSetTitleValid() { // set title with valid length
		book.setTitle(validTitleLow);
		assertEquals(book.getTitle(),"I");
		book.setTitle("Normal Book title");
		assertEquals(book.getTitle(),"Normal Book title");
	}
	@Test
	void testSetTitleInvalid() { // set title with valid length
		Assertions.assertThrows(NullPointerException.class,()->{
			book.setAuthor(invalidTitle2);
		});
	}
	

	@Test
	void testBookConstructor() {
		Book book2 = new Book("1A56789034","Valid Author","Valid Title",5);
		assertEquals(book2.getAuthor(),"Valid Author");
		assertEquals(book2.getTitle(),"Valid Title");
		assertEquals(book2.getISBN(),"1A56789034");
		assertEquals(book2.getRating(),5);
	}

}
