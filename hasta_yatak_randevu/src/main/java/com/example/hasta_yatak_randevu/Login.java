package com.example.hasta_yatak_randevu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Login extends Hasta implements Serializable {

    private String kullaniciAdi;
    private String sifre;

    public Login() {
        // No-argument constructor
    }

    private static final ArrayList<Login> kullaniciListesi = new ArrayList<>();

    public Login(String isim, String soyisim, int yas, int kimlikNumarasi, String kullaniciAdi, String sifre) {
        super(isim, soyisim, yas, kimlikNumarasi);

        if (kullaniciAdi == null || kullaniciAdi.isEmpty() || sifre == null || sifre.isEmpty()) {
            throw new IllegalArgumentException("Kullanıcı adı veya şifre boş olamaz.");
        }

        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        kullaniciListesi.add(this);
    }


    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
    public static boolean validateCredentials(String enteredUsername, String enteredPassword) {
        for (Login user : kullaniciListesi) {
            if (user.getKullaniciAdi().equals(enteredUsername) && user.getSifre().equals(enteredPassword)) {
                return true;
            }
        }
        return false; // No matching user found
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        if (kullaniciAdi == null || kullaniciAdi.isEmpty()) {
            throw new IllegalArgumentException("Kullanıcı adı boş olamaz.");
        }

        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        if (sifre == null || sifre.isEmpty()) {
            throw new IllegalArgumentException("Şifre boş olamaz.");
        }

        this.sifre = sifre;
    }

    public static void yeniKullaniciOlustur(String isim, String soyisim, int yas, int kimlikNumarasi, String kullaniciAdi, String sifre) {
        new Login(isim, soyisim, yas, kimlikNumarasi, kullaniciAdi, sifre);
    }

    public static ArrayList<Login> getKullaniciListesi() {
        return kullaniciListesi;
    }

    public static void saveUsersToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
            if (Files.exists(Paths.get(filename))) {
                System.out.println("File already exists. Appending to: " + filename);
            }

            // Write each user individually to avoid overwriting
            for (Login user : kullaniciListesi) {
                oos.writeObject(user);
            }

            System.out.println("Users saved to file: " + filename);
            System.out.println("Absolute path: " + new File(filename).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void loadUsersFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object readObject = ois.readObject();

            if (readObject instanceof ArrayList) {
                ArrayList<Login> loadedUsers = (ArrayList<Login>) readObject;

                // Append the loaded users to the main list
                kullaniciListesi.addAll(loadedUsers);

                System.out.println("Users loaded from file: " + filename);
                System.out.println("Absolute path: " + new File(filename).getAbsolutePath());
            } else {
                System.err.println("Invalid data format in file: " + filename);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading users from file: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        }
    }





    public static void printUserList(ArrayList<Login> userList) {
        System.out.println("User List:");
        for (Login user : userList) {
            if (user.getIsim() != null && user.getSoyisim() != null) {
                System.out.println("Name: " + user.getIsim());
                System.out.println("Surname: " + user.getSoyisim());
                System.out.println("Age: " + user.getYas());
                System.out.println("ID: " + user.getKimlikNumarasi());
                System.out.println("Username: " + user.getKullaniciAdi());
                System.out.println("Password: " + user.getSifre());
                System.out.println("---------------");
            }
        }
    }

}
