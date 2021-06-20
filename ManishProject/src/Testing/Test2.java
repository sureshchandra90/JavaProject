package Testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.XLUtils;

public class Test2 {

	static String path = "D:\\WorkSpace\\ManishProject\\src\\TestData\\ToolsQA.xlsx";

	public static void main(String args[]) throws InterruptedException, IOException {

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
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"item-0\"]/span")).click();
		Thread.sleep(1000);

		WebElement Name = driver.findElement(By.xpath("//input[@id='userName']"));

		WebElement Email = driver.findElement(By.xpath("//input[@id='userEmail']"));

		WebElement CurrentAdd = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));

		WebElement PermanentAdd = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));

		WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));

		
		
		int row = XLUtils.getRowCount(path, "Sheet1");
		// int coulumn = XLUtils.getCellCount(path, "Sheet1",row);
		// ArrayList<String>list = new ArrayList<String>();
		for (int i = 1; i < row; i++) {
			String name = XLUtils.getCellData(path, "Sheet1", i, 0);
			Name.clear();
			Name.sendKeys(name);
			Thread.sleep(1000);
			// list.add(name);
			String email = XLUtils.getCellData(path, "Sheet1", i, 1);
			Email.clear();
			Email.sendKeys(email);
			Thread.sleep(1000);
			// list.add(email);
			String curAdd = XLUtils.getCellData(path, "Sheet1", i, 2);
			CurrentAdd.clear();
			CurrentAdd.sendKeys(curAdd);
			Thread.sleep(1000);
			// list.add(curAdd);
			String perAdd = XLUtils.getCellData(path, "Sheet1", i, 3);
			PermanentAdd.clear();
			PermanentAdd.sendKeys(perAdd);
			Thread.sleep(1000);
			// list.add(perAdd);

			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", submit);

			submit.click();
			Thread.sleep(2000);
		}

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


	}
}
