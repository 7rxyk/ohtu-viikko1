package ohtu.data_access;

import ohtu.domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserDao implements UserDao {

    private String fileName;


    public FileUserDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> listAll() {
        Scanner fileScanner = null;
        List<User> lista = new ArrayList<>();
        User user;
        String[] next;
        try {
            fileScanner = new Scanner(new File(fileName));
            while(fileScanner.hasNextLine()) {
                next = fileScanner.nextLine().split(":");
                lista.add(new User(next[0], next[1]));
            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return lista;
    }

    @Override
    public User findByName(String name) {
        List<User> lista = this.listAll();
        if(lista == null) {
            return null;
        }
        for(User u : lista) {
            if(u.getUsername().equals(name)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        File file = new File(fileName);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(Exception e) {
                return;
            }
        }

        try {
            new FileWriter(fileName, true).append(user.getUsername()+":" + user.getPassword() + "\n").flush();
        } catch (Exception e) {
            return;
        }
    }
}