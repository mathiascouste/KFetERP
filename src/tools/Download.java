package tools;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Download
{
    private static final String PROTOCOL = "http";
    private static final String HOST = "couste.eu";
    public static String getFile(String file)
    {
        String path = PROTOCOL+"://"+HOST+"/"+file;
        String s;
        String toRet = "";
        BufferedReader r = null;
        try {
            r = new BufferedReader(new InputStreamReader(new URL(path).openStream()));
            while ((s = r.readLine()) != null) {
                toRet += s +"\n";
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return toRet;
    }

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("You must give the URL of the file to download.");
            return;
        }

        getFile(args[0]);
    }
}