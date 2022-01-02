package entities;

import java.util.List;

public class Board {

    static int idCounter = 0;
    int id;
    String name;
    String url;
    String privacy;
    List<User> membersInBoard;
    List<BoardList> listsInBoard;

    public Board(String name) {
        this.name = name;
        this.id = ++idCounter;
        setPrivacy("PUBLIC");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public List<User> getMembersInBoard() {
        return membersInBoard;
    }

    public void setMembersInBoard(List<User> membersInBoard) {
        this.membersInBoard = membersInBoard;
    }

    public List<BoardList> getListsInBoard() {
        return listsInBoard;
    }

    public void setListsInBoard(List<BoardList> listsInBoard) {
        this.listsInBoard = listsInBoard;
    }
}
