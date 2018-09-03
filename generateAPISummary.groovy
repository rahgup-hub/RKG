import static groovy.io.FileType.FILES;
import static java.util.Calendar.*; 


class FileExample {
   static void main(String[] args) {
   
   def folder = "D:\\projects\\work\\groovy\\soapresults";
   def destFilePath=  "D:\\projects\\work\\groovy\\soapresults";
   def dir ;
   def pass=0;
   def fail=0;
   def total=0;
   def passPer=0.0;
   
      dir = new File(folder)
      dir.eachFileMatch(~/.*[_OK].txt/){
        // file ->println file.getName();
         pass++;
      }
      
      println "Pass "+ pass;
      
      dir = new File(folder)
      dir.eachFileMatch(~/.*[_FAILED].txt/) {
       // file -> println file.getName();
        fail++;
      }
      
       // println "fail "+ fail;
        passPer= (pass/(fail+pass))*100;
       // println "passPer "+ passPer;
  
  // Creating Output Filename
  
      def date = new Date();
      def destFile = destFilePath+"\\"+date[YEAR]+""+date[MONTH]+""+date[DATE] +"_"+date[HOUR]+""+date[MINUTE]+"_APITestResultSummary.txt";
     
 //Generating Summary File.
            
      File outFile = new File(destFile)
      outFile.write "Total TC = "+(fail+pass)+System.getProperty("line.separator")
      outFile << "Total PASS =  "+pass+System.getProperty("line.separator")
      outFile << "\nTotal FAIL = "+fail+System.getProperty("line.separator")
      outFile << "\nPASS PERCENTAGE = "+passPer+System.getProperty("line.separator")  
      println outFile.text
      
      
   }
}