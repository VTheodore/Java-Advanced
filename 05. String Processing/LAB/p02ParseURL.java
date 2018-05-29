package L05StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();

        String[] url = input.split("://");

        if (url.length != 2){
            System.out.println("Invalid URL");
            return;
        }

        String protocol = url[0];
        String server = url[1].substring(0, url[1].indexOf("/"));
        String resources = url[1].substring(url[1].indexOf("/") + 1);


        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);
    }
}
