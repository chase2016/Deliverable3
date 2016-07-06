import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



//As a user of the program, I want use the compile feature

public class CompilerTest {
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
		// When I view the Compile button
		// Then I see that the value is Compile
	  @Test
	  public void testValueVerifyCompile() throws Exception {
		  driver.get("http://lit-bayou-7912.herokuapp.com/");
	    try {
	      assertEquals("Compile", driver.findElement(By.xpath("(//input[@name='commit'])[3]")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	
	
	// Given that I am on the main page
	// When I input a = 5 and click the Compile button
	// Then I see the compiling include the Compile Operation was a success 
	@Test
	 public void testCompiler1() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
		    driver.findElement(By.id("code_code")).clear();
		    driver.findElement(By.id("code_code")).sendKeys("a = 5");
		    driver.findElement(By.xpath("(//input[@name='commit'])[3]")).click();
		    try {
		      assertEquals("Hood Popped - Compile Operation == disasm: <RubyVM::InstructionSequence:<compiled>@<compiled>>========== \n local table (size: 2, argc: 0 [opts: 0, rest: -1, post: 0, block: -1] s1) \n [ 2] a \n 0000 trace 1 ( 1) \n 0002 putobject 5 \n 0004 dup \n 0005 setlocal_OP__WC__0 2 \n 0007 leave \n \n Back", driver.findElement(By.cssSelector("body")).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		  }
		
}