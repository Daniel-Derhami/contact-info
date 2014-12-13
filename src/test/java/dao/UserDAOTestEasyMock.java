package dao;

import model.UserInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.eq;
import static org.junit.Assert.*;

public class UserDAOTestEasyMock {

    static UserDAO mock;

    @BeforeClass
    public static void oneTimeSetUp() {
        mock = createMock(UserDAO.class);

    }
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }



    @Test
    public void testSaveUser() throws Exception {
        UserInfo userInfo = new UserInfo("asdasd", "dssada", 23232, "wde@dfd.dss");
        expect( mock.saveUser( userInfo) ).andReturn( userInfo );
        replay(mock);
        UserInfo customer = mock.saveUser(userInfo );
        assertEquals( "wde@dfd.dss", customer.getEmail());
        verify(mock);

    }

    /*@Test
    public void testSearchUser() throws Exception {

        ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();

        expect( mock.searchUser("asdasd")).andReturn(userInfos);

        replay(mock);

        userInfos = mock.searchUser("asdasd" );
        assertEquals("wde@dfd.dss", userInfos.get(0).getEmail());
        verify(mock);

    } */





















}