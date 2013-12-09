package de.kifaru.minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

    static private Position givenPosition = new Position(1, 2);
    
    @Test
    public void putMine_onEmptyField() {
        final Board board = makeEmptyBoard();
        whenPutMine(board);
        thenMine(board);
    }

    @Test
    public void putMine_replaceImpactField() {
        final Board board = makeBoardWithImpactField();
        whenPutMine(board);
        thenMine(board);
    }

    @Test
    public void putMine_onMineField() {
        final Board board = makeBoardWithMineField();
        whenPutMine(board);
        thenMine(board);
    }

    private Board makeEmptyBoard() {
        return new Board();
    }
    
    private Board makeBoardWithMineField() {
        final Board board = new Board();
        board.put(givenPosition, new MineField());
        return board;
    }

    private Board makeBoardWithImpactField() {
        final Board board = new Board();
        board.put(givenPosition, new ImpactField(1));
        return board;
    }

    private void whenPutMine(final Board board) {
        board.putMine(givenPosition);
    }

    private void thenMine(final Board board) {
        final Field field = board.get(givenPosition);
        assertTrue(field instanceof MineField);
    }
}
