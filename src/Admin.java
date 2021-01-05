public class Admin {
    private static volatile Admin admin;

    private Admin() {
    }

    public static Admin getInstance(String value) {
        if (admin == null) {
            synchronized (Admin.class) {
                if (admin == null) {
                    admin = new Admin();
                }
            }
        }
        return admin;
    }
}
