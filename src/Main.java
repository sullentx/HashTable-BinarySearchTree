import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String line = "";
        String splitBy = ",";
        int id=1;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);    // use comma as separator
                System.out.println("["+id+"] Bussines [ID=" + bussines[0] + ", Name=" + bussines[1] + ", Address=" + bussines[2] + ", City=" + bussines[3] + ", State= " + bussines[4] +"]");
                id++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}