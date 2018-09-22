package stable;

import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;


public class stable {
	
	//Instructions to run the program
	//place the girls,boys,lads and lasses text file in and outside the bin.
	//I have opened the terminal on bin and given below instructions.
	
	//lakshminarayanad17@pungo:~/Desktop/stable/bin> java stable.stable find boys.txt girls.txt matching
    //Picked up _JAVA_OPTIONS:  -Xmx128m -Xms128m
    //Gale Shapley Algorithm..............
	//A file named matching created..............
	
	//lakshminarayanad17@pungo:~/Desktop/stable/bin> java stable.stable check  lads.txt lasses.txt doubtful
    //Picked up _JAVA_OPTIONS:  -Xmx128m -Xms128m
    //Gale Shapley Algorithm..............
    //A file named doubtful created..............

	private int N, engagedCount;
	//private MyLinkedList <MyLinkedList<Integer>> menPref = new MyLinkedList<MyLinkedList<Integer>>();
	private MyLinkedList <MyLinkedList<Integer>> menPref = new MyLinkedList<MyLinkedList<Integer>>();
	private MyArrayList <MyArrayList<Integer>> womenPref = new MyArrayList <MyArrayList<Integer>>();
	private Integer[] womenPartner;
	private boolean[] menEngaged;
	private  String fileName;
	private String operation;

	public stable(MyLinkedList <MyLinkedList<Integer>> mp,
			MyArrayList <MyArrayList<Integer>> wp, String fn,String oprn) {
		//N = mp.size();
		N = wp.size();
		engagedCount = 0;
		fileName = fn;
		menPref = mp;
		womenPref = wp;
		menEngaged = new boolean[N];
		womenPartner = new Integer[N];
		operation = oprn;
		calcMatches();
	}

	private void calcMatches() {
		while (engagedCount < N) {
			int free;
			for (free = 0; free < N; free++)
				if (!menEngaged[free])
					break;

			for (int i = 0; i < N && !menEngaged[free]; i++) {
				int index = womenIndexOf(menPref.get(free).get(i));
				if (womenPartner[index] == null) {
					womenPartner[index] = free+1;
					menEngaged[free] = true;
					engagedCount++;
				} else {
					int currentPartner = womenPartner[index];
					if (morePreference(currentPartner, free+1, index)) {
						womenPartner[index] = free+1;
						menEngaged[free] = true;
						menEngaged[menIndexOf(currentPartner)] = false;
					}
				}
			}
		}
		printCouples();
	}

	private boolean morePreference(int curPartner, int newPartner,
			int index) {
		for (int i = 0; i < N; i++) {
			if (womenPref.get(index).get(i).equals(newPartner))
				return true;
			if (womenPref.get(index).get(i).equals(curPartner))
				return false;
		}
		return false;
	}

	/** get men index **/
	private int menIndexOf(int currentPartner) {
		for (int i = 0; i < N; i++)
			if (i+1 ==(currentPartner))
				return i;
		return -1;
	}

	/** get women index **/
	private int womenIndexOf(Integer integer) {
		for (int i = 0; i < N; i++)
			if ((i+1) == (integer))
				return i;
		return -1;
	}

	/** print couples **/
	public void printCouples() {
		
		boolean duplicateFound = false;
		boolean notEngagedManFound = false;
		boolean allWomenAllocated = true;
		boolean perfectMatching = false;
		
		Set setToValidatePairs  = new HashSet<Integer>();
		
		System.out.println("A file named "+fileName +" created..............\n");

		
		try ( BufferedWriter bw = 
				new BufferedWriter (new FileWriter (fileName+".txt", false)) ) 
		{	
			bw.write ("Couples are : "+ "\n");
		for (int i = 0; i < N; i++) {
			bw.write (womenPartner[i] + " " + (i+1) + "\n");
			boolean res = setToValidatePairs.add(womenPartner[i]);
			if(!res){
				duplicateFound = true;
			}
			if(womenPartner[i] == null){
				allWomenAllocated = false;
			}
			
		}	
			bw.close ();
			
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
		for(int i = 0; i < N; i++){
			if(!menEngaged[i]){
				notEngagedManFound = true;
			}
		}
		
		if(!duplicateFound && !notEngagedManFound && allWomenAllocated){
			perfectMatching = true;
		}
		
		if("check".equalsIgnoreCase(operation)){
			if(perfectMatching)
			System.out.println("The pairs forms a perfect matching");
			else
			System.out.println("The pairs forms a perfect matching");
	
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Gale Shapley Algorithm..............\n");
		
		MyLinkedList <MyLinkedList<Integer>> mp = new MyLinkedList <MyLinkedList<Integer>>();
		MyLinkedList<Integer> mp1 = new MyLinkedList<Integer>();
		 MyArrayList <MyArrayList<Integer>> wp = new  MyArrayList <MyArrayList<Integer>>();
		 MyArrayList<Integer> wp1 = new MyArrayList<Integer>();
		 
		 String oprn = args[0];
		 
		Scanner sc = new Scanner(new BufferedReader(new FileReader(args[1])));
		
	      int rows = 4;
	      int columns = 4;
	      
	      while(sc.hasNextLine()) {
	         for (int i=0; i<rows; i++) {
	        	 mp1 = new MyLinkedList<Integer>();
	            String[] line = sc.nextLine().trim().split(" ");
	            for (int j=0; j<line.length; j++) {
	            	mp1.add(Integer.parseInt(line[j]));
	            }
	            mp.add(mp1);
	         }
	      }
	      
	  sc = new Scanner(new BufferedReader(new FileReader(args[2])));

	      while(sc.hasNextLine()) {
	         for (int i=0; i<rows; i++) {
	        	 wp1 = new MyArrayList<Integer>();
	            String[] line = sc.nextLine().trim().split(" ");
	            for (int j=0; j<line.length; j++) {
	            	wp1.add(Integer.parseInt(line[j]));
	            }
	            wp.add(wp1);
	         }
	      }	      

	      stable s = new stable(mp, wp, args[3], oprn);
	}

}
