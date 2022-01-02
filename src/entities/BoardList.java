package entities;

import java.util.List;

public class BoardList {

    static int idCounter = 0;
    int id;
    String name;
    List<Card> cardList;
    Board memberOfBoard;

    public BoardList(String name) {
        this.name = name;
        this.id = ++idCounter;
    }

    public Board getMemberOfBoard() {
        return memberOfBoard;
    }

    public void setMemberOfBoard(Board memberOfBoard) {
        this.memberOfBoard = memberOfBoard;
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

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
