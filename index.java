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
            System.out.println("5. Absensi Kursus");
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
                    absensi();
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
            if (daftarPeserta.isEmpty()) {
            System.out.println("Tidak ada data peserta.");
        } 
            else {
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
        System.out.println("Delete Data Peserta:");
    System.out.println("==============================");

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

        System.out.print("Masukkan Kode Peserta yang akan dihapus: ");
        String targetKodePeserta = scanner.nextLine();

        boolean pesertaDitemukan = false;

        for (peserta1 peserta : daftarPeserta) {
            if (peserta.kdPeserta().equals(targetKodePeserta)) {
                pesertaDitemukan = true;

                System.out.println("Data Peserta yang akan dihapus:");
                System.out.println("==============================");
                System.out.println("Kode Peserta: " + peserta.kdPeserta());
                System.out.println("Nama Peserta: " + peserta.namaPeserta());
                System.out.println("Jenis Kelamin: " + peserta.jenisKelamin());
                System.out.println("Alamat Peserta: " + peserta.alamatPeserta());
                System.out.println("==============================");

                System.out.print("Apakah Anda yakin ingin menghapus peserta ini? (Y/N): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("Y")) {
                    // Hapus peserta dari listPeserta
                    daftarPeserta.remove(peserta);
                    System.out.println("Data Peserta berhasil dihapus!");
                } else {
                    System.out.println("Penghapusan data Peserta dibatalkan.");
                }

                break;
            }
        }

        if (!pesertaDitemukan) {
            System.out.println("Peserta dengan kode " + targetKodePeserta + " tidak ditemukan.");
        }
    }

    // Tekan Enter untuk kembali ke menu
    System.out.println("Tekan Enter untuk kembali ke menu.");
    scanner.nextLine();
        
    }
    
    /*MENU PELAJARAN */
    public record pelajaran1(String kdPelajaran , String namaPelajaran , String guruPengajar, String ruangPelajaran ){}
    private static final List<pelajaran1> daftarPelajaran = new ArrayList<>();
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

        System.out.println("Tambah Pelajaran:");
System.out.println("==============================");

System.out.print("Masukkan jumlah data pelajaran yang akan diinput: ");
int jumlahData = scanner.nextInt();
scanner.nextLine();

for (int i = 0; i < jumlahData; i++) {
    System.out.println("Data Pelajaran ke-" + (i + 1) + ":");
    System.out.print("Masukkan kode pelajaran: ");
    String kdPelajaran = scanner.nextLine();
    System.out.print("Masukkan nama pelajaran: ");
    String namaPelajaran = scanner.nextLine();
    System.out.print("Masukkan guru pengajar: ");
    String guruPengajar = scanner.nextLine();
    System.out.print("Masukkan ruang pelajaran: ");
    String ruangPelajaran = scanner.nextLine();
    
    pelajaran1 pelajaranBaru = new pelajaran1 (kdPelajaran, namaPelajaran, guruPengajar, ruangPelajaran);
    daftarPelajaran.add(pelajaranBaru);
}

System.out.println("Data Pelajaran berhasil ditambahkan!");
    }

    private static void listPelajaran() {

        if (daftarPelajaran.isEmpty()) {
            System.out.println("Tidak ada data pelajaran.");

        } else {
            daftarPelajaran.sort(Comparator.comparing(pelajaran1::kdPelajaran));
            System.out.println("Daftar Pelajaran:");
            System.out.println("==============================");
            for (pelajaran1 pelajaran : daftarPelajaran) {
                System.out.println("Kode Pelajaran: " + pelajaran.kdPelajaran());
                System.out.println("Nama Pelajaran: " + pelajaran.namaPelajaran());
                System.out.println("Guru Pengajar: " + pelajaran.guruPengajar());
                System.out.println("Ruang Pelajaran: " + pelajaran.ruangPelajaran());
                System.out.println("==============================");
            }
        }
        
        // Tekan Enter untuk kembali ke menu
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine();    
       
    }
    private static void editPelajaran() {
        System.out.println("Edit Data Pelajaran:");
        System.out.println("==============================");
        
        if (daftarPelajaran.isEmpty()) {
            System.out.println("Tidak ada data pelajaran.");
            
        } else {
            System.out.print("Masukkan kode pelajaran yang akan diedit: ");
            daftarPelajaran.sort(Comparator.comparing(pelajaran1::kdPelajaran));
            System.out.println("Daftar Pelajaran:");
            System.out.println("==============================");
            for (pelajaran1 pelajaran : daftarPelajaran) {
                System.out.println("Kode Pelajaran: " + pelajaran.kdPelajaran());
                System.out.println("Nama Pelajaran: " + pelajaran.namaPelajaran());
                System.out.println("Guru Pengajar: " + pelajaran.guruPengajar());
                System.out.println("Ruang Pelajaran: " + pelajaran.ruangPelajaran());
                System.out.println("==============================");
            }
            String targetKdPelajaran = scanner.nextLine();
        
            boolean found = false;
        
            for (pelajaran1 pelajaran : daftarPelajaran) {
                if (pelajaran.kdPelajaran().equals(targetKdPelajaran)) {
                    found = true;
        
                    System.out.println("Data Pelajaran yang akan diedit:");
                    System.out.println("==============================");
                    System.out.println("Kode Pelajaran : " + pelajaran.kdPelajaran());
                    System.out.println("Nama Pelajaran : " + pelajaran.namaPelajaran());
                    System.out.println("Guru Pengajar  : " + pelajaran.guruPengajar());
                    System.out.println("Ruang Pelajaran: " + pelajaran.ruangPelajaran());
                    System.out.println("==============================");
        
                    System.out.print("Masukkan nama baru: ");
                    String newNamaPelajaran = scanner.nextLine();
                    System.out.print("Masukkan guru pengajar baru: ");
                    String newGuruPengajar = scanner.nextLine();
                    System.out.print("Masukkan ruang pelajaran baru: ");
                    String newRuangPelajaran = scanner.nextLine();
        
                    // Buat objek baru dengan data yang sudah diubah
                    pelajaran1 editedPelajaran = new pelajaran1(targetKdPelajaran, newNamaPelajaran, newGuruPengajar, newRuangPelajaran);
        
                    // Ganti data lama dengan data baru di daftarPelajaran
                    daftarPelajaran.set(daftarPelajaran.indexOf(pelajaran), editedPelajaran);
        
                    System.out.println("Data Pelajaran berhasil diubah!");
                    break;    
                }
            }
        
            if (!found) {
                System.out.println("Pelajaran dengan kode " + targetKdPelajaran + " tidak ditemukan.");
            }
        }
        
        // Tekan Enter untuk kembali ke menu
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine();
           
            }
    

    private static void deletePelajaran() {
        System.out.println("Delete Data Pelajaran:");
    System.out.println("==============================");

    if (daftarPelajaran.isEmpty()) {
        System.out.println("Tidak ada data pelajaran.");
    } else {
        daftarPelajaran.sort(Comparator.comparing(pelajaran1::kdPelajaran));
        System.out.println("Daftar Pelajaran:");
        System.out.println("==============================");

        for (pelajaran1 pelajaran : daftarPelajaran) {
            System.out.println("Kode Pelajaran: " + pelajaran.kdPelajaran());
            System.out.println("Nama Pelajaran: " + pelajaran.namaPelajaran());
            System.out.println("Guru Pengajar: " + pelajaran.guruPengajar());
            System.out.println("Ruang Pelajaran: " + pelajaran.ruangPelajaran());
            System.out.println("==============================");
        }

        System.out.print("Masukkan Kode Pelajaran yang akan dihapus: ");
        String targetKodePelajaran = scanner.nextLine();

        boolean pelajaranDitemukan = false;

        for (pelajaran1 pelajaran : daftarPelajaran) {
            if (pelajaran.kdPelajaran().equals(targetKodePelajaran)) {
                pelajaranDitemukan = true;

                System.out.println("Data Pelajaran yang akan dihapus:");
                System.out.println("==============================");
                System.out.println("Kode Pelajaran: " + pelajaran.kdPelajaran());
                System.out.println("Nama Pelajaran: " + pelajaran.namaPelajaran());
                System.out.println("Guru Pengajar: " + pelajaran.guruPengajar());
                System.out.println("Ruang Pelajaran: " + pelajaran.ruangPelajaran());
                System.out.println("==============================");

                System.out.print("Apakah Anda yakin ingin menghapus pelajaran ini? (Y/N): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("Y")) {
                    // Hapus pelajaran dari listPelajaran
                    daftarPelajaran.remove(pelajaran);
                    System.out.println("Data Pelajaran berhasil dihapus!");
                } else {
                    System.out.println("Penghapusan data Pelajaran dibatalkan.");
                }

                break;
            }
        }

        if (!pelajaranDitemukan) {
            System.out.println("Pelajaran dengan kode " + targetKodePelajaran + " tidak ditemukan.");
        }
    }

    // Tekan Enter untuk kembali ke menu
    System.out.println("Tekan Enter untuk kembali ke menu.");
    scanner.nextLine();
    }

    /*MENU JADWAL */
    public record jadwal1(String kdJadwal ,String hari,String waktu, String durasi, String tempat){}
    private static ArrayList<jadwal1> listJadwal = new ArrayList<>();
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
        
            

        System.out.print("Masukkan Kode Jadwal: ");
        String kdJadwal = scanner.nextLine();
        System.out.print("Masukkan Waktu Jadwal: ");
        String waktu = scanner.nextLine();
        System.out.print("Masukkan Hari: ");
        String hari = scanner.nextLine();
        System.out.print("Masukkan Durasi: ");
        String durasi = scanner.nextLine();
        System.out.print("Masukkan Tempat: ");
        String tempat = scanner.nextLine();

        jadwal1 jadwal = new jadwal1(kdJadwal, hari, waktu, durasi, tempat);
        listJadwal.add(jadwal);

        System.out.println("Jadwal berhasil ditambahkan.");      
    }
        

    private static void listJadwal() {
        System.out.println("List Jadwal:");
        if (listJadwal.isEmpty()) {
            System.out.println("Tidak ada jadwal.");
        } else {
            for (jadwal1 jadwal : listJadwal) { 
                System.out.println("         Data Jadwal");
                System.out.println("==============================");
                System.out.println("Kode Jadwal: " + jadwal.kdJadwal());
                System.out.println("Waktu: " + jadwal.waktu());
                System.out.println("Hari: " + jadwal.hari());
                System.out.println("Durasi: " + jadwal.durasi());
                System.out.println("Tempat: " + jadwal.tempat());
                System.out.println("==============================");
            }        
        }  
        System.out.println("Tekan Enter untuk kembali ke menu.");
            scanner.nextLine();  // Menunggu pengguna menekan Enter
    }
    private static void editJadwal() {
        System.out.println("Edit Data Jadwal:");
    System.out.println("==============================");

    if (listJadwal.isEmpty()) {
        System.out.println("Tidak ada data jadwal.");
    } else {
        listJadwal.sort(Comparator.comparing(jadwal1::kdJadwal));
        System.out.println("Daftar Jadwal:");
        System.out.println("==============================");

        for (jadwal1 jadwal : listJadwal) {
            System.out.println("Kode Jadwal: " + jadwal.kdJadwal());
            System.out.println("Waktu: " + jadwal.waktu());
            System.out.println("Hari: " + jadwal.hari());
            System.out.println("Durasi: " + jadwal.durasi());
            System.out.println("Tempat: " + jadwal.tempat());
            System.out.println("==============================");
        }

        System.out.print("Masukkan Kode Jadwal yang akan diedit: ");
        String targetKodeJadwal = scanner.nextLine();

        boolean jadwalDitemukan = false;

        for (jadwal1 jadwal : listJadwal) {
            if (jadwal.kdJadwal().equals(targetKodeJadwal)) {
                jadwalDitemukan = true;

                System.out.println("Data Jadwal yang akan diedit:");
                System.out.println("==============================");
                System.out.println("Kode Jadwal: " + jadwal.kdJadwal());
                System.out.println("Waktu: " + jadwal.waktu());
                System.out.println("Hari: " + jadwal.hari());
                System.out.println("Durasi: " + jadwal.durasi());
                System.out.println("Tempat: " + jadwal.tempat());
                System.out.println("==============================");

                System.out.print("Masukkan Tanggal Jadwal baru: ");
                String newTanggalJadwal = scanner.nextLine();
                System.out.print("Masukkan Hari baru: ");
                String newHari = scanner.nextLine();
                System.out.print("Masukkan Durasi baru: ");
                String newDurasi = scanner.nextLine();
                System.out.print("Masukkan Tempat baru: ");
                String newTempat = scanner.nextLine();

                // Buat objek baru dengan data yang sudah diubah
                jadwal1 editedJadwal = new jadwal1(targetKodeJadwal, newTanggalJadwal, newHari, newDurasi, newTempat);

                // Ganti data lama dengan data baru di listJadwal
                listJadwal.set(listJadwal.indexOf(jadwal), editedJadwal);

                System.out.println("Data Jadwal berhasil diubah!");
                break;
            }
        }

        if (!jadwalDitemukan) {
            System.out.println("Jadwal dengan kode " + targetKodeJadwal + " tidak ditemukan.");
        }
    }

    // Tekan Enter untuk kembali ke menu
    System.out.println("Tekan Enter untuk kembali ke menu.");
    scanner.nextLine();
        
       
    }

    private static void deleteJadwal() {
        System.out.println("Delete Data Jadwal:");
    System.out.println("==============================");

    if (listJadwal.isEmpty()) {
        System.out.println("Tidak ada data jadwal.");
    } else {
        listJadwal.sort(Comparator.comparing(jadwal1::kdJadwal));
        System.out.println("Daftar Jadwal:");
        System.out.println("==============================");

        for (jadwal1 jadwal : listJadwal) {
            System.out.println("Kode Jadwal: " + jadwal.kdJadwal());
            System.out.println("Waktu: " + jadwal.waktu());
            System.out.println("Hari: " + jadwal.hari());
            System.out.println("Durasi: " + jadwal.durasi());
            System.out.println("Tempat: " + jadwal.tempat());
            System.out.println("==============================");
        }

        System.out.print("Masukkan Kode Jadwal yang akan dihapus: ");
        String targetKodeJadwal = scanner.nextLine();

        boolean jadwalDitemukan = false;

        for (jadwal1 jadwal : listJadwal) {
            if (jadwal.kdJadwal().equals(targetKodeJadwal)) {
                jadwalDitemukan = true;

                System.out.println("Data Jadwal yang akan dihapus:");
                System.out.println("==============================");
                System.out.println("Kode Jadwal: " + jadwal.kdJadwal());
                System.out.println("waktu: " + jadwal.waktu());
                System.out.println("Hari: " + jadwal.hari());
                System.out.println("Durasi: " + jadwal.durasi());
                System.out.println("Tempat: " + jadwal.tempat());
                System.out.println("==============================");

                System.out.print("Apakah Anda yakin ingin menghapus jadwal ini? (Y/N): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("Y")) {
                    // Hapus jadwal dari listJadwal
                    listJadwal.remove(jadwal);
                    System.out.println("Data Jadwal berhasil dihapus!");
                } else {
                    System.out.println("Penghapusan data Jadwal dibatalkan.");
                }

                break;
            }
        }

        if (!jadwalDitemukan) {
            System.out.println("Jadwal dengan kode " + targetKodeJadwal + " tidak ditemukan.");
        }
    }
       
    }

    /*MENU TRANSAKSI */
    public record Transaksi1(String kdTransaksi ,String tanggalTransaksi,Double jumlah, String keterangan){}
    private static List<Transaksi1> listTransaksi = new ArrayList<>();
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
        System.out.println("Buat Transaksi:");
        System.out.println("==============================");

        System.out.print("Masukkan Kode Transaksi: ");
        String kdTransaksi = scanner.nextLine();
        System.out.print("Masukkan Tanggal Transaksi: ");
        String tanggalTransaksi = scanner.nextLine();
        System.out.print("Masukkan Jumlah Transaksi: ");
        Double jumlah = scanner.nextDouble();
        scanner.nextLine(); // Membuang karakter newline setelah memasukkan angka
        System.out.print("Masukkan Keterangan Transaksi: ");
        String keterangan = scanner.nextLine();

        // Membuat objek Transaksi1 baru
        Transaksi1 newTransaksi = new Transaksi1(kdTransaksi, tanggalTransaksi, jumlah, keterangan);

        // Menambahkan objek Transaksi1 baru ke listTransaksi
        listTransaksi.add(newTransaksi);

        System.out.println("Transaksi berhasil ditambahkan!");
       
       
    }

    private static void listTransaksi() {
        System.out.println("List Transaksi:");
    System.out.println("==============================");

    if (listTransaksi.isEmpty()) {
        System.out.println("Tidak ada transaksi.");
    } else {
        listTransaksi.sort(Comparator.comparing(Transaksi1::kdTransaksi));
        System.out.println("Daftar Transaksi:");
        System.out.println("==============================");

        for (Transaksi1 transaksi : listTransaksi) {
            System.out.println("Kode Transaksi: " + transaksi.kdTransaksi());
            System.out.println("Tanggal Transaksi: " + transaksi.tanggalTransaksi());
            System.out.println("Jumlah Transaksi: " + transaksi.jumlah());
            System.out.println("Keterangan Transaksi: " + transaksi.keterangan());
            System.out.println("==============================");
        }
    }

    // Tekan Enter untuk kembali ke menu
    System.out.println("Tekan Enter untuk kembali ke menu.");
    scanner.nextLine();
       
    }

    private static void deleteTransaksi() {
        System.out.println("Delete Transaksi:");
    System.out.println("==============================");

    if (listTransaksi.isEmpty()) {
        System.out.println("Tidak ada transaksi.");
    } else {
        listTransaksi.sort(Comparator.comparing(Transaksi1::kdTransaksi));
        System.out.println("Daftar Transaksi:");
        System.out.println("==============================");

        for (Transaksi1 transaksi : listTransaksi) {
            System.out.println("Kode Transaksi: " + transaksi.kdTransaksi());
            System.out.println("Tanggal Transaksi: " + transaksi.tanggalTransaksi());
            System.out.println("Jumlah Transaksi: " + transaksi.jumlah());
            System.out.println("Keterangan Transaksi: " + transaksi.keterangan());
            System.out.println("==============================");
        }

        System.out.print("Masukkan Kode Transaksi yang akan dihapus: ");
        String targetKodeTransaksi = scanner.nextLine();

        boolean transaksiDitemukan = false;

        for (Transaksi1 transaksi : listTransaksi) {
            if (transaksi.kdTransaksi().equals(targetKodeTransaksi)) {
                transaksiDitemukan = true;

                System.out.println("Data Transaksi yang akan dihapus:");
                System.out.println("==============================");
                System.out.println("Kode Transaksi: " + transaksi.kdTransaksi());
                System.out.println("Tanggal Transaksi: " + transaksi.tanggalTransaksi());
                System.out.println("Jumlah Transaksi: " + transaksi.jumlah());
                System.out.println("Keterangan Transaksi: " + transaksi.keterangan());
                System.out.println("==============================");

                System.out.print("Apakah Anda yakin ingin menghapus transaksi ini? (Y/N): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("Y")) {
                    // Hapus transaksi dari listTransaksi
                    listTransaksi.remove(transaksi);
                    System.out.println("Data Transaksi berhasil dihapus!");
                } else {
                    System.out.println("Penghapusan data Transaksi dibatalkan.");
                }

                break;
            }
        }

        if (!transaksiDitemukan) {
            System.out.println("Transaksi dengan kode " + targetKodeTransaksi + " tidak ditemukan.");
        }
    }

    // Tekan Enter untuk kembali ke menu
    System.out.println("Tekan Enter untuk kembali ke menu.");
    scanner.nextLine();
       
    }  
}