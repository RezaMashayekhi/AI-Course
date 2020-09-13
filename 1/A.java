
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rezam
 */
public class A {
    public static void main(String args[]){
        // soale 7
        int a[]= new int[1000];  // dar har step [0 ta 999] agar A kasif bashad meghdaresh 0 vagarna 1 hast. dar vaghe shabihsazie kasif boodan ya naboodan khaneye A dar in 1000 step ast ke be soorate random anjam midaham.
        int b[]= new int[1000];
        int pm=0; //performance messure
        Random rand= new Random();
        
        for(int i=0;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        int agent=rand.nextInt(2);  //agar 0 bood dar khaneye A hast, agar 1 bood dar khaneye B hast
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
        
        for(int i=0; i<1000;i++)
            pm+=a[i]+b[i];
        
        System.out.println("Javabe soale 7 baraye 1000 ta random step"+pm);
            
        
        
        // soal 8
        
        // agent do ta ja mitoone bashe har khoone ham 2 halat darad pas 2^3=8 halate avalie momken ast
        
        
        
        // halate 1
        a[0]=0; b[0]=0; agent=0;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm1=0;
        for(int i=0; i<1000;i++)
            pm1+=a[i]+b[i];
        
        System.out.println("javabe halate 1"+" "+ pm1);
        
        // halate 2
        a[0]=0; b[0]=0; agent=1;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm2=0;
        for(int i=0; i<1000;i++)
            pm2+=a[i]+b[i];
        
        System.out.println("javabe halate 2"+" "+ pm2);
        
        // halate 3
        a[0]=0; b[0]=1; agent=0;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm3=0;
        for(int i=0; i<1000;i++)
            pm3+=a[i]+b[i];
        
        System.out.println("javabe halate 3"+" "+ pm3);
        
        // halate 4
        a[0]=0; b[0]=1; agent=1;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm4=0;
        for(int i=0; i<1000;i++)
            pm4+=a[i]+b[i];
        
        System.out.println("javabe halate 4"+" "+ pm4);
        
        // halate 5
        a[0]=1; b[0]=0; agent=0;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm5=0;
        for(int i=0; i<1000;i++)
            pm5+=a[i]+b[i];
        
        System.out.println("javabe halate 5"+" "+ pm5);
        
        // halate 6
        a[0]=1; b[0]=0; agent=1;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm6=0;
        for(int i=0; i<1000;i++)
            pm6+=a[i]+b[i];
        
        System.out.println("javabe halate 2"+" "+ pm6);
        
        // halate 7
        a[0]=1; b[0]=1; agent=0;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm7=0;
        for(int i=0; i<1000;i++)
            pm7+=a[i]+b[i];
        
        System.out.println("javabe halate 2"+" "+ pm7);
        
        // halate 8
        a[0]=1; b[0]=1; agent=1;
        
        for(int i=1;i<1000;i++){
            a[i]=rand.nextInt(2);
            b[i]=rand.nextInt(2);
        }
        
        for(int i=0; i<1000;i++){
            if(a[i]==0 && agent==0)
                a[i]=1;
            else if (a[i]==1 && agent==0)
                agent=1;
            else if(b[i]==0 && agent==1)
                b[i]=1;
            else if(b[i]==1 && agent==1)
                agent=0;
            
        }
         int pm8=1;
        for(int i=0; i<1000;i++)
            pm8+=a[i]+b[i];
        
        System.out.println("javabe halate 2"+" "+ pm8);
        
        System.out.println("Average is "+ (pm1+pm2+pm3+pm4+pm5+pm6+pm7+pm8)/8);
        
    }
}
