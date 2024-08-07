import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class Lig {
    Takım a[]= new Takım[18];
    private String[][] fikstur = new String[34][18];
    
    public Lig(){
        a[0]= new Takım("Besiktas");
        a[1]=new Takım("Galatasaray");
        a[2]=new Takım("Fenerbahce");
        a[3]=new Takım("Trabzonspor");
        a[4]=new Takım("Bursaspor");
        a[5]=new Takım("Ankaragucu");
        a[6]=new Takım("Gaziantepspor");
        a[7]=new Takım("Genclerbirligi");
        a[8]=new Takım("Sivasspor");
        a[9]=new Takım("Konyaspor");
        a[10]=new Takım("Rizespor");
        a[11]=new Takım("Antalyaspor");
        a[12]=new Takım("Kayserispor");
        a[13]=new Takım("Malatyaspor");
        a[14]=new Takım("Denizlispor");
        a[15]=new Takım("Erzurumspor");
        a[16]=new Takım("Hatayspor");
        a[17]=new Takım("Kasimpasa");
              
    }
        public String[][] getFikstur() {
        return fikstur;
    }

        public void Takimlari_Yazdir(){
        System.out.println("Takım İsmi" +"    " + " Kaleci Gücü" + "    "+ "Savunma Gücü"+ "    "+ "Ortasaha Gücü"+ "    "+ "Hücum Gücü"+"    "+"TafatarGücü"+"    "+"Ortalama Güç");
        for(int i =0;i<18;i++){
            System.out.println(a[i].getTakım_ismi()+"  "+ new DecimalFormat("##.##").format(a[i].getKaleci_gucu())+"  "+ new DecimalFormat("##.##").format(a[i].getSavunma_gucu())+"  "+ new DecimalFormat("##.##").format(a[i].getOrtasaha_gucu())+"  "+ new DecimalFormat("##.##").format(a[i].getHucum_gucu())+"  "+ new DecimalFormat("##.##").format(a[i].getTaraftarGucu(true))+"  "+ new DecimalFormat("##.##").format(a[i].getTakım_gucu()));
        
        }
        
        
    }
public void fiksturOlustur() {
    // Takımları karıştır
    List<Takım> takimlar = new ArrayList<>(Arrays.asList(a));
    Collections.shuffle(takimlar);

    // Fikstürü oluştur
    for (int hafta = 1; hafta <= 34; hafta++) {
        for (int i = 0; i < 9; i++) {
            Takım t1 = takimlar.get(i);
            Takım t2 = takimlar.get(17 - i);
            if (hafta <= 17) {
                fikstur[hafta - 1][i * 2] = t1.getTakım_ismi();
                fikstur[hafta - 1][i * 2 + 1] = t2.getTakım_ismi();
            } else {
                fikstur[hafta - 1][i * 2] = t2.getTakım_ismi();
                fikstur[hafta - 1][i * 2 + 1] = t1.getTakım_ismi();
            }
        }

        // Takımları döndür
        Takım temp = takimlar.get(1);
        for (int i = 1; i < 17; i++) {
            takimlar.set(i, takimlar.get(i + 1));
        }
        takimlar.set(17, temp);
    }
}

public void macYap(String takim1, String takim2) {
    // İki takımı bul
    Takım t1 = null;
    Takım t2 = null;
    for (int i = 0; i < 18; i++) {
        if (a[i].getTakım_ismi().equals(takim1)) {
            t1 = a[i];
        }
        if (a[i].getTakım_ismi().equals(takim2)) {
            t2 = a[i];
        }
    }

    // Maçı oynat
    
    if (t1 != null && t2 != null) {
        
        double t1Guc;
        double t2Guc;
        
         /////// taraftar güçlerinin hesaba katılması//////////
         
        if (takim1.equals(t1.getTakım_ismi())) { 
            t1Guc = t1.getTakım_gucu() + t1.getTaraftarGucu(true); 
            t2Guc = t2.getTakım_gucu() + t2.getTaraftarGucu(false);
        } else { 
            t1Guc = t1.getTakım_gucu()+ t2.getTaraftarGucu(false);
            t2Guc = t2.getTakım_gucu() + t2.getTaraftarGucu(true); 
            }
        
        double toplamGuc = t1Guc + t2Guc;
        double t1Olasilik = t1Guc / toplamGuc;
        double rastgeleSayi = Math.random();
        int skor1, skor2;
        if (rastgeleSayi < t1Olasilik) {
            skor1 = (int) (Math.random() * 6);
            skor2 = (int) (Math.random() * 4);
        } else {
            skor1 = (int) (Math.random() * 4);
            skor2 = (int) (Math.random() * 6);
        }
        System.out.println(takim1 + " " + skor1 + " - " + skor2 + " " + takim2);

        // Puanları güncelle
        if (skor1 > skor2) {
            // Takım 1 kazandı
            t1.setGalibiyet(t1.getGalibiyet() + 1);
            t1.setPuan(t1.getPuan() + 3);
            t2.setYenilgi(t2.getYenilgi() + 1);
        } else if (skor2 > skor1) {
            // Takım 2 kazandı
            t2.setGalibiyet(t2.getGalibiyet() + 1);
            t2.setPuan(t2.getPuan() + 3);
            t1.setYenilgi(t1.getYenilgi() + 1);
        } else {
            // Berabere
            t1.setBeraberlik(t1.getBeraberlik() + 1);
            t1.setPuan(t1.getPuan() + 1);
            t2.setBeraberlik(t2.getBeraberlik() + 1);
            t2.setPuan(t2.getPuan() + 1);
        }

        // Gol istatistiklerini güncelle
        t1.setAtilanGol(t1.getAtilanGol() + skor1);
        t1.setYenilenGol(t1.getYenilenGol()+ skor2);
        t2.setAtilanGol(t2.getAtilanGol() + skor2);
        t2.setYenilenGol(t2.getYenilenGol() + skor1);
                // Maç istatistiklerini güncelle
        t1.setOynananmac(t1.getOynananmac()+ 1);
        t2.setOynananmac(t2.getOynananmac()+ 1);
    } else {
        System.out.println("Takımlardan biri veya ikisi bulunamadı.");
    }
}


public void puanTablosuYazdir() {
    // Takımları puanlarına göre sırala
    Arrays.sort(a, new Comparator<Takım>() {
        @Override
        public int compare(Takım o1, Takım o2) {
            if (o1.getPuan() != o2.getPuan()) {
                return o2.getPuan() - o1.getPuan();
            } else if (o1.getAveraj() != o2.getAveraj()) {
                return o2.getAveraj() - o1.getAveraj();
            } else if (o1.getAtilanGol() != o2.getAtilanGol()) {
                return o2.getAtilanGol() - o1.getAtilanGol();
            } else {
                return o2.getGalibiyet() - o1.getGalibiyet();
            }
        }
    });

    // Puan tablosunu yazdır
    System.out.println("Puan Tablosu");
    System.out.println("Güç\tİsim\t\tMaç İstatistikleri");
    for (int i = 0; i < 18; i++) {
        Takım t = a[i];
        System.out.println(new DecimalFormat("##.##").format(t.getTakım_gucu()) + "\t" + t.getTakım_ismi() + "\tO:" + t.getOynananmac() + " G:" + t.getGalibiyet() + " B:" + t.getBeraberlik() + " M:" + t.getYenilgi() + " A:" + t.getAtilanGol() + " Y:" + t.getYenilenGol() + " AVG:" + (t.getAtilanGol() - t.getYenilenGol()) + " P:" + t.getPuan());
    }
    
}
public void ligiOynat() {
    // Fikstürü oluştur
    fiksturOlustur();

    // Maçları oynat
    for (int hafta = 1; hafta <= 34; hafta++) {
        System.out.println(hafta + ". Hafta Maçları");
        for (int i = 0; i < 9; i++) {
            String takim1 = fikstur[hafta - 1][i * 2];
            String takim2 = fikstur[hafta - 1][i * 2 + 1];
            System.out.println(takim1 + " vs " + takim2);
        }
        System.out.println();
        System.out.println(hafta + ". Hafta Maç Sonuçları");
        for (int i = 0; i < 9; i++) {
            String takim1 = fikstur[hafta - 1][i * 2];
            String takim2 = fikstur[hafta - 1][i * 2 + 1];
            macYap(takim1, takim2);
        }
        System.out.println();
        puanTablosuYazdir();
    }
    
}
}
