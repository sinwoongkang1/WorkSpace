package day14;

import java.net.InetAddress;

public class NSLookupLocal {
    public static void main(String[] args) {

                try {
                    InetAddress address = InetAddress.getByName("www.google.com");
                    System.out.println(address.getHostAddress());
                    System.out.println(address.getClass());

                    InetAddress localHost = InetAddress.getLocalHost();
                    System.out.println("Host address : "+localHost.getHostAddress());
                    System.out.println("Host name : "+localHost.getHostName());

                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
}
