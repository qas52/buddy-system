package buddy;

import java.util.LinkedList;
import java.util.Scanner;








public class Trial {

	public static void main(String[] args) {
     int memsize=0,i=0;
     char c='y';
     char value='U';
     
    System.out.println("enter memory size in terms of KB so for MB * 1024 , GB *1024^2 and so on");
    @SuppressWarnings("resource")
	Scanner input= new Scanner(System.in);
	memsize=input.nextInt();
	
	LinkedList <Memory> memqueue = new LinkedList<Memory>();
	
	Memory memory = new Memory(memsize,'U');
	
	memqueue.add(memory);
	
	while(c=='y') {
		System.out.println("enter input");
		int flag=0;
		memsize=input.nextInt();
	    value=input.next().charAt(0);
	  if(memsize>0)
	  {  i=0;
	    while (i<memqueue.size()) {
	        
	    	if(memsize>memqueue.get(i).memsize)
	    		i++;
	    	else if(memsize<memqueue.get(i).memsize&& memsize<memqueue.get(i).memsize/2 && memqueue.get(i).value=='U')
	    	{	memqueue.get(i).memsize=memqueue.get(i).memsize/2;
	    	    memory = new Memory(memqueue.get(i).memsize,memqueue.get(i).value);
	    	    memqueue.add(i, memory);
	    	    }
	    	else if (memsize<memqueue.get(i).memsize&& memqueue.get(i).value=='U')
	    	{ memqueue.get(i).value=value;
	    	  flag =1;
	    	  break;}
	    	else
	         i++;
	    	
	    	
	     // System.out.println(memqueue.get(i).memsize);
	     // System.out.println(memqueue.get(i).value);
	    	
	                              } 
	   if(flag==0)
		System.out.println("no free memory");
	    i=0;
	    while(i<memqueue.size())
	    { System.out.println(memqueue.get(i).memsize);
	      System.out.println(memqueue.get(i).value);
	     i++;
	    }
	  }   
	  else {
		  i=0;
	  while(i<memqueue.size()) {
	   if(value!=memqueue.get(i).value)
		   i++;
	   else { 
	  memqueue.get(i).value='U';
		   if(i==0)
		   i++;	   
	     break;
	  }
	  }
	  
	   while(i<(memqueue.size()-1)) {
	  
		   if(memqueue.get(i).memsize==memqueue.get(i+1).memsize&&memqueue.get(i).value==memqueue.get(i+1).value)
	   { memqueue.get(i).memsize=memqueue.get(i).memsize*2;
	    memqueue.remove(i+1);
	    
	    }
	  else if(memqueue.get(i).memsize==memqueue.get(i-1).memsize&&memqueue.get(i).value==memqueue.get(i-1).value)
	    {memqueue.get(i).memsize=memqueue.get(i).memsize*2;
	    memqueue.remove(i-1);
	    }
	    else
	    i++;
	    }
	   i=0;
	   if(memqueue.get(i).memsize==memqueue.get(i+1).memsize&&memqueue.get(i).value==memqueue.get(i+1).value)
	   { memqueue.get(i).memsize=memqueue.get(i).memsize*2;
	    memqueue.remove(i+1);
	    
	    }
	    while(i<memqueue.size())
	    { System.out.println(memqueue.get(i).memsize);
	      System.out.println(memqueue.get(i).value);
	     i++;
	    }
	  }	  
		  
	  
	  System.out.println("enter y to continue");
    	c=input.next().charAt(0);
    	
	                           
	}
 }

}
