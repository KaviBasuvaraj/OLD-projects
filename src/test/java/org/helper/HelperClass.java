package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor j;
	public static Alert al;

	public static void openChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void openEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void openFireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void launchUrl(String pgUrl) {
		driver.get(pgUrl);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void minWindow() {
		driver.manage().window().minimize();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void toBack() {
		driver.navigate().back();
	}

	public static void toForward() {
		driver.navigate().forward();
	}

	public static void reloadPage() {
		driver.navigate().refresh();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void closeCurrentTab() {
		driver.close();
	}

	public static void pauseExecution(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public static String fetchCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static String fetchTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void fillTextBox(WebElement element, String input) {
		element.sendKeys(input);
	}

	public static void toClickButton(WebElement clkelem) {
		clkelem.click();
	}

	public static String toGetText(WebElement gtex) {
		String text = gtex.getText();
		return text;
	}

	public static String toGetAttribute(WebElement gatt) {
		String attribute = gatt.getAttribute("value");
		return attribute;
	}

	public static void toMoveToElement(WebElement mele) {
		a.moveToElement(mele).perform();
	}

	public static void toDragAndDrop(WebElement src, WebElement des) {
		a.dragAndDrop(src, des).perform();
	}

	public static void toDoubleClick(WebElement dclick) {
		a.doubleClick().perform();
	}

	public static void toContextClick(WebElement context) {
		a.contextClick().perform();
	}

	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void past() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void selectAll() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);

		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void next() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public static void up() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	public static void down() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void left() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
	}

	public static void right() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
	}

	public static void enter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void pageUp() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	public static void pageDown() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	public static void simpleAlert() {
		driver.switchTo().alert();
		al.accept();
	}

	public static void dismiss() {
		driver.switchTo().alert();
		al.dismiss();
	}

	public static void alertWithText(String text) {
		al.sendKeys(text);
		al.accept();
	}

	public static void jsfillTextBox(String sendvalue, WebElement element) {
		j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].setAttribute('value'," + sendvalue + ")", element);
	}

	public static void jsGetAttributes(WebElement getat) {
		j = (JavascriptExecutor) driver;
		Object text = j.executeScript("return arguments[0].getAttribute('value')", getat);
		String a = (String) text;
		System.out.println(a);
	}

	public static void jsClick(WebElement elec) {
		j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()", elec);
	}

	public static void scrollDown(WebElement ele1) {
		j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", ele1);

	}

	public static void scrollUp(WebElement ele2) {
		j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(false)", ele2);

	}

	public static void screenShot(String name) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\KAVI B\\eclipse-workspace\\MavenSample\\screenshots\\" + name + ".png");
		FileUtils.copyFile(src, des);
	}

	public static void switchWebElement(WebElement fram) {
		driver.switchTo().frame(fram);
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void mainFrame() {
		driver.switchTo().defaultContent();
	}

	public static void selectIndex(WebElement WebElement, int index) {
		Select s = new Select(WebElement);
		s.selectByIndex(index);
	}

	public static void selectValue(WebElement s1, String value) {
		Select s = new Select(s1);
		s.selectByValue(value);
	}

	public static void selectVisibleText(WebElement WebElement, String value) {
		Select s = new Select(WebElement);
		s.selectByVisibleText(value);

	}

	public static void getallSelected(WebElement WebElement) {
		Select s = new Select(WebElement);
		s.getAllSelectedOptions();
	}

	public static void getFirstSelected(WebElement WebElement) {
		Select s = new Select(WebElement);
		s.getFirstSelectedOption();
	}

	public static void checkMultile(WebElement WebElement) {
		Select s = new Select(WebElement);
		boolean mul = s.isMultiple();
		System.out.println(mul);
	}

	public static void deselectAll(WebElement WebElement) {
		Select s = new Select(WebElement);
		s.deselectAll();
	}

	public static void deselectIndex(WebElement WebElement, int index) {
		Select s = new Select(WebElement);
		s.deselectByIndex(index);
	}

	public static void deselectValue(WebElement WebElement, String value) {
		Select s = new Select(WebElement);
		s.deselectByValue(value);
	}

	public static void deselectVisibleText(WebElement WebElement, String text) {
		Select s = new Select(WebElement);
		s.deselectByVisibleText(text);
	}

	public static void getAllOptions(WebElement WebElement) {
		Select s = new Select(WebElement);
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
	}

	public static void getParentWindowId() {
		String window = driver.getWindowHandle();
		System.out.println(window);
	}

	public static void getAllWindowId() {
		String window = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		for (String each : ids) {
			if(! each.equals(window)) {
				driver.switchTo().window(each);
			}
			
		}
	}

	public static void switchWindowByUrl(String url) {
		driver.switchTo().window(url);
	}

	public static void switchWindowByTitle(String title) {
		driver.switchTo().window(title);
	}

	public static void switchWindowById(String id) {
		driver.switchTo().window(id);
	}

	public static void tableCount() {
		List<WebElement> alltables = driver.findElements(By.tagName("table"));
		int size = alltables.size();
		System.out.println("Total number of Tabels :" + size);
	}

	public static void allRow() {
		List<WebElement> allRows = driver.findElements(By.tagName("tr"));
		int size = allRows.size();
		System.out.println("Total number of Tabels :" + size);

	}

	public static void tableHeading(int rowno) {
		List<WebElement> allhead = driver.findElements(By.tagName("tr"));

		for (int i = 0; i < allhead.size(); i++) {
			WebElement row = allhead.get(i);
			System.out.println(row);
		}
	}

	public static void allData(int rowno) {
		List<WebElement> alldata = driver.findElements(By.tagName("td"));

		for (int j = 0; j < alldata.size(); j++) {
			WebElement data = alldata.get(j);
			System.out.println(data.getText());
		}
	}

	public static String readDataFromExcel(int sheetNo, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\KAVI B\\eclipse-workspace\\MavenSample\\Excel files\\DATA.xlsx");
		FileInputStream fil = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fil);
		Sheet sheet = w.getSheetAt(sheetNo);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int type = cell.getCellType();

		String input;
		if (type == 1) {
			input = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd/MMM/yyyy");
			input = sim.format(date);

		} else {
			double dou = cell.getNumericCellValue();
			long l = (long) dou;
			input = String.valueOf(l);
		}

		return input;

	}

}
