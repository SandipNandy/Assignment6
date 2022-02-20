import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignMent6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		WebElement Parentdriver=driver.findElement(By.xpath("//div[@class='right-align' and @id='checkbox-example']/fieldset"));
		List<WebElement> options=Parentdriver.findElements(By.xpath("//fieldset/legend[contains(text(),'Checkbox Example')]/following-sibling::label"));
		int OptionsNumber=options.size();
		String[] menuItems = new String[OptionsNumber];
		int y = 0;
		for(int i=1,j=0;(i<=OptionsNumber & j<OptionsNumber);i++,j++) {
			if(options.get(j).getText().equalsIgnoreCase("Option1")) {
			Parentdriver.findElement(By.xpath("//fieldset/legend[contains(text(),'Checkbox Example')]/following-sibling::label["+i+"]/input")).click();
			System.out.println(options.get(j).getText());
			menuItems[j]=options.get(j).getText();
			y=j;
			}
			
		}
		System.out.println(y);
		System.out.println(menuItems[y]);
		
		//drop down with select static tag
        WebElement staticDropdown= driver.findElement(By.id("dropdown-class-example"));
        //This methods of choosing drop down will work only when there is 'select' option available in dom page in devtools
        Select dropdown= new Select(staticDropdown);
        dropdown.selectByVisibleText(""+menuItems[y]+"");
        
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(menuItems[y]);
        driver.findElement(By.id("alertbtn")).click();
        String AlertText=driver.switchTo().alert().getText();
        System.out.println(AlertText);
        driver.switchTo().alert().accept();
        Pattern pattern = Pattern.compile(""+menuItems[y]+"");
		Matcher matcher = pattern.matcher(AlertText);
		String Group = null;
		while(matcher.find()){
			 Group = matcher.group();
            System.out.println("Matching Text of '"+AlertText+"' is : "+Group);
            
		}
        

	}

}
