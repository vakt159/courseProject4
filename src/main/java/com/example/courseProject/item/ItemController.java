package com.example.courseProject.item;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/")
    public List<Item> getAll()
    {
        return itemService.findAll();
    }

    @PostMapping("/item")
    public Item addItem(@RequestBody Item item){
        return itemService.save(item);
    }
    @DeleteMapping("/item")
    public void deleteItem(@RequestBody Item item)
    {
        itemService.delete(item);
    }
    @PutMapping("/item")
    public Item updateItem(@RequestBody Item item){
        return itemService.save(item);
    }

}
