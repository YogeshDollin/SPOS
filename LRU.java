import java.io.*;
import java.util.*;

class LRU{
	ArrayList<Integer> pageArray;
	int rear;
	
	public LRU(){
		rear = -1;
		pageArray = new ArrayList <Integer>(5);
	}
	
	public void push(int data){
		rear = (rear + 1) % 5;
		int tempIndex = pageArray.indexOf(data);
		 if ( tempIndex != -1){
		 
		 	int temp = pageArray.get(rear);
//		 	pageArray.remove(rear);
		 	pageArray.set(rear, data);
		 	pageArray.set(tempIndex, temp);
		 }
		 else{
		 		if (pageArray.size() != 5)
		 			pageArray.add(rear, data);
		 		else{
			 	pageArray.set(rear, data);
		 	}
		 }
	}
	
	public void display(){
	System.out.println();
		for(int i = 0 ; i < pageArray.size() ; i++)
			System.out.print(pageArray.get(i) + " ");
	}
	
	public static void main(String arg[]){
	
		LRU l = new LRU();
	
		Scanner sc = new Scanner(System.in);
		int value = 0;
		
		while(value >= 0){
			value = sc.nextInt();
			
			l.push(value);
			//System.out.println("Olay");
			l.display();
		}
	}
}
