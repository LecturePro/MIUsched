package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.model.Block;
import com.eregistrar.miueregistrar.service.impl.BlockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Block controller.
 */
@RestController
@RequestMapping("block")
public class BlockController {
    private BlockServiceImpl blockServiceImpl;

    /**
     * Instantiates a new Block controller.
     *
     * @param blockService the block service
     */
    @Autowired
    public BlockController(BlockServiceImpl blockService){
        this.blockServiceImpl = blockService;
    }

    /**
     * Save block.
     *
     * @param block the block
     */
    @PostMapping(value = "")
    public void saveBlock(@ModelAttribute("blockForm") Block block, HttpServletResponse response) throws IOException {
        blockServiceImpl.saveBlock(block);
        response.sendRedirect("/block.html");
    }

    /**
     * Gets all block.
     *
     * @return the all block
     */
    @GetMapping(value="")
    @ResponseBody
    public List<Block> getAllBlock() {
        return blockServiceImpl.getAllBlock();
    }

    /**
     * Gets block by id.
     *
     * @param blockId the block id
     * @return the block by id
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Block getBlockById(@PathVariable("id") Integer blockId) {
        return blockServiceImpl.getBlockById(blockId);
    }

    /**
     * Delete block by id.
     *
     * @param blockId the block id
     */
    @DeleteMapping("/{id}")
    public void deleteBlockById(@PathVariable("id") Integer blockId) {
        blockServiceImpl.deleteBlockById(blockId);
    }
    @PutMapping(value = "")
    public void updateBlock(@RequestBody Block block){
        blockServiceImpl.updateBlock(block);
    }
}
