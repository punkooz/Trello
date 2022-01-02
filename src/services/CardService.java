package services;

import entities.Board;
import entities.BoardList;
import entities.Card;
import entities.User;
import repositories.BoardListRepo;
import repositories.BoardRepo;
import repositories.CardRepo;
import repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    public void createCard(int listId, String name, CardRepo cardRepo, BoardListRepo boardListRepo, BoardRepo boardRepo) {

        Card card = new Card(name);

        cardRepo.createCard(card);

        BoardList boardList = boardListRepo.getListById(listId);

        card.setMemberOfList(boardList);

        cardRepo.udpateCard(card);

        updateBoardAndList(card, boardList, boardListRepo, boardRepo);

    }

    private void updateBoardAndList(Card card, BoardList boardList, BoardListRepo boardListRepo, BoardRepo boardRepo) {

        List<Card> cardList = boardList.getCardList();

        if (cardList == null)
            cardList = new ArrayList<>();

        cardList.add(card);

        boardList.setCardList(cardList);

        boardListRepo.udpateList(boardList);

        Board board = boardList.getMemberOfBoard();

        List<BoardList> listsInBoard = board.getListsInBoard();

        for (int i = 0; i < listsInBoard.size(); i++){
            BoardList boardList1 = listsInBoard.get(i);
            if (boardList1.getId() == boardList.getId()){
                listsInBoard.set(i, boardList);
                break;
            }
        }

        board.setListsInBoard(listsInBoard);

        boardRepo.udpateBoard(board);

    }

    public void updateName(BoardRepo boardRepo, BoardListRepo boardListRepo, CardRepo cardRepo, int id, String name) {

        Card card = cardRepo.getCardById(id);

        card.setName(name);

        cardRepo.udpateCard(card);

        BoardList boardList = card.getMemberOfList();

        updateBoardAndList(card, boardList, boardListRepo, boardRepo);

    }

    public void updateDescription(BoardRepo boardRepo, BoardListRepo boardListRepo, CardRepo cardRepo, int id, String description) {

        Card card = cardRepo.getCardById(id);

        card.setDescription(description);

        cardRepo.udpateCard(card);

        BoardList boardList = card.getMemberOfList();

        updateBoardAndList(card, boardList, boardListRepo, boardRepo);

    }

    public void assign(UserRepo userRepo, BoardRepo boardRepo, BoardListRepo boardListRepo, CardRepo cardRepo, int id, String userEmail) {

        Card card = cardRepo.getCardById(id);

        card.setAssignedUser(userRepo.getUserByEmail(userEmail));

        cardRepo.udpateCard(card);

        BoardList boardList = card.getMemberOfList();

        updateBoardAndList(card, boardList, boardListRepo, boardRepo);

    }

    public void unassign(UserRepo userRepo, BoardRepo boardRepo, BoardListRepo boardListRepo, CardRepo cardRepo, int id) {

        Card card = cardRepo.getCardById(id);

        card.setAssignedUser(null);

        cardRepo.udpateCard(card);

        BoardList boardList = card.getMemberOfList();

        updateBoardAndList(card, boardList, boardListRepo, boardRepo);

    }

    public void move(BoardRepo boardRepo, BoardListRepo boardListRepo, CardRepo cardRepo, int cardId, int fromListId, int toListId) {

        Card card = cardRepo.getCardById(cardId);

        card.setMemberOfList(boardListRepo.getListById(toListId));

        cardRepo.udpateCard(card);

        BoardList fromBoardList = boardListRepo.getListById(fromListId);
        BoardList toBoardList = card.getMemberOfList();

        List<Card> cardList = fromBoardList.getCardList();

        cardList.removeIf(card1 -> card1.getId() == card.getId());

        fromBoardList.setCardList(cardList);

        boardListRepo.udpateList(fromBoardList);

        Board board = fromBoardList.getMemberOfBoard();

        List<BoardList> listsInBoard = board.getListsInBoard();

        for (int i = 0; i < listsInBoard.size(); i++){
            BoardList boardList1 = listsInBoard.get(i);
            if (boardList1.getId() == fromBoardList.getId()){
                listsInBoard.set(i, fromBoardList);
                break;
            }
        }

        board.setListsInBoard(listsInBoard);

        boardRepo.udpateBoard(board);

        updateBoardAndList(card, toBoardList, boardListRepo, boardRepo);

    }

    public void show(int id, CardRepo cardRepo) {

        Card card = cardRepo.getCardById(id);

        System.out.println("card name = " + card.getName());

        String description = card.getDescription();

        if (description != null)
            System.out.print(", description = "+ description);

        User assignedUser = card.getAssignedUser();

        if (assignedUser != null)
            System.out.print(", assignedUser = " + assignedUser.getEmail());

    }
}
