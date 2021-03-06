package exercise.cpc.chess.board;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.impl.knight.ChessKnight;
import exercise.cpc.chess.pieces.piece.impl.rook.ChessRook;
import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;
import exercise.cpc.data.output.display.DataOutputDisplay;

/**
 * Board unit tests.
 * I'm Checking is my idea is good or not.
 * After that TODO change tests flow. 
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class ChessBoardTest {
    @Test
    public void simpleNotRealTestJustDisplaywhatHappendWwhenTwoKingsArePlaced() {
        DataInputDimensions did = new DataInputDimensions(4, 4);
        ChessBoard chessBoard = new ChessBoard(did);
        chessBoard.initialize(0, 0);
        
        DataOutputDisplay dod = new DataOutputDisplay();
        List<ChessPiece> piecesList = new ArrayList<ChessPiece>();
        //        piecesList.add(new ChessKing(did));
        //        piecesList.add(new ChessKing(did));
        //        piecesList.add(new ChessKing(did));
        //        piecesList.add(new ChessRook(did));
        //        piecesList.add(new ChessBishop(did));
        //        piecesList.add(new ChessQueen(did));
        piecesList.add(new ChessRook(did));
        piecesList.add(new ChessRook(did));
        piecesList.add(new ChessKnight(did));
        piecesList.add(new ChessKnight(did));
        piecesList.add(new ChessKnight(did));
        piecesList.add(new ChessKnight(did));
        dod.print(chessBoard);
        System.out.println(chessBoard.getFreePositions().size() + ", " + chessBoard.getPiecesPositions().size());
        
        for (ChessPiece piece : piecesList) {
            System.out.println(chessBoard.placePieceInPlaceWhereHasNotGotCollisions(piece));
            dod.print(chessBoard);
            System.out.println(chessBoard.getFreePositions().size() + ", " + chessBoard.getPiecesPositions().size());
        }
    }
    
    @Test
    public void simpleNotTestJustDisplaywhatHappendWwhenTwoKingsArePlaced() {
        // TODO in  present implementation each board will be the same
        // TODO add random first position with checking is not used on prev boards?  
    }
}
