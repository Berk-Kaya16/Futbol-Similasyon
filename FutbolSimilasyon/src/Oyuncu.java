
import java.util.Random;



public class Oyuncu {
    String pozisyon;
    
    
    // indislerin tuuttuğu özellikler:
    //f[0]=Acceleration,f[1]=Agility,f[2]=Balnce,f[3]=Jumping Reach,f[4]=Naturel Fitness ,f[5]=Pace ,f[6]=Stamina  , f[7]=Strengh
    
    //m[0]=Aggeresion, m[1]=Aticipation, m[2]=Bravery, m[3]=Composure, m[4]=Concentration, m[5]=Decisions, m[6]=Determination, m[7]=Flair, m[8]=Leadership
    //m[9]=Off the Ball , m[10]=Positioning , m[11]=Teamwork  ,m[12]=Vison , m[13]= Work Rate
    
    //t[0]=Corners, t[1]=Crossing, t[2]=Dribbling, t[3]=Finishing, t[4]=First Touch, t[5]=Free Kick Taking, t[6]=Heading, 
    //t[7]=Long Shots, t[8]=Long Throws, t[9]=Marking , t[10]=Passing, t[11]=Peanlty Taking, t[12]=Tackling, t[13]=Technique
    
    
    // k[0]=Aerial Reach , k[1]=Command of Area , k[2]=Comminication, k[3]=Handling, k[4]=Kicking, k[5]=One on Ones , k[6]=Punching, k[7]=Reflexes, k[8]=Throwing
    
    
    double[] fizikselOzelliler = new double[8]; 
    double[] mentalOzellikler = new double[14];
    double[] teknikOzellikler = new double[14];
    double[] kaleciOzellikler = new double[9];
    double guc=0;
    
    
        public Oyuncu(String a) {
            Random rand = new Random();
            this.pozisyon=a;
            //////////////savunma/////////////////
            if (this.pozisyon.equals("savunma")){
            for(int i =0 ;i<14;i++){
               if(i<8){
               if(((i==2 || i==3 || i==6 || i==7)))//savunma oyuncuları için              
               this.fizikselOzelliler[i]= rand.nextInt(10,20) + 3;
               else
               this.fizikselOzelliler[i]= rand.nextInt(0,20)*0.2;
               
              guc+=fizikselOzelliler[i];
               }
                if(i<14)
                {
                 if(((i==2 || i==4 || i==8 || i==10)))
                    this.mentalOzellikler[i]= rand.nextInt(10,20) + 3;
            else
             this.mentalOzellikler[i]= rand.nextInt(0,20) *0.2;
               
                if(((i==4 || i==6 || i==9 || i==12)))                 
                     this.teknikOzellikler[i]= rand.nextInt(10,20) + 3;
            else
             this.teknikOzellikler[i]= rand.nextInt(0,20)*0.2;
                
                guc+=(mentalOzellikler[i]+teknikOzellikler[i]);
                
                }
           
             
            if(i<9)
            {
            this.kaleciOzellikler[i]= rand.nextInt(0,20)*0.2;
            guc+=kaleciOzellikler[i];
            
            } 
            }
            }
          
            ////////////////////////hücum///////////////////////
           else if (this.pozisyon.equals("hucum")){
                for(int i=0;i<14;i++){
                if(i<8){
                    
                if(((i==0 || i==2 || i==4 || i==7)))             
                    this.fizikselOzelliler[i]= rand.nextInt(10,20) + 3;
               else
                    this.fizikselOzelliler[i]= rand.nextInt(0,20)*0.2;
               
               guc+=fizikselOzelliler[i];
           
               }
               if(i<14){
                   
                 if(((i==1 || i==3 || i==7 || i==12)))
               
                    this.mentalOzellikler[i]= rand.nextInt(10,20) + 3;
               else
                    this.mentalOzellikler[i]= rand.nextInt(0,20) *0.2;
               
                if(((i==2 || i==4 || i==10 || i==13)))                 
                     this.teknikOzellikler[i]= rand.nextInt(10,20) + 3;
               else
                     this.teknikOzellikler[i]= rand.nextInt(0,20)*0.2;
                
                guc+=(mentalOzellikler[i]+teknikOzellikler[i]);
                
                }
             if(i<9)
            {
            this.kaleciOzellikler[i]= rand.nextInt(0,20)*0.2;
            guc+=kaleciOzellikler[i];
            } 
                
            }
            }
            
            /////////////ortasaha////////////////////////
            
           else if (this.pozisyon.equals("ortasaha")){
                for(int i=0;i<14;i++){
                if(i<8){
                    
                if(((i==1 || i==2 || i==4 || i==5)))             
                    this.fizikselOzelliler[i]= rand.nextInt(10,20) + 3;
               else
                    this.fizikselOzelliler[i]= rand.nextInt(0,20)*0.2;
               
               guc+=fizikselOzelliler[i];
           
               }
               if(i<14){
                   
                 if(((i==3 || i==6 || i==7 || i==9)))
                    this.mentalOzellikler[i]= rand.nextInt(10,20) + 3;
               else
                    this.mentalOzellikler[i]= rand.nextInt(0,20) *0.2;
               
                if(((i==4 || i==6 || i==10 || i==13)))                 
                     this.teknikOzellikler[i]= rand.nextInt(10,20) + 3;
               else
                     this.teknikOzellikler[i]= rand.nextInt(0,20)*0.2;
                
                guc+=(mentalOzellikler[i]+teknikOzellikler[i]);
                
                }
            if(i<9)
            {
            this.kaleciOzellikler[i]= rand.nextInt(0,20)*0.2;
            guc+=kaleciOzellikler[i];
            
            } 
                
            }
            }
            /////////////kaleci////////////////////////
           else {
                for(int i=0;i<14;i++){
                if(i<8){
                    
                this.fizikselOzelliler[i]= rand.nextInt(0,20)*0.2;
                guc+=fizikselOzelliler[i];
           
               }
               if(i<14){
               this.mentalOzellikler[i]= rand.nextInt(0,20) *0.2;
               this.teknikOzellikler[i]= rand.nextInt(0,20)*0.2;
                
               guc+=(mentalOzellikler[i]+teknikOzellikler[i]);
                
                }
            if(i<9)
            {
            this.kaleciOzellikler[i]= rand.nextInt(10,20)+3;      
            guc+=kaleciOzellikler[i];
            
            } 
                
            }
           }
          guc=guc/45;
          
        }
}