import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementos {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANDRESSA\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com");
		driver.manage().window().maximize();
		
	}
	@Test
	public void validaEscolha() {
		//Escolhendo o produto pelo nome
		driver.findElement(By.linkText("Blouse")).click();
		
		//Adicionando o produto ao carrinho
		driver.findElement(By.id("add_to_cart")).click();
	
		//Aguardar carregamento de página antes de prosseguir para checkin
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		//Seguir para checkout
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
		
		//Validar produto no carrinho
		assertEquals("Blouse", driver.findElement(By.linkText("Blouse")).getText());
				
		//Visualizar carrinho e seguir para cadastro/login
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
		
		//Criar cadastro
		driver.findElement(By.id("email_create")).sendKeys("teste0002@dbserver.com");
	
		//Clicar em Create an account
		driver.findElement(By.id("SubmitCreate")).click();

		//Preencher dados de cadastro
		driver.findElement(By.id("id_gender2")).click();	
		driver.findElement(By.id("customer_firstname")).sendKeys("db");
		driver.findElement(By.id("customer_lastname")).sendKeys("server");
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
	    
	    
	    driver.findElement(By.id("firstname")).sendKeys("teste");
	    driver.findElement(By.id("lastname")).sendKeys("teste2");
	    driver.findElement(By.id("company")).sendKeys("DBSERVER");
	    driver.findElement(By.id("address1")).sendKeys("Avenida Bento Gonçalves");
	    driver.findElement(By.id("city")).sendKeys("Porto Alegre");
		
		//Selecionando o estado
		WebElement comboboxState = driver.findElement(By.id("id_state"));
		Select comboboxState1 = new Select(comboboxState);
		comboboxState1.selectByVisibleText("Alabama");
		
		//Inserindo código postal
		driver.findElement(By.id("postcode")).sendKeys("22222");
		
		//Selecionando país
		WebElement comboboxCountry = driver.findElement(By.id("id_country"));
		Select comboboxCountry1 = new Select(comboboxCountry);
		comboboxCountry1.selectByVisibleText("United States");
		
		//Inserindo telefone
		driver.findElement(By.id("phone_mobile")).sendKeys("999999999");
		
		//Validar endereço
		assertEquals("Avenida Bento Gonçalves", driver.findElement(By.id("address1")).getText());
		
		//Clicar em registrar
		driver.findElement(By.name("submit")).sendKeys(Keys.RETURN);
		
		//Aceitar termos
		driver.findElement(By.name("cgv")).click();
		
		//Prosseguir para checkout
		driver.findElement(By.name("proccessAddress")).click();
		
		//Validar total da compra
		driver.findElement(By.id("total_price")).click();
		
		//Escolher forma de pagamento
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
		
		//Confirmar compra
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		
		//Validar compra
		WebElement popup = driver.findElement(By.id("oder-confirmation"));
		String mensagem = popup.getText();
		assertEquals("Compra realizada com sucesso", mensagem);
	}
	/*	@After
		public void tearDown() {
		driver.quit();
		}*/
	}


