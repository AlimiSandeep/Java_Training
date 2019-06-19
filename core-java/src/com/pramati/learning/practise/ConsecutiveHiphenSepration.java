package com.pramati.learning.practise;

public class ConsecutiveHiphenSepration {
public static void main(String[] args) {
	  String str="5,7,9,10,11,14,15,17,18,19";
	    String[] arr=str.split(",");
	    int[] b=new int[arr.length];
	    for(int i=0;i<arr.length;i++)
	    b[i]=Integer.parseInt(arr[i]);
		int x=b[0];
		int z=arr.length-1;
		String str1="";
		int k=-1;
		for(int i=0;i<b.length;i++)
		{
		    if(b[i]==x){
		        x++;
		        k++;
		    }
		    else{
		        if(k>0)
		        str1+="("+b[i-k-1]+"-"+b[i-1]+")";
		        else
		        str1+=+b[i-1];
		        str1+=",";
		        k=-1;
		        x=b[i];
		        i--;
		    
		}
		}
		if(k>0)
		        str1+="("+b[z-k]+"-"+b[z]+")";
		        else
		        str1+=+b[z];
		System.out.print(str1);
}
}
