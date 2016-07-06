import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


//As a user of the program, I want use the tokenize feature


public class TokenizerTest {

	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for Hoodpopper for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}

	// Given that I am on the main page
	// When I view the title
	// Then I see that it contains the word "Hoodpopper"
	@Test
	public void testShowsCorrectTitle() {
		
		// Check the title contains the word "Hoodpopper"
		
		String title = driver.getTitle();
		assertTrue(title.contains("Hoodpopper"));
	}
	
	
	// Given that I am on the main page
	// When I view the Tokenize button
	// Then I see that the value is Tokenize
	 @Test
	  public void testValueVerifyTokenize() throws Exception {
	    try {
	      assertEquals("Tokenize", driver.findElement(By.name("commit")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	

	// Given that I am on the main page
	// When I input 77
	// Then I should see a new page that tokenizes the 77
	@Test
	  public void testTokenizer() {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
		  try {
		    driver.findElement(By.id("code_code")).clear();
		    driver.findElement(By.id("code_code")).sendKeys("77");
		    driver.findElement(By.name("commit")).click();
		  } catch (NoSuchElementException nseex) {
				fail();
		  }
	  }
	
	
	// Given that I am on the main page
	// When I input a = 10 and select Tokenize
	// Then I should see the tokenization process "on_ident","on_sp"
	  @Test
	  public void testTokenize1() throws Exception {
		  driver.get("http://lit-bayou-7912.herokuapp.com/");
	    driver.findElement(By.id("code_code")).clear();
	    driver.findElement(By.id("code_code")).sendKeys("a = 10");
	    driver.findElement(By.name("commit")).click();
	    try {
	      assertEquals("Hood Popped - Tokenize Operation [[1, 0], :on_ident, \"a\"]\n[[1, 1], :on_sp, \" \"]\n[[1, 2], :on_op, \"=\"]\n[[1, 3], :on_sp, \" \"]\n[[1, 4], :on_int, \"10\"] \n Back", driver.findElement(By.cssSelector("body")).getText());
	    } catch (Error e) {
	    	verificationErrors.append(e.toString());
	    }
	  }
	
	  
}