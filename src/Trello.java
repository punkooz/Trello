import controllers.TrelloController;

public class Trello {

    public static void main(String[] args){

        TrelloController trelloController = new TrelloController();

        trelloController.initializeUsers();

        trelloController.show();

        trelloController.createBoard("work@tech");

        trelloController.showBoard(1);

        trelloController.show();

        trelloController.updateBoardName(1, "workat.tech");
        trelloController.updateBoardPrivacy(1, "PRIVATE");

        trelloController.showBoard(1);

        trelloController.createBoard("workat");

        trelloController.show();

        trelloController.addBoardMember(1, "user1");
        trelloController.addBoardMember(1, "user2");
        trelloController.addBoardMember(1, "user3");

        trelloController.removeBoardMember(1, "user2");

        trelloController.showBoard(1);

        trelloController.deleteBoard(2);

        trelloController.showBoard(2);

        trelloController.show();

        trelloController.createList(1, "Mock Interviews");

        trelloController.showBoardList(1);

        trelloController.updateListName(1, "Mock Interviews");

        trelloController.showBoardList(1);

        trelloController.createList(1, "Mock Interviews - Scheduled");

        trelloController.showBoard(1);

        trelloController.createCard(1, "abcd@gmail.com");

        trelloController.createCard(1, "abcda@gmail.com");

        trelloController.showBoardList(1);

        trelloController.updateCardName(1, "abcde@gmail.com");

        trelloController.updateCardDescription(1, "AT 7 PM");

        trelloController.showBoardList(1);

        trelloController.assignCard(1, "gaurav@workat.tech");

        trelloController.showCard(1);

        trelloController.moveCard(1, 1, 2);

        trelloController.showBoardList(1);
        trelloController.showBoardList(2);

        trelloController.unAssignCard(1);

        trelloController.show();

    }

}
