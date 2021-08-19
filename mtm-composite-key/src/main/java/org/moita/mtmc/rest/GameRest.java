package org.moita.mtmc.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.moita.mtmc.domain.Game;
import org.moita.mtmc.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.moita.mtmc.configuration.Swagger.GAME_TAG;

@RestController
@RequestMapping("/rest/game")
@Api(tags = GAME_TAG)
public class GameRest {

    private GameService gameService;

    @Autowired
    public GameRest(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "FindById")
    public Game findById(@ApiParam @PathVariable Long id) {
        return gameService.findById(id);
    }

    @GetMapping("/find")
    @ApiOperation(value = "Find")
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save")
    public Game save(@ApiParam @RequestBody Game game) {
        return gameService.save(game);
    }
}
