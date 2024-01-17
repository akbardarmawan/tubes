import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class index {
    
    private static Scanner scanner = new Scanner(System.in);

    /*MENU UTAMA */
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Peserta");
            System.out.println("2. Pelajaran");
            System.out.println("3. Jadwal");
            System.out.println("4. Transaksi");
            System.out.println("5. Riwayat Kursus");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah memasukkan angka

            switch (choice) {
                case 1:
                    peserta();
                    break;
                case 2:
                    pelajaran();
                    break;
                case 3:
                    jadwal();
                    break;
                case 4:
                    transaksi();
                    break;
                case 5:
                    riwayat();
                    break; 
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 0);

        scanner.close();
    }

    /*MENU PESERTA */
    public record peserta1(String kdPeserta, String namaPeserta, String jenisKelamin, String alamatPeserta){}
    private static final List<peserta1> daftarPeserta = new ArrayList<>();

    private static void peserta() {
        int choice;
        do {
            System.out.println("1. Tambah Peserta");
            System.out.println("2. List Peserta");
            System.out.println("3. Edit Data Peserta");
            System.out.println("4. Delete Data Peserta");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu (0-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah memasukkan angka

            switch (choice) {
                case 1:
                    tambahPeserta();
                    break;
                case 2:
                    listPeserta();
                    break;
                case 3:
                    editPeserta();
                    break;    
                case 4:
                    deletePeserta();
                    break;
                case 0:
                    index.main(null);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 0);

        scanner.close();
        
        
    }

    private static void tambahPeserta() {
        System.out.println("Tambah Peserta:");
    System.out.println("==============================");

    System.out.print("Masukkan jumlah data peserta yang akan diinput: ");
    int jumlahData = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < jumlahData; i++) {
        System.out.println("Data Peserta ke-" + (i + 1) + ":");
        System.out.print("Masukkan kode peserta: ");
        String kdPeserta = scanner.nextLine();
        System.out.print("Masukkan nama peserta: ");
        String namaPeserta = scanner.nextLine();
        System.out.print("Masukkan jenis kelamin peserta: ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Masukkan alamat peserta: ");
        String alamatPeserta = scanner.nextLine();

        peserta1 pesertaBaru = new peserta1(kdPeserta, namaPeserta, jenisKelamin, alamatPeserta);
        daftarPeserta.add(pesertaBaru);
    }

    System.out.println("Data Peserta berhasil ditambahkan!");
}
    
    private static void listPeserta() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Tidak ada data peserta.");
        } else {
            daftarPeserta.sort(Comparator.comparing(peserta1::kdPeserta));
            System.out.println("Daftar Peserta:");
            System.out.println("==============================");
            for (peserta1 peserta : daftarPeserta) {
                System.out.println("Kode Peserta: " + peserta.kdPeserta());
                System.out.println("Nama Peserta: " + peserta.namaPeserta());
                System.out.println("Jenis Kelamin: " + peserta.jenisKelamin());
                System.out.println("Alamat Peserta: " + peserta.alamatPeserta());
                System.out.println("==============================");
            }
        }
    
        // Tekan Enter untuk kembali ke menu
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine();
        

    }
    private static void editPeserta() {
        System.out.println("Edit Data Peserta:");
        System.out.println("==============================");
    
        if (daftarPeserta.isEmpty()) {
            System.out.println("Tidak ada data peserta.");
        } else {
            System.out.print("Masukkan kode peserta yang akan diedit: ");
            String targetKdPeserta = scanner.nextLine();
    
            boolean found = false;
    
            for (peserta1 peserta : daftarPeserta) {
                if (peserta.kdPeserta().equals(targetKdPeserta)) {
                    found = true;
    
                    System.out.println("Data Peserta yang akan diedit:");
                    System.out.println("==============================");
                    System.out.println("Kode Peserta: " + peserta.kdPeserta());
                    System.out.println("Nama Peserta: " + peserta.namaPeserta());
                    System.out.println("Jenis Kelamin: " + peserta.jenisKelamin());
                    System.out.println("Alamat Peserta: " + peserta.alamatPeserta());
                    System.out.println("==============================");
    
                    System.out.print("Masukkan nama baru: ");
                    String newNamaPeserta = scanner.nextLine();
                    System.out.print("Masukkan jenis kelamin baru: ");
                    String newJenisKelamin = scanner.nextLine();
                    System.out.print("Masukkan alamat baru: ");
                    String newAlamatPeserta = scanner.nextLine();
    
                    // Buat objek baru dengan data yang sudah diubah
                    peserta1 editedPeserta = new peserta1(targetKdPeserta, newNamaPeserta, newJenisKelamin, newAlamatPeserta);
    
                    // Ganti data lama dengan data baru di daftarPeserta
                    daftarPeserta.set(daftarPeserta.indexOf(peserta), editedPeserta);
    
                    System.out.println("Data Peserta berhasil diubah!");
                    break;
                }
            }
    
            if (!found) {
                System.out.println("Peserta dengan kode " + targetKdPeserta + " tidak ditemukan.");
            }
        }
    
        // Tekan Enter untuk kembali ke menu
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine();    
    }
       
    private static void deletePeserta() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Tidak ada data peserta.");
        } else {
            System.out.println("Daftar Peserta:");
            System.out.println("==============================");
            for (peserta1 peserta : daftarPeserta) {
                System.out.println("Kode Peserta: " + peserta.kdPeserta());
                System.out.println("Nama Peserta: " + peserta.namaPeserta());
                System.out.println("Jenis Kelamin: " + peserta.jenisKelamin());
                System.out.println("Alamat Peserta: " + peserta.alamatPeserta());
                System.out.println("==============================");
            }
    
            System.out.print("Masukkan kode peserta yang akan dihapus: ");
            String kodePesertaToDelete = scanner.nextLine();
    
            // Cari peserta berdasarkan kode peserta
            peserta1 pesertaToDelete = null;
            for (peserta1 peserta : daftarPeserta) {
                if (peserta.kdPeserta().equals(kodePesertaToDelete)) {
                    pesertaToDelete = peserta;
                    break;
                }
            }
    
            if (pesertaToDelete != null) {
                // Hapus peserta dari daftarPeserta
                daftarPeserta.remove(pesertaToDelete);
                System.out.println("Peserta dengan kode " + kodePesertaToDelete + " berhasil dihapus.");
            } else {
                System.out.println("Tidak ditemukan peserta dengan kode " + kodePesertaToDelete + ".");
            }
        }
    
        // Tekan Enter untuk kembali ke menu
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine();
        
       
    }
    
    /*MENU PELAJARAN */
    public record pelajaran1(String nama, String nim, String prodi, String kat){}
    private static void pelajaran() {
        int choice;
        do {
            System.out.println("1. Tambah Pelajaran");
            System.out.println("2. List Pelajaran");
            System.out.println("3. Edit Data Pelajaran");
            System.out.println("4. Delete Data Pelajaran");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu (0-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah memasukkan angka

            switch (choice) {
                case 1:
                    tambahPelajaran();
                    break;
                case 2:
                    listPelajaran();
                    break;
                case 3:
                    editPelajaran();
                    break;
                case 4:
                    deletePelajaran();
                    break; 
                case 0:
                    index.main(null);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 0);

        scanner.close();
    }

     

    private static void tambahPelajaran() {
        
       
    }

    private static void listPelajaran() {
        
       
    }
    private static void editPelajaran() {
        
       
    }

    private static void deletePelajaran() {
        
       
    }

    /*MENU JADWAL */
    public record jadwal1(String nama, String nim, String prodi, String kat){}
    private static void jadwal() {
        int choice;
        do {
            System.out.println("1. Tambah Jadwal");
            System.out.println("2. List Jadwal");
            System.out.println("3. Edit Data Jadwal");
            System.out.println("4. Delete Data Jadwal");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah memasukkan angka

            switch (choice) {
                case 1:
                    tambahJadwal();
                    break;
                case 2:
                    listJadwal();
                    break;
                case 3:
                    editJadwal();
                    break;
                case 4:
                    deleteJadwal();
                    break;
                
                case 0:
                    index.main(null);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 0);

        scanner.close();
       
    }

    private static void tambahJadwal() {
        
       
    }

    private static void listJadwal() {
        
       
    }
    private static void editJadwal() {
        
       
    }

    private static void deleteJadwal() {
        
       
    }

    /*MENU TRANSAKSI */
    private static void transaksi() {
        int choice;
        do {
            System.out.println("1. Buat Transaksi");
            System.out.println("2. List Transaksi");
            System.out.println("3. Hapus Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah memasukkan angka

            switch (choice) {
                case 1:
                    tambahTransaksi();
                    break;
                case 2:
                    listTransaksi();
                    break;
                case 3:
                    deleteTransaksi();
                    break;

                case 0:
                    index.main(null);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 0);

        scanner.close();
       
    }

    private static void tambahTransaksi() {
        
       
    }

    private static void listTransaksi() {
        
       
    }

    private static void deleteTransaksi() {
        
       
    }


    /*MENU RIWAYAT */
    private static void riwayat() {
        int choice;
        do {
            System.out.println("1. Peserta");
            System.out.println("2. Pelajaran");
            System.out.println("3. Jadwal");
            System.out.println("4. Transaksi");
            System.out.println("5. Riwayat Kursus");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah memasukkan angka

            switch (choice) {
                case 1:
                    peserta();
                    break;
                case 2:
                    pelajaran();
                    break;
                case 3:
                    jadwal();
                    break;
                case 4:
                    transaksi();
                    break;
                case 5:
                    riwayat();
                    break; 
                case 0:
                    index.main(null);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 0);

        scanner.close();
       
    }
}