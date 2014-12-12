package dao;

import exceptions.ErrorCode;
import exceptions.UserInfoException;
import model.UserInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahriar on 12/12/14.
 */
public class FileSaving {
    /**
     * write list of userInfo in file
     *
     * @param userInfos
     * @throws UserInfoException
     */
    public  void writeUserInfos(List<UserInfo> userInfos,String filePath) throws  UserInfoException {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(userInfos);
            byte b[] = baos.toByteArray();
            raf.seek(0);
            raf.write(b);
            raf.close();
            oos.close();
            baos.close();
        } catch (IOException e) {
            throw new UserInfoException(e,ErrorCode.IO);
        } catch (Exception e) {
            throw new UserInfoException(e,ErrorCode.UNKNOWN);
        }
    }

    /**
     * read list of userInfos from file
     *
     * @return userInfos
     * @throws UserInfoException
     */
    public  List<UserInfo> readUserInfos(String filePath) throws ClassNotFoundException {
        List<UserInfo> members = null;

        try {
            if(filePath == null){
                throw new UserInfoException(null,ErrorCode.NULL);
            }
            File f = new File(filePath);
            if (!f.exists()) {
                throw new UserInfoException(null,ErrorCode.FILE_NOT_FOUND);
            }
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            raf.seek(0);
            byte b[] = new byte[10000];
            raf.read(b);
            ByteArrayInputStream bais = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bais);
            members = (List<UserInfo>) ois.readObject();
            ois.close();
            bais.close();
        } catch (IOException e) {
            throw new UserInfoException(e,ErrorCode.IO);
        }
        return members;
    }

}
