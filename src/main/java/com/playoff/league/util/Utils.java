package com.playoff.league.util;

import java.io.*;

public class Utils {

    public static String getFileData(File file) {
        StringBuilder sb = new StringBuilder();
        try{
            InputStream is = new FileInputStream(file);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();

            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }


        return sb.toString();
    }

    public static String streamToString(InputStream is){
        StringBuilder sb = new StringBuilder();
        try{

            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();

            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }


        return sb.toString();
    }

    public static void dumpData(String data){
//        try{
//
//
//            PrintWriter out = new PrintWriter("/Users/jessereim/dev/personal/projects/League/data/filename.txt");
//            out.println(data);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            System.exit(-1);
//        }

        File file = new File("/Users/jessereim/dev/personal/projects/League/data18/filename.txt");
        writeFile(file,data);

    }

    public static void writeFile(String data, String topPlayer){
        File file = new File("/Users/jessereim/dev/personal/projects/League/data18/html/scoringSheet.html");
        String finalTemplate = getFileData(file);

        String finalPageData = String.format(finalTemplate, topPlayer, data);
        File outFile = new File("/Users/jessereim/dev/personal/projects/League/data18/scoringSheet.html");
        writeFile(outFile , finalPageData);

    }

    public static void writeFile(File file , String data){
        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = data.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
