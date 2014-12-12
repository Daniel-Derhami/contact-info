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
            if (userInfo.getId() == null || userInfo.getId().equals(0)) {
                userInfo.setId(usersList.size() + 1);
            }
            usersList.add(userInfo);
            fileSaving.writeUserInfos(usersList, path);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
    }

    public void updateUser(UserInfo userInfo) {
        try {
            UserInfo found =null;
            for (UserInfo userInfo1 : usersList) {
                if (userInfo1.getId().equals(userInfo.getId())) {
                    found = userInfo1;
                }
            }
            usersList.remove(found);
            saveUser(userInfo);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
    }

    public int  removeUser(String name) {
        int i = 0;
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        for (UserInfo userInfo : usersList) {
            if (userInfo.getName().equals(name)) {
                users.add(userInfo);
                i++;
            }
        }
        for (UserInfo userInfo : users){
            usersList.remove(userInfo);
        }

        try {
            fileSaving.writeUserInfos(usersList, path);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
        return i;
    }

}
