package dao;

import exceptions.ErrorCode;
import exceptions.UserInfoException;
import model.UserInfo;

import java.util.ArrayList;

/**
 * Created by shahriar on 12/12/14.
 */
public class UserDAO {
    private ArrayList<UserInfo> usersList = new ArrayList<UserInfo>();
    private FileSaving fileSaving;
    private String path;

    public UserDAO(String path) {
        this.setPath(path);
        setUsersList(new ArrayList<UserInfo>());
        setFileSaving(new FileSaving());
        try {
            setUsersList(getFileSaving().readUserInfos(path));
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }

    }


    public ArrayList<UserInfo> searchUser(String name) {
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        for (UserInfo userInfo : getUsersList()) {
            if (userInfo.getName() != null && userInfo.getName().equals(name)) {
                users.add(userInfo);
            }
        }

        return users;

    }


    public UserInfo saveUser(UserInfo userInfo) {
        try {
            if (userInfo.getId() == null || userInfo.getId().equals(0)) {
                userInfo.setId(getUsersList().size() + 1);
            }
            getUsersList().add(userInfo);
            getFileSaving().writeUserInfos(getUsersList(), getPath());
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
        return userInfo;
    }

    public void updateUser(UserInfo userInfo) {
        try {
            UserInfo found =null;
            for (UserInfo userInfo1 : getUsersList()) {
                if (userInfo1.getId().equals(userInfo.getId())) {
                    found = userInfo1;
                }
            }
            getUsersList().remove(found);
            saveUser(userInfo);
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
    }

    public int  removeUser(String name) {
        int i = 0;
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        for (UserInfo userInfo : getUsersList()) {
            if (userInfo.getName().equals(name)) {
                users.add(userInfo);
                i++;
            }
        }
        for (UserInfo userInfo : users){
            getUsersList().remove(userInfo);
        }

        try {
            getFileSaving().writeUserInfos(getUsersList(), getPath());
        } catch (Exception e) {
            throw new UserInfoException(e, ErrorCode.IO);
        }
        return i;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileSaving getFileSaving() {
        return fileSaving;
    }

    public void setFileSaving(FileSaving fileSaving) {
        this.fileSaving = fileSaving;
    }

    public ArrayList<UserInfo> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<UserInfo> usersList) {
        this.usersList = usersList;
    }
}
