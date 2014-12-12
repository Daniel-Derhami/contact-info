package dao;

import exceptions.ErrorCode;
import exceptions.UserInfoException;
import model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahriar on 12/12/14.
 */
public class UserDAO {
    private ArrayList<UserInfo> usersList = new ArrayList<UserInfo>();
    private FileSaving fileSaving;
    private String path;

    public UserDAO(String path) {
        this.path = path;
        usersList = new ArrayList<UserInfo>();
        fileSaving = new FileSaving();
        try {
            usersList = fileSaving.readUserInfos(path);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }

    }


    public ArrayList<UserInfo> searchUser(String name) {
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        for (UserInfo userInfo : usersList) {
            if (userInfo.getName() != null && userInfo.getName().equals(name)) {
                users.add(userInfo);
            }
        }

        return users;

    }


    public void saveUser(UserInfo userInfo) {
        try {
            usersList.add(userInfo);
            fileSaving.writeUserInfos(usersList, path);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
    }

    public void updateUser(UserInfo userInfo) {
        try {
            ArrayList<UserInfo> users = searchUser(userInfo.getName());
            for (UserInfo userInfo1 : users) {
                removeUser(userInfo1.getName());
            }
            saveUser(userInfo);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
    }

    public void removeUser(String name) {
        for (UserInfo userInfo : usersList) {
            if (userInfo.getName().equals(name)) {
                usersList.remove(userInfo);
            }
        }
        try {
            fileSaving.writeUserInfos(usersList, path);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
    }

}
