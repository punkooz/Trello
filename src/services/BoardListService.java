package services;

import entities.Board;
import entities.BoardList;
import repositories.BoardListRepo;
import repositories.BoardRepo;

import java.util.ArrayList;
import java.util.List;

public class BoardListService {
    public void createList(int boardId, String name, BoardRepo boardRepo, BoardListRepo boardListRepo) {

        BoardList boardList = new BoardList(name);

        boardListRepo.createList(boardList);

        Board board = boardRepo.getBoardById(boardId);

        boardList.setMemberOfBoard(board);

        List<BoardList> listsInBoard = board.getListsInBoard();

        if (listsInBoard == null)
            listsInBoard = new ArrayList<>();

        listsInBoard.add(boardList);

        board.setListsInBoard(listsInBoard);

        boardListRepo.udpateList(boardList);

        boardRepo.udpateBoard(board);

    }

    public void showList(int id, BoardListRepo boardListRepo) {
    }

    public void updateName(BoardRepo boardRepo, BoardListRepo boardListRepo, int id, String name) {
    }
}
