package com.example.hasta_yatak_randevu;

public class Yatak extends Hastane {
 private int yatakSayisi = 50;
 private boolean[] yatakDurumu;

 public Yatak(int yatakSayisi) {
  this.yatakSayisi = yatakSayisi;
  yatakDurumu = new boolean[yatakSayisi];  // Initialize the array to track bed occupancy
 }

 // Method to get information about empty beds
 String bosYataklar() {
  int totalEmptyBeds = 0;
  for (int i = 0; i < yatakSayisi; i++) {
   if (!yatakDurumu[i]) {
    totalEmptyBeds++;
   }
  }
  return "Toplam Boş Yatak Sayısı: " + totalEmptyBeds;
 }

 // Method to reserve a bed and return the result
 String reserveBed(int bedNumber) {
  if (bedNumber < 1 || bedNumber > yatakSayisi) {
   return "Geçersiz yatak numarası";
  }

  if (!yatakDurumu[bedNumber - 1]) {
   yatakDurumu[bedNumber - 1] = true;
   return "Yatak " + bedNumber + " başarıyla rezerve edildi";
  } else {
   return "Yatak " + bedNumber + " zaten dolu";
  }
 }

 // Method to release a bed and return the result
 String releaseBed(int bedNumber) {
  if (bedNumber < 1 || bedNumber > yatakSayisi) {
   return "Geçersiz yatak numarası";
  }

  if (yatakDurumu[bedNumber - 1]) {
   yatakDurumu[bedNumber - 1] = false;
   return "Yatak " + bedNumber + " başarıyla boşaltıldı";
  } else {
   return "Yatak " + bedNumber + " zaten boş";
  }
 }

 // Method to get information about occupied beds
 String doluYataklar() {
  StringBuilder result = new StringBuilder("Dolu Yataklar: ");
  for (int i = 0; i < yatakSayisi; i++) {
   if (yatakDurumu[i]) {
    result.append(i + 1).append(" ");
   }
  }
  return result.toString();
 }
}
