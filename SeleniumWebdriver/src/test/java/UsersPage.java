import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class UsersPage {
    @FindBy(xpath = "//table[@id='people']/tbody/tr/td[2]/a[@href='user/someuser/']")
    WebElement userName;

    @FindBy(xpath = "//table[@id='people']")
    WebElement user;

    @FindBy(xpath = "//a[@href='user/someuser/delete']")
    private WebElement deleteSomeUserReference;

    @FindBy(id = "yui-gen1-button")
    private WebElement confirmDeleteSomeUser;

    @FindBy(xpath = "//form[@method='post']")
    private WebElement infoDeleteUser;

    @FindBy(xpath = "//table[@id='people']/tbody/tr/td/a[@href='user/admin/delete']")
    private WebElement userAdminReference;

    public String getYesButtonColor()
    {
        String color = confirmDeleteSomeUser.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }

    UsersPage clickDeleteSomeUser() {
        deleteSomeUserReference.click();
        return this;
    }

    UsersPage confirmDelete() {
        confirmDeleteSomeUser.click();
        return this;
    }

    public boolean check_User_Name() {
        if (this.userName.getText().equals("someuser"))
            return true;
        else return false;
    }

    public String get_info_delete_user() {
        String mass[] = this.infoDeleteUser.getText().split("\n");
        return mass[0];
    }


    public boolean isUserNameEnabled(WebDriver driver) {
        try {
            return this.userName.isDisplayed();
        }catch (Exception exc)
        {
            return false;
        }
    }
    public boolean isUserNameDeleteReferenceDisplayed(WebDriver driver)
    {
        try {
            return deleteSomeUserReference.isDisplayed();
        }catch (Exception exc)
        {
            return false;
        }
    }

    public boolean isAdminDeleteReferenceDisplayed(WebDriver driver)
    {
        try {
            return userAdminReference.isDisplayed();
        }catch (Exception exc)
        {
            return false;
        }
    }
}
