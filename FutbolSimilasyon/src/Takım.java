import java.util.Random;



public class Takım {
    private  String Takım_ismi;
    private  double Takım_gucu;
    private  double kaleci_gucu;
    private  double savunma_gucu;
    private  double ortasaha_gucu;
    private  double hucum_gucu;
    private  double taraftar_gucu;
    private int oynananmac;
    private int galibiyet;
    private int Yenilgi;
    private int beraberlik;
    private int YenilenGol;
    private int AtilanGol;
    private int puan;
    private int averaj;
    
    public int getYenilenGol() {
        return YenilenGol;
    }

    public void setYenilenGol(int YenilenGol) {
        this.YenilenGol = YenilenGol;
    }
   
    public int getAtilanGol() {
        return AtilanGol;
    }

    public void setAtilanGol(int AtilanGol) {
        this.AtilanGol = AtilanGol;
    }
    
    public int getYenilgi() {
        return Yenilgi;
    }

    public void setYenilgi(int Yenilgi) {
        this.Yenilgi = Yenilgi;
    }

    public int getOynananmac() {
        return oynananmac;
    }

    public void setOynananmac(int oynananmac) {
        this.oynananmac = oynananmac;
    }

    public int getGalibiyet() {
        return galibiyet;
    }

    public void setGalibiyet(int galibiyet) {
        this.galibiyet = galibiyet;
    }

    public int getBeraberlik() {
        return beraberlik;
    }

    public void setBeraberlik(int beraberlik) {
        this.beraberlik = beraberlik;
    }

    public int getAveraj() {
        return (this.AtilanGol-this.YenilenGol);
    }

    public void setAveraj(int averaj) {
        this.averaj = averaj;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
    
        public String getTakım_ismi() {
        return Takım_ismi;
    }

    public double getKaleci_gucu() {
        return kaleci_gucu;
    }

    public double getSavunma_gucu() {
        return savunma_gucu;
    }

    public double getOrtasaha_gucu() {
        return ortasaha_gucu;
    }

    public double getHucum_gucu() {
        return hucum_gucu;
    }

    public double getTaraftarGucu(boolean evSahibi) {
        if (evSahibi) {
            return taraftar_gucu;
        } else {
            return 0;
        }
    }

    public void setTaraftar_gucu(double taraftar_gucu) {
        this.taraftar_gucu = taraftar_gucu;
    }
    
    
    
    public double getTakım_gucu() {
        return Takım_gucu;
    }
    


    
    
    public Takım(String Takım_ismi ){
        Random rnd = new Random();
        this.Takım_ismi=Takım_ismi;
        this.taraftar_gucu=rnd.nextInt(0,20);         
    
        Oyuncu a[]=new Oyuncu[25];
        
        for(int i=0;i<25;i++){
            
            if(i<3){
            a[i]=new Oyuncu("kaleci");
            this.kaleci_gucu+=a[i].guc;
            }
            else if (i>=3 && i<13){
            a[i]=new Oyuncu("savunma");
            this.savunma_gucu+=a[i].guc;
            }
            else if (i>=13 && i<19){
            a[i]=new Oyuncu("ortasaha");
            this.ortasaha_gucu+=a[i].guc;
            }
            else{
            a[i]=new Oyuncu("hucum");
            this.hucum_gucu+=a[i].guc;
            }
            
            
        }
    this.Takım_gucu=((this.hucum_gucu )/3 + (this.ortasaha_gucu)/10 + (this.savunma_gucu)/6 + (this.kaleci_gucu)/6)+ this.taraftar_gucu;
    
    
    }



    
}