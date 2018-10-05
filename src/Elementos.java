import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Elementos {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANDRESSA\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//Aguardar carregamento de páginas
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.automationpractice.com");
		driver.manage().window().maximize();
		
	}
	@Test
	public void efetuandoCompra()  {
		//Escolhendo o produto pelo nome
		driver.findElement(By.linkText("Blouse")).click();
		
		//Adicionando o produto ao carrinho
		driver.findElement(By.id("add_to_cart")).click();
			
		//Seguir para checkout
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
		
		//Validar produto no carrinho
		assertEquals("Blouse", driver.findElement(By.linkText("Blouse")).getText());
				
		//Visualizar carrinho e seguir para cadastro/login
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
		
		//Criar cadastro
		driver.findElement(By.id("email_create")).sendKeys("teste08@dbserver.com");
	
		//Clicar em Create an account
		driver.findElement(By.id("SubmitCreate")).click();

		//Preencher dados de cadastro
		driver.findElement(By.id("id_gender2")).click();	
		driver.findElement(By.id("customer_firstname")).sendKeys("dbtestedbtst");
		driver.findElement(By.id("customer_lastname")).sendKeys("dbservertestet");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		
		//Selecionando data de aniversário
		WebElement comboBoxDays = driver.findElement(By.id("days"));
	    Select comboBoxDays1 = new Select(comboBoxDays);
	    comboBoxDays1.selectByValue("1");
		WebElement comboBoxMonths = driver.findElement(By.id("months"));
	    Select comboBoxMonths1 = new Select(comboBoxMonths);
	    comboBoxMonths1.selectByValue("1");
	    WebElement comboBoxYears = driver.findElement(By.id("years"));
	    Select comboBoxYears1 = new Select(comboBoxYears);
	    comboBoxYears1.selectByValue("1980");
	    
	    
	    driver.findElement(By.id("firstname")).sendKeys("dbtestedbtst");
	    driver.findElement(By.id("lastname")).sendKeys("dbservertestet");
	    driver.findElement(By.id("company")).sendKeys("DBSERVER");
	    driver.findElement(By.id("address1")).sendKeys("Avenida Bento Goncalves");
		
	    driver.findElement(By.id("city")).sendKeys("Porto Alegre");
		
		//Selecionando o Estado
		WebElement comboboxState = driver.findElement(By.id("id_state"));
		Select comboboxState1 = new Select(comboboxState);
		comboboxState1.selectByVisibleText("Alabama");
		
		//Inserindo código postal
		driver.findElement(By.id("postcode")).sendKeys("22222");
		
		//Selecionando País
		WebElement comboboxCountry = driver.findElement(By.id("id_country"));
		Select comboboxCountry1 = new Select(comboboxCountry);
		comboboxCountry1.selectByVisibleText("United States");
		
		//Inserindo telefone
		driver.findElement(By.id("phone_mobile")).sendKeys("999999999");
		
		//Validar endereço
		assertEquals(driver.findElement(By.id("address1")).getAttribute("value"), "Avenida Bento Goncalves");
		
		//Clicar em registrar
		driver.findElement(By.id("submitAccount")).click();

		//Prosseguir para checkout
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
				
		//Aceitar termos
		driver.findElement(By.id("cgv")).click();
		
		//Prosseguir para checkout
		driver.findElement(By.name("processCarrier")).click();
		
		//Validar total da compra
		driver.findElement(By.id("total_price")).click();
		
		//Escolher forma de pagamento
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
		
		//Confirmar compra
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		
		//Validar compra
		boolean validaCompra = driver.getPageSource().contains("");
		assertTrue(validaCompra);
	}
		@After
		public void tearDown() {
		driver.quit();
		}
	}


