package exercise.cpc.data.output.display;

import java.util.List;

import exercise.cpc.chess.board.ChessBoard;
import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.position.Position;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//

/**
 * TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class DataOutputDisplay {
    public void print(ChessBoard chessBoard, List<ChessPiece> piecesList) {
        // TODO this data should be make outside
        StringBuilder data = new StringBuilder();
        
        for (int i = 0; i < chessBoard.getN(); ++i) {
            for (int j = 0; j < chessBoard.getM(); ++j) {
                final Position position = new Position(i, j);
                if (chessBoard.getPiecesPositions().contains(position)) {
                    int indexOfPiece = piecesList.indexOf(position);
                    if (-1 < indexOfPiece) {
                        data.append(piecesList.get(indexOfPiece).getName());
                    } else {
                        data.append("P");
                    }
                } else if (chessBoard.getFreePositions().contains(position)) {
                    data.append(".");
                } else {
                    data.append("X");
                }
            }
            data.append("\n");
        }
        
        System.out.println(data.toString());
    }
}
