package repositories;

import entities.BoardList;
import entities.Card;

import java.util.HashMap;

public class CardRepo {

    HashMap<Integer, Card> cardHashMap;

    public CardRepo() {
        this.cardHashMap = new HashMap<>();
    }

    public void createCard(Card card){
        cardHashMap.put(card.getId(), card);
    }

    public void udpateCard(Card card){
        cardHashMap.put(card.getId(), card);
    }

    public Card getCardById(int id){
        return cardHashMap.get(id);
    }

}
