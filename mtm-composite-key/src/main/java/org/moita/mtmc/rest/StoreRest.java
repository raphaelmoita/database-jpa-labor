package org.moita.mtmc.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.moita.mtmc.domain.Game;
import org.moita.mtmc.domain.Store;
import org.moita.mtmc.domain.StoreGame;
import org.moita.mtmc.entity.StoreEntity;
import org.moita.mtmc.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.moita.mtmc.configuration.Swagger.STORE_TAG;

@RestController
@RequestMapping("/rest/store")
@Api(value = STORE_TAG)
public class StoreRest {

    private StoreService storeService;

    @Autowired
    public StoreRest(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "FindById")
    public Store findById(@ApiParam @PathVariable Long id) {
        return storeService.findById(id);
    }

    @GetMapping("/find")
    @ApiOperation(value = "Find")
    public List<Store> findAll() {
        return storeService.findAll();
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save")
    public Store save(@ApiParam @RequestBody Store store) {
        return storeService.save(store);
    }

    @PostMapping("/add-game")
    @ApiOperation(value = "Add a game")
    public void addGame(@ApiParam @RequestBody StoreGame storeGame) {
        storeService.addGame(storeGame);
    }
}
