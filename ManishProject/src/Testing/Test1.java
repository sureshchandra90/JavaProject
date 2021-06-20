package Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.XLUtils;

public class Test1 {
	static String path = "D:\\WorkSpace\\ManishProject\\src\\TestData\\ToolsQA.xlsx";

	public static void main(String[] args) throws Exception {
		

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.toolsqa.com/");

		driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[6]/a/span/span")).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"item-0\"]/span")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Manish Negi");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("abc@xyz.com");

		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("HN xyz,noida");

		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("HN xyz,ghaziabad");
		WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));

		
		js.executeScript("arguments[0].scrollIntoView(true)", submit);

		submit.click();

		Thread.sleep(2000);

		// ArrayList<WebElement> dd = (ArrayList<WebElement>) driver
		// .findElements(By.xpath("//*[@class=\"border col-md-12 col-sm-12\"]/p"));

		List<WebElement> eleData = driver.findElements(By.xpath("//*[@id='output']/div/p"));
		int a=0;
		for (WebElement out : eleData) {
			
			// System.out.println(out.getText());
			String abc = out.getText();
			// System.out.println(abc);

			String[] st = abc.split(":");
			
			for (int i =0; i <st.length - 1; i++) {
				a=a+0;
				System.out.println(st.length - 1);
				// System.out.println(st[1]);

				XLUtils.setCellData(path, "Sheet2", 1, a, st[1]);
				
			}
				
a++;
		}

		String name = "Name:Manish Negi";
		String name1 = driver.findElement(By.xpath("//p[@id='name']")).getText();

		if (name.equals(name1)) {

			System.out.println(name1);
			System.out.println("Test is Pass");
		} else {
			System.out.println("Test is Fail");

		}

		driver.quit();

	}

}
