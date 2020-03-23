package com.softwareTest_task2;


import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumTest {

	
	 private static String url="http://103.120.226.190/selenium-demo/git-repo";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���ӻ������
        System.setProperty("webdriver.gecko.driver", "D:\\JarCollect\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
//        String title=driver.getTitle();
//        System.out.println(title);
//        String pagesource = driver.getPageSource();
//        System.out.println(pagesource);
//        driver.quit();
		
        
        try {
        	//��ȡ�����ļ�
			InputStream iss = new FileInputStream("file/Lab2020.xlsx");
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(iss);

			// ��ȡÿһ��������
			for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
				if (xssfSheet == null) {
					continue;
				}
				
				// ��ȡ��ǰ��������ÿһ��
				for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
					XSSFRow xssfRow = xssfSheet.getRow(rowNum);
					if (xssfRow != null&& !xssfRow.getCell(1).toString().equals("")&&! xssfRow.getCell(2).toString().equals("")) {
						// ��ȡ�û���
						XSSFCell username = xssfRow.getCell(1);
//						System.out.println(username.toString());
						
						// ��ȡ����
						XSSFCell password = xssfRow.getCell(2);
//						System.out.println(password.toString());
				
						WebElement userName = driver.findElement(By.name("user_number"));
						userName.sendKeys(username.toString());
						WebElement passWord = driver.findElement(By.name("password"));
						passWord.sendKeys(password.toString());
						WebElement button = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
						button.click();
						
						WebElement returnText = driver.findElement(By.className("mb-2"));
						//System.out.println(returnText.getText());
						if(returnText.getText().equals("user number and password don't match!")) {
							System.out.println("����: �����˺��ǣ� "+username.toString()+"    ���������ǣ�"+password.toString());
						}else {
							System.out.println("��ȷ: �����˺��ǣ�"+username.toString()+"     ���������ǣ�"+password.toString());
						}
					}
					
				}
				break;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		


	}

}
   