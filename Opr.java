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
        
        boolean flag = true;

        for (int i = 0 ; i < 10 ; i++){

            noLongerUsed[0] = getIndex(i,pageDisplay[0][i]);
            noLongerUsed[1] = getIndex(i,pageDisplay[1][i]);
            noLongerUsed[2] = getIndex(i,pageDisplay[2][i]);

            for(int j = 0 ; j < 3 ; j++){
                if (noLongerUsed[j] == -1)
                    pageDisplay[j][i] = page[i];
                    flag = false;
                    break;
            }
            if (flag){

                pageDisplay[getMax()][i] = page[i];
            }

        }
    }

    void display(){

        for (int i = 0 ; i < 10 ; i++)
            System.out.print(page[i]+" ");

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
