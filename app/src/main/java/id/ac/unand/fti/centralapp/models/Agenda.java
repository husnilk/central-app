package id.ac.unand.fti.centralapp.models;

public class Agenda {

    String gambar;
    int tipeAgenda;
    String namaAgenda;
    String waktu;
    String tempat;
    int status;

    public Agenda(){ }

    public Agenda(String gambar, int tipeAgenda, String namaAgenda, String waktu, String tempat, int status) {
        this.gambar = gambar;
        this.tipeAgenda = tipeAgenda;
        this.namaAgenda = namaAgenda;
        this.waktu = waktu;
        this.tempat = tempat;
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getTipeAgenda() {
        return tipeAgenda;
    }

    public void setTipeAgenda(int tipeAgenda) {
        this.tipeAgenda = tipeAgenda;
    }

    public String getNamaAgenda() {
        return namaAgenda;
    }

    public void setNamaAgenda(String namaAgenda) {
        this.namaAgenda = namaAgenda;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
