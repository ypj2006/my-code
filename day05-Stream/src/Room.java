import java.util.*;

public class Room {
    List<Card> allCards = new ArrayList<>();
    {
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♠", "♥", "♣", "♦"};
        int count = 0;
        for (String num : nums) {
            count++;
            for (String color : colors) {
                allCards.add(new Card(num, color, count));
            }
        }
        Collections.addAll(allCards, new Card("", "joker", ++count), new Card("", "JOKER",++count));
    }
    public void start() {
        Collections.shuffle(allCards);

        Map<String, List<Card>> players = new HashMap<>();
        List<Card> card1 = new ArrayList<>();
        players.put("player1", card1);
        List<Card> card2 = new ArrayList<>();
        players.put("player2", card2);
        List<Card> card3 = new ArrayList<>();
        players.put("player3", card3);


        for (int i = 0; i < allCards.size()-3; i++) {
            Card card = allCards.get(i);
            if (i % 3 == 0) {
                card1.add(card);
            } else if (i % 3 == 1) {
                card2.add(card);
            } else {
                card3.add(card);
            }
        }

        List<Card> lastCards = allCards.subList(allCards.size()-3, allCards.size());
        System.out.println("底牌是: " + lastCards);

        Random random = new Random();
        int index = random.nextInt(3);
        String winner = "";
        switch (index) {
            case 0:
                System.out.println("地主是：" + "player1");
                card1.addAll(lastCards);
                break;
            case 1:
                System.out.println("地主是：" + "player2");
                card2.addAll(lastCards);
                break;
            case 2:
                System.out.println("地主是：" + "player3");
                card3.addAll(lastCards);
                break;
        }

        sortCards(card1);
        sortCards(card2);
        sortCards(card3);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


        for(String name : players.keySet()){
            List<Card> cards = players.get(name);
            System.out.println(name + "的牌是: " + cards);
        }

    }

    private void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getValue() - o2.getValue();
            }
        });
    }
}
