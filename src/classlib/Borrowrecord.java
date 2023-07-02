package classlib;

public class Borrowrecord {
     int ID;
     int BorrowBookID;
     String BorrowUserID;
     String BorrowDate;
     String ReturenDate;
     int status;
    @Override
    public String toString() {
        return this.getBorrowUserID()+":"+getBorrowBookID();
    }

    public Borrowrecord(int ID, int borrowBookID, String borrowUserID, String borrowDate, String returenDate, int status) {
        this.ID = ID;
        BorrowBookID = borrowBookID;
        BorrowUserID = borrowUserID;
        BorrowDate = borrowDate;
        ReturenDate = returenDate;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBorrowBookID() {
        return BorrowBookID;
    }

    public void setBorrowBookID(int borrowBookID) {
        BorrowBookID = borrowBookID;
    }

    public String getBorrowUserID() {
        return BorrowUserID;
    }

    public void setBorrowUserID(String borrowUserID) {
        BorrowUserID = borrowUserID;
    }

    public String getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        BorrowDate = borrowDate;
    }

    public String getReturenDate() {
        return ReturenDate;
    }

    public void setReturenDate(String returenDate) {
        ReturenDate = returenDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
