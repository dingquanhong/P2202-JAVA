package classlib;

public class Booklist {
  int listid;
  String userid;
  String list;

    public Booklist(int listid, String userid, String list) {
        this.listid = listid;
        this.userid = userid;
        this.list = list;
    }

    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
