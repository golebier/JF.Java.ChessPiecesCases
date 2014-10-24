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
import java.util.List;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

import exercise.cpc.chess.board.ChessBoard;
import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.impl.bishop.ChessBishop;
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
        DataInputDimensions did = new DataInputDimensions(3, 3);
        
        // TODO change this, olny for debug now
        DataOutputDisplay dod = new DataOutputDisplay();
        // TODO generate this from DataInput
        // TODO should be sorted from most invassive to the less
        List<ChessPiece> piecesList = new ArrayList<ChessPiece>();
        // FIXME 2K & R, should have 4Boards
        piecesList.add(new ChessBishop(did));
        piecesList.add(new ChessRook(did));
        //        piecesList.add(new ChessKing(did));
        //        piecesList.add(new ChessKing(did));
        //        piecesList.add(new ChessKing(did));
        // remember used positions pear the piece, then removing will not be needed
        for (int x = 0; x < did.getN(); ++x) {
            for (int y = 0; y < did.getM(); ++y) {
                ChessBoard chessBoard = new ChessBoard(did);
                chessBoard.initialize(x, y);
                boolean isValid = false;
                for (ChessPiece piece : piecesList) {
                    isValid = chessBoard.placePieceInPlaceWhereHasNotGotCollisions(piece);
                    if (!isValid) {
                        break;
                    }
                }
                if (isValid) {
                    System.out.println(">>>> " + isValid);
                    dod.print(chessBoard, piecesList);
                    System.out.println("<<<< " + isValid);
                }
                if (isValid) {
                    boards.add(chessBoard);
                }
            }
        }
        //        System.out.println("--------------Valid boards-(" + boards.size() + ")------------------");
        //        for (ChessBoard chessBoard : boards) {
        //            // TODO this works only if each board has own piecesList, maybe simple write those names in the board?
        //            dod.print(chessBoard, piecesList);
        //            System.out.println("---------------------------------");
        //        }
        System.out.println("DoneIn: " + (System.currentTimeMillis() - baganAt) + ", Boards variants: " + boards.size());
        // TODO just adding final solutions, make this correct when all done.
        // DataInputReaderSimple dataInputReaderSimple = new DataInputReaderSimple(new DataInputReaderDimensions(), new DataInputReaderPieces());
        // dataInputReaderSimple.read(args)
        
        /* TODO first algorithm:
                    // for each position on board try to generate new pieces places to stay/place
                    // if there is no same pieces in list then there is no problem,
                    //   but there are/will be, should remember are this piece in different sequence
                    //   was placed here? or remove clones
                     * 
                     * yep not always is possible to add board,
                     * but where costs are bigger?
                     *  move pieces on board or destroy wrong attempted and start from scratch?
                    if (prepareBeard(x, y, board)) {
                        boards.add(board);
                    }
                    // TODO is more needed here?
                }
            }
            printBoards(boards);
        */
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
