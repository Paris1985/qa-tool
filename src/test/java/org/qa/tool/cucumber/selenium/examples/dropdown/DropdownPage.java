package org.qa.tool.cucumber.selenium.examples.dropdown;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.qa.tool.cucumber.base.pages.BasePage;

public class DropdownPage extends BasePage {

    private final static String url = "https://letcode.in/dropdowns";
    @FindBy(id = "fruits")
    private WebElement dropDownElement;
    @FindBy(className = "is-success")
    private WebElement notificationElem;

    public DropdownPage() {
        super(url);
    }
    public void selectVisibleText(String text){
        Select select = new Select(dropDownElement);
        select.selectByVisibleText(text);
    }
    public boolean containsSelectedItem(String item) {
        return notificationElem.getText().contains(item);
    }
}
