package exercise.cpc.chess.pieces.piece.impl.king;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;

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
        // place me in first free position from freePositions, remove this position and check my collisions with rest of objects
        
        // TODO take first free position
        // I can be placed here, but AmI not disturb others?
        
        // TODO maybe move to another free position
        for (Position myFreeposition : freePositions) {
            if (hasNotGotCollisions(myFreeposition, piecesPositions)) {
                List<Position> positionsToRemoveFromFreePositionsList = new ArrayList<Position>();
                // TODO add position I'm collide with
                //                positionsToRemoveFromFreePositionsList.add(x - 1, y -1);
                positionsToRemoveFromFreePositionsList.add(myFreeposition);
                ListUtils.removeAll(freePositions, positionsToRemoveFromFreePositionsList);
                xy = myFreeposition;
                return true;
            }
        }
        // this mean we could not find free position to set this piece, then this variation is wrong
        return false;
    }
    
    private boolean hasNotGotCollisions(Position myFreeposition, List<Position> piecesPositions) {
        int x = myFreeposition.getX();
        int y = myFreeposition.getY();
        
        Position tmp = new Position(x - 1, y - 1);
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        tmp.setX(x);
        //        tmp.setY(y - 1);
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        //                    tmp.setX(x);
        tmp.setY(y + 1);
        ;
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        tmp.setX(x + 1);
        //                    tmp.setY(y - 1);
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        tmp.setX(x - 1);
        tmp.setY(y);
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        tmp.setX(x + 1);
        //                    tmp.setY(y);
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        tmp.setX(x + 1);
        tmp.setY(y + 1);
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        tmp.setX(x - 1);
        tmp.setY(y + 1);
        if (piecesPositions.contains(tmp)) {
            return false;
        }
        return false;
    }
}
