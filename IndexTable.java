import java.util.Scanner;

class Ogrenci{
    
    int not;
    int ogrNum;
    int index;

    public  Ogrenci(int num,int not,int index) {
       
        this.not = not;
        this.ogrNum = num ;
        this.index = index;
    }

}

public class IndexTable {
    public static void main(String[] args) {

        final int kapasite = 100 ;
        int[] numbers ={18060311,20060045,19061091,20060134,20060678,18061086,20060032,20060067,19060456,18060245,20060110,20060234,20060141,20060011,20060012};
        int [] notes = {40,50,75,90,40,75,50,60,60,75,40,90,60,50,60};
        int i = numbers.length;
        int temp ;

        Ogrenci[]  ogrenciler = new Ogrenci[kapasite];

        for(temp=0;temp<i;temp++){

            Ogrenci o1 = new Ogrenci(numbers[temp],notes[temp],temp);
            ogrenciler[temp]= o1;
 
        }     
        ogrenciler =  sirala(ogrenciler);
        yazdir(ogrenciler);
        ekle(ogrenciler);
        sil(ogrenciler, 10);
        degistir(ogrenciler, 5);
    }
    public static Ogrenci[]  sirala(Ogrenci ogrenciler[]){
       
        int size = elemansayisibul(ogrenciler);
        int i,j ;
        int m_index;
        for(i = 0 ; i < size ; i++ ){
            m_index=i;
            for(j = i ; j < size ; j++){

                if(ogrenciler[j].not > ogrenciler[m_index].not){
                    m_index = j ;
                }
                else if(ogrenciler[j].not == ogrenciler[m_index].not){
                    if(ogrenciler[j].ogrNum<ogrenciler[m_index].ogrNum){
                        m_index = j ;
                    }
                    
                }
            }

            Ogrenci temp = ogrenciler[i];
            ogrenciler[i] = ogrenciler[m_index];
            ogrenciler[m_index] = temp ;

        }

        return ogrenciler;
    }
    public static void yazdir(Ogrenci ogrenciler[]){
      
        int size = elemansayisibul(ogrenciler);
        int temp;   
        for(temp = 0;temp<size;temp++){
            
            System.out.print(ogrenciler[temp].index + " ");
           
        }

        System.out.println("");
   

    }
    public static  void sil(Ogrenci ogrenciler[], int index){
        int size = elemansayisibul(ogrenciler);
        int control = 0 ;
        while(ogrenciler[control].index != index){
            control++;
        }
        
        for(int i = control; i< size ;i++){
            ogrenciler[i]=ogrenciler[i+1];
        }
        System.out.print(index + " indexli eleman listeden cikarildi yeni sirlama : " );
        for(int i = 0 ; i<size-1;i++){
           
            System.out.print(ogrenciler[i].index + " "); 
            
        }
        System.out.println(" ");
    }
    public static Ogrenci[]  ekle(Ogrenci ogrenciler[]){

        int index = elemansayisibul(ogrenciler);
        Scanner data = new Scanner(System.in);
		System.out.print("Eklemek istediginiz ogrencinin numarasi : ? ");
        int no  = data.nextInt();
        System.out.print("Eklemek istediginiz ogrencinin notu  : ? ");
        int not  = data.nextInt();
        Ogrenci ogrenci = new Ogrenci(no, not, index);

       

        ogrenciler[index] = ogrenci;
        ogrenciler =  sirala(ogrenciler);
        System.out.println("ogrenci eklendi ");
        System.out.print("yeni siralama : ");
        yazdir(ogrenciler);
        

        return ogrenciler;
    }
    
    public static int elemansayisibul(Ogrenci ogrenciler[]){
        int count = 0 ; 
        while(ogrenciler[count] != null){
            
            count++;
        }
    
        return count ; 
    } 
    public static  void degistir(Ogrenci ogrenciler[], int index){

        int control = 0 ;
        while(ogrenciler[control].index != index){
            control++;
        }

        Scanner data = new Scanner(System.in);
		System.out.print(index +" indexli ogrencinin notunu kac yapmak istiyorsunuz: ? ");
        int not  = data.nextInt();
        ogrenciler[control].not = not;
        data.close();
        sirala(ogrenciler);

        System.out.println(index + " indexli ogrencinin notu "+  not+ " yapildi.");
        System.out.print("yeni sirlama : ");
        yazdir(ogrenciler);
    }
    
}
