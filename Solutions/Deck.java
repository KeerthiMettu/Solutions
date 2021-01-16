import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Deck.java
 * 
 * @brief A class that represents a deck of playing cards
 * 
 * @details
 * This class is responsible for shuffling and dealing a deck of cards. The deck should
 * contain 52 cards A,2 - 10, J,Q K or four suits and jokers.
 */
class Deck 
{
  //class variable declarations
  Card.Suit suit;
  Card.Value value;
  Card mycard;
  ArrayList<Card> allcards = new ArrayList<Card>() ;

  //instantiating all 52 cards to card object and an arraylist in constructor
  public Deck() 
  {
    for(Card.Suit s: Card.Suit.values()){
      for(Card.Value v:Card.Value.values()){
        mycard = new Card(v, s);
        allcards.add(mycard); 
      }
    }
  }
  
  //function that deals with N sets and M cards 
  public void deal_hand( int sets, int cards ) 
  {
    //get total elements to print through deal_hand
    int totalCards=sets*cards;
    int rowLen=cards;
    //instantiate a new array list with required sets of cards.
    ArrayList<Card> setsList = new ArrayList<Card>(allcards.subList(1, totalCards+1));
    /*printing the cards in sets and breaks line when printing after each set*/
    for(Card c:setsList){
      c.print();
      if(rowLen >1)
        rowLen -=1;
      else{
        System.out.println("");
        rowLen = cards;
      }
    }
  }
  
  /*
    method that prints each of the card value along with suit from an array list
  */ 
  public void print_deck() 
  { 
    int rowLength =0;
    //iterates through each card and break at each row
    for(Card c: allcards){
      c.print();
      if(rowLength <13)
        rowLength +=1;
      else{
        System.out.println("");
        rowLength =0;
      }

    }
  }
  
  //method for shuffling the cards (in arraylist) using the random generator seed value
  public void shuffle( int seed ) 
  {
     Random randomNumber = new Random(seed);
     Collections.shuffle(allcards, randomNumber);
  }
  
  //function to arrange cards in ascending order of suits and values
  public void sort() 
  {
    for(int i=0;i<allcards.size();i++){
      for(int j=allcards.size() -1; j>i;j--){
          Card c1= allcards.get(i);
          Card c2= allcards.get(j);
          //re-arrange positions if the beginning card is greater than end card value
          if( c1.is_greater_than(c2) || c1.is_equal(c2))
          { 
            //simple swap logic
            Card temp = c1;
            allcards.set(i,allcards.get(j));
            allcards.set(j,temp);
          }
      }
    }
  }  
}