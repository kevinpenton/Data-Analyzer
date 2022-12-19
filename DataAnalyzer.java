package analyze;

import app.ExecutionInfo;
import java.util.ArrayList;

public class DataAnalyzer {
    
    private ArrayList<ExecutionInfo> data; 

    public DataAnalyzer() {
        
        data = new ArrayList<>();
    }

    public ArrayList<ExecutionInfo> getData() {
        return data;
    }
    
    public void findGrowthRate(){
          System.out.println("");
          
         System.out.println("-------------------------------------------------");
         System.out.println("Data Analyzer Growth Rate");
         System.out.println("-------------------------------------------------");
         
         // your output format must match mine
         // look at the video for see the out format
         // the exponent value is e^x = total method class   
         // you need to find the x... do not over think it use the Math class 
         for(ExecutionInfo executionInfo : data)
         
         {
          double exponent = Math.log(executionInfo.getTotalMethodCalls());
         
          System.out.printf("Index: %d \tFibValue: %-8d \tCalls: %-8.0f \tExponent: %.3f \n", 
                     executionInfo.getFibIndex(), executionInfo.getFibValue(), executionInfo.getTotalMethodCalls(), exponent);
         }// end for

    }
    
}// end class
