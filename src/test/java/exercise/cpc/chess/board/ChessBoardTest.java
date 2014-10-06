package exercise.cpc.chess.board;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import org.testng.annotations.Test;

import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.impl.base.ChessPieceBase;
import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;

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
    public void f() {
        // TODO now just to fast check the idea
        ChessBoard chessBoard = new ChessBoard(new DataInputDimensions(3, 3));
        
        // TEST using free positions
        // TEST try place the piece
        // TEST revert changes if piece has collision << when checking has collision then free positions to use them later
        // TEST try place next piece
        ChessPiece piece = new ChessPieceBase();
        chessBoard.placePieceInPlaceWhereHasNotGotCollisions(piece);
    }
}