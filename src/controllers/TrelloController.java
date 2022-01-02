package controllers;

import entities.User;
import repositories.BoardListRepo;
import repositories.BoardRepo;
import repositories.CardRepo;
import repositories.UserRepo;
import services.BoardListService;
import services.BoardService;
import services.CardService;

public class TrelloController {

    BoardRepo boardRepo = new BoardRepo();
    BoardListRepo boardListRepo = new BoardListRepo();
    UserRepo userRepo = new UserRepo();
    CardRepo cardRepo = new CardRepo();
    BoardService boardService = new BoardService();
    BoardListService boardListService = new BoardListService();
    CardService cardService = new CardService();

    //User functions
    public void initializeUsers(){
        User user1 = new User("user1", "gaurav", "gaurav@workat.tech");
        User user2 = new User("user2", "chandak", "chandak@workat.tech");
        User user3 = new User("user3", "mukesh", "mukesh@workat.tech");

        userRepo.createUser(user1);
        userRepo.createUser(user2);
        userRepo.createUser(user3);

    }


    //BOARD functions
    public void show(){
        boardService.show(boardRepo);
    }

    public void showBoard(int id){
        boardService.showBoard(id, boardRepo);
    }

    public void updateBoardName(int id, String name){
        boardService.updateName(boardRepo, id, name);
    }

    public void updateBoardPrivacy(int id, String privacy){
        boardService.updatePrivacy(boardRepo, id, privacy);
    }

    public void createBoard(String name){
        boardService.createBoard(boardRepo, name);
    }

    public void addBoardMember(int id, String userId){
        boardService.addMember(boardRepo, userRepo, id, userId);
    }

    public void removeBoardMember(int id, String userId){
        boardService.removeMember(boardRepo, userRepo, id, userId);
    }

    public void deleteBoard(int id){
        boardService.deleteBoard(boardRepo, id);
    }


    //List functions
    public void createList(int boardId, String name){
        boardListService.createList(boardId, name, boardRepo, boardListRepo);
    }

    public void showBoardList(int id){
        boardListService.showList(id, boardListRepo);
    }

    public void updateListName(int id, String name){
        boardListService.updateName(boardRepo, boardListRepo, id, name);
    }

//    public void deleteList(int id){
//        boardListService.deleteList(boardRepo, boardListRepo, id);
//    }


    //CARD functions

    public void createCard(int listId, String name){
        cardService.createCard(listId, name, cardRepo, boardListRepo, boardRepo);
    }

    public void updateCardName(int id, String name){
        cardService.updateName(boardRepo, boardListRepo, cardRepo, id, name);
    }

    public void updateCardDescription(int id, String description){
        cardService.updateDescription(boardRepo, boardListRepo, cardRepo, id, description);
    }

    //todo: check if this memmber is also a member of the board or not
    public void assignCard(int id, String userEmail){
        cardService.assign(userRepo, boardRepo, boardListRepo, cardRepo, id, userEmail);
    }

    public void unAssignCard(int id){
        cardService.unassign(userRepo, boardRepo, boardListRepo, cardRepo, id);
    }

    public void moveCard(int cardId, int fromListId, int toListId){
        cardService.move(boardRepo, boardListRepo, cardRepo, cardId, fromListId, toListId);
    }

    public void showCard(int id) {

        cardService.show(id, cardRepo);

    }
}
