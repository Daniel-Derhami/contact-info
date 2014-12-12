package dao;

import model.UserInfo;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserDAOTestng {

    static UserDAO userDAO;
    @BeforeClass
    public static void oneTimeSetUp() {
        userDAO= new UserDAO("userInfo.obj");
    }

    @Test(invocationCount = 10,threadPoolSize = 2)
    public void testSearchUser() throws Exception {
        ArrayList<UserInfo> userInfos = userDAO.searchUser("name");
        assertFalse(userInfos.isEmpty());
    }

    @Test(invocationCount = 10,threadPoolSize = 2)
    public void testSaveUser() throws Exception {
        UserInfo userInfo = new UserInfo("new", "fdsfd", 1223, "eer@dfr.dfg");
        userDAO.saveUser(userInfo);
        assertNotNull(userInfo.getId());

    }


}