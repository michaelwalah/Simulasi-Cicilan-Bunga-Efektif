
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author i14019
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jumlah Pinjaman:");
        double pokokPinjaman = sc.nextDouble();
        System.out.println("Bunga per Tahun:");
        double sukuBungaPerTahun = sc.nextDouble();
        System.out.println("Tenor:");
        double lamaKreditPerBulan = sc.nextDouble();
        System.out.println("Biaya Administrasi Bulanan:");
        double biayaAdministrasiBulanan = sc.nextDouble();
        System.out.println("\n");
        
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        double cicilanPokokPerBulan = pokokPinjaman/lamaKreditPerBulan;
        System.out.printf("Cicilan pokok per bulan = "+kursIndonesia.format(cicilanPokokPerBulan));
        System.out.println("\n");
        
        double j = 0;
        double bungaPerBulan = 0;
        double cicilanPerBulan = 0;
        
        double totalAngsuran = 0;
        double totalBunga = 0;
        double totalAngsuranPokok = 0;
        double totalBiayaAdministrasi = 0;
        
        for (int i = 1; i <= lamaKreditPerBulan; i++) {
            bungaPerBulan = (pokokPinjaman - (j * cicilanPokokPerBulan)) * (sukuBungaPerTahun/100) / 12;
            j++;
            System.out.printf("Bunga bulan ke-"+i+"   = "+kursIndonesia.format(bungaPerBulan));
            System.out.println("");
            
            cicilanPerBulan = cicilanPokokPerBulan + bungaPerBulan + biayaAdministrasiBulanan;
            System.out.printf("Cicilan bulan ke-"+i+" = "+kursIndonesia.format(cicilanPerBulan));
            System.out.println("");
            System.out.println("\n");
            
            totalAngsuranPokok += cicilanPokokPerBulan;
            totalAngsuran += cicilanPerBulan;
            totalBunga += bungaPerBulan;
            totalBiayaAdministrasi += biayaAdministrasiBulanan;
        }
        System.out.printf("Total Angsuran Pokok = "+kursIndonesia.format(totalAngsuranPokok));
        System.out.println("\n");
        System.out.printf("Total Angsuran = "+kursIndonesia.format(totalAngsuran));
        System.out.println("\n");
        System.out.printf("Total Bunga = "+kursIndonesia.format(totalBunga));
        System.out.println("\n");
        System.out.printf("Total Biaya Administrasi = "+kursIndonesia.format(totalBiayaAdministrasi));
        System.out.println("\n");
    }
}