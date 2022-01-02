package services;

import entities.Board;
import entities.BoardList;
import entities.Card;
import entities.User;
import repositories.BoardRepo;
import repositories.UserRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
    public void show(BoardRepo boardRepo) {

        HashMap<Integer, Board> boardHashMap = boardRepo.getBoardHashMap();

        if (boardHashMap == null || boardHashMap.size() == 0){
            System.out.println("No Boards");
            return;
        }

        for (Map.Entry<Integer, Board> boardEntry : boardHashMap.entrySet()){
            Board board = boardEntry.getValue();

            System.out.println("id = " + board.getId() + ", name = " + board.getName() + ", privacy = " + board.getPrivacy());

            printBoard(board);

        }

    }

    private void printBoard(Board board) {

        String url = board.getUrl();
        List<User> membersInBoard = board.getMembersInBoard();
        List<BoardList> listsInBoard = board.getListsInBoard();

        if (listsInBoard != null && listsInBoard.size() > 0){
            System.out.print(", lists : [ ");
            for (BoardList bList : listsInBoard){
                System.out.print(" listId = " + bList.getId() + ", name = " + bList.getName());
                List<Card> cardList = bList.getCardList();

                if (cardList != null && cardList.size() > 0){
                    System.out.print(", cards : [ ");
                    for (Card card : cardList){
                        System.out.print(" cardId = " + card.getId() + ", name = " + card.getName());
                        String description = card.getDescription();
                        if (description != null)
                            System.out.print(", description = " + card.getName());

                        System.out.print(" | ");
                    }
                    System.out.print(" ] ");
                }
                System.out.print(" | ");
            }
            System.out.print(" ] ");
        }

        if (membersInBoard != null && membersInBoard.size() > 0){
            System.out.print(", members : [ ");
            for (User member : membersInBoard){
                System.out.print(" memberId = " + member.getUserId() + ", name = " + member.getName() + ", email = " + member.getEmail());
            }
            System.out.print(" ] ");
        }

        if (url != null){
            System.out.print(" [ url = " + url);
        }

    }

    public void showBoard(int id, BoardRepo boardRepo) {

        Board board = boardRepo.getBoardById(id);

        if (board == null){
            System.out.println("Board: " + id + " does not exist");
            return;
        }

        printBoard(board);

    }

    public void updateName(BoardRepo boardRepo, int id, String name) {

        Board board = boardRepo.getBoardById(id);

        board.setName(name);

        boardRepo.udpateBoard(board);

    }

    public void updatePrivacy(BoardRepo boardRepo, int id, String privacy) {

        Board board = boardRepo.getBoardById(id);

        board.setPrivacy(privacy);

        boardRepo.udpateBoard(board);

    }

    public void createBoard(BoardRepo boardRepo, String name) {

        Board board = new Board(name);

        boardRepo.createBoard(board);

    }

    public void addMember(BoardRepo boardRepo, UserRepo userRepo, int id, String userId) {
        Board board = boardRepo.getBoardById(id);

        List<User> membersInBoard = board.getMembersInBoard();

        if (membersInBoard == null)
            membersInBoard = new ArrayList<>();

        HashMap<String, User> userHashMap = userRepo.getUserHashMap();

        User user = null;

        for (Map.Entry<String, User> userEntry : userHashMap.entrySet()){
            if (userEntry.getValue().getUserId().equals(userId)){
                user = userEntry.getValue();
            }
        }

        if (user == null){
            System.out.println(userId + " not found in system for adding to board");
        }

        membersInBoard.add(user);

        board.setMembersInBoard(membersInBoard);

        boardRepo.udpateBoard(board);
    }

    public void removeMember(BoardRepo boardRepo, UserRepo userRepo, int id, String memberEmail) {

        Board board = boardRepo.getBoardById(id);

        List<User> membersInBoard = board.getMembersInBoard();

        if (membersInBoard == null)
            membersInBoard = new ArrayList<>();

        membersInBoard.remove(userRepo.getUserByEmail(memberEmail));

        board.setMembersInBoard(membersInBoard);

        boardRepo.udpateBoard(board);

    }

    public void deleteBoard(BoardRepo boardRepo, int id) {

        Board board = boardRepo.getBoardById(id);

        boardRepo.removeBoard(board);

    }
}
