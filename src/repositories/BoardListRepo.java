package repositories;

import entities.BoardList;
import entities.User;

import java.util.HashMap;

public class BoardListRepo {

    HashMap<Integer, BoardList> boardListHashMap;

    public BoardListRepo() {
        this.boardListHashMap = new HashMap<>();
    }

    public void createList(BoardList boardList){
        boardListHashMap.put(boardList.getId(), boardList);
    }

    public void udpateList(BoardList boardList){
        boardListHashMap.put(boardList.getId(), boardList);
    }

    public BoardList getListById(int id){
        return boardListHashMap.get(id);
    }

}
