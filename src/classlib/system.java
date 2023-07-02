package classlib;

public class system {
    static String mysql_admin = "root";
    static String mysql_pass = "123456";
    static int avatar;
    static int userid ;

    public static int getUserid() {
        return userid;
    }

    public static void setUserid(int userid) {
        system.userid = userid;
    }

    public static int getAvatar() {
        return avatar;
    }
    public static String avatarpath(){
        String path = "D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\user\\"+getPhone()+".jpg";
        return path;
    }
    public static void setAvatar(int avatar) {
        system.avatar = avatar;
    }

    static String Defaultavatar="D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\avatar.jpg";
    static String user;
    static String phone;
    static String pass;

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        system.pass = pass;
    }

    static int borrownum;

    public static int getBorrownum() {
        return borrownum;
    }

    public static void setBorrownum(int borrownum) {
        system.borrownum = borrownum;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        system.phone = phone;
    }

    public static String format(String s){
        if (!s.contains("/'")){
            s="\""+s+"\"";
        }
        return s;
    }
    public static String getDefaultavatar() {
        return Defaultavatar;
    }

    public static void setDefaultavatar(String defaultavatar) {
        Defaultavatar = defaultavatar;
    }

    static int type;

    public static void setMysql_admin(String mysql_admin) {
        system.mysql_admin = mysql_admin;
    }

    public static void setMysql_pass(String mysql_pass) {
        system.mysql_pass = mysql_pass;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        system.user = user;
    }

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        system.type = type;
    }

    public static String getMysql_pass() {
        return mysql_pass;
    }
    public static String getMysql_admin() {
        return mysql_admin;
    }

}
