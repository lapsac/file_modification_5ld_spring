import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
        String fileName;
        System.out.println("Input file name:");
        fileName = sc.nextLine();
        sc.close();
        
        try {
            sc = new Scanner(new FileReader(fileName));
            PrintWriter out = new PrintWriter(new FileWriter("temp.txt"));
            String s;
            
            // --atrast visgarako rindu--
            String visgarakaRinda = "";
            int visgarakaRindaLength = 0;

            while (sc.hasNextLine()) {
                s = sc.nextLine();
                if (s.length() > visgarakaRindaLength) { //--ja rindas garums > iepr. gar. garakaja rinda, uztvert to ka jaunu garako rindu--
                    visgarakaRindaLength = s.length();
                    visgarakaRinda = s;
                }
            }
            sc.close();
            
            sc = new Scanner(new FileReader(fileName));
            int rindasSkaits = 0;

            while (sc.hasNextLine()) {
                s = sc.nextLine();
                if (!s.isEmpty()) { // --centresana--
                    int atstarpesSkaits = (visgarakaRindaLength - s.length()) / 2;
                    String atstarpes = "";
                    for (int i = 0; i < atstarpesSkaits; i++) {
                        atstarpes += " ";
                    }
                    String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
                    out.println(atstarpes + cap); //--pievieno atstarpes un pirmo lielo burtu--
                    rindasSkaits++;
                    if (rindasSkaits % 2 == 0) { //--add tuksu rindu pec katram divam netuksajam rindam--
                        out.println();
                    }
                }
            }

            sc.close();
            out.close();
            
            File sourceFile = new File(fileName);
            File tempFile = new File("temp.txt");
            
            sourceFile.delete();
            tempFile.renameTo(sourceFile);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
