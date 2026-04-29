package com.example.business.system.dict.controller;

import com.example.business.system.dict.service.DictService;
import com.example.common.model.request.DictSaveRequest;
import com.example.common.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system/dicts")
public class DictController {
    private final DictService dictService;

    public DictController(DictService dictService) {
        this.dictService = dictService;
    }

    @GetMapping("/{dictCode}/items")
    public Result<?> items(@PathVariable String dictCode) {
        return Result.success(dictService.listItems(dictCode));
    }

    @PostMapping("/items")
    public Result<?> saveItem(@RequestBody DictSaveRequest request) {
        return Result.success(dictService.saveItem(request));
    }
}
