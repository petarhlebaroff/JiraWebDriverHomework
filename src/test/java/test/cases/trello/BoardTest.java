package test.cases.trello;

import org.asynchttpclient.util.Assertions;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

import org.junit.Test;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardTest extends BaseTest {




    @Test
    public void test1_createBoardWhenCreateBoardClicked() {

        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();
    }


    @Test
    public void test2_createNewCardInExistingBoardWhenCreateCardClicked() {

        login();
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());

        boardsPage.clickOnBoard(getUIMappingByKey("trello.boardName"));

        BoardPage boardPage = new BoardPage(actions.getDriver());
        String cardName = getUIMappingByKey("trello.cardName");
        boardPage.addCardToFirstList(cardName);
        boardPage.assertAddCardExists();
        String listName = "To Do";
        boardPage.assertCardInList(cardName, listName);

    }

    @Test
    public void test3_moveCardBetweenStatesWhenDragAndDropIsUsed() {
        login();
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());

        boardsPage.clickOnBoard(getUIMappingByKey("trello.boardName"));
        BoardPage boardPage = new BoardPage(actions.getDriver());
        String cardName = getUIMappingByKey("trello.cardName");
        String listName = "Doing";
        String firstListName = "To Do";
        boardPage.moveCardToList(cardName, listName);
        boardPage.assertCardInList(cardName, listName);
        boardPage.assertCardNotInList(firstListName, cardName);

    }

    @Test
    public void test4_deleteBoardWhenDeleteButtonIsClicked() {
        login();
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());

        boardsPage.clickOnBoard(getUIMappingByKey("trello.boardName"));
        BoardPage boardPage = new BoardPage(actions.getDriver());
        String boardName = getUIMappingByKey("trello.boardName");
        boardPage.deleteBoard(boardName);
        boardPage.assertBoardDeleted(boardName);

    }
}
