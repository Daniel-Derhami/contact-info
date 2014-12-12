package dao;

import model.UserInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahriar on 12/12/14.
 */
public class FileSaving {

    public void writeUserInfos(List<UserInfo> userInfos) {
        try {
            File f = new File("userInfo.obj");
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
           throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public List<UserInfo> readUserInfos() {
        List<UserInfo> members = new ArrayList<UserInfo>();

        try {
            File f = new File("userInfo.obj");
            if (!f.exists()) {
                return members;
            }
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            raf.seek(0);
            byte b[] = new byte[10000];
            raf.read(b);
            ByteArrayInputStream bais = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream((InputStream) bais);
            members = (List<UserInfo>) ois.readObject();
            ois.close();
            bais.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return members;
    }

}
