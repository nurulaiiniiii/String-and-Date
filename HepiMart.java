import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HepiMart {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bagian Login
        boolean isLoggedIn = false; 
        System.out.println("+-----------------------------------------------------+"); 
        System.out.println("Log in"); 
        System.out.println("+-----------------------------------------------------+");
        while (!isLoggedIn) {
            try {
                System.out.print("Username : ");
                String username = scanner.nextLine().trim(); // Method String - trim untuk menghapus spasi
                System.out.print("Password : ");
                String password = scanner.nextLine();
                String inputCaptcha;
                String correctCaptcha = "54321"; // Captcha tetap untuk contoh
                System.out.println("Captcha  : " + correctCaptcha); // Menampilkan captcha tetap 
                System.out.print("Masukkan Captcha : "); 
            inputCaptcha = scanner.nextLine(); // Membaca input string untuk captcha
                if (username.equals("HepiMart") && password.equals("12345") &&  inputCaptcha.equals(correctCaptcha)) {
                    System.out.println("Login berhasil!");
                    isLoggedIn = true;
                } else {
                    throw new IllegalArgumentException("Login gagal, silakan ulangi.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("+-----------------------------------------------------+");

        // Tampilkan selamat datang
        System.out.println("\nSelamat Datang di HepiMart!");
        String timestamp = getCurrentDateTime(); // Method Date - ambil waktu saat ini
        System.out.println("Tanggal dan Waktu : " + timestamp);
        System.out.println("+-----------------------------------------------------+");

        try {
            // Input Data Transaksi
            System.out.print("No. Faktur      : ");
            String noFaktur = scanner.nextLine().toUpperCase(); // Method String - uppercase

            System.out.print("Kode Barang     : ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Nama Barang     : ");
            String namaBarang = scanner.nextLine();

            System.out.print("Harga Barang    : ");
            double hargaBarang = Double.parseDouble(scanner.nextLine()); 

            // Validasi harga barang
            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari 0.");
            }

            System.out.print("Jumlah Beli     : ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine()); 

            // Validasi jumlah beli
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0.");
            }

            double total = hargaBarang * jumlahBeli; 

            // Output Data Transaksi
            System.out.println("+-----------------------------------------------------+");
            System.out.println("No. Faktur      : " + noFaktur);
            System.out.println("Kode Barang     : " + kodeBarang);
            System.out.println("Nama Barang     : " + namaBarang);
            System.out.println("Harga Barang    : Rp " + String.format("%.2f", hargaBarang)); 
            System.out.println("Jumlah Beli     : " + jumlahBeli);
            System.out.println("TOTAL           : Rp " + String.format("%.2f", total));
            System.out.println("+-----------------------------------------------------+");

            System.out.print("Kasir           : ");
            String namaKasir = scanner.nextLine(); 

            System.out.println("+-----------------------------------------------------+");
            
            System.out.println("Terima kasih telah berbelanja di HepiMart!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Input harga atau jumlah beli harus berupa angka!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Terjadi kesalahan yang tidak diketahui.");
        } finally {
            scanner.close(); 
        }
    }

    // Method untuk mendapatkan tanggal dan waktu saat ini
    public static String getCurrentDateTime() {
        Date now = new Date(); // Objek Date untuk mendapatkan waktu sekarang
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Format tanggal dan waktu
        return sdf.format(now); // Method format untuk mengubah Date menjadi String
    }
}