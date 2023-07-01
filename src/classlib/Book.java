package classlib;

public class Book {
    int id;                  //图书编码（自动增序）
    String bookname;          //图书名字
    String author;            //图书作者
    String imgsrc;             //图片
    String describe;             //图书的描述
    String ISBN;                  //图书的一维码编号
    Float score;                 //图书评分
    Float price;                   //图书价格
    int state;                     //图书状态（在库：1  借出：0   已损坏：-1）

    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getbookname() {
        return bookname;
    }

    public void setbookname(String bookname) {
        this.bookname = bookname;
    }
    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }
    public String getimagsrc() {
        return imgsrc;
    }

    public void setimagsrc(String imagsrc) {
        this.imgsrc = imagsrc;
    }
    public String getdescribe() {
        return describe;
    }

    public void setdescribe(String describe) {
        this.describe = describe;
    }
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public Float getscore() {
        return score;
    }
    public void setscore(float score) {
        this.score = score;
    }
    public Float getprice() {
        return price;
    }
    public void setprice(float price) {
        this.price = price;
    }
    public int getstate() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public Book(int id, String bookname, String author, String imgsrc, String describe, String ISBN, Float score , Float price, int state) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.imgsrc = imgsrc;
        this.describe = describe;
        this.ISBN = ISBN;
        this.score = score;
        this.price = price;
        this.state = state;
    }

    @Override
    public String toString() {
        String out = "id:"+id+"\n"+"bookname:"+bookname+"\n"+"author:"+author+"\n"+"imgsrc:"+imgsrc+"\n"+"describe:"+describe+"\n"+"ISBN:"+ISBN+"\n"+"score:"+score+"\n"+"price:"+price+"\n"+"state:"+state+"\n"+"\n";
        return out;
    }
}
