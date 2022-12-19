//=============================================================================
// Project Info Header
//=============================================================================
//=============================================================================
// PROGRAMMER:  Kevin Penton  
// PANTHER ID:  6173069 
//
// CLASS:       COP3337    
// SECTION:     RVBB 
// SEMESTER:    Fall 2021
// CLASSTIME:   Wednesday 7:00 pm 
//
// Project:     #4    
// DUE:         Dec 8 at 11:59 pm   
//
//CERTIFICATION: I understand FIU’s academic policies, and I certify that this 
//               work is my own and that none of it is the work of any other person.
//                
//=============================================================================

package app;

import analyze.DataAnalyzer;
import java.util.Stack;
import util.StopWatch;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;



public class Controller {

    
    public static void main(String[] args) {
       
        
        // IMPORTANT WATCH THE PROJECT VIDEO BEFORE YOU START
        // IT WILL SAVE YOU A LOT OF TIME
        
        // create a DataAnalyzer object named dataAnalyzer
        DataAnalyzer dataAnalyzer = new DataAnalyzer();


        // find the first 35 fibonacci numbers
        // until you get it all working set the for-loop to loop 8 times to save time
        
        for(int n = 1; n<=35; n++){ 
            
            // create a Stack object named stack
            Stack<Integer> stack = new Stack<>();
            
            // create a StopWatch object named stopWatch
            StopWatch stopWatch = new StopWatch();
            

            // start the stopWatch
            stopWatch.start();
            
            // find the fibonacci index at n and save the value in fibValue
            // also pass the stack object so it can record the recursive method calls
            
            // HINT
            int fibValue = fib(n,stack);
            
            // create a map object <String, Integer> name map that is
            // constructed using a TreeMap constructor
            // HINT
            Map<String, Integer> map = new TreeMap();
            
            
            // figure out here how  many times a fib(n) was called and store this 
            // information in the map with fib(m) as the key and the times it was called 
            // as the vlaue for this key
            // example
            // map("fib(5)", 2832);
            // map("fib(6)", 1230);
            //....
            
            // hint use
            for(int i=1; i<=n; i++){
                Iterator<Integer> stackIterator = stack.iterator();
                
                int counter = 0; 
                
                while(stackIterator.hasNext())
                {
                    if (stackIterator.next() == i)
                    {
                        counter++;     
                    }//end if
                   
                }//end while
        
                map.put(("fib(" + i + ")"), counter);
            }//end for
            
    
            // stop the stopWatch object
            stopWatch.stop();

            
            // create an ExecutionInfo object name executionInfo
            // with correct inputs for the constructor
            // hint use stopWatch.getElapsedTime() for the last input
            
            // ExecutionInfo executionInfo 
            ExecutionInfo executionInfo = new ExecutionInfo(map, n, fibValue, stopWatch.getElapsedTime());
            
            
            
            
            // add the executionInfo object to the dataAnalyzer arraylist
            dataAnalyzer.getData().add(executionInfo);
 
        }//end for
        
   
        //----------------------------------
        
        
        // run the displayInfo method on each executionInfo object
        // within the dataAnalyzer arraylist using an enhanced for-loop
        for (ExecutionInfo executionInfo : dataAnalyzer.getData())
        {
            executionInfo.displayInfo();       
        }
        
        // call the dataAnalyzer findGrowthRate method
        dataAnalyzer.findGrowthRate();

    }
    
    public static int fib(int n, Stack stack){
        
        // update the stack with the needed information
        stack.push(n);
        
        
        if(n ==1 ) {
            return 1;
        }
        if(n ==2 ) {
            return 2; 
        }
        
        return fib(n-1,stack) +  fib(n-2,stack);
    }
    
}
