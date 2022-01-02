package repositories;

import entities.Board;
import entities.BoardList;

import java.util.HashMap;

public class BoardRepo {

    HashMap<Integer, Board> boardHashMap;

    public BoardRepo() {
        this.boardHashMap = new HashMap<>();
    }

    public void createBoard(Board board){
        boardHashMap.put(board.getId(), board);
    }

    public void udpateBoard(Board board){
        boardHashMap.put(board.getId(), board);
    }

    public Board getBoardById(int id){
        return boardHashMap.get(id);
    }

    public HashMap<Integer, Board> getBoardHashMap() {
        return boardHashMap;
    }

    public void removeBoard(Board board){
        boardHashMap.remove(board.getId());
    }
}
