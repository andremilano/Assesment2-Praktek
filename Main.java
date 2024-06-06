import java.util.*;

class Cucian {
    int idCuci;
    String namaPelanggan;
    String tipe;
    int usia;

    public Cucian(int idCuci, String namaPelanggan, String tipe, int usia) {
        this.idCuci = idCuci;
        this.namaPelanggan = namaPelanggan;
        this.tipe = tipe;
        this.usia = usia;
    }

    public int getPrioritas() {
        // jika input hijau, tidak perlu antri
        if (tipe.equals("hijau")) {
            System.out.println("Pasien Nama Pasien : " + namaPelanggan + " Usia : " + usia + " tidak perlu antri");
            return 0;
        } else if (tipe.equals("merah")) {
            return 1;
        } else if (tipe.equals("merah")) {
            return 2;
        } else if (tipe.equals("merah")) {
            return 3;
        } else {
            return 9999;
        }
    }
}

class Laundry {
    List<Cucian> daftarPasien = new ArrayList<>();

    public void antrianPasien(int idCuci, String namaPelanggan, String tipe, int usia) {
        Cucian cucian = new Cucian(idCuci, namaPelanggan, tipe, usia);
        daftarPasien.add(cucian);
    }

    public void tampilkanUrutanCucian() {
        daftarPasien.sort(Comparator.comparingInt(Cucian::getPrioritas).thenComparingInt(c -> c.idCuci));
        System.out.println("Urutan Penanganan pasien:");
        for (Cucian c : daftarPasien) {
            System.out.println("Nama Pasien : " + c.namaPelanggan + " | usia: " + c.usia);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Laundry pEr = new Laundry();
        pEr.antrianPasien(1, "nur", "biru", 30);
        pEr.antrianPasien(2, "rima", "merah", 20);
        pEr.antrianPasien(3, "kira", "hijau", 10);
        pEr.antrianPasien(4, "didi", "kuning", 5);
        pEr.antrianPasien(5, "mila", "biru", 65);

        pEr.tampilkanUrutanCucian();
    }
}
