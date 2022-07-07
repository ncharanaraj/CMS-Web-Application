package sample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kings on 01-12-17.
 */
public class P {

    public  static void p(String string)
    {
        System.out.println(string);
    }

    public static String drive_name() throws Exception {
        return getDataFromIPtext("DRIVE");
    }

    public static String dname() throws Exception {
        return getDataFromIPtext("DNAME");
    }

    public static String duser() throws Exception {
        return getDataFromIPtext("DUSER");
    }

    public static String dpword() throws Exception {
        return getDataFromIPtext("DPWORD");
    }

    public static String ipaddress_name() throws Exception {
        return getDataFromIPtext("IP_ADDRESS");
    }

    public static String getDataFromIPtext(String key) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        String s = new String(Files.readAllBytes(Paths.get(FilePath.JSON_PATH_2+"db.txt")));
        Object obj = parser.parse(s);
        String d= String.valueOf(((JSONObject) obj).get(key));
        System.out.println(d);
        return d;
    }

    static String aa="\n--------------------------------00000-------------------------------------\n";
    public static void loggerLoader(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        try {
         //   Logger.log(aa+exceptionAsString+aa);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public static void loggerLoader(String message)  {
        try {
         //   Logger.log(aa+message+aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
