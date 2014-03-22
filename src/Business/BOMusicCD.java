/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Entity.MusicCD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Long Nguyen
 */
public final class BOMusicCD {

    private final String filename = "MUSICDB.dat";
    private final ArrayList<MusicCD> t = new ArrayList<>();

    public BOMusicCD() throws IOException, ClassNotFoundException {
        loadData();
    }

    public void addMusicCD(MusicCD music) throws IOException {
        t.add(music);
    }

    public void deleteMusicCD(int index) {
        t.remove(index);

    }

    public MusicCD get(int i) {
        return t.get(i);
    }

    public int getSize() {
        return t.size();
    }

    public String getLastCode() {
        if (t.size() > 0) {
            return t.get(t.size() - 1).getCode();
        }
        return "0";
    }

    public void removeItemAt(int pos) {
        t.remove(pos);
    }

    public int searchByCode(String codeToSearch) {
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getCode().equals(codeToSearch)) {
                return i;
            }
        }
        return -1;
    }

    private void loadData() {
        try {
            File myFile = new File(filename);
            if (!myFile.exists()) {
                myFile.createNewFile();
            }

            //Open ObjectInputStream for myFile
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(myFile));

            //Read MusicCD from myFile
            while (true) {
                t.add((MusicCD) inputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void saveData() throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (int i = 0; i < t.size(); i++) {
                objectOutputStream.writeObject(t.get(i));
            }
        }
    }
}
