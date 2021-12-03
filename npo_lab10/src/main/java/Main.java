import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1.Зайти на google.by
2.Выполнить поиск по “iTechArt”
3.Убедиться что на странице результатов поиска
    a)Первый результат содержит слово “iTechArt”
    b)Title вкладки браузера содержит слово “iTechArt”
*/

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "T:\\Uni\\5_sem\\NPO\\NPO_labs\\npo_lab10\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("iTechArt");
        searchBar.submit();

        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));
        if(firstResult.getText().contains("iTechArt"))
            System.out.println("Первый результат содержит слово 'iTechArt'");
        else System.out.println("Первый результат НЕ содержит слово 'iTechArt'");

        if(driver.getTitle().contains("iTechArt"))
            System.out.println("Title вкладки браузера содержит слово 'iTechArt'");
        else System.out.println("Title вкладки браузера НЕ содержит слово 'iTechArt'");
    }
}