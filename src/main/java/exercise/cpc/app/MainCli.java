package exercise.cpc.app;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

import exercise.cpc.chess.board.ChessBoard;
import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.impl.knight.ChessKnight;
import exercise.cpc.chess.pieces.piece.impl.rook.ChessRook;
import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;
import exercise.cpc.data.output.display.DataOutputDisplay;

/**
 *  Core main file, runs all needed.
 *  Now just basic to began.
 *  // TODO add more, correct doc.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class MainCli {
    private static final int OK_EXIT_STATUS = 0;
    private static final String CONTEXT_PATH = "main-context.xml";
    
    public static void main(String[] args) throws IOException {
        final ConfigurableApplicationContext applicationContext = loadContext(CONTEXT_PATH);
        
        if (null != applicationContext) {
            // TODO add more
        }
        
        // TODO more spring like ..
        new MainCli().runCoreLogic(args);
    }
    
    public void runCoreLogic(String[] args) throws IOException {
        long baganAt = System.currentTimeMillis();
        List<ChessBoard> boards = new ArrayList<ChessBoard>();
        // TODO get board dimensions from parameters
        //        DataInputReaderSimple dataInputReaderSimple = new DataInputReaderSimple(new DataInputReaderDimensions(),
        //                new DataInputReaderPieces());
        //        DataInput di = dataInputReaderSimple.read(args);
        DataInputDimensions did = new DataInputDimensions(4, 4);
        DataOutputDisplay dod = new DataOutputDisplay();
        List<ChessPiece> piecesList = new ArrayList<ChessPiece>();
        // FIXME 2K & R, should have 4Boards
        // FIXME B & R, should have 8Boards
        
        //        piecesList.add(new ChessKing(did));
        //        piecesList.add(new ChessKing(did));
        //        piecesList.add(new ChessKnight(did));
        //        piecesList.add(new ChessQueen(did));
        //        piecesList.add(new ChessQueen(did));
        //        piecesList.add(new ChessBishop(did));
        //        piecesList.add(new ChessBishop(did));
        //        
        piecesList.add(new ChessRook(did));
        piecesList.add(new ChessRook(did));
        piecesList.add(new ChessKnight(did));
        piecesList.add(new ChessKnight(did));
        piecesList.add(new ChessKnight(did));
        piecesList.add(new ChessKnight(did));
        
        //        //        piecesList.add(new ChessKing(did));
        //        //        piecesList.add(new ChessKing(did));
        //        //        piecesList.add(new ChessKing(did));
        //        
        //        //        piecesList.add(new ChessKing(did));
        //        //        piecesList.add(new ChessKing(did));
        //        //        piecesList.add(new ChessRook(did));
        
        final List<List<ChessPiece>> listOfpiecesList = preparePiecesLists(piecesList);
        for (final List<ChessPiece> currentList : listOfpiecesList) {
            for (int x = 0; x < did.getN(); ++x) {
                for (int y = 0; y < did.getM(); ++y) {
                    final ChessBoard chessBoard = new ChessBoard(did);
                    chessBoard.initialize(x, y);
                    boolean isValid = false;
                    for (ChessPiece piece : currentList) {
                        isValid = chessBoard.placePieceInPlaceWhereHasNotGotCollisions(piece);
                        if (!isValid) {
                            break;
                        }
                    }
                    if (!isValid) {
                        continue;
                    }
                    //                    System.out.println("T");
                    // TODO bez contains, ale ze sprawdzeniem contains @ preparePiecesLists 
                    if (boards.contains(chessBoard)) {
                        continue;
                    }
                    boards.add(chessBoard);
                }
            }
        }
        System.out.println("DoneIn: " + (System.currentTimeMillis() - baganAt) + ", Boards variants: " + boards.size());
        for (ChessBoard chessBoard : boards) {
            System.out.println("++++++++++++++++++++ >>>> ");
            dod.print(chessBoard);
            System.out.println("++++++++++++++++++++ <<<< ");
            System.out.println();
        }
        System.out.println("DoneIn: " + (System.currentTimeMillis() - baganAt) + ", Boards variants: " + boards.size());
        System.exit(OK_EXIT_STATUS);
    }
    
    /* TODO pseudo code now, just to see how to do this ;)
    boolean prepareBeard(int xToStart, int yToStart, Board board) {
        // sortedListOfPiecesToPlaceOnBoard more invasive on front, then less moves are needed
        for (Piece piece : sortedListOfPiecesToPlaceOnBoard) {
            // this method fill the list of free positions to use if new piece has not got collisions
            // and place the piece on board
            if (!board.placePieceInPlaceWhereHasNotGotCollisions(piece)) {
                return false;
            }
        }
        return true;
    }
     */
    
    private List<List<ChessPiece>> preparePiecesLists(List<ChessPiece> piecesList) {
        List<List<ChessPiece>> listOfpiecesList = new ArrayList<List<ChessPiece>>();
        ChessPiece[] sorted = piecesList.toArray(new ChessPiece[piecesList.size()]);
        permute(sorted, 0, listOfpiecesList);
        System.out.println();
        for (List<ChessPiece> pieces : listOfpiecesList) {
            for (ChessPiece piece : pieces) {
                System.out.print(piece.getName());
            }
            System.out.println(listOfpiecesList.size());
        }
        return listOfpiecesList;
    }
    
    private void permute(ChessPiece[] word, int k, List<List<ChessPiece>> piecesList) {
        if (word.length == k) {
            addList(word, piecesList);
        } else {
            prepareLists(word, k, piecesList);
        }
    }
    
    private void addList(ChessPiece[] word, List<List<ChessPiece>> piecesList) {
        List<ChessPiece> pieces = new ArrayList<ChessPiece>();
        pieces.addAll(Arrays.asList(word));
        boolean notExists = true;
        for (List<ChessPiece> listOfPieces : piecesList) {
            if (ListUtils.isEqualList(listOfPieces, pieces)) {
                notExists = false;
                break;
            }
        }
        if (notExists) {
            piecesList.add(pieces);
        }
    }
    
    private void prepareLists(ChessPiece[] word, int k, List<List<ChessPiece>> piecesList) {
        for (int i = k; i < word.length; i++) {
            if (i + 1 < word.length && 0 == word[i].compareTo(word[i + 1])) {
                continue;
            }
            swap(word, i, k);
            for (int l = k + 1; l <= i; l++) {
                if (0 < word[l].compareTo(word[i])) {
                    swap(word, l, i);
                }
            }
            permute(word, k + 1, piecesList);
            for (int l = i; l >= k + 1; l--) {
                if (0 > word[l].compareTo(word[i])) {
                    swap(word, l, i);
                }
            }
            swap(word, i, k);
        }
    }
    
    private void swap(ChessPiece[] s, int index, int i) {
        ChessPiece temp = s[index];
        s[index] = s[i];
        s[i] = temp;
    }
    
    protected static ConfigurableApplicationContext loadContext(final String contextPath) {
        final GenericApplicationContext ctx = new GenericApplicationContext();
        final XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
        xmlReader.loadBeanDefinitions(new ClassPathResource(contextPath));
        final PropertyPlaceholderConfigurer placeholderProcessor = new PropertyPlaceholderConfigurer();
        ctx.addBeanFactoryPostProcessor(placeholderProcessor);
        ctx.refresh();
        return ctx;
    }
}
