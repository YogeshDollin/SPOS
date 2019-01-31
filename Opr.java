import java.io.*;
import java.util.*;

public class Opr{

    int pagePointer;
	int page[];
	int pageDisplay[][];
    int noLongerUsed[];
    Scanner sc = new Scanner(System.in);
    
    Opr(){
        noLongerUsed = new int[3];
        page = new int[10];
        pageDisplay = new int[3][10];
        for( int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 10 ; j++)
                pageDisplay[i][j] = -1;
    }
    }

	void set(){
		for(int i =0 ; i < 10 ; i++)
            page[i]= sc.nextInt();
	}

    int getIndex(int start,int key){

        for (int i = start+1 ; i < 10 ; i++)
            if(page[i] == key)
                return i;
        return -1;

    }

    int getMax(){
        int max = -1,maxIndex = -1;
        for( int i = 0 ; i < 3 ; i++){
            if (noLongerUsed[i]  > max){
                max = noLongerUsed[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    void process(){
        
        boolean flag2 = true ,flag1 = true;
        int j=0;

        for (int i = 0 ; i < 10 ; i++){

            flag2 = true;
            flag1 = true;

            noLongerUsed[0] = getIndex(i,pageDisplay[0][i]);
            noLongerUsed[1] = getIndex(i,pageDisplay[1][i]);
            noLongerUsed[2] = getIndex(i,pageDisplay[2][i]);

            System.out.println(noLongerUsed[0]+" "+noLongerUsed[1]+" "+noLongerUsed[2]);

            if (j < 3){
                for(j = 0 ; j < 3 ; j++){
                if (pageDisplay[j][i] == -1){
                    pageDisplay[j][i] = page[i];
                    break;
                 }
                }
            }

                for(int k = 0 ; k < 3 ; k++){
                if (pageDisplay[k][i] == page[i]){
                    flag1 = false;
                    break;
                 }
                }
           
                if(flag1){
                    for(int k = 0 ; k < 3 ; k++){
                        if (noLongerUsed[k] == -1){
                            pageDisplay[k][i] = page[i];
                        flag2 = false;
                         break;
                        }
                     }
                     if (flag2){
                         pageDisplay[getMax()][i] = page[i];
                    }
                }
            
            

            if((i+1) < 10){
                pageDisplay[0][i+1] = pageDisplay[0][i];
                pageDisplay[1][i+1] = pageDisplay[1][i];
                pageDisplay[2][i+1] = pageDisplay[2][i];
            }

        }
    }

    void display(){

        for (int i = 0 ; i < 10 ; i++)
            System.out.print(page[i]+" ");

    System.out.println();

        for( int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                System.out.print(pageDisplay[i][j]+" ");
            }
            System.out.println();
        }            
    }

    public static void main(String arg[]){

        Opr o = new Opr();
        o.set();
        o.process();
        o.display();
    }
}
