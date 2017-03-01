package routerpatchchecker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public class CSVReader {

    private static final String FILEOUTPUT = "result.csv";

    public static void main(String[] args) throws IOException {
        //Readijng the input file
        BufferedReader br = null;
        String line = "";
        String csvFile = "BTcsv.csv";

        //Wrting to output file
        BufferedWriter bw = null;
        FileWriter fw = null;

        String cvsSplitBy = ",";
        String firstRun = "yes";
        RouterDTo dt = new RouterDTo();
        int i = 0;
        ArrayList<RouterDTo> list = new ArrayList<RouterDTo>();
        ArrayList<String> checkIp = new ArrayList<String>(10);
        ArrayList<String> checkName = new ArrayList<String>(10);
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                i++;
                String[] country = line.split(cvsSplitBy);
                try {
                    dt = new RouterDTo(country[0], country[1], country[2], Double.parseDouble(country[3]), country[4]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    dt = new RouterDTo(country[0], country[1], country[2], Double.parseDouble(country[3]), "");
                }
                if (dt.ifPatched.equalsIgnoreCase("no") && dt.osVersion >= 12) {
                    if (firstRun.equals("yes")) {
                        list.add(dt);
                        firstRun = "no";
                        checkIp.add(dt.getIpAddress());
                        checkName.add(dt.getHostName());
                    } else if (firstRun.equals("no")) {
                        if (!checkIp.contains(dt.getIpAddress()) && !checkName.contains(dt.getHostName())) {
                            checkIp.add(dt.getIpAddress());
                            checkName.add(dt.getHostName());
                            list.add(dt);
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                br.close();
                System.out.println("------------------------------------------------Results------------------------------------------------------------");
                fw = new FileWriter(FILEOUTPUT);
                bw = new BufferedWriter(fw);
                for (int b = 0; b < list.size(); b++) {
                    System.out.println(list.get(b).toString());
                    bw.write(list.get(b).toString() + System.lineSeparator());
                }
                System.out.println("------------------------------------------------End Results------------------------------------------------------------");

                System.out.println("Total Number of unpatched routers:  " + i);
                System.out.println("Print out successful, a CSV file has also been created with these same rusults");
                System.out.println("------------------------------------------------------------------------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
