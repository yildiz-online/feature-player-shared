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

package be.yildizgames.engine.feature.player.protocol.mapper;

import be.yildizgames.common.mapping.ObjectMapper;
import be.yildizgames.common.mapping.Separator;
import be.yildizgames.common.mapping.model.PlayerIdMapper;
import be.yildizgames.engine.feature.player.exception.PlayerMappingException;
import be.yildizgames.engine.feature.player.protocol.PlayerDto;

/**
 * @author Grégory Van den Borre
 */
public class PlayerDtoMapper implements ObjectMapper<PlayerDto> {

    private static final PlayerDtoMapper INSTANCE = new PlayerDtoMapper();

    private PlayerDtoMapper() {
        super();
    }

    public static PlayerDtoMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public final PlayerDto from(String s) {
        try {
            String[] v = s.split(Separator.VAR_SEPARATOR);
            return new PlayerDto(PlayerIdMapper.getInstance().from(v[0]), v[1], PlayerStatusMapper.getInstance().from(v[2]));
        } catch (IndexOutOfBoundsException e) {
            throw new PlayerMappingException(e);
        }
    }

    @Override
    public final String to(PlayerDto dto) {
        return PlayerIdMapper.getInstance().to(dto.player)
                + Separator.VAR_SEPARATOR
                + dto.login
                + Separator.VAR_SEPARATOR
                + PlayerStatusMapper.getInstance().to(dto.status);
    }
}
