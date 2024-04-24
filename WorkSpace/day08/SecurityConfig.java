package day08;

public final class SecurityConfig {
    private static final String ENCRYPTION_KEY = "Complexkey123";

    private SecurityConfig(){};


    public static String getEncryptedPassword() {
        return ENCRYPTION_KEY;
    }


    public static void main(String[] args) {

        String encryptionKey = SecurityConfig.getEncryptedPassword();
        System.out.println("암호화 키 : " + encryptionKey);



    }

}
