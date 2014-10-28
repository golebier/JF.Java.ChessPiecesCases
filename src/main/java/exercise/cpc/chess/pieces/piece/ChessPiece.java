package exercise.cpc.chess.pieces.piece;

import java.util.List;

import exercise.cpc.chess.pieces.piece.position.Position;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
/**
 * Basic interface for all of the chess pieces. Now just basic to began.
 * // TODO add more, correct doc.
 *
 * @author Gra <Gołębiewski Radosław A.> https://github.com/golebier or
 *         https://golebier.github.io https://google.com/+RadoslawGolebiewski
 *         http
 *         ://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public interface ChessPiece {
    // TODO change method name, should be more clear
    /**
     * Checks if collisions accrue, to estimate if adding this piece brakes counting possibility.
     * @param freePositions {@code List} of {@code Position} that are free and can be used in counting. 
     * @param piecesPositions {@code List} of {@code Position} that represents allocated piece position.
     * @return false if free position for set this piece is not found, true if set piece in free position was possible.
     */
    boolean checkCollisions(List<Position> freePositions, List<Position> piecesPositions);
    
    /**
     * Allocated X position of the piece.
     *
     * @return {@code int} as X position allocation.
     */
    int getX();
    
    /**
     * Allocated Y position of the piece.
     *
     * @return {@code int} as Y position allocation.
     */
    int getY();
    
    /**
     * Short name of the piece.
     * @return {@code String} as short version of the piece name.
     */
    String getName();
    
    /**
     * Compares two strings lexicographically. The comparison is based on the Unicode value of each character 
    in the strings. The character sequence represented by this String object is compared lexicographically to 
    the character sequence represented by the argument string. The result is a negative integer if this String 
    object lexicographically precedes the argument string. The result is a positive integer if this String object 
    lexicographically follows the argument string. The result is zero if the strings are equal; compareTo returns 
    0 exactly when the equals(Object) method would return true. 
    This is the definition of lexicographic ordering. If two strings are different, then either they have different 
    characters at some index that is a valid index for both strings, or their lengths are different, or both. If they 
    have different characters at one or more index positions, let k be the smallest such index; then the string 
    whose character at position k has the smaller value, as determined by using the < operator, 
    lexicographically precedes the other string. In this case, compareTo returns the difference of the two 
    character values at position k in the two string -- that is, the value: 
    this.charAt(k)-anotherString.charAt(k)
    If there is no index position at which they differ, then the shorter string lexicographically precedes the 
    longer string. In this case, compareTo returns the difference of the lengths of the strings -- that is, the 
    value: 
    this.length()-anotherString.length()
    
    Specified by: compareTo(...) in Comparable
    Parameters:
    anotherString the String to be compared.
    Returns:
     the value 0 if the argument string is equal to this string; a value less than 0 if this string is 
      lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically 
      greater than the string argument.
     */
    int compareTo(ChessPiece piece);
}
