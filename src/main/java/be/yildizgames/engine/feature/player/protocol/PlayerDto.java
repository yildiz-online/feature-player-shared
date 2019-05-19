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

package be.yildizgames.engine.feature.player.protocol;

import be.yildizgames.common.model.PlayerId;
import be.yildizgames.engine.feature.player.PlayerStatus;

/**
 * @author Grégory Van den Borre
 */
public class PlayerDto {

    /**
     * Player unique Id.
     */
    public final PlayerId player;

    /**
     * Player name.
     */
    public final String login;

    /**
     * Player status for the current player.
     */
    public final PlayerStatus status;

    public PlayerDto(PlayerId player, String login, PlayerStatus status) {
        super();
        this.player = player;
        this.login = login;
        this.status = status;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerDto playerDto = (PlayerDto) o;

        return player.equals(playerDto.player) && login.equals(playerDto.login) && status == playerDto.status;
    }

    @Override
    public final int hashCode() {
        int result = player.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
