package dao;

import exceptions.ErrorCode;
import model.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserDAOTest {

    static UserDAO userDAO;
    @BeforeClass
    public static void oneTimeSetUp() {
        userDAO= new UserDAO("userInfo.obj");
    }
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSearchUser() throws Exception {
        ArrayList<UserInfo> userInfos = userDAO.searchUser("name");
        assertFalse(userInfos.isEmpty());
    }

    @Test
    public void testSaveUser() throws Exception {
        UserInfo userInfo = new UserInfo("new", "fdsfd", 1223, "eer@dfr.dfg");
        userDAO.saveUser(userInfo);
        assertNotNull(userInfo.getId());

    }

    @Test
    public void testUpdateUser() throws Exception {
        ArrayList<UserInfo> userInfos = userDAO.searchUser("name");
        UserInfo userInfo = userInfos.get(0);
        userInfo.setName("name");
        userDAO.updateUser(userInfo);
        assertNotNull(userInfo.getId());

    }

    @Test
    public void testRemoveUser() throws Exception {
        int i = userDAO.removeUser("new");
        assertEquals(0,i);
    }
}