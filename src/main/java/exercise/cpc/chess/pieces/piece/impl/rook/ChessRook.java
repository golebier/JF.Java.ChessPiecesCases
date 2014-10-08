package exercise.cpc.chess.pieces.piece.impl.rook;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.List;

import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.impl.base.ChessPieceBase;
import exercise.cpc.chess.pieces.piece.position.Position;

/**
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class ChessRook extends ChessPieceBase implements ChessPiece {
    
    public ChessRook(int x, int y) {
        super(x, y);
    }
    
    public ChessRook(Position xy) {
        super(xy);
    }
    
    // TODO name is deprecated, change it
    protected void placePieceOnBoard(Position myFreeposition, List<Position> freePositions) {
        freePositions.remove(myFreeposition);
        int x = myFreeposition.getX();
        int y = myFreeposition.getY();
        
        Position tmp = new Position(x - 1, y - 1);
        freePositions.remove(tmp);
        tmp.setX(x);
        //        tmp.setY(y - 1);
        freePositions.remove(tmp);
        //                    tmp.setX(x);
        tmp.setY(y + 1);
        freePositions.remove(tmp);
        tmp.setX(x + 1);
        //                    tmp.setY(y - 1);
        freePositions.remove(tmp);
        tmp.setX(x - 1);
        tmp.setY(y);
        freePositions.remove(tmp);
        tmp.setX(x + 1);
        //                    tmp.setY(y);
        freePositions.remove(tmp);
        tmp.setX(x + 1);
        tmp.setY(y + 1);
        freePositions.remove(tmp);
        tmp.setX(x - 1);
        tmp.setY(y + 1);
        freePositions.remove(tmp);
    }
    
    protected boolean hasGotCollision(Position myFreeposition, List<Position> piecesPositions) {
        int x = myFreeposition.getX();
        int y = myFreeposition.getY();
        
        Position tmp = new Position(x - 1, y - 1);
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        tmp.setX(x);
        //        tmp.setY(y - 1);
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        //                    tmp.setX(x);
        tmp.setY(y + 1);
        ;
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        tmp.setX(x + 1);
        //                    tmp.setY(y - 1);
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        tmp.setX(x - 1);
        tmp.setY(y);
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        tmp.setX(x + 1);
        //                    tmp.setY(y);
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        tmp.setX(x + 1);
        tmp.setY(y + 1);
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        tmp.setX(x - 1);
        tmp.setY(y + 1);
        if (piecesPositions.contains(tmp)) {
            return true;
        }
        return false;
    }
    
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "R";
    }
}
