/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.engine.feature.player;

/**
 * Possible status for a player.
 *
 * @author Grégory Van den Borre
 */
public enum PlayerStatus {

    /**
     * Represent the current player in this session, only one by game.
     */
    ME(0),

    /**
     * For all player who are ally with this session.
     */
    ALLY(1),

    /**
     * Default status for all unit.
     */
    HOSTILE(2),

    /**
     * Default status for all doodads.
     */
    NEUTRAL(3);

    public final int value;

    /**
     * Simple constructor.
     */
    PlayerStatus(int value) {
        this.value = value;
    }


    /**
     * Get a status from an ordinal value.
     *
     * @param ord Place of the enumeration value to retrieve.
     * @return The matching enumeration value.
     */
    public static PlayerStatus valueOf(final int ord) {
        if (ord < 0 || ord >= PlayerStatus.values().length) {
            throw new IllegalArgumentException(ord + " is invalid value.");
        }
        return PlayerStatus.values()[ord];
    }

}
