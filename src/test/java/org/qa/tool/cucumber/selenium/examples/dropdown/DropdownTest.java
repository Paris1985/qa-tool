package org.qa.tool.cucumber.selenium.examples.dropdown;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qa.tool.cucumber.base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;

    @Before
    public void before(){
       this.before("Dropdown Test");
    }
    @After
    public void after(){
        this.after(null);
    }
    @Test
    public void testVisibleText() {
        dropdownPage = new DropdownPage();
        dropdownPage.selectVisibleText("Banana");
        assertThat(dropdownPage.containsSelectedItem("Banana")).isTrue();
    }


}
