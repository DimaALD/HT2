import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {
    String base_url = "http://localhost:8080/";
    private WebDriver driver = null;
    private MainPage mainPage = null;
    private LogInPage logInPage = null;
    private CreateUserPage createUserPage = null;
    private UsersPage usersPage = null;
    public SampleTest()
    {

    }
    @BeforeClass
    public void beforeClass() throws Exception {
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--lang=en-us");
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        this.driver = new ChromeDriver(options);
        driver.get(base_url);
        logInPage = (LogInPage)PageFactory.initElements(this.driver, LogInPage.class);
        logInPage.setName("admin").setPassword("123456789").pressLogInButton();
        mainPage = (MainPage)PageFactory.initElements(this.driver,MainPage.class);
        createUserPage = (CreateUserPage)PageFactory.initElements(this.driver,CreateUserPage.class);
        usersPage = (UsersPage)PageFactory.initElements(this.driver,UsersPage.class);
    }

    @Test
    public void check_Main_Task()
    {
        mainPage.pressManageJenkins();

        Assert.assertTrue(mainPage.ManageUsers_DD(),"Отстутсвует поле dd Create/delete/modify users that can log in to this Jenkins");

        Assert.assertTrue(mainPage.ManageUsers_DT(),"Отстутсвует поле dt Manage Users");

        mainPage.pressManageUsers();

        Assert.assertTrue(createUserPage.Create_User_Ref(),"Отсутствует href Create User");

        createUserPage.pressCreateUser_Reference();

        Assert.assertTrue(createUserPage.checkForm(driver),"поля типа text != 3 или поля типа password !=2");

        Assert.assertTrue(createUserPage.check_Empty_Rows(),"поля не пустые");

        createUserPage.setUserName("someuser").setPassword("somepassword").setConfirmPassword("somepassword").setFullName("Some Full Name").setEmail("some@addr.dom");

        createUserPage.clickCreateUser_Button();

        Assert.assertTrue(usersPage.check_User_Name(),"Имя: someuser отстутсвует");

        usersPage.clickDeleteSomeUser();

        Assert.assertEquals(usersPage.get_info_delete_user(),"Are you sure about deleting the user from Jenkins?");

        usersPage.confirmDelete();

        Assert.assertFalse(usersPage.isUserNameEnabled(driver),"someuser не удалён со страницы");

        Assert.assertFalse(usersPage.isUserNameDeleteReferenceDisplayed(driver),"user/someuser/delete не удалена со страницы");

        Assert.assertFalse(usersPage.isAdminDeleteReferenceDisplayed(driver),"Пользователь не является admin");

    }
    @Test
    public void check_buttons_color()
    {
        mainPage.pressManageJenkins();
        mainPage.pressManageUsers();
        createUserPage.pressCreateUser_Reference();
        Assert.assertEquals(createUserPage.getCreateUserButtonColor(),"#4b758b");
        createUserPage.setUserName("someuser").setPassword("somepassword").setConfirmPassword("somepassword").setFullName("Some Full Name").setEmail("some@addr.dom");
        createUserPage.clickCreateUser_Button();
        usersPage.clickDeleteSomeUser();
        Assert.assertEquals(usersPage.getYesButtonColor(),"#4b758b");
    }
    @Test
    public void check_Warning_Message() {
        mainPage.pressManageJenkins();
        mainPage.pressManageUsers();
        createUserPage.pressCreateUser_Reference();
        createUserPage.setUserName("").setPassword("somepassword").setConfirmPassword("somepassword").setFullName("Some Full Name").setEmail("some@addr.dom");
        createUserPage.clickCreateUser_Button();
        Assert.assertEquals(createUserPage.getErrorMessage(),"\"\" is prohibited as a full name for security reasons.");
    }
    @Test
    public void check_Enable_Auto_Refresh()
    {
        for (int i = 0;i<4;i++)
        {
            mainPage.pressEnable_Auto_Refresh();
            mainPage.pressDisable_Auto_Refres();
        }
    }
    @AfterClass
    public void close()
    {
    }

}
