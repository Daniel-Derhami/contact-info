package dao;

import exceptions.UserInfoException;
import model.UserInfo;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileSavingTest {

    private static FileSaving fileSaving = null;
    private static List<UserInfo> userInfos = null;

    @BeforeClass
    public static void oneTimeSetUp() {
        fileSaving = new FileSaving();
    }

   /* @AfterClass
    public static void oneTimeTearDown() {
    }*/

    @Before
    public void setUp() throws Exception {
        userInfos = new ArrayList<UserInfo>();
    }

    /*@After
    public void tearDown() throws Exception {
        userInfos = null;

    }*/

    @Ignore
    public void testWriteUserInfos() throws Exception {
        UserInfo userInfo = new UserInfo(1, "name", "adress", 21, "email@www.dfv") ;
        userInfos.add(userInfo);
        fileSaving.writeUserInfos(userInfos);

    }

    @Ignore
    public void testReadUserInfos() throws Exception {
        userInfos = fileSaving.readUserInfos();
        assertFalse(userInfos.isEmpty());

    }

    @Test(expected = UserInfoException.class)
    public void newUserByEmailWithException() {
        UserInfo userInfo = new UserInfo(1, "name", "adress", 21, "email") ;
    }
}