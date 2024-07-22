package com.example.hasta_yatak_randevu;

import java.nio.file.*;

public class test {

    public static void main(String[] args) {
        // Create new users
        Login.yeniKullaniciOlustur("John", "Doe", 30, 123456789, "john.doe", "password");
        Login.yeniKullaniciOlustur("elif", "kılıç", 28, 132334345, "elflic", "elif1234");
        Login.yeniKullaniciOlustur("admin", "admin", 28, 132334345, "admin", "admin");

        // Print the contents of the user list after creation
        System.out.println("User List after creating users:");
        Login.printUserList(Login.getKullaniciListesi());

        // Save users to file
        Login.saveUsersToFile("users.txt");

        // Check if the file is read-only
        checkFileReadOnlyStatus("users.txt");

        // Load users from file
        Login.loadUsersFromFile("users.txt");

        // Print the contents of the user list after loading
        System.out.println("User List after loading from file:");
        Login.printUserList(Login.getKullaniciListesi());

        // Use Yatak class methods
        Yatak yatak = new Yatak(50);
        System.out.println("Empty Beds: " + yatak.bosYataklar());
        System.out.println("Reserve Bed Result: " + yatak.reserveBed(1));
        System.out.println("Release Bed Result: " + yatak.releaseBed(1));
    }

    private static void checkFileReadOnlyStatus(String filePath) {
        try {
            Path path = Paths.get(filePath);
            boolean isReadOnly = Files.isRegularFile(path) && !Files.isWritable(path);

            if (isReadOnly) {
                System.out.println("The file is read-only.");
            } else {
                System.out.println("The file is writable.");
            }
        } catch (Exception e) {
            System.err.println("Error checking file status: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
