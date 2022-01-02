package entities;

public class Card {

    static int idCounter = 0;
    int id;
    String name;
    String description;
    User assignedUser;
    BoardList memberOfBoardList;

    public Card(String name) {
        this.name = name;
        this.id = ++idCounter;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public BoardList getMemberOfList() {
        return memberOfBoardList;
    }

    public void setMemberOfList(BoardList memberOfBoardList) {
        this.memberOfBoardList = memberOfBoardList;
    }
}
