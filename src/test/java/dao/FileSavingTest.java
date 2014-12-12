package dao;

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
        userInfos = new ArrayList<UserInfo>();
    }

    @AfterClass
    public static void oneTimeTearDown() {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        userInfos = null;

    }

    @Test
    public void testWriteUserInfos() throws Exception {
        UserInfo userInfo = new UserInfo(1, "name", "adress", 21, "email") ;
        userInfos.add(userInfo);
        fileSaving.writeUserInfos(userInfos);


    }
}