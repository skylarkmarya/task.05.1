import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String gString = null;
        for(;;){
            System.out.println("For see files in directory and choice path press - 1");
            System.out.println("For work with files press - 2");
            System.out.println("For deleted files press - 3");
            System.out.println("For exit press - 'q'");
            System.out.println("Enter you choice:");
            String choice = in.nextLine();
            if( "q".equals(choice))
                break;
            switch (choice){
                case "1":

                    System.out.println("You choice see directory");
                    System.out.println("(For example: D:\\My tasks\\JAVA\\MASHA JAVA\\s0501\\src\\test)");
                    System.out.println("Enter full path: ");
                    String s = in.nextLine();
                    File f = new File(s);
                    try{
                        String[] sDirList = f.list();
                        int i;
                        assert sDirList != null;
                        for(i = 0; i < sDirList.length; i++)
                        {
                            File f1 = new File(s + File.separator + sDirList[i]);
                            if(f1.isFile())
                                System.out.println(sDirList[i]);
                            else
                                System.out.println("-dir- " + sDirList[i]);
                        }
                        gString = s + "\\";
                        System.out.println("Directory is remembered.");}
                    catch (NullPointerException n){
                        if (!f.exists()) {
                            System.out.println("\nNot found: " + s);
                            break;
                        }
                        if (!f.isDirectory()) {
                            System.out.println("\nNot directory: " + s);
                            break;
                        }
                    }
                    break;
                case "2":
                    System.out.println("Enter file name (\"fileA\"):");
                    String fileName = in.nextLine();
                    File text = new File(gString + fileName +".txt");
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(text, true));
                        writer.write("Hello World!!!\n");
                        writer.flush();
                        writer.close();

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("Enter deleted file name (\"test\"):");
                    String dFile = in.nextLine();
                    File deleteFile = new File(gString + "\\" + dFile + ".txt");
                    if (deleteFile.delete()){
                        System.out.println("File deleted!");
                    }else {
                        System.out.println("File not found, check path.");
                    }
                    break;
            }
        }
    }
}