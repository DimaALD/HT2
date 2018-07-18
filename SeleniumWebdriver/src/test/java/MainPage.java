import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.Iterator;

public class MainPage {

    @FindBy(linkText = "Manage Jenkins")
    private WebElement Manage_Jenkins;

    @FindBy (xpath = "//a[@href='securityRealm/'][@title='Manage Users']")
    private WebElement Manage_Users;

    @FindBy(xpath = "//a[@href='securityRealm/'][@title='Manage Users']/dl/dt[text()='Manage Users']")
    private WebElement ManageUsersDT;

    @FindBy(xpath = "//a[@href='securityRealm/'][@title='Manage Users']/dl/dd[text()='Create/delete/modify users that can log in to this Jenkins']")
    private WebElement ManageUsersDD;

    @FindBy(xpath = "//div[@class ='smallfont']/a[@href='?auto_refresh=true']")
    private WebElement enable_auto_refresh;

    @FindBy(xpath = "//div[@class ='smallfont']/a[@href='?auto_refresh=false']")
    private WebElement disable_auto_refresh;

    MainPage pressManageJenkins()
    {
        Manage_Jenkins.click();
        return this;
    }

    MainPage pressManageUsers()
    {
        Manage_Users.click();
        return this;
    }

    MainPage pressDisable_Auto_Refres()
    {
        disable_auto_refresh.click();
        return this;
    }

    MainPage pressEnable_Auto_Refresh()
    {
        enable_auto_refresh.click();
        return this;
    }

   boolean ManageUsers_DT()
   {
       if (ManageUsersDT.getText().equals("Manage Users"))
       return true;
       else return false;
   }

   boolean ManageUsers_DD()
   {
       if (ManageUsersDD.getText().equals("Create/delete/modify users that can log in to this Jenkins"))
       return true;
       else return false;
   }


}
