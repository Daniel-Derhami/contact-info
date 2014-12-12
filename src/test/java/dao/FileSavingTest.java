package dao;

import exceptions.ErrorCode;
import exceptions.UserInfoException;
import model.UserInfo;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

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
        UserInfo userInfo = new UserInfo(1, "name", "adress", 21, "email@www.dfv") ;
        userInfos.add(userInfo);
    }

    /*@After
    public void tearDown() throws Exception {
        userInfos = null;

    }*/

    @Test
    public void testWriteUserInfos() {

        try {
            fileSaving.writeUserInfos(userInfos,"userInfo.obj");
        } catch (UserInfoException e) {
            assertEquals(e.getErrorCode(), ErrorCode.UNKNOWN);
        }

    }

    @Test
    public void testReadUserInfos() throws ClassNotFoundException {
        try {
            userInfos = fileSaving.readUserInfos("userInfo.obj");
        } catch (UserInfoException e) {
            assertEquals(e.getErrorCode(), ErrorCode.UNKNOWN);
        }
        assertFalse(userInfos.isEmpty());

    }
    @Test(expected = UserInfoException.class)
    public void testReadUserInfosWithException() throws ClassNotFoundException {
            userInfos = fileSaving.readUserInfos("userInfo2.obj");


    }

    @Test(expected = ClassNotFoundException.class)
    public void testReadUserInfosWithExceptionClassNotFoundException() throws ClassNotFoundException {
        userInfos = fileSaving.readUserInfos("userInfo4.obj");


    }


    @Test(expected = UserInfoException.class)
    public void newUserByEmailWithException() {
        UserInfo userInfo = new UserInfo(2, "name", "adress", 21, "email") ;
    }
}