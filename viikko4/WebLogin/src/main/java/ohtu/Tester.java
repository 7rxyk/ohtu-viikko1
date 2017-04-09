package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        // Väärällä salasanalla:
        element = driver.findElement(By.linkText("logout"));
        element.click();
        element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("piip");
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("Väärällä salasanalla: " + driver.getPageSource().contains("wrong username or password"));

        // Ei-olemassaoleva käyttäjätunnus:
        element = driver.findElement(By.name("username"));
        element.sendKeys("lollo");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("Ei-olemassaoleva käyttäjätunnus: " + driver.getPageSource().contains("wrong username or password"));

        // Uuden käyttäjän luonti:
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        element = driver.findElement(By.linkText("register new user"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("noora");
        element = driver.findElement(By.name("password"));
        element.sendKeys("norsu");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("norsu");
        element = driver.findElement(By.name("signup"));
        element.submit();

        System.out.println("Luotu uusi käyttäjä: " + driver.getPageSource().contains("info for newbie"));

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        // Uloskirjautuminen
        element = driver.findElement(By.linkText("logout"));
        element.click();

        System.out.println("Kirjauduttu ulos: " + driver.getPageSource().contains("login"));
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
