package HW11;

public class TestLoginUtil {
    public static void main(String[] args) {
        LoginUtil.isUserAuthentic("baklajan241","468s4afsas", null);
        LoginUtil.isUserAuthentic("Valera","Sapojnik","Sapojnik");//login doesn't exist in database
    }
}
