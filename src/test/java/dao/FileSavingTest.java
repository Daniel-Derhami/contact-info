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
    private static ArrayList<UserInfo> userInfos = null;

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
    public void testWriteUserInfos() throws Exception {

        try {
            fileSaving.writeUserInfos(userInfos,"userInfo.obj");
        } catch (UserInfoException e) {
            assertEquals(e.getErrorCode(), ErrorCode.UNKNOWN);
        }

    }

    @Test(expected = Exception.class)
    public void testWriteUserInfosWith() throws Exception {


            fileSaving.writeUserInfos(userInfos,"userInfo.obj");


    }

    @Test
    public void testReadUserInfos() throws Exception {
        try {
            userInfos = fileSaving.readUserInfos("userInfo.obj");
        } catch (UserInfoException e) {
            assertEquals(e.getErrorCode(), ErrorCode.UNKNOWN);
        }
        assertFalse(userInfos.isEmpty());

    }
    @Test
    public void testReadUserInfosWithFileNotFoundnd() throws Exception {
        UserInfoException e = null;
        try {
            userInfos = fileSaving.readUserInfos("badArgs.txt");
        } catch (UserInfoException e1) {
            e=e1;
        }
        assertEquals(e.getErrorCode(), ErrorCode.FILE_NOT_FOUND);

    }
    @Test(expected = UserInfoException.class)
    public void testReadUserInfosWithException() throws Exception {
            userInfos = fileSaving.readUserInfos("userInfo2.obj");


    }

    @Test(expected = ClassNotFoundException.class)
    public void testReadUserInfosWithExceptionClassNotFoundException() throws Exception {
        userInfos = fileSaving.readUserInfos("userInfo4.obj");


    }


    @Test(expected = UserInfoException.class)
    public void newUserByEmailWithException() {
        UserInfo userInfo = new UserInfo(2, "name", "adress", 21, "email") ;
    }
}