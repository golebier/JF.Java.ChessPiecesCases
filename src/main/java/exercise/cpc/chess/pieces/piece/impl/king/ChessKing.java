package exercise.cpc.chess.pieces.piece.impl.king;

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
public class ChessKing extends ChessPieceBase implements ChessPiece {
    
    public ChessKing(int x, int y) {
        super(x, y);
    }
    
    public ChessKing(Position xy) {
        super(xy);
    }
    
    @Override
    public boolean checkCollisions(List<Position> freePositions, List<Position> piecesPositions) {
        for (Position myFreeposition : freePositions) {
            if (hasGotCollision(myFreeposition, piecesPositions)) {
                continue;
            }
            removeCollisionsPositions(myFreeposition, freePositions);
            xy = myFreeposition;
            piecesPositions.add(myFreeposition);
            return true;
        }
        // this mean we could not find free position to set this piece, then this variation is wrong
        return false;
    }
    
    // TODO name is deprecated, change it
    private void removeCollisionsPositions(Position myFreeposition, List<Position> freePositions) {
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
    
    private boolean hasGotCollision(Position myFreeposition, List<Position> piecesPositions) {
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
}
