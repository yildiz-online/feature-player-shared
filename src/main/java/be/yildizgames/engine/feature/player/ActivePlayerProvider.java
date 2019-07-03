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

import be.yildizgames.common.model.PlayerId;

/**
 * Provide the players currently registered in the local game.
 * This provider is for local multiplayer games, for client-server based games, the server will be responsible to provide the players.
 * @author Grégory Van den Borre
 */
public class ActivePlayerProvider {

    private PlayerId player1;
    private PlayerId player2;
    private PlayerId player3;
    private PlayerId player4;

    public final void registerPlayer1(PlayerId player) {
        this.player1 = player;
    }

    public final void registerPlayer2(PlayerId player) {
        this.player2 = player;
    }

    public final void registerPlayer3(PlayerId player) {
        this.player3 = player;
    }

    public final void registerPlayer4(PlayerId player) {
        this.player4 = player;
    }

    public final PlayerId getPlayer1() {
        if(player1 == null) {
            throw new IllegalArgumentException("Player 1 not registered.");
        }
        return this.player1;
    }

    public final PlayerId getPlayer2() {
        if(player2 == null) {
            throw new IllegalArgumentException("Player 2 not registered.");
        }
        return this.player2;
    }

    public final PlayerId getPlayer3() {
        if(player3 == null) {
            throw new IllegalArgumentException("Player 3 not registered.");
        }
        return this.player3;
    }

    public final PlayerId getPlayer4() {
        if(player3 == null) {
            throw new IllegalArgumentException("Player 4 not registered.");
        }
        return this.player4;
    }

}
